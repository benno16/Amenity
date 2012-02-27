package com.amenity.workbench.wizards.addProjectSource;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Text;

import com.amenity.engine.helper.gui.SynergyProjectLabelProvider;
import com.amenity.engine.helper.synergy.SynergyProject;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;


public class Page3_Synergy extends WizardPage {
	private List<String> projectList;
	private List<SynergyProject> projects;
	Text text;
	ListViewer listViewer;
	ListViewer listViewer_1;
	private ISelection projectSelection;
	private IStructuredSelection structuredSelection;
	
	/**
	 * Create the wizard.
	 */
	public Page3_Synergy(List<String> projectList) {
		super("wizardPage");
		this.projectList = projectList;
		projects = new ArrayList<SynergyProject>();
//		createProjectList(projectList);
		setTitle("Synergy Data Source Profile");
		setDescription("Please select Rational Synergy Project");
	}

	protected void createProjectList(List<String> projectList2) {
		this.projectList = projectList2;
		String shortName = "";
		String release = "";
		for ( String s : projectList ) {
			shortName = "";
			release = "";
			String[] x = s.split("-");
			shortName = x[0];
			release = x[1];
			SynergyProject spl = new SynergyProject();
			spl.setFullName(s);
			spl.setShortName(shortName);
			boolean exists = false;
			for ( SynergyProject sp : projects ) {
				if (sp.getShortName().equals(shortName)) {
					sp.getRelease().add(release);
					exists = true;
					break;
				}
			}
			if ( !exists ) {
				spl.getRelease().add(release);
				projects.add(spl);
			}
		}
		if ( projects.size() > 0) 
			listViewer.setInput(projects);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		createProjectList(projectList);
		
		Label lblSelectProject = new Label(container, SWT.NONE);
		lblSelectProject.setBounds(10, 10, 100, 15);
		lblSelectProject.setText("Select Project");
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(322, 10, 100, 15);
		lblNewLabel.setText("Select Version");
		
		listViewer = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
		org.eclipse.swt.widgets.List list = listViewer.getList();
		list.setBounds(10, 31, 278, 182);
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/**
				 * TODO set global var
				 */
				projectSelection = listViewer.getSelection();
				
			}
		});
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {

		    public void selectionChanged(SelectionChangedEvent event) {
		        // Handle selection changed event here
		    	projectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) projectSelection;
		        if ( !structuredSelection.isEmpty()) {
		        	if ( structuredSelection.getFirstElement() instanceof SynergyProject ) {
		        		ProjectWizard wizard = (ProjectWizard)getWizard();
		        		listViewer_1.setInput((SynergyProject) 
		        				structuredSelection.getFirstElement());
		        		wizard.connection.setProject( ( (SynergyProject) 
		        				structuredSelection.getFirstElement() ).getShortName());
		        		System.out.println(">>>" + ((SynergyProject) 
		        				structuredSelection.getFirstElement() ).getShortName());
		        		wizard.connection.setRelease("");
		        		checkPageComplete();
		        	}
		        }
			}
		});
		listViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<SynergyProject>)inputElement ) .toArray();
			}
		});
		listViewer.setLabelProvider(new SynergyProjectLabelProvider());
		listViewer.setInput(projects);
		
		
		listViewer_1 = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
		org.eclipse.swt.widgets.List list_1 = listViewer_1.getList();
		list_1.setBounds(294, 31, 278, 182);
		listViewer_1.setContentProvider(new IStructuredContentProvider() {

			@Override
			public void dispose() {
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return ((SynergyProject)inputElement).getRelease().toArray();
			}
			
		});
		
		listViewer_1.addSelectionChangedListener(new ISelectionChangedListener() {

		    public void selectionChanged(SelectionChangedEvent event) {
		        // Handle selection changed event here
		    	projectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) projectSelection;
		        if ( !structuredSelection.isEmpty()) {
		        	if ( structuredSelection.getFirstElement() instanceof String ) {
		        		ProjectWizard wizard = (ProjectWizard)getWizard();
		        		wizard.connection.setRelease(  
		        				structuredSelection.getFirstElement().toString() );
		        		wizard.connection.setDatabase( wizard.connection.getProject() + 
		        				wizard.connection.getRelease());
		        		System.out.println(">>>" + 
		        				structuredSelection.getFirstElement().toString() );
		        		checkPageComplete();
		        	}
		        }
			}
		});
		Label lblConnectionName = new Label(container, SWT.NONE);
		lblConnectionName.setBounds(10, 219, 100, 13);
		lblConnectionName.setText("Connection Name");
		
		text = new Text(container, SWT.BORDER);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				checkPageComplete();
			}
		});
		text.setBounds(10, 238, 562, 19);
		
		Button btnRefresh = new Button(container, SWT.NONE);
		btnRefresh.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ProjectWizard wizard = (ProjectWizard)getWizard();
				System.out.println("there are Elements: " + wizard.projectList.size());
				createProjectList(wizard.projectList);
			}
		});
		btnRefresh.setBounds(10, 268, 68, 23);
		btnRefresh.setText("refresh");
		setPageComplete(true);
	}
	
	private void checkPageComplete() {
		ProjectWizard wizard = (ProjectWizard)getWizard();
		System.out.println("am I complete? text: " + text.getText() + " " + 
		" Project: " + wizard.connection.getProject() + " release: " + wizard.connection.getRelease() );
		if ( text.getText().length() > 1 && wizard.connection.getProject().length() > 0 
				&& wizard.connection.getRelease().length() > 0 ) {
			setPageComplete ( true );
			System.err.println("true");
		}
		else {
			setPageComplete ( false );
			System.err.println("false");
		}
	}
}
