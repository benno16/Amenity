package com.amenity.workbench.preferencepage;

import java.io.File;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.amenity.workbench.Activator;

public class SettingsPage2 extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	private FileFieldEditor sgyExe;
	private BooleanFieldEditor setDir;
	
	public SettingsPage2 () {
		super(GRID);
	}
	
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore ( Activator.getDefault().getPreferenceStore());
		setDescription ("Data Source");
	}
	@Override
	public void propertyChange ( PropertyChangeEvent event) {
		if ( event.getNewValue().toString() == "true" ) {
			sgyExe.setEnabled(true, getFieldEditorParent());
		} else
			sgyExe.setEnabled(false, getFieldEditorParent());
		
	}
	
	@Override
	protected void createFieldEditors() {
		setDir = new BooleanFieldEditor (
				"BOOLEAN_MORE", "&Change Default",
				1, getFieldEditorParent());
		addField ( setDir );
		
		sgyExe = new FileFieldEditor  ( 
				"SGYEXE", "&Synergy Client executable", true, 
				getFieldEditorParent());

		String[] fileNames = {"*.exe","*.*"};
		sgyExe.setFileExtensions(fileNames);
		File sgyExeUrl = new File("M:\\pmtqtools\\Synergy71\\Synergy_client7103\\bin\\");
		sgyExe.setFilterPath(sgyExeUrl);
		
		addField ( sgyExe );
		if ( Activator.getDefault().getPreferenceStore().getBoolean("BOOLEAN_MORE") ) {
			sgyExe.setEnabled(true, getFieldEditorParent());
		} else
			sgyExe.setEnabled(false, getFieldEditorParent());
		
	}

}
