package com.amenity.workbench.views;

import java.util.ArrayList;
import java.util.List;

import general.Container;
import general.ContentObject;
import general.File;
import general.Folder;
import general.Snapshot;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import dao.DaoFactory;
import dao.GenericDao;
import org.eclipse.swt.layout.FillLayout;

import com.amenity.engine.helper.compare.MKSComparator;

import swing2swt.layout.BorderLayout;

public class CompareSnapshotsView extends ViewPart {

	// Snapshot left
	private Snapshot currentSnapshot1;
	private List<Folder> folders1;
	private List<File> files1;
	private List<ContentObject> contentObjects1;
	private List<GridItem> gridItems1;
	
	// Snapshot right
	private Snapshot currentSnapshot2;
	private List<Folder> folders2;
	private List<File> files2;
	private List<ContentObject> contentObjects2;
	private List<GridItem> gridItems2;
	
	// general
	private GenericDao genericDao;
	private Composite compositeWest;
	private org.eclipse.swt.widgets.List containerList;
	private org.eclipse.swt.widgets.List snapshotList;
	private java.util.List<Container> containerArray;
	private java.util.List<Snapshot> snapshotArray;
	private Container currentContainer;
	private Grid grid;
	
	
	
	public CompareSnapshotsView() {
		genericDao = DaoFactory.eINSTANCE.createGenericDao();
		
		folders1 = new ArrayList<Folder>();
		files1 = new ArrayList<File>();
		contentObjects1 = new ArrayList<ContentObject>();
		gridItems1 = new ArrayList<GridItem>();
		
		folders2 = new ArrayList<Folder>();
		files2 = new ArrayList<File>();
		contentObjects2 = new ArrayList<ContentObject>();
		gridItems2 = new ArrayList<GridItem>();
		
		containerArray = new ArrayList<Container>();
		snapshotArray = new ArrayList<Snapshot>();
	}

	@Override
	public void createPartControl(Composite parent) {
//		Shell shell = parent.getShell();
		
		parent.setLayout(new GridLayout(2, true));
		
		Composite compositeTop = new Composite(parent, SWT.NONE);
		compositeTop.setLayout(null);
		compositeTop.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true,
				false, 2, 1));
		

//		Composite compositeLeft = new Composite(parent, SWT.NONE);
//		compositeLeft.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true,
//				true, 1, 1));
		
//		Composite compositeRight = new Composite(parent, SWT.NONE);
//		compositeRight.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true,
//				true, 2, 1));
		
		grid = new Grid(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		grid.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true,
				true, 2, 1));
		grid.setHeaderVisible(true);
	    GridColumn column = new GridColumn(grid,SWT.NONE);
	    column.setText("Name");
	    column.setWidth(250);
	    column.setTree(true);
	    GridColumn column1 = new GridColumn(grid,SWT.NONE);
	    column1.setText("Version");
	    column1.setWidth(100);
	    column1.setSummary(false);
	    GridColumn column2 = new GridColumn(grid,SWT.NONE);
	    column2.setText("Modified");
	    column2.setWidth(100);
	    column2.setSummary(false);
	    GridColumn column3 = new GridColumn(grid,SWT.NONE);
	    column3.setText("<OID>");
	    column3.setWidth(100);
	    column3.setSummary(false);
	    column3.setVisible(false);
	    GridColumn column4 = new GridColumn(grid,SWT.NONE);
	    column4.setText("Difference");
	    column4.setWidth(50);
	    column4.setSummary(false);
	    GridColumn column5 = new GridColumn(grid,SWT.NONE);
	    column5.setText("Name");
	    column5.setWidth(250);
	    column5.setTree(true);
	    GridColumn column6 = new GridColumn(grid,SWT.NONE);
	    column6.setText("Version");
	    column6.setWidth(100);
	    column6.setSummary(false);
	    GridColumn column7 = new GridColumn(grid,SWT.NONE);
	    column7.setText("Modified");
	    column7.setWidth(100);
	    column7.setSummary(false);
	    GridColumn column8 = new GridColumn(grid,SWT.NONE);
	    column8.setText("<OID>");
	    column8.setWidth(100);
	    column8.setSummary(false);
	    column8.setVisible(false);
	    

		String query1 = "from " + ContentObject.class.getName().toString() + 
				" where partOf = '4cd7d81e-ffd1-4b67-b36f-58caedd930f1'";

		String query2 = "from " + ContentObject.class.getName().toString() + 
				" where partOf = 'd9fa617e-afce-4793-9066-7cf866db89e5'";
		
	    MKSComparator compare = new MKSComparator( (List<ContentObject>) genericDao.getByQuery(query1), 
	    		(List<ContentObject>) genericDao.getByQuery(query2));
	    compare.getComparableGrid(grid);
	    
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
