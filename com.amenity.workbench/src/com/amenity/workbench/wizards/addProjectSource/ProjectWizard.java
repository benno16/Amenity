package com.amenity.workbench.wizards.addProjectSource;

import java.util.Date;

import general.Connection;
import general.ConnectionType;
import general.Container;
import general.GeneralFactory;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import dao.ConnectionDao;
import dao.DaoFactory;

public class ProjectWizard extends Wizard {

	Page1 one;
	Page2_MKS two_mks;
	Page3_MKS three_mks;
	Page2_Synergy two_sgy;
	Page3_Synergy three_sgy;
	Page4 four;
	Container container = GeneralFactory.eINSTANCE.createContainer(); 
	Connection connection;
	boolean storePassword = false;
	
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
		four = new Page4( connection );
		
		
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
			connection.setPartOf( container );
			if ( one.isItsMks() ) {
				connection.setConnectionType(ConnectionType.MKS);
				return two_mks;
			} else {
				connection.setConnectionType(ConnectionType.SYNERGY);
				return two_sgy;
			}
		}
		
		if ( page instanceof Page2_MKS) {
			connection.setUsername(two_mks.text.getText());
			if ( two_mks.btnSaveSettings.getSelection() )
				storePassword = true;
			connection.setPassword(two_mks.text_1.getText());
			connection.setDatabase(two_mks.combo.getItem(two_mks.combo.getSelectionIndex()));
			return three_mks;
		}
		
		if ( page instanceof Page3_MKS) {
			
			return null;
		}
		
		if ( page instanceof Page2_Synergy) {
			return three_sgy;
		}
		return one;
	}
	
//	@Override
//	public boolean canFinish() {
//		/**
//		 * TODO: Page 4 with save options 
//		 */
//		if ( this.getContainer().getCurrentPage() == three_mks || 
//				this.getContainer().getCurrentPage() == three_sgy )
//			return true;
//		return false;
//	}

	@Override
	public boolean performFinish() {

		/**
		 * TODO
		 * Database finish and Synergy Integration! 
		 */
		connection.setLastUsed(new Date());
		if ( three_mks.btnSandbox.getSelection() ) {
			connection.setAddInfo4("Sandbox");
		} else {
			connection.setAddInfo4("Online");
		}
		connection.setAddInfo1(three_mks.text.getText());
		connection.setAddInfo2(three_mks.text_1.getText());
		connection.setProject(three_mks.combo.getItem(three_mks.combo.getSelectionIndex()));
		connection.setCreated(new Date());
		ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
		connectionDao.create(connection);
		
		return true;
		
	}
}
