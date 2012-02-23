package com.amenity.workbench.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class CompareSnapshotsView extends ViewPart {

	public CompareSnapshotsView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
//		Shell shell = parent.getShell();
		
		parent.setLayout(new GridLayout(2, true));
		
		Composite compositeTop = new Composite(parent, SWT.NONE);
		compositeTop.setLayout(null);
		compositeTop.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true,
				false, 2, 1));
		

		Composite compositeLeft = new Composite(parent, SWT.NONE);
		compositeLeft.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true,
				true, 1, 1));
		

		Composite compositeRight = new Composite(parent, SWT.NONE);
		compositeRight.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true,
				true, 1, 1));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
