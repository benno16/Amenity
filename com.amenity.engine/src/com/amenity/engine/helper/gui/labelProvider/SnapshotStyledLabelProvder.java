package com.amenity.engine.helper.gui.labelProvider;

import general.File;
import general.Folder;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class SnapshotStyledLabelProvder extends StyledCellLabelProvider  {

	private String fnName;
	
	public SnapshotStyledLabelProvder ( String fnName){
		this.fnName = fnName;
	}
	
	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		StyledString text = new StyledString();

		if (element instanceof Folder) {
			Folder folder = (Folder) element;
			text.append(folder.getName());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FOLDER));
			if ( fnName.length() > 0 )
				text.append(" ( " + fnName + " ) ", StyledString.COUNTER_STYLER);
		} else {
			File file = (File) element;
			text.append(file.getName());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FILE));
			if ( fnName.length() > 0 )
				text.append(" ( " + fnName + " ) ", StyledString.COUNTER_STYLER);
		}
		cell.setText(text.toString());
		cell.setStyleRanges(text.getStyleRanges());
		super.update(cell);
	}
}
