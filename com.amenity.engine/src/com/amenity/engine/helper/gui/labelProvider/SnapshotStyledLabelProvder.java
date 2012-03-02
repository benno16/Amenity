package com.amenity.engine.helper.gui.labelProvider;

import java.util.ArrayList;
import java.util.List;

import general.File;
import general.FileFunctionStatus;
import general.Folder;
import general.Snapshot;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import dao.DaoFactory;
import dao.FileFunctionStatusDao;

public class SnapshotStyledLabelProvder extends StyledCellLabelProvider  {

	private Snapshot snapshot;
	private List<FileFunctionStatus> fileFunctionStatus;
	
	public SnapshotStyledLabelProvder ( Snapshot snapshot ){
		this.snapshot = snapshot;
		fileFunctionStatus = new ArrayList<FileFunctionStatus>();
	}
	
	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		StyledString text = new StyledString();
		
		getFileFunctionStatusList();
		
		if (element instanceof Folder) {
			Folder folder = (Folder) element;
			text.append(folder.getName());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FOLDER));
			if ( fileFunctionStatus.contains(folder) ) {
				System.out.println("---" + folder.getName());
				cell.setBackground(new Color(Display.getCurrent(), 255, 228, 225));
			}
//				text.append(" ( " +  + " ) ", StyledString.COUNTER_STYLER);
		} else {
			File file = (File) element;
			text.append(file.getName());
			cell.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_FILE));
			if ( fileFunctionStatus.contains(file) ) {
				System.out.println("---" + file.getName());
				cell.setBackground(new Color(Display.getCurrent(), 255, 228, 225));
			}
////			if ( fnName.length() > 0 )
////				text.append(" ( " + fnName + " ) ", StyledString.COUNTER_STYLER);
		}
		cell.setText(text.toString());
		cell.setStyleRanges(text.getStyleRanges());
		super.update(cell);
	}
	
	@SuppressWarnings("unchecked")
	private void getFileFunctionStatusList() {
		FileFunctionStatusDao fileFunctionStatusDao = 
				DaoFactory.eINSTANCE.createFileFunctionStatusDao();
		fileFunctionStatus = fileFunctionStatusDao
				.getFileFunctionStatusBySnapshot(snapshot);
	}
}
