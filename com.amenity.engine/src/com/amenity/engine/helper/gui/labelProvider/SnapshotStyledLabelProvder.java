package com.amenity.engine.helper.gui.labelProvider;

import general.File;
import general.Folder;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.hibernate.Session;

import dao.impl.HibernateUtilImpl;

public class SnapshotStyledLabelProvder extends StyledCellLabelProvider  {

	
	public SnapshotStyledLabelProvder (  ){
	}
	
	@Override
	public void update(ViewerCell cell) {
		// fetch cell element
		Object element = cell.getElement();
		
		StyledString text = new StyledString();
		Session s = HibernateUtilImpl.getSessionFactoryEdefault().openSession();
		
		if (element instanceof Folder) {
			// if element is a file set its name and style if it is part of a function
			Folder folder = (Folder) element;
			s.beginTransaction();
			s.load(folder, folder.getObjectId());
			
			text.append(folder.getName());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FOLDER));

			if ( ((Folder) element).getFunction().size() > 0  ) {
				
				cell.setForeground(new Color(Display.getCurrent(), 120, 120, 120));
				
			}
//				text.append(" ( " +  + " ) ", StyledString.COUNTER_STYLER);
		} else {
			File file = (File) element;
			s.beginTransaction();
			s.load(file, file.getObjectId());
			
			text.append(file.getName());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FILE));
			if ( ((File)element).getFunction().size() > 0 ) {
			
				cell.setForeground(new Color(Display.getCurrent(), 120, 120, 120));
			
			}
		}
		
		cell.setText(text.toString());
		
		cell.setStyleRanges(text.getStyleRanges());
		s.close();
		
		super.update(cell);
	}
}
