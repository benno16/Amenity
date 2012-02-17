package com.amenity.workbench.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class AssignFunctionsView extends ViewPart {

	public AssignFunctionsView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {

		Label lbl = new Label ( parent , SWT.BORDER);
		lbl.setImage(new Image ( parent.getDisplay(), "d:/temp/assignFunctionView.png"));
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
