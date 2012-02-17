package com.amenity.workbench.wizards.addProjectSource;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

public class ProjectWizard extends Wizard {

	private Page1 one;
	private Page2_MKS two_mks;
	private Page3_MKS three_mks;
	private Page4_MKS four_mks;
	private Page2_Synergy two_sgy;
	private Page3_Synergy three_sgy;
	
	public ProjectWizard() {
		setWindowTitle("New Data Source");
	}

	@Override
	public void addPages() {
		
		one = new Page1();
		two_mks = new Page2_MKS();
		three_mks = new Page3_MKS();
		four_mks = new Page4_MKS();
		two_sgy = new Page2_Synergy();
		three_sgy = new Page3_Synergy();
		
		
		addPage ( one );
		addPage ( two_mks );
		addPage ( three_mks );
		addPage ( four_mks );
		addPage ( two_sgy );
		addPage ( three_sgy );
		
	}
	
	@Override
	public WizardPage getNextPage(IWizardPage page) {
		if ( page instanceof Page1 ){
			if ( one.isItsMks() ) {
				return two_mks;
			} else {
				return two_sgy;
			}
		} 
		if ( page instanceof Page2_MKS)
			return three_mks;
		if ( page instanceof Page3_MKS)
			return null;
		if ( page instanceof Page2_Synergy)
			return three_sgy;
		return one;
	}
	
	@Override
	public boolean canFinish() {
		return false;
	}

	@Override
	public boolean performFinish() {
		/*
		 * database ++
		 */
		return true;
		
	}

}
