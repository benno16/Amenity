package com.amenity.engine.helper.gui;

import org.eclipse.jface.viewers.*;

import com.amenity.engine.helper.synergy.SynergyProject;

public class SynergyProjectLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		if (element instanceof SynergyProject) {
			SynergyProject project = (SynergyProject) element;
			return project.getShortName();
		} 
		return element.toString();
	}
}
