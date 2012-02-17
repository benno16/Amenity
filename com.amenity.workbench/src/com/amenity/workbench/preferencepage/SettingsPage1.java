package com.amenity.workbench.preferencepage;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.amenity.workbench.Activator;

public class SettingsPage1 extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public SettingsPage1 () {
		super(GRID);
	}
	
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore ( Activator.getDefault().getPreferenceStore());
		setDescription ("Database");
	}

	@Override
	protected void createFieldEditors() {
		addField ( new DirectoryFieldEditor ( 
				"PATH", "&Directory preference:", 
				getFieldEditorParent()));
		addField ( new BooleanFieldEditor (
				"BOOLEAN_VALUE", "&Local Administered Database",
				1, getFieldEditorParent()));
		addField ( new RadioGroupFieldEditor (
				"CHOICE","Select database server", 1,
				new String[][] {{"&Local", "Localhost"}, 
						{"&Central", "Central Database Server"}},
						getFieldEditorParent()));
		addField ( new StringFieldEditor ("USERNAME",
				"A &text preference:", getFieldEditorParent()));
		addField ( new StringFieldEditor ("Password",
				"A &text preference:", getFieldEditorParent()));
	}


}
