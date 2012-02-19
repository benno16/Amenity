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

public class Page2_Synergy extends WizardPage {
	
	private ProgressBar progressBar;
	private Label lblNewLabel;
	
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
		
		Button btnConnect = new Button(container, SWT.NONE);
		btnConnect.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void widgetSelected(SelectionEvent e) {
				container.getDisplay().getDefault().asyncExec(new Runnable() {
					public void run() {
						progressBar.setMaximum(5000);
						for ( int i = 1 ; i < 51 ; i++ ) {
							progressBar.setSelection(100*i);
							try {
								Thread.sleep(100);
							} catch ( InterruptedException e) {
								e.printStackTrace();
							}
						}
						progressBar.setSelection(0);
						lblNewLabel.setText("Connected with ID 123123123");
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
		
	}
}
