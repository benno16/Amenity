package com.amenity.workbench.wizards.addSnapshot;

import general.Connection;
import general.ConnectionType;
import general.Container;
import general.GeneralFactory;
import general.Snapshot;

import java.util.Date;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ProgressBar;

import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.engine.helper.mks.MksReader;
import com.amenity.engine.helper.synergy.SynergyLogin;
import com.amenity.engine.helper.synergy.SynergyReader;
import com.amenity.workbench.SessionSourceProvider;

import dao.ConnectionDao;
import dao.ContainerDao;
import dao.DaoFactory;
import dao.SnapshotDao;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

public class Page1 extends WizardPage {
	private Text text_name;
	private Text text_comment;
	private Button btnCreate;
	private ProgressBar progressBar;
	private Composite container;
	private ComboViewer containerComboViewer;
	private ComboViewer connectionComboViewer;
	private Connection current_connection;
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	private Snapshot snapshot;
	/**
	 * Create the wizard.
	 */
	public Page1() {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
		snapshot = GeneralFactory.eINSTANCE.createSnapshot();
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		Label lblContainer = new Label(container, SWT.NONE);
		lblContainer.setBounds(10, 13, 100, 15);
		lblContainer.setText("Container");
		
		Label lblConnection = new Label(container, SWT.NONE);
		lblConnection.setBounds(10, 42, 100, 15);
		lblConnection.setText("Connection");
		
		text_name = new Text(container, SWT.BORDER);
		text_name.setBounds(116, 68, 448, 21);
		
		Label lblName = new Label(container, SWT.NONE);
		lblName.setBounds(10, 71, 100, 15);
		lblName.setText("Name");
		
		text_comment = new Text(container, SWT.BORDER);
		text_comment.setBounds(116, 95, 448, 21);
		
		Label lblComment = new Label(container, SWT.NONE);
		lblComment.setBounds(10, 98, 100, 15);
		lblComment.setText("Comment");
		
		btnCreate = new Button(container, SWT.NONE);
		btnCreate.setBounds(489, 175, 75, 25);
		btnCreate.setText("Create");
		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ( text_name.getText().length()< 1 ) {
					/**
					 * TODO: Nicer error msg
					 */
					System.out.println("no name entered");
				} else {
					/**
					 * TODO: Concurrency with progress bar
					 */
					System.out.println("<<< Start task");
					fetchMetaInformation(current_connection);
					System.out.println("<<< End task");
					setPageComplete(true);
				}
				
			}
		});
		
		progressBar = new ProgressBar(container, SWT.NONE);
		progressBar.setBounds(10, 255, 554, 17);
		
		containerComboViewer = new ComboViewer(container, SWT.NONE);
		Combo containerCombo = containerComboViewer.getCombo();
		containerCombo.setBounds(116, 10, 448, 21);
		
		containerComboViewer.setLabelProvider(new GenericNameLabelProvider());
		
		containerComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Container>)inputElement ) .toArray();
			}
		});
		
		containerComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( !structuredSelection.isEmpty()) {
		        	if ( structuredSelection.getFirstElement() instanceof Container ) {
		        		SessionSourceProvider.CURRENT_CONTAINER = 
		        			(Container) structuredSelection.getFirstElement();
		        		getConnectionList();
		        	}
		        }
			}
			
		});

		connectionComboViewer = new ComboViewer(container, SWT.NONE);
		Combo connectionCombo = connectionComboViewer.getCombo();
		connectionCombo.setBounds(116, 39, 448, 21);

		connectionComboViewer.setLabelProvider(new GenericNameLabelProvider());
		
		connectionComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Connection>)inputElement ) .toArray();
			}
		});
		
		connectionComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( !structuredSelection.isEmpty()) {
		        	if ( structuredSelection.getFirstElement() instanceof Connection ) {
		        		if ( text_name.getText().length() > 1 ) {
		        		} else {
		        			System.out.println("set name");
		        		}
		        		current_connection = (Connection) structuredSelection.getFirstElement();
	        			btnCreate.setEnabled(true);
		        	}
		        }
			}
			
		});
		
		
		getContainerList();
		setPageComplete(false);
	}
	
	protected boolean fetchMetaInformation( Connection connection ) {
		
		createSnapshot();
		
		if ( current_connection.getConnectionType() == ConnectionType.MKS) {
			MksReader mksReader = new MksReader( current_connection, 
					SessionSourceProvider.CURRENT_SNAPSHOT );
			if ( current_connection.getAddInfo4().equals("Sandbox"))
				mksReader.getSandboxFiles();
			else
				mksReader.getProjectFiles();
		} else if ( current_connection.getConnectionType() == ConnectionType.SYNERGY ) {
			if ( SessionSourceProvider.SYNERGY_SID == null ) {
				SessionSourceProvider.SYNERGY_SID = new SynergyLogin().getSynergySessionId();
			}
			System.out.println("Its a sgy session " + SessionSourceProvider.SYNERGY_SID);
			SynergyReader synergyReader = new SynergyReader (SessionSourceProvider.SYNERGY_SID,
					current_connection, SessionSourceProvider.CURRENT_SNAPSHOT );
			synergyReader.getProjectFiles();
		}
		/**
		 * TODO: Fix the below problem...
		 */
//		SessionSourceProvider.CURRENT_SNAPSHOT.setVia(current_connection);
//		SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
//		snapshotDao.update(SessionSourceProvider.CURRENT_SNAPSHOT);
		
		return true;
	}

	private void createSnapshot() {

		snapshot.setCreated(new Date());
		snapshot.setName(text_name.getText());
		snapshot.setComment(text_comment.getText());
		/**
		 * TODO: TEST This feature
		 */
		System.out.println(current_connection.getConnectionId());
		snapshot.setVia(current_connection);
		SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
		snapshotDao.create(snapshot);
		SessionSourceProvider.CURRENT_SNAPSHOT = snapshot;
		
	}

	protected void getConnectionList() {
		if ( SessionSourceProvider.CURRENT_CONTAINER != null ) {
			ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
			connectionComboViewer.setInput( connectionDao
					.getListByContainer( SessionSourceProvider.CURRENT_CONTAINER ) );

		} else {
			/**
			 * TODO: nicer error message
			 */
			System.out.println("No container selected");
		}
	}

	// used to fetch container list if not yet available
	@SuppressWarnings("unchecked")
	protected void getContainerList() {
		if ( SessionSourceProvider.CONTAINER_LIST.size() < 1) {
			ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
			SessionSourceProvider.CONTAINER_LIST = containerDao.getListByOwner(Container.class, 
					SessionSourceProvider.USER);
		} 
		containerComboViewer.setInput(SessionSourceProvider.CONTAINER_LIST);
	}
}
