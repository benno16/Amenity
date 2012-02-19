package com.amenity.workbench.views;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import general.Container;
import general.GeneralFactory;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;

import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.dialogs.RenameDialog;
import com.amenity.workbench.wizards.addContainer.ContainerWizard;

import dao.ContainerDao;
import dao.DaoFactory;

public class ContainerView extends ViewPart {

	public static final String ID = "com.amenity.rcp.ui.views.ContainerView"; //$NON-NLS-1$

	private Combo combo;
	private java.util.List<Container> containers;
	private ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
	private Container container;
	private EContentAdapter adapter;
	private Composite parent;
	private Button btnDelete;
	private Button btnModify;
	
	public ContainerView() {
		GeneralFactory factory = GeneralFactory.eINSTANCE;
		
		container = factory.createContainer();
		
		adapter = new EContentAdapter() {
			public void notifyChanged ( Notification notification ) {
				super.notifyChanged(notification);
				System.out.println("container changed");
			}
		};
	
		container.eAdapters().add(adapter);
	
	}


	public java.util.List<Container> getContainers() {
		return containers;
	}

	public void setContainers(java.util.List<Container> containers) {
		this.containers = containers;
	}
	
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void createPartControl(final Composite parent) {
		this.setParent(parent);
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		
		Composite composite = new Composite(container, SWT.LEFT);
		composite.setLayout(null);
		
		Label lblAvailableContainer = new Label(composite, SWT.NONE);
		lblAvailableContainer.setBounds(10, 10, 268, 15);
		lblAvailableContainer.setText("Available Container");
		
		combo = new Combo(composite, SWT.NONE);
		combo.setBounds(10, 33, 268, 23);
		containers = (java.util.List<Container>) containerDao.getList(Container.class);
		java.util.List<Container> containersTemp = new java.util.ArrayList<Container>();
		for ( Container c : containers) {
			if ( c.getOwner().getUserId().equalsIgnoreCase(SessionSourceProvider.USERID) ) {
				containersTemp.add(c);
				combo.add(c.getName());
			}
		}
		containers.clear();
		containers.addAll(containersTemp);
		containersTemp.clear();
		combo.select(0);
		
		Button btnCreate = new Button(composite, SWT.NONE);
		btnCreate.setBounds(10, 62, 75, 25);
		btnCreate.setText("Create");
		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerWizard wizard = new ContainerWizard(containers);
				WizardDialog dialog = new WizardDialog ( parent.getShell(), wizard);
				dialog.open();
				rebuildCombo();
				combo.select(0);
				enableButtons();
			}
		});
		
		btnDelete = new Button(composite, SWT.NONE);
		btnDelete.setBounds(203, 62, 75, 25);
		btnDelete.setText("Delete");
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = combo.getSelectionIndex();
				if ( containers.size() > 0 ) {
					String itemToDelete = combo.getItem(index).toString();
					for ( Iterator<Container> iter = containers.iterator(); iter.hasNext(); ) {
						Container c = iter.next();
						if ( c.getName().equals(itemToDelete) ) {
							MessageDialog msg = new MessageDialog ( parent.getShell(), 
									"Warning", null, 
									"Are you sure you want to delete the container '" 
											+ itemToDelete + "'? \n" +
													"This operation cannot be reversed!", 
									MessageDialog.WARNING, 
									new String[] {"Delete", "Keep"}, 1);
							if ( msg.open() == 0 ) {
								iter.remove();
								rebuildCombo();
								containerDao.delete(c);
							}
							break;
						}
					}
				}
				enableButtons();
			}
		});
		
		btnModify = new Button(composite, SWT.NONE);
		btnModify.setBounds(106, 62, 75, 25);
		btnModify.setText("Modify");
		btnModify.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected ( SelectionEvent e ) {
				int index = combo.getSelectionIndex();
				String itemToModify = combo.getItem(index);
				
				RenameDialog dialog = new RenameDialog ( parent.getShell()); 
				dialog.setToRename(itemToModify);
				
				if ( dialog.open() == Window.OK ) {
					System.out.println("old: " + itemToModify + " new: " + dialog.getToRename());
					for ( Iterator<Container> iter = containers.iterator(); iter.hasNext(); ) {
						Container c = iter.next();
						if ( c.getName().equals(itemToModify) ) {
							c.setName(dialog.getText().getText());
							rebuildCombo();
							containerDao.update(c);
							break;
						}
					}
					
				}
				
				enableButtons();
			}
		});
		
		Composite composite_1 = new Composite(container, SWT.LEFT);
		
		Label lblAvailableSnapshots = new Label(composite_1, SWT.NONE);
		lblAvailableSnapshots.setBounds(10, 10, 268, 15);
		lblAvailableSnapshots.setText("Available Snapshots");
		
		List list = new List(composite_1, SWT.BORDER);
		list.setBounds(10, 31, 268, 147);
		
		Button btnViewSelectedSnapshot = new Button(composite_1, SWT.NONE);
		btnViewSelectedSnapshot.setBounds(10, 184, 268, 25);
		btnViewSelectedSnapshot.setText("View Selected Snapshot");

		createActions();
		enableButtons();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	private void rebuildCombo() {
		combo.removeAll();
		Collections.sort(containers, newAscStringComparator());
		for ( Container c : containers) {
			if ( c.getOwner().getUserId().equalsIgnoreCase(SessionSourceProvider.USERID) )
				combo.add(c.getName());
		}
		if ( combo.getItemCount() > 0 ) 
			combo.select(0);
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

		if ( containers.size() < 1 ) {
			btnModify.setEnabled(false);
			btnDelete.setEnabled(false);
		} else {
			btnModify.setEnabled(true);
			btnDelete.setEnabled(true);
		}
	}


	public Composite getParent() {
		return parent;
	}


	public void setParent(Composite parent) {
		this.parent = parent;
	}
}
