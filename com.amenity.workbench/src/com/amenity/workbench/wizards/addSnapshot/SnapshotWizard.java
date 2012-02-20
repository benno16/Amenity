package com.amenity.workbench.wizards.addSnapshot;

import org.eclipse.jface.wizard.Wizard;

public class SnapshotWizard extends Wizard {

	public SnapshotWizard() {
		setWindowTitle("New Wizard");
	}

	@Override
	public void addPages() {
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
