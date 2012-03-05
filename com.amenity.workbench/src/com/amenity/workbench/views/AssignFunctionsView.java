package com.amenity.workbench.views;


import java.util.ArrayList;
import java.util.Date;

import general.Container;
import general.ContentObject;
import general.File;
import general.FileFunctionStatus;
import general.Folder;
import general.Function;
import general.GeneralFactory;
import general.Snapshot;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
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
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.engine.helper.gui.labelProvider.SnapshotStyledLabelProvder;
import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.dialogs.CreateFunctionDialog;

import dao.ContainerDao;
import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.FileFunctionStatusDao;
import dao.FolderDao;
import dao.FunctionDao;
import dao.SnapshotDao;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AssignFunctionsView extends ViewPart {
	public static String newFn = null;
	private Text functionNameText;
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	
	private ComboViewer functionComboViewer;
	private Combo functionCombo;
	private ComboViewer snapshotComboViewer;
	private Combo snapshotCombo;
	private TreeViewer snapshotTreeViewer;
	private TreeViewer functionTreeViewer;
	private Tree snapshotTree;
	private Tree functionTree;
	private Composite composite;
	private java.util.List<ContentObject> contentObjects;
	private java.util.List<Function> functions;
	

	public AssignFunctionsView() {
		contentObjects = new ArrayList<ContentObject>();
		functions = new ArrayList<Function>();
	}

	@SuppressWarnings("unused")
	@Override
	public void createPartControl(Composite parent) {
		this.composite = parent;
		GridLayout gridLayout = new GridLayout(9,true);
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
		        		
		        		fillFunctionCombo();
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
		
		functionComboViewer.setLabelProvider(new GenericNameLabelProvider());
		functionComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Snapshot>)inputElement ) .toArray();
			}
		});
		functionComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof Function) {
						SessionSourceProvider.CURRENT_FUNCTION = (Function) 
								structuredSelection.getFirstElement();
					}
				}
			}
		});
		
		Button btnAdd = new Button(parent, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ( SessionSourceProvider.CURRENT_SNAPSHOT != null ) {
					CreateFunctionDialog dialog = new CreateFunctionDialog(composite.getShell(), 
							newFn, SessionSourceProvider.CURRENT_SNAPSHOT.getName());
					if ( dialog.open() == Window.OK) {
						Function function = GeneralFactory.eINSTANCE.createFunction();
						function.setCreated(new Date());
						function.setSnapshot(SessionSourceProvider.CURRENT_SNAPSHOT);
						function.setName(newFn);
						function.setModified(new Date());
						FunctionDao functionDao = DaoFactory.eINSTANCE.createFunctionDao();
						functionDao.create(function);
//						functions = functionDao.getFunctionsBySnapshot(SessionSourceProvider.CURRENT_SNAPSHOT);
//						functionComboViewer.setInput(functions);
						fillFunctionCombo();
					}
				}
				
			}
		});
		btnAdd.setText("Add");
		
		
		
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
		new Label(parent, SWT.NONE);
		
		/**
		 * TODO: implement multi select
		 * SWT.MULTI
		 */
		snapshotTreeViewer = new TreeViewer( parent, SWT.BORDER );
		snapshotTree = snapshotTreeViewer.getTree();
		snapshotTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		snapshotTreeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public void dispose() {}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

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
		snapshotTreeViewer.setLabelProvider(new SnapshotStyledLabelProvder
				(SessionSourceProvider.CURRENT_SNAPSHOT));
		/**
		 * TODO: Temp sorter implementation
		 * Issue here its basically sorting strictly by name not type! 
		 */
		snapshotTreeViewer.setSorter(new ViewerSorter() {
			public int compare ( TreeViewer snapshotTreeViewer, Object obj1, Object obj2) {
				if ( obj1 instanceof File && obj2 instanceof File ) {
					return ((File) obj1).getName().compareTo(((File) obj2).getName());
				} else if ( obj1 instanceof Folder && obj2 instanceof Folder ) {
					return ((Folder) obj1).getName().compareTo(((Folder) obj2).getName());
				} else if ( obj1 instanceof Folder && obj2 instanceof File ) {
					return 1;
				} 
				return 0;
			}	
		});
		
		
		/**
		 * TODO: Drag and Drop
		 */
		int operations = DND.DROP_MOVE | DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { TextTransfer.getInstance() };
		
	    snapshotTreeViewer.addDragSupport(operations, transfers, new DragSourceListener() {

			@Override
			public void dragFinished(DragSourceEvent event) {
			}
			@Override
			public void dragSetData(DragSourceEvent event) {
				// Here you do the convertion to the type which is expected.
				IStructuredSelection selection = (IStructuredSelection) snapshotTreeViewer.getSelection();
				ContentObject firstElement = (ContentObject) selection.getFirstElement();
				
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = firstElement.getObjectId(); 
				}
			}
			
			@Override
			public void dragStart(DragSourceEvent event) {
			}

		});
		
		
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
		
		functionTreeViewer = new TreeViewer(parent, SWT.BORDER);
		functionTree = functionTreeViewer.getTree();
		functionTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		functionTreeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public void dispose() {}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

			@Override
			public Object[] getElements(Object inputElement) {
				return contentObjects.toArray();
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
		functionTreeViewer.setLabelProvider(new GenericNameLabelProvider());

	    functionTreeViewer.addDropSupport(operations, transfers, new ViewerDropAdapter(snapshotComboViewer) {

			public void drop ( DropTargetEvent event ) {
				int location = this.determineLocation(event);
				determineTarget ( event ) ;
				super.drop(event); 
			}
			
			@Override
			public boolean performDrop(Object data) {
				/**
				 * TODO: prettier message
				 */
				if ( SessionSourceProvider.CURRENT_FUNCTION != null ) {
					ContentObjectDao contentObjectDao = DaoFactory.eINSTANCE.createContentObjectDao();
					ContentObject co = GeneralFactory.eINSTANCE.createContentObject();
					co = (ContentObject) contentObjectDao.getById(data.toString());
					
					co.getFunction().add(SessionSourceProvider.CURRENT_FUNCTION);
					contentObjectDao.create(co);
					contentObjects.add(co);
					
					
//					FileFunctionStatusDao fileFunctionStatusDao = 
//							DaoFactory.eINSTANCE.createFileFunctionStatusDao();
					
//					for ( ContentObject co : contentObjects) {
////						FileFunctionStatus ffs = GeneralFactory.eINSTANCE.createFileFunctionStatus();
////						ffs.setOfFile(co);
////						ffs.setOfFunction(SessionSourceProvider.CURRENT_FUNCTION);
////						fileFunctionStatusDao.create(ffs);
//						co.getFunction().add(SessionSourceProvider.CURRENT_FUNCTION);
//						contentObjectDao.update(co);
//					}
					functionTreeViewer.setInput(contentObjects);
				}
				return false;
			}

			@Override
			public boolean validateDrop(Object target, int operation,
					TransferData transferType) {
				return true;
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
		new Label(parent, SWT.NONE);
		
		Label lblFunctionName = new Label(parent, SWT.NONE);
		GridData gd_lblFunctionName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblFunctionName.widthHint = 85;
		lblFunctionName.setLayoutData(gd_lblFunctionName);
		lblFunctionName.setText("Function Name");
		new Label(parent, SWT.NONE);
		
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
		new Label(parent, SWT.NONE);
		
		Label lblConfigured = new Label(parent, SWT.NONE);
		lblConfigured.setText("Configured");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		fillContainerCombo(containerComboViewer, containerCombo);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Button btnSave = new Button(parent, SWT.NONE);
		btnSave.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnSave.setText("Save");
		btnSave.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_ETOOL_SAVE_EDIT));
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/**
				 * TODO: read info from middle tree and store asso
				 * 
				 */
			}
		});
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
	}

	
	


	@SuppressWarnings("unchecked")
	protected void fillFunctionCombo() {
		functions.clear();
		contentObjects.clear();
		FunctionDao functionDao = DaoFactory.eINSTANCE.createFunctionDao();
		functions = functionDao.getFunctionsBySnapshot(SessionSourceProvider.CURRENT_SNAPSHOT);
		functionComboViewer.setInput(functions);
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
		snapshotTreeViewer.setLabelProvider(new SnapshotStyledLabelProvder
				(SessionSourceProvider.CURRENT_SNAPSHOT));
		FolderDao folderObjectDao = DaoFactory.eINSTANCE.createFolderDao();
		Folder folder = 
				folderObjectDao.getRootFolderBySnapshot(
						SessionSourceProvider.CURRENT_SNAPSHOT);
		snapshotTreeViewer.setInput(folder);
	}
	
	
	
	
	
	@Override
	public void setFocus() {}
}
