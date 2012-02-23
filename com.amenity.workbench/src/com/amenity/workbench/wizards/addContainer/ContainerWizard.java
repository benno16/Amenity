package com.amenity.workbench.wizards.addContainer;

import java.util.Date;

import general.Container;
import general.GeneralFactory;
import general.GeneralPackage;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;

import com.amenity.workbench.SessionSourceProvider;

import dao.ContainerDao;
import dao.DaoFactory;

public class ContainerWizard extends Wizard {

	private Page1 one;
	private java.util.List<Container> containers;
	
	public ContainerWizard(java.util.List<Container> containers) {
		this.containers = containers;
		setWindowTitle("New Project Container");
	}

	@Override
	public void addPages() {
		one = new Page1(containers);
		addPage ( one );
	}

	@Override
	public boolean performFinish() {
		boolean duplicate = false;
		for ( Container c : containers ) {
			if ( c.getName().equals(one.getTxtContainerName()) )
				duplicate = true;
		}
		if ( duplicate ) {
			System.out.println("cannot modify");
			MessageDialog.openError(this.getShell(), "Error", "Duplicate Entry!");

			return false;
		} else {
		Container container = GeneralFactory.eINSTANCE.createContainer();
		container.eSet(GeneralPackage.Literals.CONTAINER__NAME, one.getTxtContainerName());
		container.setName(one.getTxtContainerName());
		container.setAddInfo1(one.getTxtDescription());
		container.setCreated(new Date());
		container.setOwnerId(SessionSourceProvider.USERID);
		container.setOwner(SessionSourceProvider.USER);
		
		ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
		containerDao.create(container);
		containers.add(container);
		return true;
		}
	}

}
