package com.amenity.workbench.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RenameTitleAreaDialog extends TitleAreaDialog {
	private Text text;
	private String toRename;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public RenameTitleAreaDialog(Shell parentShell) {
		super(parentShell);
		setErrorMessage("");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		container.setLayout(null);
		
		Label lblCurrent = new Label(container, SWT.NONE);
		lblCurrent.setBounds(10, 13, 100, 15);
		lblCurrent.setText("New Name");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(116, 10, 200, 21);
		text.setText(toRename);
		text.setToolTipText("Enter the new name here");

		return area;
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

	@Override
	protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      super.setHelpAvailable(false);
	      super.setTitle("test123");
	      super.setMessage("message");
	      shell.setText("Rename... ");
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(330, 192);
	}

}
