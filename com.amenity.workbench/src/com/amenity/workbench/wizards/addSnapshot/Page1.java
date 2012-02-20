package com.amenity.workbench.wizards.addSnapshot;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ProgressBar;

public class Page1 extends WizardPage {
	private Text text_name;
	private Text text_comment;

	/**
	 * Create the wizard.
	 */
	public Page1() {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		Label lblContainer = new Label(container, SWT.NONE);
		lblContainer.setBounds(10, 13, 100, 15);
		lblContainer.setText("Container");
		
		Combo combo_container = new Combo(container, SWT.NONE);
		combo_container.setBounds(116, 10, 448, 23);
		
		Combo combo_connection = new Combo(container, SWT.NONE);
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
		
		Button btnCreate = new Button(container, SWT.NONE);
		btnCreate.setBounds(489, 175, 75, 25);
		btnCreate.setText("Create");
		
		ProgressBar progressBar = new ProgressBar(container, SWT.NONE);
		progressBar.setBounds(10, 255, 554, 17);
	}
}
