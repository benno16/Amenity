package com.amenity.workbench.wizards.addProjectSource;

import general.Connection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.progress.UIJob;

import com.amenity.engine.helper.synergy.SynergyLogin;
import com.amenity.workbench.SessionSourceProvider;

public class Page2_Synergy extends WizardPage {
	
	private ProgressBar progressBar;
	private Label lblNewLabel;
	private Button btnConnect;
	private Logger log;
	private Composite container;
	private Job job;
	private Job job2;
	private Job job3;
	
	/**
	 * Create the wizard.
	 */
	public Page2_Synergy(Connection connection) {
		super("wizardPage");
		setTitle("Synergy Data Source Profile");
		setDescription("Please connect to Synergy");
		/*
		 * logger creation and initialization
		 */
		log = LogManager.getLogger(Page2_Synergy.class);
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		btnConnect = new Button(container, SWT.NONE);
		
		
		btnConnect.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected ( SelectionEvent e ) {
				
				job2 = new Job("bar update") {
					protected IStatus run(IProgressMonitor monitor ) {
						startProgressBar();

						return Status.OK_STATUS;
					};
				};
				job3 = new Job("bar update") {
					protected IStatus run(IProgressMonitor monitor ) {
						stopProgressBar();

						return Status.OK_STATUS;
					};
				};
				
				job = new Job("Synergy Connect") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						// start progressbar
						job2.schedule();
						
						/*
						 * TODO: check thread issue. most likely exporting to async task
						 *  Synergy connection starts here
						 */
						
						
						SynergyLogin sgyLogin = new SynergyLogin();
						
						SessionSourceProvider.SYNERGY_SID = sgyLogin.getSynergySessionId();
						
						SessionSourceProvider.SESSION_STATUS.setSynergySession(SessionSourceProvider.SYNERGY_SID );
						
						if ( SessionSourceProvider.SYNERGY_PROJECT_LIST == null )
							SessionSourceProvider.SYNERGY_PROJECT_LIST = sgyLogin.getRawProjectList(
									SessionSourceProvider.SYNERGY_SID);
						
						/*
						 *  Synergy connection ends here
						 */
						
						// inform about finish status
						job3.schedule();
						syncWithUi();
						return Status.OK_STATUS;
					}
				};

				job.setUser(true);
				job.schedule();
			}
			
		});
		
		
		// Original starts here
		
		
//		btnConnect.addSelectionListener(new SelectionAdapter() {
//			@SuppressWarnings("static-access")
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				
//				/*
//				 * working example below but aweful! 
//				 */
//				finished = false;
//				container.getDisplay().getDefault().asyncExec(new Runnable() {
//					public void run() {
//						progressBar.setMaximum(30000);
//						for ( int i = 0; i<30 ; i++){
//							progressBar.setSelection( 100*i );
//							try {
//								Thread.sleep(100);
//							} catch ( InterruptedException e) {
//								e.printStackTrace();
//							}
//							if ( finished ) break;
//						}
//					}
//				});
//				container.getDisplay().getDefault().asyncExec(new Runnable() {
//					public void run() {
//						btnConnect.setEnabled(false);
//						
//						SynergyLogin sgyLogin = new SynergyLogin();
//						
//						SessionSourceProvider.SYNERGY_SID = sgyLogin.getSynergySessionId();
//						
//						SessionSourceProvider.SESSION_STATUS.setSynergySession(SessionSourceProvider.SYNERGY_SID );
//						if ( SessionSourceProvider.SYNERGY_SID == null ) {
//							log.error("Error while creating SID");
//							btnConnect.setEnabled(true);
//						} else {
//							if ( SessionSourceProvider.SYNERGY_PROJECT_LIST == null )
//								SessionSourceProvider.SYNERGY_PROJECT_LIST = sgyLogin.getRawProjectList(
//										SessionSourceProvider.SYNERGY_SID);
//							
//							if ( SessionSourceProvider.SYNERGY_PROJECT_LIST.size() > 0 ) {
//								log.info(SessionSourceProvider.SYNERGY_PROJECT_LIST.size());
//								ProjectWizard wizard = (ProjectWizard)getWizard();
//								wizard.projectList = SessionSourceProvider.SYNERGY_PROJECT_LIST;
//								lblNewLabel.setText("Connected with ID: " + 
//										SessionSourceProvider.SYNERGY_SID);
//								SessionSourceProvider.SESSION_STATUS
//									.setSynergySession(SessionSourceProvider.SYNERGY_SID);
//								setPageComplete(true);
//								finished = true;
//								progressBar.setSelection(0);
//							} else {
//								/**
//								 * TODO: Nicer error messages
//								 */
//								log.error("Error while reading projects");
//							}
//						}
//					}
//				});
//			}
//		});
		
		// Original ends here
		
		btnConnect.setBounds(241, 47, 75, 25);
		btnConnect.setText("Connect");
		
		Label lblEstablishSynergyConnection = new Label(container, SWT.NONE);
		lblEstablishSynergyConnection.setBounds(10, 10, 200, 15);
		lblEstablishSynergyConnection.setText("Establish Synergy Connection");
		
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 78, 554, 2);
		
		lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("-");
		lblNewLabel.setBounds(10, 234, 554, 15);

//		progressBar = new ProgressBar(container, SWT.NONE);
		progressBar = new ProgressBar(container, SWT.INDETERMINATE|SWT.HORIZONTAL);
		progressBar.setBounds(10, 255, 554, 17);
//		progressBar.setMaximum(100);
		progressBar.setState(SWT.PAUSED); //.setEnabled(false);
		if ( SessionSourceProvider.SYNERGY_SID == null ) {
			setPageComplete(false);
			btnConnect.setEnabled(true);
		} else {
			setPageComplete(true);
			btnConnect.setEnabled(false);
		}
	}

	
	void buttonPressed( int buttonId ) {
		System.out.println("button pressed" + buttonId);
	}
	
	void nextPressed() {
		ProjectWizard wizard = (ProjectWizard)getWizard();
		wizard.three_sgy.createProjectList(wizard.projectList);
	}

	@SuppressWarnings("unused")
	private void doConnect() {
		btnConnect.setEnabled(false);
		
		SynergyLogin sgyLogin = new SynergyLogin();
		
		SessionSourceProvider.SYNERGY_SID = sgyLogin.getSynergySessionId();
		
		SessionSourceProvider.SESSION_STATUS.setSynergySession(SessionSourceProvider.SYNERGY_SID );
		if ( SessionSourceProvider.SYNERGY_SID == null ) {
			System.out.println("Error while creating SID");
			btnConnect.setEnabled(true);
		} else {
			if ( SessionSourceProvider.SYNERGY_PROJECT_LIST == null )
				SessionSourceProvider.SYNERGY_PROJECT_LIST = sgyLogin.getRawProjectList(SessionSourceProvider.SYNERGY_SID);
			if ( SessionSourceProvider.SYNERGY_PROJECT_LIST.size() > 0 ) {
				System.out.println(SessionSourceProvider.SYNERGY_PROJECT_LIST.size());
				ProjectWizard wizard = (ProjectWizard)getWizard();
				wizard.projectList = SessionSourceProvider.SYNERGY_PROJECT_LIST;
				lblNewLabel.setText("Connected with ID: " + 
						SessionSourceProvider.SYNERGY_SID);
				setPageComplete(true);
			}
        
	        lblNewLabel.getDisplay().asyncExec(new Runnable() {
	        	public void run() {
	        	lblNewLabel.setText("Connected with ID: " + 
						SessionSourceProvider.SYNERGY_SID);
	        	}
	        });
		}
	}
	
	private void syncWithUi() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(container.getShell(), "Status Message",
						"The Synergy Connection is established");
//				lblNewLabel.setText("ID 123123");
				
				
				if ( SessionSourceProvider.SYNERGY_SID == null ) {
					log.error("Error while creating SID");
					btnConnect.setEnabled(true);
				} else 
					if ( SessionSourceProvider.SYNERGY_PROJECT_LIST.size() > 0 ) {
						log.info(SessionSourceProvider.SYNERGY_PROJECT_LIST.size());
						ProjectWizard wizard = (ProjectWizard)getWizard();
						wizard.projectList = SessionSourceProvider.SYNERGY_PROJECT_LIST;
						lblNewLabel.setText("Connected with ID: " + 
								SessionSourceProvider.SYNERGY_SID);
						SessionSourceProvider.SESSION_STATUS
							.setSynergySession(SessionSourceProvider.SYNERGY_SID);
						setPageComplete(true);
				} else {
						/**
						 * TODO: Nicer error messages
						 */
						log.error("Error while reading projects");
					
				}
			}
		});
	}
	
	
	private void startProgressBar() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				btnConnect.setEnabled(false);
				progressBar.setState(SWT.NORMAL);
			}
		});
	}
	private void stopProgressBar() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				progressBar.setState(SWT.PAUSED);
			}
		});
	}
}
