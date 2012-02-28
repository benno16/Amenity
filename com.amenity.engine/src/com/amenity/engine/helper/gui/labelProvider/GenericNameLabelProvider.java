package com.amenity.engine.helper.gui.labelProvider;

import general.*;

import org.eclipse.jface.viewers.LabelProvider;

import com.amenity.engine.helper.synergy.SynergyProject;

public class GenericNameLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		
		if (element instanceof Snapshot) {
			return ((Snapshot) element).getName();
		} else 
			if (element instanceof Container) {
			return ((Container) element).getName();
		} else 
			if (element instanceof Connection) {
			return ((Connection) element).getAddInfo1();
		} else 
			if (element instanceof User) {
			return ((User) element).getUsername();
		} else 
			if (element instanceof DataSource) {
			return ((DataSource) element).getName();
		} else 
			if (element instanceof File) {
			return ((File) element).getName();
		} else 
			if (element instanceof Folder) {
			return ((Folder) element).getName();
		} else 
			if (element instanceof Task) {
			return ((Task) element).getDescription();
		} else 
			if (element instanceof SynergyProject) {
			return ((SynergyProject) element).getShortName();
		} else 
			return element.toString();
	}
}
