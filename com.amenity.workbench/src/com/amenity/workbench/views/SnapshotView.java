package com.amenity.workbench.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class SnapshotView extends ViewPart {

	public static final String ID = "com.amenity.rcp.ui.views.SnapshotView"; //$NON-NLS-1$
	
	public SnapshotView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		//Composite container = new Composite(parent, SWT.NONE);

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
//		Grid grid = new Grid(parent,SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
//	    grid.setHeaderVisible(true);
//	    GridColumn column = new GridColumn(grid,SWT.NONE);
//	    column.setText("Column 1");
//	    column.setWidth(100);
//	    GridColumnGroup columnGroup = new GridColumnGroup(grid,SWT.TOGGLE);
//	    columnGroup.setText("Column Group");
//	    GridColumn column2 = new GridColumn(columnGroup,SWT.NONE);
//	    column2.setText("Column 2");
//	    column2.setWidth(60);
//	    column2.setSummary(false);
//	    GridColumn column3 = new GridColumn(columnGroup,SWT.NONE);
//	    column3.setText("Column 3");
//	    column3.setWidth(60);
//	    column3.setSummary(false);
//	    GridColumn summaryColumn = new GridColumn(columnGroup,SWT.NONE);
//	    summaryColumn.setText("Sum");
//	    summaryColumn.setWidth(93);
//	    summaryColumn.setDetail(false);
//	    summaryColumn.setSummary(true);
//	    GridItem item1 = new GridItem(grid,SWT.NONE);
//	    item1.setText("First Item");
//	    item1.setText(1,"100");
//	    item1.setText(2,"42");
//	    item1.setText(3,"142");
//	    GridItem item2 = new GridItem(grid,SWT.NONE);
//	    item2.setText("Second Item");
//	    item2.setText(1,"63");
//	    item2.setText(2,"92");
//	    item2.setText(3,"155");
//	    GridItem item3 = new GridItem(grid,SWT.NONE);
//	    item3.setText("Third Item");
//	    item3.setText(1,"7");
//	    item3.setText(2,"3");
//	    item3.setText(3,"10");
//		
		
		
	}


	@Override
	public void setFocus() {
		// Set the focus
	}

}
