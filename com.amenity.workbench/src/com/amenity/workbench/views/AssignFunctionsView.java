package com.amenity.workbench.views;

import general.Container;
import general.ContentObject;
import general.Folder;
import general.Snapshot;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
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
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.amenity.engine.helper.gui.contentProvider.ComponentObjectTreeContentProvider;
import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.workbench.SessionSourceProvider;

import dao.ContainerDao;
import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.FolderDao;
import dao.SnapshotDao;

public class AssignFunctionsView extends ViewPart {
	private Text functionNameText;
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	private Composite composite;
	
	private ComboViewer functionComboViewer;
	private Combo functionCombo;
	private ComboViewer snapshotComboViewer;
	private Combo snapshotCombo;
	private TreeViewer snapshotTreeViewer;
	private Tree snapshotTree;

	public AssignFunctionsView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		composite = parent;
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
		
		snapshotTreeViewer = new TreeViewer(parent, SWT.BORDER);
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
				/**
				 * TODO: Query fetching children content objects
				 */
				return null;
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				/**
				 * TODO: Query fetching children content objects
				 */
				return null;
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
		
		DropTarget dropTarget = new DropTarget(snapshotTree, DND.DROP_MOVE);
		
		DragSource dragSource_1 = new DragSource(snapshotTree, DND.DROP_MOVE);
		
		Composite composite_1 = new Composite(parent, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		composite_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button arrowLeftLeft = new Button(composite_1, SWT.NONE);
		arrowLeftLeft.setText("<");
		
		Button arrowLeftRight = new Button(composite_1, SWT.NONE);
		arrowLeftRight.setText(">");
		
		TreeViewer functionTreeViewer = new TreeViewer(parent, SWT.BORDER);
		Tree functionTree = functionTreeViewer.getTree();
		functionTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		DragSource dragSource = new DragSource(functionTree, DND.DROP_MOVE);
		
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
				(SessionSourceProvider.CURRENT_CONTAINER.getContainerId());

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
//		ContentObjectDao contentObjectDao = DaoFactory.eINSTANCE.createContentObjectDao();
//		java.util.List<ContentObject> contentObjects = 
//				contentObjectDao.getListBySnapshot(SessionSourceProvider.CURRENT_SNAPSHOT);
//		snapshotTreeViewer.setInput(contentObjects.toArray());
		snapshotTreeViewer.setInput(SessionSourceProvider.CURRENT_SNAPSHOT);
		FolderDao folderObjectDao = DaoFactory.eINSTANCE.createFolderDao();
		Folder folder = 
				folderObjectDao.getRootFolderBySnapshot(
						SessionSourceProvider.CURRENT_SNAPSHOT);
		snapshotTreeViewer.setInput(folder);
	}
	
	
	
	
	
	@Override
	public void setFocus() {
	}

}
