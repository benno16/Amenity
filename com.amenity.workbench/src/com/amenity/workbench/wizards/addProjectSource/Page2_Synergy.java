package com.amenity.workbench.wizards.addProjectSource;

import general.Connection;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.amenity.engine.helper.synergy.SynergyLogin;
import com.amenity.workbench.SessionSourceProvider;

public class Page2_Synergy extends WizardPage {
	
	private ProgressBar progressBar;
	private Label lblNewLabel;
	private Button btnConnect;
	private boolean finished;
	
	/**
	 * Create the wizard.
	 */
	public Page2_Synergy(Connection connection) {
		super("wizardPage");
		setTitle("Synergy Data Source Profile");
		setDescription("Please connect to Synergy");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		btnConnect = new Button(container, SWT.NONE);
		btnConnect.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				/*
				 * working example below but aweful! 
				 */
				finished = false;
				container.getDisplay().getDefault().asyncExec(new Runnable() {
					public void run() {
						progressBar.setMaximum(30000);
						for ( int i = 0; i<30 ; i++){
							progressBar.setSelection( 100*i );
							try {
								Thread.sleep(100);
							} catch ( InterruptedException e) {
								e.printStackTrace();
							}
							if ( finished ) break;
						}
					}
				});
				container.getDisplay().getDefault().asyncExec(new Runnable() {
					public void run() {
						btnConnect.setEnabled(false);
						
						SynergyLogin sgyLogin = new SynergyLogin();
						
						SessionSourceProvider.SYNERGY_SID = sgyLogin.getSynergySessionId();
						
						SessionSourceProvider.SESSION_STATUS.setSynergySession(SessionSourceProvider.SYNERGY_SID );
						if ( SessionSourceProvider.SYNERGY_SID == null ) {
							System.out.println("Error while creating SID");
							btnConnect.setEnabled(true);
						} else {
							if ( SessionSourceProvider.SYNERGY_PROJECT_LIST == null )
								SessionSourceProvider.SYNERGY_PROJECT_LIST = sgyLogin.getRawProjectList(
										SessionSourceProvider.SYNERGY_SID);
							
							if ( SessionSourceProvider.SYNERGY_PROJECT_LIST.size() > 0 ) {
								System.out.println(SessionSourceProvider.SYNERGY_PROJECT_LIST.size());
								ProjectWizard wizard = (ProjectWizard)getWizard();
								wizard.projectList = SessionSourceProvider.SYNERGY_PROJECT_LIST;
								lblNewLabel.setText("Connected with ID: " + 
										SessionSourceProvider.SYNERGY_SID);
								setPageComplete(true);
								finished = true;
								progressBar.setSelection(0);
							} else {
								/**
								 * TODO: Nicer error messages
								 */
								System.out.println("Error while reading projects");
							}
						}
					}
				});
			}
		});
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
		
		progressBar = new ProgressBar(container, SWT.NONE);
		progressBar.setBounds(10, 255, 554, 17);
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
		System.out.println("there are Elements: " + wizard.projectList.size());
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
				finished = true;
				progressBar.setSelection(0);
			}
        
	        lblNewLabel.getDisplay().asyncExec(new Runnable() {
	        	public void run() {
	        	lblNewLabel.setText("Connected with ID: " + 
						SessionSourceProvider.SYNERGY_SID);
	        	}
	        });
		}
	}
}
