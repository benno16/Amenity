package com.amenity.workbench.views;

import java.util.ArrayList;
import java.util.List;

import general.Connection;
import general.ContentObject;
import general.File;
import general.Folder;
import general.GeneralFactory;
import general.Snapshot;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.amenity.engine.helper.mks.MksGetFile;
import com.amenity.workbench.supporter.IconFactory;

import dao.ConnectionDao;
import dao.DaoFactory;
import dao.FileDao;
import dao.GenericDao;

public class SnapshotView extends ViewPart {

	public static final String ID = "com.amenity.rcp.ui.views.SnapshotView"; //$NON-NLS-1$
	
	private Composite container;
	private Grid grid;
	private GenericDao genericDao;
	private List<GridItem> gridItems;
	private List<Folder> folders;
	private List<File> files;
	private List<ContentObject> contentObjects;
	
	public SnapshotView() {
		gridItems = new ArrayList<GridItem>();
		genericDao = DaoFactory.eINSTANCE.createGenericDao();
		folders = new ArrayList<Folder>();
		files = new ArrayList<File>();
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		container = parent;

		/**
		 * Xviewer to develop futher! 
		 */
//		XViewer xViewer = new XViewer ( parent, SWT.None | 
//				SWT.H_SCROLL | SWT.V_SCROLL, new XViewerTestFactory("") );
//		xViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
//		xViewer.setContentProvider(new FileContentProvider());
//		xViewer.setLabelProvider(new XFolderLabelProvider(xViewer));
//		xViewer.setInput(new FileMockModel());
//
//		
//		
		/**
		 * GRID Example
		 */
		long start = System.currentTimeMillis();
		setHeader();
		
		Snapshot snapshot = GeneralFactory.eINSTANCE.createSnapshot();
		
		if ( genericDao.getList(Snapshot.class).size() > 0 ) {
		
		snapshot = (Snapshot) genericDao.getList(Snapshot.class).get(0);

		String query = "from " + ContentObject.class.getName().toString() + 
				" where partOf = '" + snapshot.getSnapshotId() + "'";
		
		contentObjects = new ArrayList<ContentObject>();
		
		contentObjects = (List<ContentObject>) genericDao.getByQuery(query);
		
		System.out.println("there are " + contentObjects.size() + 
				" items within snapshot: " + snapshot.getSnapshotId());
			
		setContent(snapshot);
		}
		System.out.println(" >>>>> The creation of the view took: " + 
				(System.currentTimeMillis() - start) + " ms");
		
	}


	private void setContent(Snapshot snapshot) {
		/**
		 * TODO 
		 * manual snapshot selection
		 */
		
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
				    gridItem.setText(3, f.getModfiedDate().toString());
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
		grid = new Grid(container, SWT.BORDER_DOT | SWT.V_SCROLL | SWT.H_SCROLL);
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
				System.out.println("Dragged Object" + grid.getSelection().toString() );
				
			}
	    	
	    });
	    grid.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				GridItem gi = grid.getSelection()[0];
				System.out.println("Double Click Event " + gi.getText(4) );
				FileDao fileDao = DaoFactory.eINSTANCE.createFileDao();
				File file = (File) fileDao.getById(gi.getText(4));
				System.out.println(file.getObjectId() +
						file.getVersion() + file.getFullName());
				ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
				Connection connection = null;
				connection = (Connection) connectionDao.getByQuery("from " + 
						Connection.class.getName().toString() + 
						" where connectionId = '0a0976b5-2f73-4dc8-b9f6-30e5cc413fd4'").get(0);
				MksGetFile mksGetFile = new MksGetFile(connection, file);
				System.out.println(mksGetFile.openFile());
			}

	    	
	    });
	}

}
