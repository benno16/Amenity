package com.amenity.workbench.dialogs;

import java.util.Date;

import general.GeneralFactory;
import general.User;
import general.UserList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.amenity.workbench.SessionSourceProvider;

import dao.DaoFactory;
import dao.GeneralQueries;
import dao.UserDao;

@SuppressWarnings("unused")
public class LoginDialog extends Dialog {
	/**
	 * Manning JFace Page 231
	 */
	private Text text;
	private Text text_1;
	private static final int RESET_ID = IDialogConstants.NO_TO_ALL_ID + 1;
	public static Button btnRememberMyPassword;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public LoginDialog(Shell parentShell) {
		super(parentShell);
	}
	
	@Override
	protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      shell.setText("I BS Q - Amenity");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(null);
		
		Label lblUserName = new Label(container, SWT.NONE);
		lblUserName.setBounds(10, 53, 100, 15);
		lblUserName.setText("User Name");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(116, 50, 167, 21);
		text.setText(System.getenv("username"));
		text.setEnabled(false);

		text_1 = new Text(container, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(116, 77, 167, 21);
		
		Label lblPassword = new Label(container, SWT.NONE);
		lblPassword.setBounds(10, 77, 100, 15);
		lblPassword.setText("Password");
		
		btnRememberMyPassword = new Button(container, SWT.CHECK);
		btnRememberMyPassword.setBounds(116, 104, 200, 16);
		btnRememberMyPassword.setText("Remember my password");
		
		Button button = new Button(container, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setEnabled(true);
			}
		});
		button.setBounds(289, 48, 27, 25);
		button.setText("...");

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		createButton(parent, RESET_ID, "Reset All", false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	protected void buttonPressed ( int buttonId ) {
		/*
		 * ID 0 : OK
		 * ID 1 : Cancel
		 */
		if ( buttonId == RESET_ID ) {
			text.setText(System.getenv("username"));
			text.setEnabled(false);
			text_1.setText("");
			
		} else if ( buttonId == 0 ){	// on OK
			SessionSourceProvider sessionSourceProvider = new SessionSourceProvider();
			sessionSourceProvider.setLoggedIn(true);
			GeneralQueries generalQueries = DaoFactory.eINSTANCE.createGeneralQueries();
			if ( generalQueries.dbAlive() ) {
				try {
					User tempUser = GeneralFactory.eINSTANCE.createUser();
					tempUser.setUsername( text.getText() );
					UserDao userDao = DaoFactory.eINSTANCE.createUserDao();
					/*
					 * Temporary user creation
					 */
					
//					tempUser.setEmail("ben@go-unified.com");
//					tempUser.setLastUsed(new Date());
//					tempUser.setTimesUsed(1);
//					userDao.create(tempUser);
					
					/*
					 * END Temporary user creation
					 */
					tempUser = userDao.findByUsername(tempUser);
					if ( tempUser.getUserId() != null ) {
						sessionSourceProvider.setLoggedIn(true);
						SessionSourceProvider.USERID = tempUser.getUserId();
						SessionSourceProvider.USER = tempUser;
						super.buttonPressed(buttonId);
					}
				} catch ( Exception ex ) {
					System.out.println("can't find user " + ex.getMessage() );
					ErrorDialog errorDialog = new ErrorDialog(this.getShell(),
							"Database Connection Error",
							"There is a problem with the database connection! ",
							createStatus(),
							IStatus.ERROR | IStatus.INFO );
					errorDialog.open();
				}
			} else {
				MessageDialog.openError(null, "Error", "Error occured");

				System.out.println("DB Server not running");
			}
			
		} else { //cancel and stuff
			super.buttonPressed(buttonId);
		}
	}

	private IStatus createStatus() {
		final String dummyPlugin = "some plugin";
		IStatus[] statuses = new IStatus[1];
		
		statuses[0] = new Status(IStatus.ERROR, dummyPlugin, 
				IStatus.OK, "Oh no! An error occurred!", new Exception());
		
//		statuses[1] = new Status(IStatus.INFO, dummyPlugin, 
//				IStatus.OK, "More errors!?!?", new Exception() );
		
//		MultiStatus multiStatus = new MultiStatus(dummyPlugin, IStatus.OK,
//				statuses, "Several errors have occurred.", new Exception() );
		
//		return multiStatus;
		return new Status(IStatus.ERROR, dummyPlugin, 
				IStatus.OK, "Please confirm your username!", new Exception());
		
	}

}
