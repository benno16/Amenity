package com.amenity.workbench.views;

import java.util.ArrayList;
import java.util.List;

import general.ContentObject;
import general.File;
import general.Folder;
import general.GeneralFactory;
import general.Snapshot;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import dao.DaoFactory;
import dao.GenericDao;

public class SnapshotView extends ViewPart {

	public static final String ID = "com.amenity.rcp.ui.views.SnapshotView"; //$NON-NLS-1$
	
	private Composite container;
	private Grid grid;
	private GenericDao genericDao;
	private List<GridItem> gridItems;
	private List<Folder> folders;
	
	public SnapshotView() {
		gridItems = new ArrayList<GridItem>();
		genericDao = DaoFactory.eINSTANCE.createGenericDao();
		folders = new ArrayList<Folder>();
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
		
		setHeader();
		
		Snapshot snapshot = GeneralFactory.eINSTANCE.createSnapshot();
		
		
		snapshot = (Snapshot) genericDao.getList(Snapshot.class).get(0);
		
		
		setContent(snapshot);
	    
//	    GridItem item1 = new GridItem(grid,SWT.NONE);
//	    item1.setText("First Item");
//	    item1.setText(1,"100");
//	    item1.setText(2,"42");
//	    item1.setText(3,"142");
//	    GridItem item2 = new GridItem(item1,SWT.NONE);
//	    item2.setText("Second Item");
//	    item2.setText(1,"63");
//	    item2.setText(2,"92");
//	    item2.setText(3,"155");
//	    item2.hasChildren();
//	    item2.setExpanded(false);
//	    GridItem item3 = new GridItem(grid,SWT.NONE);
//	    item3.setText("Third Item");
//	    item3.setText(1,"7");
//	    item3.setText(2,"3");
//	    item3.setText(3,"10");
		
		
		
	}


	private void setContent(Snapshot snapshot) {
		String query = "from " + ContentObject.class.getName().toString() + 
				" where partOf = " + snapshot.getSnapshotId() ;
		
//		ContentObject contentObject = GeneralFactory.eINSTANCE.createContentObject();
		
		List<ContentObject> contentObjects = new ArrayList<ContentObject>();
		
		contentObjects = (List<ContentObject>) genericDao.getByQuery(query);
		GridItem item;
		for ( ContentObject c : contentObjects ) {
			if ( c instanceof File ) {
				// its a file! 
				/**
				 * TODO
				 * find root directory and root grid
				 * add item values and add to table
				 * including an invisible column for the ContentObjectID
				 */
				((File) c).getRootDir();
			} else {
				// its a folder! 
				/**
				 * TODO
				 * add to folders list
				 * find root directory and root grid
				 * add item values and add to table
				 * including an invisible column for the ContentObjectID
				 */
				folders.add((Folder) c);
				
			}
		}
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
	    column.setWidth(500);
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
	    column4.setWidth(100);
	    column4.setSummary(false);
	}

}
