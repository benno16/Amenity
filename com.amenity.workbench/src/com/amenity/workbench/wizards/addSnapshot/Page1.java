package com.amenity.workbench.wizards.addSnapshot;

import general.Connection;
import general.Container;
import general.GeneralFactory;
import general.Snapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ProgressBar;

import com.amenity.engine.helper.mks.MksReader;
import com.amenity.workbench.SessionSourceProvider;

import dao.ConnectionDao;
import dao.ContainerDao;
import dao.DaoFactory;
import dao.GenericDao;

public class Page1 extends WizardPage {
	private Text text_name;
	private Text text_comment;
	private Combo combo_container;
	private Combo combo_connection;
	private Button btnCreate;
	private ProgressBar progressBar;
	private List<Container> containers;
	private List<Connection> connections;
	private Snapshot snapshot;
	private Composite container;
	private static boolean isFinished;
	
	/**
	 * Create the wizard.
	 */
	public Page1() {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
		containers = new ArrayList<Container>();
		connections = new ArrayList<Connection>();
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
		
		combo_container = new Combo(container, SWT.NONE);
		combo_container.setBounds(116, 10, 448, 23);
		combo_container.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setConnections( combo_container
						.getItem(combo_container.getSelectionIndex()) );
			}
		});
		
		combo_connection = new Combo(container, SWT.NONE);
		combo_connection.setBounds(116, 39, 448, 23);
		
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
//				if ( fetchMetaInformation() )
//					setPageComplete(true);
//				else 
//					setErrorMessage("Error while creating snapshot");
				
				// still stopping task to run :(
				Display.getCurrent().asyncExec(new Runnable() {
					public void run() {
						System.out.println("<<< Start task");
						fetchMetaInformation();
						System.out.println("<<< End task");
					}
				});
				
				Job job = new Job("First Job") {
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						doLongThing();
						syncWithUi();
						// Use this to open a Shell in the UI thread
						return Status.OK_STATUS;
					}

				};
				job.setUser(true);
				job.schedule();
				
			}
		});
		
		progressBar = new ProgressBar(container, SWT.NONE);
		progressBar.setBounds(10, 255, 554, 17);
		init();
		setPageComplete(false);
	}
	
	private void doDummy() {
		while (!isFinished) {
			try {
				// We simulate a long running operation here
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void doLongThing() {
		for (int i = 0; i < 10; i++) {
			try {
				// We simulate a long running operation here
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Doing something");
		}
	}
	private void syncWithUi() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(container.getShell(), "Your Popup ",
						"Your job has finished.");
			}
		});

	}
	protected boolean fetchMetaInformation() {
		Container container = null;
		for ( Container c : containers ) {
			if ( c.getName().toString()
					.equals(combo_container.getItem(combo_container
							.getSelectionIndex()))) {
				container = c;
				break;
			}
		}
		createSnapshot( container );
		Connection connection = null;
		for ( Connection c : connections ) {
			if ( c.getCreated().toString()
					.equals(combo_connection.getItem(combo_connection
							.getSelectionIndex()))) {
				connection = c;
				break;
			}
		}
		MksReader mksReader = new MksReader( connection, snapshot );
		if ( connection.getAddInfo4().equals("Sandbox"))
			mksReader.getSandboxFiles();
		else
			mksReader.getProjectFiles();
		isFinished = true;
		return true;
	}

	private void createSnapshot( Container container ) {
		snapshot.setCreated(new Date());
		snapshot.setPartOf(container);
		GenericDao genericDao = DaoFactory.eINSTANCE.createGenericDao();
		genericDao.create(snapshot);
	}

	protected void setConnections( String containerName ) {
		Container container = GeneralFactory.eINSTANCE.createContainer();
		for ( Container c : containers ) {
			if ( c.getName().equals(containerName)) {
				container = c;
				break;
			}
		}
		ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
		connections = connectionDao.getListByContainer( container );
		for ( Connection c : connections ) 
			combo_connection.add( c.getCreated().toString() );
	}

	@SuppressWarnings("unchecked")
	protected void init() {
		ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
		containers = containerDao.getListByOwner(Container.class, 
				SessionSourceProvider.USER);
		
		for ( Container c : containers )
			combo_container.add(c.getName());
		if ( containers.size() < 1 )
			System.out.println("error");
		else 
			combo_container.select(0);
		
	}
}
