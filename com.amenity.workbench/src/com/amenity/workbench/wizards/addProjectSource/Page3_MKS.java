package com.amenity.workbench.wizards.addProjectSource;

import general.Connection;

import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

import com.amenity.engine.helper.mks.MksLogin;

public class Page3_MKS extends WizardPage {

	Button btnSandbox;
	private Button btnOnlineProject;
	private Label label_1;
	private Label lblSelectDataSource;
	Combo combo;
	private Label lblConnectionName;
	Text text;
	List<String> projects;
	
	
	/**
	 * Create the wizard.
	 */
	public Page3_MKS(Connection connection) {
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
				ProjectWizard wizard = (ProjectWizard)getWizard();
				
				MksLogin mksLogin;
				if ( btnSandbox.getSelection() ) {
					mksLogin = new MksLogin (wizard.connection.getUsername(), 
							wizard.connection.getPassword(), 
							wizard.connection.getDatabase(), true);
					projects = mksLogin.showProjects();
					System.out.println( "There are Sandboxprojects: " + projects.size());
					mksLogin = null;
				} else {
					mksLogin = new MksLogin (wizard.connection.getUsername(), 
							wizard.connection.getPassword(), 
							wizard.connection.getDatabase(), false);
					projects = mksLogin.showProjects();
					mksLogin = null;
					System.out.println( "There are online projects: " + projects.size());
				}
				combo.removeAll();
				for ( String string : projects )
					combo.add(string);
				if ( combo.getItemCount() > 0 )
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
//		combo.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseUp(MouseEvent e) {
//				text.setText(combo.getItem(combo.getSelectionIndex()).toString() + " " + new Date().toString());
//				setPageComplete ( true );
//			}
//		});
		combo.setBounds(10, 122, 554, 23);
		
		Button btnSave = new Button(container, SWT.NONE);
		btnSave.setBounds(489, 199, 75, 25);
		btnSave.setText("Save");
		
		lblConnectionName = new Label(container, SWT.NONE);
		lblConnectionName.setBounds(10, 151, 101, 15);
		lblConnectionName.setText("Connection Name");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(10, 172, 554, 21);
		setPageComplete ( false );
	}
}
