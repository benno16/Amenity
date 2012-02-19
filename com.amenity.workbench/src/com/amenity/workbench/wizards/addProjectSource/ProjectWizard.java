package com.amenity.workbench.wizards.addProjectSource;

import java.util.Date;

import general.Connection;
import general.ConnectionType;
import general.Container;
import general.GeneralFactory;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

public class ProjectWizard extends Wizard {

	private Page1 one;
	private Page2_MKS two_mks;
	private Page3_MKS three_mks;
	private Page2_Synergy two_sgy;
	private Page3_Synergy three_sgy;
	private Container container = GeneralFactory.eINSTANCE.createContainer(); 
	Connection connection;
	
	public ProjectWizard() {
		setWindowTitle("New Data Source");
		connection = GeneralFactory.eINSTANCE.createConnection();
	}

	@Override
	public void addPages() {
		
		one = new Page1( connection );
		two_mks = new Page2_MKS( connection );
		three_mks = new Page3_MKS( connection );
		two_sgy = new Page2_Synergy( connection );
		three_sgy = new Page3_Synergy( connection );
		
		
		addPage ( one );
		addPage ( two_mks );
		addPage ( three_mks );
		addPage ( two_sgy );
		addPage ( three_sgy );
		
	}
	
	@Override
	public WizardPage getNextPage(IWizardPage page) {
		if ( page instanceof Page1 ){
			container = one.getSelectedContainer();
			connection.setPartOf(container);
			connection.setLastUsed(new Date());
			connection.setProject(container.getName());
			if ( one.isItsMks() ) {
				connection.setConnectionType(ConnectionType.MKS);
				return two_mks;
			} else {
				connection.setConnectionType(ConnectionType.SYNERGY);
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
		if ( this.getContainer().getCurrentPage() == three_mks || this.getContainer().getCurrentPage() == three_sgy )
			return true;
		return false;
	}

	@Override
	public boolean performFinish() {
		/*
		 * database ++
		 */
		System.out.println("do something");
		return true;
		
	}

}
