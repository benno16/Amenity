package com.amenity.workbench.supporter;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import com.amenity.workbench.supporter.classes.ContainerClass;

public class ManageContainerLabelProvider extends LabelProvider {

	@Override
	public String getText ( Object element ) {
		if ( element instanceof ContainerClass ) {
			ContainerClass container = (ContainerClass) element;
			return container.getName();
		}
		return "-";
	}
	
	@Override
	public Image getImage ( Object element ) {
		if ( element instanceof ContainerClass ) {
			return IconFactory.getInstance().getProjectCotainerIco();
		}
		return IconFactory.getInstance().getUnknownIco();
	}
	
	public class TodoLabelProvider extends StyledCellLabelProvider {
		@Override
		public void update(ViewerCell cell) {
			Object element = cell.getElement();
			StyledString text = new StyledString();

			if (element instanceof ContainerClass ) {
				ContainerClass c = (ContainerClass) element;
				text.append(c.getName());
				text.append(" ( hint ) ", StyledString.COUNTER_STYLER);
				cell.setBackground(new Color ( null , 240 , 240 , 240));
			} 
			cell.setText(text.toString());
			cell.setStyleRanges(text.getStyleRanges());
			super.update(cell);
		}
	}
}
