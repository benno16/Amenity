package com.amenity.workbench.supporter;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.amenity.workbench.Activator;
import com.amenity.workbench.interfaces.IIconFactory;

public class IconFactory implements IIconFactory {
	
	private static IconFactory instance = new IconFactory();

	// private because its a singleton! 
	private IconFactory(){
	}
	
	private ImageDescriptor doesIdExist(ImageDescriptor id) {
		
		if ( id == null ) {
			return Activator.getImageDescriptor("a.png");
		} else {
			return id;
		}
		
	}
	
	public static IconFactory getInstance() {
        return instance;
    }
	
	public Image getEventViewerIco( ) {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/nuovext/status/dialog-warning.png");
		id = doesIdExist(id);
		return id.createImage();
		
	}

	@Override
	public Image getUnknownIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/crystal_project/filesystems/actions/status_unknown.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getProjectCotainerIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/crystal_project/filesystems/folder_green.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getWorkbenchIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/nuovext/categories/package_network.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getManageContainerIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/nuovext/devices/drive-harddisk.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getShowSnapshotIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/nuovext/devices/gnome-dev-computer.png");
		id = doesIdExist(id);
		return id.createImage();
	}
	
	@Override
	public Image getCompareSnapshotIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/nuovext/actions/gnome-searchtool.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getAssignFunctionIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/nuovext/actions/bookmark_add.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getAssignFilesIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/nuovext/actions/up.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getNewContainerIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/nuovext/actions/folder_new.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getModifyIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/nuovext/actions/stock_file-properites.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getDeleteIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/nuovext/places/gtk-delete.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getHelpIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/nuovext/apps/xfce-man.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getCompressedIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/crystalProjectMimetypes/16/zip.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getWordIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/crystalProjectMimetypes/16/txt.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getPPTIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/crystalProjectMimetypes/16/pps.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getCIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/crystalProjectMimetypes/16/source c.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getHIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/crystalProjectMimetypes/16/source h.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getImageIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/crystalProjectMimetypes/16/image.png");
		id = doesIdExist(id);
		return id.createImage();
	}

	@Override
	public Image getPdfIco() {
		ImageDescriptor id = Activator.getImageDescriptor(
				"icons/crystalProjectMimetypes/16/pdf.png");
		id = doesIdExist(id);
		return id.createImage();
	}


}
