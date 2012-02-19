package com.amenity.workbench.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

public class RenameDialog extends Dialog {
	private Text text;
	private String toRename;
	
	public Text getText() {
		return text;
	}

	public String getToRename() {
		return toRename;
	}

	public void setToRename(String toRename) {
		this.toRename = toRename;
	}

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public RenameDialog(Shell parentShell ) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      shell.setText("Rename... ");
	}
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(null);
		
		Label lblCurrent = new Label(container, SWT.NONE);
		lblCurrent.setBounds(10, 13, 100, 15);
		lblCurrent.setText("New Name");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(116, 10, 200, 21);
		text.setText(toRename);
		text.setToolTipText("Enter the new name here");

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(329, 118);
	}
	
//	protected void buttonPressed ( int buttonId ) {
//		if ( buttonId == 0 ) {
//			toRename = text.getText();
//			System.out.println(buttonId);
//		} else { //cancel and stuff
//			super.buttonPressed(buttonId);
//		}
//	}
}
