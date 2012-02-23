package com.amenity.workbench.views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import general.Connection;
import general.Container;
import general.ContentObject;
import general.File;
import general.Folder;
import general.Snapshot;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.amenity.engine.helper.mks.MksGetFile;
import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.supporter.IconFactory;

import dao.ConnectionDao;
import dao.ContainerDao;
import dao.DaoFactory;
import dao.FileDao;
import dao.GenericDao;
import dao.SnapshotDao;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.ResourceManager;

public class SnapshotView extends ViewPart {

	public static final String ID = "com.amenity.rcp.ui.views.SnapshotView"; //$NON-NLS-1$
	
	private Composite container;
	private Grid grid;
	private GenericDao genericDao;
	private List<GridItem> gridItems;
	private List<Folder> folders;
	private List<File> files;
	private List<ContentObject> contentObjects;
	private Composite compositeWest;
	private org.eclipse.swt.widgets.List containerList;
	private org.eclipse.swt.widgets.List snapshotList;
	private java.util.List<Container> containerArray;
	private java.util.List<Snapshot> snapshotArray;
	private Snapshot currentSnapshot;
	private Container currentContainer;
	private Label label_1;
	private Label label_2;
	private Label label_3;
	private Label label_4;
	private Label label_5;
	private Label label_6;
	
	public SnapshotView() {
		gridItems = new ArrayList<GridItem>();
		genericDao = DaoFactory.eINSTANCE.createGenericDao();
		folders = new ArrayList<Folder>();
		files = new ArrayList<File>();
		containerArray = new ArrayList<Container>();
		snapshotArray = new ArrayList<Snapshot>();
		contentObjects = new ArrayList<ContentObject>();
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		container = parent;
		parent.setLayout(new BorderLayout(0, 0));
		
		compositeWest = new Composite(parent, SWT.NONE);
		compositeWest.setLayoutData(BorderLayout.WEST);
		compositeWest.setLayout(null);
		
		Label lblSelectProject = new Label(compositeWest, SWT.NONE);
		lblSelectProject.setBounds(10, 10, 100, 13);
		lblSelectProject.setText("Select Container");
		
		containerList = new org.eclipse.swt.widgets.List(compositeWest, SWT.BORDER | SWT.V_SCROLL);
		containerList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					fillSnapshotList(containerList
							.getItem(containerList.getSelectionIndex()));
				} catch ( IllegalArgumentException iax) {
					
				}
			} 
		});
		containerList.setBounds(10, 29, 150, 100);
		
		Label lblSelectSnapshot = new Label(compositeWest, SWT.NONE);
		lblSelectSnapshot.setBounds(10, 135, 100, 13);
		lblSelectSnapshot.setText("Select Snapshot");
		
		snapshotList = new org.eclipse.swt.widgets.List(compositeWest, SWT.BORDER | SWT.V_SCROLL);
		snapshotList.setBounds(10, 154, 150, 100);
		snapshotList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected (SelectionEvent e) {
				setCurrentSnapshot();
				label_1.setText(currentContainer.getName());
				label_2.setText("");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				label_3.setText(df.format(currentSnapshot.getCreated()));
				label_4.setText(SessionSourceProvider.USER.getUsername());
				label_5.setText(currentSnapshot.getComment());
			}
		});
		
		Button btnView = new Button(compositeWest, SWT.NONE);
		btnView.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					grid.clearAll(true);	// defaults the grid items
					grid.remove(0);
				} catch (Exception ee) {
					
				}
				visualizeSnapshot();
			}
		});
		btnView.setBounds(10, 260, 150, 23);
		btnView.setText("View selected Snapshot");
		
		Label label = new Label(compositeWest, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 289, 150, 2);
		
		Group grpSnaptshotDetails = new Group(compositeWest, SWT.NONE);
		grpSnaptshotDetails.setText("Snaptshot Details");
		grpSnaptshotDetails.setBounds(10, 289, 150, 157);
		
		Label lblContainer = new Label(grpSnaptshotDetails, SWT.NONE);
		lblContainer.setBounds(10, 20, 49, 13);
		lblContainer.setText("Container");
		
		Label lblProject = new Label(grpSnaptshotDetails, SWT.NONE);
		lblProject.setBounds(10, 39, 49, 13);
		lblProject.setText("Project");
		
		Label lblCreated = new Label(grpSnaptshotDetails, SWT.NONE);
		lblCreated.setBounds(10, 58, 49, 13);
		lblCreated.setText("Created");
		
		Label lblOwner = new Label(grpSnaptshotDetails, SWT.NONE);
		lblOwner.setBounds(10, 77, 49, 13);
		lblOwner.setText("Owner");
		
		Label lblComment = new Label(grpSnaptshotDetails, SWT.NONE);
		lblComment.setBounds(10, 96, 49, 13);
		lblComment.setText("Comment");
		
		label_1 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_1.setBounds(65, 20, 75, 13);
		
		label_2 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_2.setBounds(65, 39, 75, 13);
		
		label_3 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_3.setBounds(65, 58, 75, 13);
		
		label_4 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_4.setBounds(65, 77, 75, 13);
		
		label_5 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_5.setBounds(65, 96, 75, 13);
		
		Label lblConnection = new Label(grpSnaptshotDetails, SWT.NONE);
		lblConnection.setBounds(10, 115, 61, 13);
		lblConnection.setText("Connection");
		
		label_6 = new Label(grpSnaptshotDetails, SWT.NONE);
		label_6.setBounds(65, 115, 75, 13);
		
		Label lblSpaceHolder = new Label(compositeWest, SWT.NONE);
		lblSpaceHolder.setBounds(10, 433, 158, 13);
		
		Label lblNewLabel = new Label(compositeWest, SWT.NONE);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				snapshotList.removeAll();
				containerList.removeAll();
				fillContainerList();
			}
		});
		lblNewLabel.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/16x16/arrow_refresh.png"));
		lblNewLabel.setBounds(144, 10, 16, 16);
		
		fillContainerList();
		
		setHeader();

	}

	private void setContent(Snapshot snapshot) {
		
		for ( ContentObject c : contentObjects ) {
			if ( c instanceof File ) {
				// its a file! 
				files.add((File)c);
			} else {
				// its a folder! 
				folders.add((Folder) c);
			}
		}
		
		createGridItems();
	}
	
	private void createGridItems() {
		GridItem gridItem;
		/**
		 * create grid folder items
		 */
		System.out.println("Amount of folders: " + folders.size() );
		int i = 0;
		int noLevelResult = 0;
		SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
		for ( i = 0; i < 999 ; i++ ) { 
			int itemsFound = 0;
			if ( noLevelResult > 2) {
				break;
			}
			for ( Folder f : folders ) {
				if ( f.getLevel() == i ) {
		//			gridItem = new GridItem ( grid, SWT.NONE );
					if ( f.getRootDirectory() == null ) {
						System.out.println(">> Root Grid to be Created");
						gridItem = new GridItem ( grid, SWT.NONE );
						gridItem.setExpanded(true);
					} else {
						gridItem = new GridItem ( getParentGrid(f.getRootDirectory()), 
								SWT.NONE );
					}
					gridItem.setText(f.getName());
				    gridItem.setText(1, "");
				    gridItem.setText(2, "");
				    gridItem.setText(3, "");
				    gridItem.setText(4, f.getObjectId());
				    gridItem.setImage(PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJ_FOLDER));
				    gridItem.setText(4, f.getObjectId());
				    gridItems.add(gridItem);
				    itemsFound++;
				}
			}
		    if ( itemsFound < 1 ) 
		    	noLevelResult++;
			
		}
		for ( i = 0; i < 999 ; i++ ) { 
			int itemsFound = 0;
			for ( File f : files ) {
				if ( f.getLevel() == i ) {
					gridItem = new GridItem ( getParentGrid(f.getRootDir()), 
								SWT.NONE );
					
					gridItem.setText(f.getName());
				    gridItem.setText(1, f.getVersion());
				    gridItem.setText(2, f.getStatus());
				    gridItem.setText(3, df.format(f.getModfiedDate()));
				    gridItem.setText(4, f.getObjectId());
				    if ( f.getSuffix().equals("-") )
				    	gridItem.setImage(getDefaultImage());
				    else 
				    	gridItem.setImage(getImageIcon(f.getSuffix()));
				    gridItems.add(gridItem);
				    itemsFound++;
				}
			}
		    if ( itemsFound < 1 ) 
		    	noLevelResult++;
			
			if ( noLevelResult > 10) break;
		}
	}
	
	private Image getImageIcon(String suffix) {
		/**
		 * TODO
		 * this is just temporary
		 * in future there will be an SQL query providing the below information
		 */
		switch (suffix.toLowerCase()) {
		case ("-"):
			return getDefaultImage();
		case (".ppt"):
			return IconFactory.getInstance().getPPTIco();
		case (".c"):
			return IconFactory.getInstance().getCIco();
		case (".h"):
			return IconFactory.getInstance().getHIco();
		case (".jpg"):
			return IconFactory.getInstance().getImageIco();
		case (".pdf"):
			return IconFactory.getInstance().getPdfIco();
		case (".doc"):
			return IconFactory.getInstance().getWordIco();
		case (".zip"):
			return IconFactory.getInstance().getCompressedIco();
		case (".java"):
			return IconFactory.getInstance().getCIco();
		case (".txt"):
			return IconFactory.getInstance().getWordIco();
		case (".docx"):
			return IconFactory.getInstance().getWordIco();
		default:
			return getDefaultImage();
		}
	}

	public GridItem getParentGrid(Folder rootDirectory) {
		for ( GridItem gi : gridItems ) 
			if ( gi.getText(4).equals(rootDirectory.getObjectId() ))
				return gi;
		System.err.println("--- Grid does not exist");
		return null;
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
	
	private void setHeader() {
		grid = new Grid(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		grid.setLayoutData(BorderLayout.CENTER);
		
//		banner, SWT.BORDER
		grid.setHeaderVisible(true);
	    GridColumn column = new GridColumn(grid,SWT.NONE);
	    column.setText("Name");
	    column.setWidth(300);
	    column.setTree(true);
	    GridColumn column2 = new GridColumn(grid,SWT.NONE);
	    column2.setText("Version");
	    column2.setWidth(100);
	    column2.setSummary(false);
	    GridColumn column3 = new GridColumn(grid,SWT.NONE);
	    column3.setText("Status");
	    column3.setWidth(100);
	    column3.setSummary(false);
	    GridColumn column4 = new GridColumn(grid,SWT.NONE);
	    column4.setText("Last Modified");
	    column4.setWidth(150);
	    column4.setSummary(false);
	    GridColumn column5 = new GridColumn(grid,SWT.NONE);
	    column5.setText("ObjectId");
	    column5.setWidth(100);
	    column5.setVisible(false);
	    GridColumn column6 = new GridColumn(grid,SWT.NONE);
	    column6.setText("Release");
	    column6.setWidth(100);
	    column6.setVisible(false);
	    GridColumn column7 = new GridColumn(grid,SWT.NONE);
	    column7.setText("rootDir");
	    column7.setWidth(100);
	    column7.setVisible(false);
	    GridColumn column8 = new GridColumn(grid,SWT.NONE);
	    column8.setText("spare");
	    column8.setWidth(100);
	    column8.setVisible(false);
	    
	    grid.addDragDetectListener(new DragDetectListener(){

			@Override
			public void dragDetected(DragDetectEvent e) {
				System.out.println("Dragged Object" + 
						grid.getSelection()[0].getText(4).toString() );
				
			}
	    	
	    });
	    grid.addMouseListener(new MouseAdapter() {

	    	/**
	    	 * TODO
	    	 * Implement a connection selection to identify what open
	    	 * method has to be called
	    	 * 
	    	 */
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				GridItem gi = null;
				try {
					gi = grid.getSelection()[0];System.out.println("Double Click Event " + gi.getText(4) );
					FileDao fileDao = DaoFactory.eINSTANCE.createFileDao();
					File file = (File) fileDao.getById(gi.getText(4));
					ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
					Connection connection = null;
					connection = (Connection) connectionDao.getByQuery("from " + 
							Connection.class.getName().toString() + 
							" where connectionId = '0a0976b5-2f73-4dc8-b9f6-30e5cc413fd4'").get(0);
					MksGetFile mksGetFile = new MksGetFile(connection, file);
					mksGetFile.openFile();
				} catch (Exception ex) {
					if ( gi == null )
						MessageDialog.openError(container.getShell(), 
								"Error", 
								"Am error occured while opening the file");
				}
			}
	    });
	}
	
	@SuppressWarnings("unchecked")
	private void fillContainerList() {
		
		ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
		
		containerArray = containerDao.getListByOwner(Container.class, SessionSourceProvider.USER);
		containerList.removeAll();
		if (containerArray.size() < 1 ) {
			containerList.add("no container available");
		} else {
			for ( Container c : containerArray ) {
				containerList.add(c.getName());
			}
		}
		
		containerDao = null;
	}

	@SuppressWarnings("unchecked")
	private void fillSnapshotList( String containerName ) {

		for ( Container c : containerArray )
			if ( c.getName().equals(containerName)) {
				currentContainer = c;
				break;
			}
		if ( currentContainer != null ) {
			SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
			snapshotArray = snapshotDao.getListByContainer(currentContainer.getContainerId());
			if ( snapshotArray.size() < 1 ) {
				snapshotList.removeAll();
				snapshotList.add("no snapshots available");
			} else {
				snapshotList.removeAll();
				for ( Snapshot s : snapshotArray ) 
					snapshotList.add(s.getCreated().toString());
			}
			snapshotDao = null;
		} else {
			// Error
		}
	}
	
	private void setCurrentSnapshot() {
		for ( Snapshot s : snapshotArray ) {
			if ( s.getCreated().toString().equals(snapshotList.getItem(snapshotList.getSelectionIndex())))
				currentSnapshot = s;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void visualizeSnapshot() {
		
		/**
		 * TODO
		 * analysis if its maybe better to use JFace Tree Provider
		 * Nebula GRID 
		 * 
		 */
		long start = System.currentTimeMillis();
	
//			currentSnapshot = (Snapshot) genericDao.getList(Snapshot.class).get(0);
		String query = "from " + ContentObject.class.getName().toString() + 
				" where partOf = '" + currentSnapshot.getSnapshotId() + "'";
		
		files.clear();
		folders.clear();
		gridItems.clear();
		contentObjects.clear();
		
		contentObjects = (List<ContentObject>) genericDao.getByQuery(query);
		
//		Collections.sort(contentObjects, new Comparator(){
//
//			@Override
//			public int compare(Object o1, Object o2) {
//				String name1 = ((ContentObject) o1).getName();
//				String name2 = ((ContentObject) o2).getName();
//				return name2.compareTo(name1);
//			}
//			
//		});

//		Collections.sort(contentObjects, new Comparator(){
//
//			@Override
//			public int compare(Object o1, Object o2) {
//				String name1 = ((ContentObject) o1).getLevel();
//				String name2 = ((ContentObject) o2).getLevel();
//				return name2.compareTo(name1);
//			}
//			
//		});
		
		
		System.out.println("there are " + contentObjects.size() + 
				" items within snapshot: " + currentSnapshot.getSnapshotId());
			
		setContent(currentSnapshot);
		
		System.out.println(" >>>>> The creation of the view took: " + 
				(System.currentTimeMillis() - start) + " ms");
	}
}
