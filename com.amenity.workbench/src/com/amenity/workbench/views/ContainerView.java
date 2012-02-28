package com.amenity.workbench.views;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import general.Container;
import general.Snapshot;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.TableColumn;

import com.amenity.engine.helper.gui.ContainerLabelProvider;
import com.amenity.engine.helper.gui.contentProvider.ConnectionTreeContentProvider;
import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.dialogs.ModifyContainerDialog;
import com.amenity.workbench.wizards.addContainer.ContainerWizard;

import dao.ContainerDao;
import dao.DaoFactory;
import org.eclipse.swt.layout.GridData;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewerColumn;

import swing2swt.layout.BorderLayout;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;

public class ContainerView extends ViewPart {

	public static final String ID = "com.amenity.rcp.ui.views.ContainerView"; //$NON-NLS-1$
	private ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
	@SuppressWarnings("unused")
	private Composite parent;
	private Button btnDelete;
	private Button btnModify;
	private Button btnCreate;
	private ListViewer listViewer;
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	private TreeViewer detailTreeViewer;
	private Tree detailTree;
	private Table settingsTable;
	private TableViewer settingsTableViewer;
	
	public ContainerView() {
	}
	
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void createPartControl(final Composite parent) {
		this.parent =parent;
		parent.setLayout(new BorderLayout(0, 0));
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.widthHint = 287;
		
		Composite composite_2 = new Composite(parent, SWT.NONE);
		composite_2.setLayoutData(BorderLayout.WEST);
		composite_2.setLayout(null);
		
		Label label_1 = new Label(composite_2, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 167, 261, 2);
		
		Label lblAvailableContainer = new Label(composite_2, SWT.NONE);
		lblAvailableContainer.setBounds(10, 10, 237, 15);
		lblAvailableContainer.setText("Available Container");
		
		btnCreate = new Button(composite_2, SWT.NONE);
		btnCreate.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/folder_new.png"));
		btnCreate.setBounds(10, 136, 75, 25);
		btnCreate.setText("Create");

		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				ContainerWizard wizard = new ContainerWizard(SessionSourceProvider.CONTAINER_LIST);
				ContainerWizard wizard = new ContainerWizard();
				WizardDialog dialog = new WizardDialog ( parent.getShell(), wizard );
				dialog.open();
				enableButtons();
			}
		});
		
		// Delete Button
		btnDelete = new Button(composite_2, SWT.NONE);
		btnDelete.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gtk-cancel.png"));
		btnDelete.setBounds(91, 136, 75, 25);
		btnDelete.setText("Delete");
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog msg = new MessageDialog ( parent.getShell(), 
						"Warning", null, 
						"Are you sure you want to delete the container '" 
						+ SessionSourceProvider.CURRENT_CONTAINER.getName() + "'? \n" +
						"This operation cannot be reversed!", 
						MessageDialog.WARNING, 
						new String[] {"Delete", "Keep"}, 1);
				if ( msg.open() == 0 ) {
					Container c = null;
					for ( Iterator<Container> iter = SessionSourceProvider.CONTAINER_LIST.iterator(); iter.hasNext(); ) {
						c = iter.next();
						if ( c.equals(SessionSourceProvider.CURRENT_CONTAINER )) {
							iter.remove();
							SessionSourceProvider.CURRENT_CONTAINER = null;
							break;
						}
					}
					containerDao.delete(c);
				}
				enableButtons();
			}
		});
		
		btnModify = new Button(composite_2, SWT.NONE);
		btnModify.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/database_edit.png"));
		btnModify.setBounds(172, 136, 75, 25);
//		btnModify.setText("Rename");
//
//		btnModify.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected ( SelectionEvent e ) {
//				RenameTitleAreaDialog dialog = new RenameTitleAreaDialog ( parent.getShell(), SessionSourceProvider.CURRENT_CONTAINER, SessionSourceProvider.CONTAINER_LIST ); 
//				dialog.open();
//				containerDao.update(SessionSourceProvider.CURRENT_CONTAINER);
//				enableButtons();
//			}
//		});
		
		/**
		 * TODO TESTING Data binding for EMF
		 * 
		 */
		btnModify.setText("Modify");

		btnModify.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected ( SelectionEvent e ) {
				ModifyContainerDialog dialog = new ModifyContainerDialog ( parent.getShell()); 
				if ( dialog.open() == Window.OK) {
					containerDao.update(SessionSourceProvider.CURRENT_CONTAINER);
				}
				
			}
		});
		
		/**
		 * END OF TEST! 
		 */
		
		listViewer = new ListViewer(composite_2, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/**
				 * TODO set global var
				 */
				objectSelection = listViewer.getSelection();
				
			}
		});
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {

		    public void selectionChanged(SelectionChangedEvent event) {
		        // Handle selection changed event here
		    	objectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( !structuredSelection.isEmpty()) {
		        	if ( structuredSelection.getFirstElement() instanceof Container ) {
		        		SessionSourceProvider.CURRENT_CONTAINER = 
		        			(Container) structuredSelection.getFirstElement(); 
		        		detailTreeViewer.setInput(SessionSourceProvider.CURRENT_CONTAINER);
		        	}
		        }
			}
		});
		list.setBounds(10, 31, 237, 99);
		
		listViewer.setContentProvider(new ArrayContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Container>)inputElement ) .toArray();
			}
		});
		listViewer.setLabelProvider(new ContainerLabelProvider());
		listViewer.setInput(SessionSourceProvider.CONTAINER_LIST);

		detailTreeViewer = new TreeViewer(composite_2, SWT.BORDER);
		detailTreeViewer.setAutoExpandLevel(2);
		detailTree = detailTreeViewer.getTree();
		detailTree.setBounds(10, 194, 237, 265);
		
		Label lblConnectionsAndSnapshots = new Label(composite_2, SWT.NONE);
		lblConnectionsAndSnapshots.setBounds(10, 175, 241, 13);
		lblConnectionsAndSnapshots.setText("Connections and Snapshots");

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(BorderLayout.SOUTH);
		
		detailTreeViewer.setLabelProvider(new GenericNameLabelProvider());
		detailTreeViewer.setContentProvider(new ConnectionTreeContentProvider());
		detailTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof Snapshot ) {
						SessionSourceProvider.CURRENT_SNAPSHOT = 
								(Snapshot) structuredSelection.getFirstElement();
						java.util.List<Snapshot> snapshots = new ArrayList<Snapshot>();
						snapshots.add(SessionSourceProvider.CURRENT_SNAPSHOT);
						settingsTableViewer.setInput(snapshots.toArray());
					}
				}
			}
		});
		/**
		 * TODO: Fill in settings table
		 */
		settingsTableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		createColumns(parent, settingsTable);
		settingsTable = settingsTableViewer.getTable();
		settingsTable.setLayoutData(BorderLayout.CENTER);
		settingsTable.setHeaderVisible(true);
		settingsTable.setLinesVisible(true);
//		// publish viewer
//		getSite().setSelectionProvider(settingsTableViewer);
		settingsTableViewer.setContentProvider(new ArrayContentProvider());
		
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		settingsTableViewer.getControl().setLayoutData(gridData);
		
		enableButtons();
	}
	
	private void createColumns(Composite parent2, Table settingsTable2) {
		String[] titles = {"Name", "Comment" , "Connection"};
		int[] bounds = {100, 100, 100};
		TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Snapshot s = (Snapshot) element;
				return s.getName();
			}
		});

		col = createTableViewerColumn(titles[1], bounds[1], 1);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Snapshot s = (Snapshot) element;
				return s.getComment();
			}
		});

		col = createTableViewerColumn(titles[2], bounds[2], 2);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Snapshot s = (Snapshot) element;
				return s.getVia().getConnectionType().getName();
			}
		});
		
	}

	private TableViewerColumn createTableViewerColumn(String string, int bound,
			final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(settingsTableViewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(string);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	protected static Comparator<Container> newAscStringComparator() {
	    return new Comparator<Container>() {
	      @Override
	      public int compare(Container first , Container second) {
	        return String.valueOf(first.getName()).compareTo(String.valueOf(second.getName()));
	      }
	    };
	  }

	@Override
	public void setFocus() {
		// Set the focus
	}
	
	
	private void enableButtons() {

		if ( SessionSourceProvider.CONTAINER_LIST.size() < 1 ) {
			btnModify.setEnabled(false);
			btnDelete.setEnabled(false);
		} else {
			btnModify.setEnabled(true);
			btnDelete.setEnabled(true);
		}
		listViewer.setInput(SessionSourceProvider.CONTAINER_LIST);
	}
}
