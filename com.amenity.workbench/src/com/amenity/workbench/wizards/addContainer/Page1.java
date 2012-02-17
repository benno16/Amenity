package com.amenity.workbench.wizards.addContainer;

import general.Container;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class Page1 extends WizardPage {
	
	private Text txtContainerName;
	private Text txtDescription;
	private Composite container;
	private Button btnTrue;
	private Button btnCheckButton;
	private java.util.List<Container> containers;
	
	public String getTxtContainerName() {
		return txtContainerName.getText();
	}

	public String getTxtDescription() {
		return txtDescription.getText();
	}

	/**
	 * Create the wizard.
	 */
	public Page1(java.util.List<Container> containers) {
		super("Create a new Project Container");
		this.containers = containers;
		setTitle("Enter Details");
		setDescription("Fill in the details for your new project container");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		setControl(container);
		
		final Label lblContainerName = new Label(container, SWT.NONE);
		lblContainerName.setBounds(10, 10, 100, 15);
		lblContainerName.setText("Container Name");
		txtContainerName = new Text(container, SWT.BORDER);
		txtContainerName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtContainerName.getText().length() > 0 ) {
					setPageComplete ( true );
					boolean exists = false;
					for ( Container c : containers) {
						if ( c.getName().equals(txtContainerName.getText()) ) {
							exists = true;
							setPageComplete(false);
							lblContainerName.setToolTipText("Container does already exist");
						} 
					}
					if ( !exists ) {
						lblContainerName.setToolTipText("");
						
					}
					
				} else {
					setPageComplete ( false );
				}
			}
		});
		txtContainerName.setBounds(116, 10, 448, 21);
		
		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setBounds(10, 40, 100, 15);
		lblDescription.setText("Description");
		
		txtDescription = new Text(container, SWT.BORDER);
		txtDescription.setBounds(116, 37, 448, 21);
		
		Label lblSomethingElse = new Label(container, SWT.NONE);
		lblSomethingElse.setBounds(10, 61, 100, 15);
		lblSomethingElse.setText("Something else");
		
		btnTrue = new Button(container, SWT.CHECK);
		btnTrue.setBounds(116, 64, 448, 16);
		btnTrue.setText("Option 1");
		
		btnCheckButton = new Button(container, SWT.CHECK);
		btnCheckButton.setSelection(true);
		btnCheckButton.setBounds(116, 82, 448, 16);
		btnCheckButton.setText("Option 2");
		
		setControl ( container );
		setPageComplete ( false );
	}
	
}
