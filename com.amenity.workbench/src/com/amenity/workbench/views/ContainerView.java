package com.amenity.workbench.views;

import java.util.Comparator;
import java.util.Iterator;

import general.Container;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;

import com.amenity.engine.helper.gui.ContainerLabelProvider;
import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.dialogs.ModifyContainerDialog;
import com.amenity.workbench.dialogs.RenameTitleAreaDialog;
import com.amenity.workbench.wizards.addContainer.ContainerWizard;

import dao.ContainerDao;
import dao.DaoFactory;
import org.eclipse.swt.layout.GridData;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import swing2swt.layout.BorderLayout;
import org.eclipse.wb.swt.ResourceManager;

public class ContainerView extends ViewPart {

	public static final String ID = "com.amenity.rcp.ui.views.ContainerView"; //$NON-NLS-1$
	private ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
	@SuppressWarnings("unused")
	private Composite parent;
	private Button btnDelete;
	private Button btnModify;
	private Button btnCreate;
	private ListViewer listViewer;
	private ISelection containerSelection;
	private IStructuredSelection structuredSelection;
	
	
	public ContainerView() {
	}
	
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void createPartControl(final Composite parent) {
		this.parent =parent;
		parent.setLayout(new BorderLayout(0, 0));
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.widthHint = 287;
		
		Composite composite_2 = new Composite(parent, SWT.NONE);
		composite_2.setLayoutData(BorderLayout.WEST);
		composite_2.setLayout(null);
		
		Label label_1 = new Label(composite_2, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 167, 271, 2);
		
		Label lblAvailableContainer = new Label(composite_2, SWT.NONE);
		lblAvailableContainer.setBounds(10, 10, 237, 15);
		lblAvailableContainer.setText("Available Container");
		
		btnCreate = new Button(composite_2, SWT.NONE);
		btnCreate.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/folder_new.png"));
		btnCreate.setBounds(10, 136, 75, 25);
		btnCreate.setText("Create");

		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				ContainerWizard wizard = new ContainerWizard(SessionSourceProvider.CONTAINER_LIST);
				ContainerWizard wizard = new ContainerWizard();
				WizardDialog dialog = new WizardDialog ( parent.getShell(), wizard );
				dialog.open();
				enableButtons();
			}
		});
		
		// Delete Button
		btnDelete = new Button(composite_2, SWT.NONE);
		btnDelete.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gtk-cancel.png"));
		btnDelete.setBounds(91, 136, 75, 25);
		btnDelete.setText("Delete");
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog msg = new MessageDialog ( parent.getShell(), 
						"Warning", null, 
						"Are you sure you want to delete the container '" 
						+ SessionSourceProvider.CURRENT_CONTAINER.getName() + "'? \n" +
						"This operation cannot be reversed!", 
						MessageDialog.WARNING, 
						new String[] {"Delete", "Keep"}, 1);
				if ( msg.open() == 0 ) {
					for ( Iterator<Container> iter = SessionSourceProvider.CONTAINER_LIST.iterator(); iter.hasNext(); ) {
						Container c = iter.next();
						if ( c.equals(SessionSourceProvider.CURRENT_CONTAINER )) {
							iter.remove();
						}
					}
					containerDao.delete(SessionSourceProvider.CURRENT_CONTAINER);
				}
				enableButtons();
			}
		});
		
		btnModify = new Button(composite_2, SWT.NONE);
		btnModify.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/database_edit.png"));
		btnModify.setBounds(172, 136, 75, 25);
//		btnModify.setText("Rename");
//
//		btnModify.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected ( SelectionEvent e ) {
//				RenameTitleAreaDialog dialog = new RenameTitleAreaDialog ( parent.getShell(), SessionSourceProvider.CURRENT_CONTAINER, SessionSourceProvider.CONTAINER_LIST ); 
//				dialog.open();
//				containerDao.update(SessionSourceProvider.CURRENT_CONTAINER);
//				enableButtons();
//			}
//		});
		
		/**
		 * TODO TESTING Data binding for EMF
		 * 
		 */
		btnModify.setText("Modify");

		btnModify.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected ( SelectionEvent e ) {
				ModifyContainerDialog dialog = new ModifyContainerDialog ( parent.getShell()); 
				dialog.open();
//				containerDao.update(SessionSourceProvider.CURRENT_CONTAINER);
//				enableButtons();
			}
		});
		
		/**
		 * END OF TEST! 
		 */
		
		listViewer = new ListViewer(composite_2, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/**
				 * TODO set global var
				 */
				containerSelection = listViewer.getSelection();
				
			}
		});
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {

		    public void selectionChanged(SelectionChangedEvent event) {
		        // Handle selection changed event here
		        containerSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) containerSelection;
		        if ( !structuredSelection.isEmpty()) {
		        	if ( structuredSelection.getFirstElement() instanceof Container ) {
		        		SessionSourceProvider.CURRENT_CONTAINER = 
		        			(Container) structuredSelection.getFirstElement(); 
		        		System.out.println(">>>" + ((Container) structuredSelection.getFirstElement() ).getName());
		        	}
		        }
			}
		});
		list.setBounds(10, 31, 237, 99);
		
		listViewer.setContentProvider(new ArrayContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Container>)inputElement ) .toArray();
			}
		});
		listViewer.setLabelProvider(new ContainerLabelProvider());
		listViewer.setInput(SessionSourceProvider.CONTAINER_LIST);
		

		enableButtons();
	}
	
	protected static Comparator<Container> newAscStringComparator() {
	    return new Comparator<Container>() {
	      @Override
	      public int compare(Container first , Container second) {
	        return String.valueOf(first.getName()).compareTo(String.valueOf(second.getName()));
	      }
	    };
	  }

	@Override
	public void setFocus() {
		// Set the focus
	}
	
	
	private void enableButtons() {

		if ( SessionSourceProvider.CONTAINER_LIST.size() < 1 ) {
			btnModify.setEnabled(false);
			btnDelete.setEnabled(false);
		} else {
			btnModify.setEnabled(true);
			btnDelete.setEnabled(true);
		}
		listViewer.setInput(SessionSourceProvider.CONTAINER_LIST);
	}
}
