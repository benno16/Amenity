package com.amenity.workbench.views;


import general.Container;
import general.Folder;
import general.Snapshot;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.workbench.SessionSourceProvider;

import dao.ContainerDao;
import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.FolderDao;
import dao.SnapshotDao;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class AssignFunctionsView extends ViewPart {
	private Text functionNameText;
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	
	private ComboViewer functionComboViewer;
	private Combo functionCombo;
	private ComboViewer snapshotComboViewer;
	private Combo snapshotCombo;
	private TreeViewer snapshotTreeViewer;
	private Tree snapshotTree;
	private Tree functionTree;
	private Composite composite;

	public AssignFunctionsView() {
	}

	@SuppressWarnings("unused")
	@Override
	public void createPartControl(Composite parent) {
		this.composite = parent;
		GridLayout gridLayout = new GridLayout(8,true);
		parent.setLayout(gridLayout);
		
		ComboViewer containerComboViewer = new ComboViewer(parent, SWT.NONE);
		Combo containerCombo = containerComboViewer.getCombo();
		containerCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// Container Combo JFace Settings
		containerComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Container>)inputElement ) .toArray();
			}
		});
		containerComboViewer.setLabelProvider(new GenericNameLabelProvider());
		containerComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( !structuredSelection.isEmpty() ) {
		        	if ( structuredSelection.getFirstElement() instanceof Container ) {
		        		SessionSourceProvider.CURRENT_CONTAINER = 
		        				(Container) structuredSelection.getFirstElement();
		        		fillSnapshotCombo();
		        	}
		        }
			}
			
		});
		
		snapshotComboViewer = new ComboViewer(parent, SWT.NONE);
		snapshotComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Snapshot>)inputElement ) .toArray();
			}
		});
		snapshotComboViewer.setLabelProvider(new GenericNameLabelProvider());
		snapshotComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( !structuredSelection.isEmpty() ) {
		        	if ( structuredSelection.getFirstElement() instanceof Snapshot ) {
		        		SessionSourceProvider.CURRENT_SNAPSHOT = 
		        				(Snapshot) structuredSelection.getFirstElement();
		        		fillSnapshotTree();
		        	}
		        }
			}
			
		});
		
		snapshotCombo = snapshotComboViewer.getCombo();
		snapshotCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		
		functionComboViewer = new ComboViewer(parent, SWT.NONE);
		functionCombo = functionComboViewer.getCombo();
		functionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		List dropzoneList = new List(parent, SWT.BORDER);
		
		DropTarget dropTarget_2 = new DropTarget(dropzoneList, DND.DROP_MOVE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		/**
		 * TODO: implement multi select
		 * SWT.MULTI
		 */
		snapshotTreeViewer = new TreeViewer( parent, SWT.BORDER | SWT.MULTI );
		snapshotTree = snapshotTreeViewer.getTree();
		snapshotTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

//		snapshotTreeViewer.setContentProvider(new ComponentObjectTreeContentProvider());
		snapshotTreeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public void dispose() {}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {}

			@Override
			public Object[] getElements(Object inputElement) {
				ContentObjectDao contentobjectDao = DaoFactory.eINSTANCE.createContentObjectDao();
				return contentobjectDao.getChildren(inputElement, 
						SessionSourceProvider.CURRENT_SNAPSHOT).toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				ContentObjectDao contentobjectDao = DaoFactory.eINSTANCE.createContentObjectDao();
				
				return contentobjectDao.getChildren(parentElement, 
						SessionSourceProvider.CURRENT_SNAPSHOT).toArray();
			}

			@Override
			public Object getParent(Object element) {
				return null;
			}

			@Override
			public boolean hasChildren(Object element) {
				return element instanceof Folder;
			}
			
		});
		snapshotTreeViewer.setLabelProvider(new GenericNameLabelProvider());
		/**
		 * TODO: Drag and Drop
		 */
		int operations = DND.DROP_MOVE | DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { TextTransfer.getInstance() };
		DragSource dragSourceSnapshot = new DragSource(snapshotTree, operations);
		dragSourceSnapshot.setTransfer(transfers);
	    final TreeItem[] dragSourceItem = new TreeItem[1];
		dragSourceSnapshot.addDragListener(new DragSourceListener() {

			@Override
			public void dragStart(DragSourceEvent event) {
				/**
				 * TODO: select item from list
				 * basically working! Recursive iterator to be added
				 */
//				structuredSelection = (IStructuredSelection) snapshotTreeViewer.getSelection();
//				dndFolders.clear();
//				dndFiles.clear();
//				for ( Object o : structuredSelection.toList() ) {
//					if ( o instanceof File ) {
//						dndFiles.add( (File) o);
//						event.doit = true;
//					} else if ( o instanceof Folder ) {
//						dndFolders.add( (Folder) o);
//					} else {
//						/**
//						 * TODO: Nicer error message
//						 */
//						System.err.println("Error getting object!");
//						event.doit = false;
//					}
//				}
				TreeItem[] selection = snapshotTree.getSelection();
				System.out.println("drag start " + selection[0].getItemCount());
		        if (selection.length > 0 ) { // && selection[0].getItemCount() == 0) {
		        	event.doit = true;
		        	dragSourceItem[0] = selection[0];
		        } else {
		        	
		        	System.out.println("there are two items selected" + selection[0].getText());
		        	event.doit = false;
		        }
			}

			@Override
			public void dragSetData(DragSourceEvent event) {
				event.data = dragSourceItem[0].getText();
			}

			@Override
			public void dragFinished(DragSourceEvent event) {
				/**
				 * TODO: check out item from list
				 */
				if (event.detail == DND.DROP_MOVE)
			    	dragSourceItem[0].dispose();
			    dragSourceItem[0] = null;
			}
			
		});
		
//		snapshotTreeViewer.addDragSupport(operations, transfers, new SnapshotDragListener(snapshotTreeViewer));
		
		DropTarget dropTargetSnapshot = new DropTarget(snapshotTree, DND.DROP_MOVE);
		
		
		
		Composite composite_1 = new Composite(parent, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		composite_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button arrowLeftLeft = new Button(composite_1, SWT.NONE);
		arrowLeftLeft.setText("<");
		
		Button arrowLeftRight = new Button(composite_1, SWT.NONE);
		arrowLeftRight.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/**
				 * TODO: Move over to middle tree
				 */
			}
		});
		arrowLeftRight.setText(">");
		
		TreeViewer functionTreeViewer = new TreeViewer(parent, SWT.BORDER);
		functionTree = functionTreeViewer.getTree();
		functionTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		DragSource dragSourceFunction = new DragSource(functionTree, DND.DROP_MOVE);
		
		/**
		 * TODO: Drop target definition! shall remove items from snapshot
		 * and add to this function tree view! 
		 * To be done by database function call. to be checked if its best to use 
		 * database lookup "! part of function"
		 */
		DropTarget dropTargetFunction = new DropTarget(functionTree, DND.DROP_MOVE);
		transfers = new Transfer[] { TextTransfer.getInstance()};
		dropTargetFunction.setTransfer(transfers);
		dropTargetFunction.addDropListener(new DropTargetAdapter() {
			@Override
			public void dragOver(DropTargetEvent event) {
				event.feedback = DND.FEEDBACK_EXPAND | DND.FEEDBACK_SCROLL;
		        if (event.item != null) {
		        	TreeItem item = (TreeItem) event.item;
		        	Point pt = composite.getDisplay().map(null, functionTree, event.x, event.y);
		        	Rectangle bounds = item.getBounds();
		        	if (pt.y < bounds.y + bounds.height / 3) {
		        		event.feedback |= DND.FEEDBACK_INSERT_BEFORE;
		        	} else if (pt.y > bounds.y + 2 * bounds.height / 3) {
		        		event.feedback |= DND.FEEDBACK_INSERT_AFTER;
		        	} else {
		        		event.feedback |= DND.FEEDBACK_SELECT;
		        	}
		        }
			}

			@Override
			public void drop(DropTargetEvent event) {
				if ( event.data == null ) {
					event.detail = DND.DROP_NONE;
					return;
				}
				String text = (String) event.data;
				if ( event.item == null ) {
					TreeItem item = new TreeItem(functionTree,SWT.NONE);
					item.setText(text);
				}else {
					TreeItem item = (TreeItem) event.item;
					Point pt = composite.getDisplay().map(null, functionTree, event.x, event.y);
					Rectangle bounds = item.getBounds();
			        TreeItem parent = item.getParentItem();
			        if ( parent != null ) {
			        	TreeItem[] items = parent.getItems();
			        	int index = 0;
			        	for ( int i = 0 ; i < items.length ; i++ ) {
			        		if ( items[i] == item ) {
			        			index = i;
			        			break;
			        		}
			        	}
			        	if ( pt.y < bounds.y + bounds.height/3) {
			        		TreeItem newItem = new TreeItem(parent, SWT.NONE,
			            			index );
			            	newItem.setText(text);
			        	} else if ( pt.y > bounds.y + 2 * bounds.height / 3 ) {
			        		TreeItem newItem = new TreeItem( parent, SWT.NONE,
			            			index +1 );
			            	newItem.setText(text);
			        	} else {
			        		TreeItem newItem = new TreeItem( parent, SWT.NONE );
			            	newItem.setText(text);
			        	}
			        } else {
				        TreeItem[] items = functionTree.getItems();
			            int index = 0;
			            for (int i = 0; i < items.length; i++) {
			            	if (items[i] == item) {
			            		index = i;
			            	break;
			            	}
			            }
			            if (pt.y < bounds.y + bounds.height / 3) {
			            	TreeItem newItem = new TreeItem(functionTree, SWT.NONE,
			            			index);
			            	newItem.setText(text);
			            } else if (pt.y > bounds.y + 2 * bounds.height / 3) {
			            	TreeItem newItem = new TreeItem(functionTree, SWT.NONE,
			            			index + 1);
			            	newItem.setText(text);
			            } else {
			            	TreeItem newItem = new TreeItem(item, SWT.NONE);
			            	newItem.setText(text);
			            }
			        }
				}
				
			}
		});
		
		
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button arrowRightLeft = new Button(composite, SWT.NONE);
		arrowRightLeft.setText("<");
		
		Button arrowRightRight = new Button(composite, SWT.NONE);
		arrowRightRight.setText(">");
		
		Grid statusGrid = new Grid(parent, SWT.BORDER);
		statusGrid.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		DropTarget dropTarget_1 = new DropTarget(statusGrid, DND.DROP_MOVE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblFunctionName = new Label(parent, SWT.NONE);
		GridData gd_lblFunctionName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblFunctionName.widthHint = 85;
		lblFunctionName.setLayoutData(gd_lblFunctionName);
		lblFunctionName.setText("Function Name");
		
		functionNameText = new Text(parent, SWT.BORDER);
		functionNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		
		Button btnSetStatus = new Button(parent, SWT.NONE);
		btnSetStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnSetStatus.setText("Set Status");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblOverallStatus = new Label(parent, SWT.NONE);
		lblOverallStatus.setText("Overall Status");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblConfigured = new Label(parent, SWT.NONE);
		lblConfigured.setText("Configured");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		fillContainerCombo(containerComboViewer, containerCombo);
	}

	
	


	@SuppressWarnings("unchecked")
	protected void fillSnapshotCombo() {
		SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
		java.util.List<Container> input = snapshotDao.getListByContainer
				(SessionSourceProvider.CURRENT_CONTAINER);

		snapshotComboViewer.setInput(input);
		if ( snapshotCombo.getItemCount() > 0 ) 
			snapshotCombo.select(0);
	}

	@SuppressWarnings("unchecked")
	private void fillContainerCombo(ComboViewer containerComboViewer, Combo containerCombo) {
		ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
		java.util.List<Container> input = containerDao.getListByOwner(Container.class, SessionSourceProvider.USER);
		
		containerComboViewer.setInput(input);
		if ( containerCombo.getItemCount() > 0 ) 
			containerCombo.select(0);
	}

	protected void fillSnapshotTree() {
		snapshotTree.removeAll();
		FolderDao folderObjectDao = DaoFactory.eINSTANCE.createFolderDao();
		Folder folder = 
				folderObjectDao.getRootFolderBySnapshot(
						SessionSourceProvider.CURRENT_SNAPSHOT);
		snapshotTreeViewer.setInput(folder);
	}
	
	
	
	
	
	@Override
	public void setFocus() {}
}
