package com.amenity.workbench.wizards.addProjectSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


public class Page3_Synergy extends WizardPage {
	
	private List<Project> projects;
	private Combo combo;
	private Combo combo_1;
	
	
	class Project  {
		
		private String name;
		private List<String> versions = new ArrayList<String>();
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<String> getVersions() {
			return versions;
		}

		public void setVersions(List<String> versions) {
			this.versions = versions;
		}

		public Project () {
			
		}
		
		public Project ( String name ) {
			this.name = name;
		}
		
	}
	
	
	/**
	 * Create the wizard.
	 */
	public Page3_Synergy() {
		super("wizardPage");
		setTitle("Synergy Data Source Profile");
		setDescription("Please select Rational Synergy Project");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		
		
		setControl(container);
		
		Label lblSelectProject = new Label(container, SWT.NONE);
		lblSelectProject.setBounds(10, 10, 100, 15);
		lblSelectProject.setText("Select Project");
		
		combo = new Combo(container, SWT.NONE);
		combo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				combo_1.removeAll();
				for ( Project p : projects ) {
					if ( p.getName().equals(combo.getItem(combo.getSelectionIndex()))) {
						for ( String s : p.getVersions() )
							combo_1.add(s);
					}
				}
				combo_1.select(0);
				
			}
		});
		combo.setBounds(10, 31, 554, 23);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 60, 100, 15);
		lblNewLabel.setText("Select Version");
		
		combo_1 = new Combo(container, SWT.NONE);
		combo_1.setBounds(10, 81, 554, 23);
		
		Button btnGoFish = new Button(container, SWT.NONE);
		btnGoFish.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				combo.removeAll();
				projects = new ArrayList<Project>();
				getFiles();
				for ( Project p : projects ) {
					combo.add(p.getName());
				}
				combo.select(0);
				combo_1.removeAll();
				for ( Project p : projects ) {
					if ( p.getName().equals(combo.getItem(combo.getSelectionIndex()))) {
						for ( String s : p.getVersions() )
							combo_1.add(s);
					}
				}
				combo_1.select(0);
			}
		});
		btnGoFish.setBounds(10, 110, 75, 25);
		btnGoFish.setText("Go Fish");
		
	}
	
	private void getFiles() {
		
		File input = new File ("d:/temp/sgy_projects.txt");
		if ( input.exists()) {
		BufferedReader in = null;
		String line;
		try {
			in = new BufferedReader ( 
					new InputStreamReader (
							new FileInputStream (input)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while ( ( line = in.readLine()) != null ) {

				String name = "";
				String version = "";

				String[] x = line.split("-");
				name = x[0];
				version = x[1];
				
				Project project = new Project(name);
				boolean exists = false;
				for ( Project p : projects ) {
					if ( p.getName().equals(name)) {
						p.getVersions().add(version);
						exists = true;
					} 
				}
				if ( !exists ) {
					project.getVersions().add(version);
					projects.add(project);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	}
}
