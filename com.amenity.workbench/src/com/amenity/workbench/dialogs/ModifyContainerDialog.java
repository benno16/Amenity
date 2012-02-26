package com.amenity.workbench.dialogs;

import general.GeneralPackage;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

import com.amenity.workbench.SessionSourceProvider;
import org.eclipse.swt.widgets.Button;

public class ModifyContainerDialog extends Dialog {
	private Text text;
	private Text text_1;
	private Button btnNewButton;
	private Button button;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ModifyContainerDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(null);
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(10, 10, 424, 21);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(10, 37, 424, 21);
		
		DataBindingContext bindingContext = new DataBindingContext();

		bindingContext.bindValue(org.eclipse.jface.databinding.swt.WidgetProperties.text(SWT.Modify).observe(text), 
				EMFProperties.value(GeneralPackage.Literals.CONTAINER__NAME).observe(SessionSourceProvider.CURRENT_CONTAINER));
		
		btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.setBounds(86, 153, 75, 25);
		btnNewButton.setText("New Button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				SessionSourceProvider.CURRENT_CONTAINER.setAddInfo2("test123");
			}
		});
		button = new Button(container, SWT.NONE);
		button.setBounds(281, 153, 75, 25);
		button.setText("2");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println(SessionSourceProvider.CURRENT_CONTAINER.getName() + " " + SessionSourceProvider.CURRENT_CONTAINER.getAddInfo2());
			}
		});
				
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
		return new Point(450, 300);
	}
}
