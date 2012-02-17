package com.amenity.workbench.wizards.addProjectSource;

import java.util.Date;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Page3_MKS extends WizardPage {

	private Button btnSandbox;
	private Button btnOnlineProject;
	private Label label_1;
	private Label lblSelectDataSource;
	private Combo combo;
	private Label lblConnectionName;
	private Text text;
	
	
	/**
	 * Create the wizard.
	 */
	public Page3_MKS() {
		super("wizardPage");
		setTitle("MKS Data Source Profile");
		setDescription("Select whether to use sandbox or an online project and your project here");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		lblSelectDataSource = new Label(container, SWT.NONE);
		lblSelectDataSource.setBounds(10, 10, 554, 15);
		lblSelectDataSource.setText("Select Data Source");
		
		btnSandbox = new Button(container, SWT.RADIO);
		btnSandbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnSandbox.setSelection(true);
				btnOnlineProject.setSelection(false);
			}
		});
		btnSandbox.setBounds(10, 31, 101, 16);
		btnSandbox.setText("Sandbox");
		
		btnOnlineProject = new Button(container, SWT.RADIO);
		btnOnlineProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnSandbox.setSelection(false);
				btnOnlineProject.setSelection(true);
			}
		});
		btnOnlineProject.setSelection(true);
		btnOnlineProject.setBounds(10, 53, 101, 16);
		btnOnlineProject.setText("Online Project");
		
		Button btnShow = new Button(container, SWT.NONE);
		btnShow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ( btnSandbox.getSelection() ) {
					combo.removeAll();
					combo.add("/Playground/regensburg/RandomTest/project.pj");
					combo.add("/Playground/regensburg/project.pj");
					combo.add("/Playground/regensburg/RandomTest/project.pj");
					combo.add("/cas/body/GATEWAY/VW/VW_MQB_12_GW/VW_MQB_12_GW.pj");
					combo.add("/Playground/regensburg/project.pj");
					combo.add("/Playground/regensburg/Stages/Test/project.pj");
				} else {
					combo.removeAll();
					combo.add("/cas/body/GATEWAY/VW/VW_MQB_12_GW/VW_MQB_12_GW.pj");
					combo.add("/Playground/auburnhills/project.pj");
					combo.add("/Playground/frankfurt/project.pj");
					combo.add("/Playground/Guarulhos/project.pj");
					combo.add("/Playground/ingolstadt/project.pj");
					combo.add("/Playground/markdorf/project.pj");
					combo.add("/Playground/plmit/project.pj");
					combo.add("/Playground/regensburg/project.pj");
				}
				combo.select(0);
			}
		});
		btnShow.setBounds(489, 44, 75, 25);
		btnShow.setText("Show");
		
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 75, 554, 2);
		
		Label lblSelectProject = new Label(container, SWT.NONE);
		lblSelectProject.setBounds(10, 83, 101, 15);
		lblSelectProject.setText("Select Project");
		
		label_1 = new Label(container, SWT.NONE);
		label_1.setBounds(10, 101, 554, 15);
		label_1.setText("");
		
		combo = new Combo(container, SWT.NONE);
		combo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				text.setText(combo.getItem(combo.getSelectionIndex()).toString() + " " + new Date().toString());
			}
		});
		combo.setBounds(10, 122, 554, 23);
		
		Button btnSave = new Button(container, SWT.NONE);
		btnSave.setBounds(489, 199, 75, 25);
		btnSave.setText("Save");
		
		lblConnectionName = new Label(container, SWT.NONE);
		lblConnectionName.setBounds(10, 151, 101, 15);
		lblConnectionName.setText("Connection Name");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(10, 172, 554, 21);
	}
}
