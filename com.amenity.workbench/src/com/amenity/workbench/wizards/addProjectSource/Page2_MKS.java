package com.amenity.workbench.wizards.addProjectSource;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Page2_MKS extends WizardPage {
	private Text text;
	private Text text_1;

	/**
	 * Create the wizard.
	 */
	public Page2_MKS() {
		super("wizardPage");
		setTitle("MKS Data Source Profile");
		setDescription("Please enter your MKS Integrity account details");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		Label lblUsername = new Label(container, SWT.NONE);
		lblUsername.setBounds(10, 13, 100, 15);
		lblUsername.setText("Username");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(116, 10, 448, 21);
		text.setText(System.getenv("username"));
		
		Label lblPassword = new Label(container, SWT.NONE);
		lblPassword.setBounds(10, 40, 100, 15);
		lblPassword.setText("Password");
		
		text_1 = new Text(container, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(116, 37, 448, 21);
		
		Combo combo = new Combo(container, SWT.NONE);
		combo.setBounds(116, 64, 448, 23);
		combo.add("mks-bs",0);
		combo.select(0);
		
		Label lblMksServer = new Label(container, SWT.NONE);
		lblMksServer.setBounds(10, 67, 100, 15);
		lblMksServer.setText("MKS Server");
		
		Button btnSaveSettings = new Button(container, SWT.CHECK);
		btnSaveSettings.setBounds(464, 93, 100, 16);
		btnSaveSettings.setText("Save Settings");
		
		Button btnTest = new Button(container, SWT.NONE);
		btnTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ( loginWorking() ) {
					MessageDialog.openInformation(container.getShell(), "MKS Login Test", "Test successful!");
				} else {
					MessageDialog.openError(container.getShell(), "MKS Login Test", "Login not successful! ");
				}
			}
		});
		btnTest.setBounds(245, 149, 100, 25);
		btnTest.setText("Test Settings");
	}
	
	public boolean loginWorking() {
		if (text.getText().length() > 0 && text_1.getText().length() > 0 ) {
			return true;
		} else {
			return false;
		}
	}
	
}
