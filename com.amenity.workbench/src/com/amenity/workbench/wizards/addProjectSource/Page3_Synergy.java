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

import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.engine.helper.synergy.SynergyProject;
import com.amenity.workbench.SessionSourceProvider;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;


public class Page3_Synergy extends WizardPage {
//	private List<SynergyProject> projects;
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

		SessionSourceProvider.SYNERGY_PROJECT_LIST_OBJECT = new ArrayList<SynergyProject>();

		setTitle("Synergy Data Source Profile");
		
		setDescription("Please select a Rational Synergy Project");
		
	}

	protected void createProjectList(List<String> projectList) {
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
			for ( SynergyProject sp : SessionSourceProvider.SYNERGY_PROJECT_LIST_OBJECT ) {
				if (sp.getShortName().equals(shortName)) {
					sp.getRelease().add(release);
					exists = true;
					break;
				}
			}
			if ( !exists ) {
				spl.getRelease().add(release);
				SessionSourceProvider.SYNERGY_PROJECT_LIST_OBJECT.add(spl);
			}
		}
		if ( SessionSourceProvider.SYNERGY_PROJECT_LIST_OBJECT.size() > 0 && 
				listViewer != null ) 
			listViewer.setInput(SessionSourceProvider.SYNERGY_PROJECT_LIST_OBJECT);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		if ( SessionSourceProvider.SYNERGY_PROJECT_LIST != null &&
				SessionSourceProvider.SYNERGY_PROJECT_LIST .size() > 0 ) {
			createProjectList(SessionSourceProvider.SYNERGY_PROJECT_LIST);
		}
		
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
		listViewer.setLabelProvider(new GenericNameLabelProvider());
		listViewer.setInput(SessionSourceProvider.SYNERGY_PROJECT_LIST_OBJECT);
		
		
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
		        		wizard.connection.setDatabase( wizard.connection.getProject() + "-" +
		        				wizard.connection.getRelease());
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
				wizard.projectList = SessionSourceProvider.SYNERGY_PROJECT_LIST;
				createProjectList(wizard.projectList);
			}
		});
		btnRefresh.setBounds(10, 268, 68, 23);
		btnRefresh.setText("refresh");
		setPageComplete(true);
	}
	
	private void checkPageComplete() {
		ProjectWizard wizard = (ProjectWizard)getWizard();
		if ( text.getText().length() > 1 && wizard.connection.getProject().length() > 0 
				&& wizard.connection.getRelease().length() > 0 ) {
			setPageComplete ( true );
		}
		else {
			setPageComplete ( false );
		}
	}
}
