package com.amenity.workbench.views;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.views.interfaces.temp.StartupViewImpl;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class StartupView extends ViewPart {

	public static final String ID = "com.amenity.workbench.views.StartupView"; //$NON-NLS-1$
	private StartupViewImpl svi = StartupViewImpl.getInstance();
	private Table table;
	private Table table_1;
	private Label lblLastLogin;
	private Label lblTimesUsed;
//	private IMemento memento;

	public StartupView() {

		Adapter adapter = new AdapterImpl() {
			public void notifyChanged ( Notification notification ) {
				
				lblLastLogin.setText(buildDate(SessionSourceProvider
						.USER.getLastUsed()));
				lblTimesUsed.setText("Times Used: " + 
						SessionSourceProvider.USER.getTimesUsed());
			}
		};
		SessionSourceProvider.USER.eAdapters().add(adapter);
	}
	
	/**
	 * Save selection! 
	 * http://blog.eclipse-tips.com/2009/08/remember-state.html
	 */
//	@Override
//	public void init ( IViewSite site, IMemento memento ) throws PartInitException {
//		this.memento = memento;
//		super.init(site, memento);
//	}
	
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Composite compInfo = new Composite(composite, SWT.LEFT);
		
		lblLastLogin = new Label(compInfo, SWT.NONE);
		lblLastLogin.setBounds(10, 10, 304, 15);
		lblLastLogin.setText( buildDate(SessionSourceProvider
				.USER.getLastUsed()) );
		
		lblTimesUsed = new Label(compInfo, SWT.NONE);
		lblTimesUsed.setBounds(10, 31, 304, 15);
		lblTimesUsed.setText("Times Used: " + SessionSourceProvider
				.USER.getTimesUsed() );
		
		Label lblTaskList = new Label(compInfo, SWT.NONE);
		lblTaskList.setBounds(10, 60, 304, 15);
		lblTaskList.setText("Task List");
		
		table = new Table(compInfo, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 81, 304, 122);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Label label = new Label(compInfo, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 52, 304, 2);
		
		Composite compError = new Composite(composite, SWT.LEFT);
		compError.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		
		Label lblLatestErrors = new Label(compError, SWT.NONE);
		lblLatestErrors.setBounds(10, 10, 304, 15);
		lblLatestErrors.setText("Latest Errors:");
		
		table_1 = new Table(compError, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(10, 31, 304, 117);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		Composite compStatus = new Composite(composite, SWT.BOTTOM |SWT.LEFT);
		compStatus.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true, 1, 1));
		compStatus.setLayout(new GridLayout(3, false));
		Button btnMks = new Button(compStatus, SWT.TOGGLE);
		if ( svi.isMKSRunning() ) {
			btnMks.setSelection(true);
			btnMks.setToolTipText("MKS session is open");
		}
		btnMks.setEnabled(false);
		btnMks.setText("MKS");
		
		Button btnSynergy = new Button(compStatus, SWT.TOGGLE);
		btnSynergy.setEnabled(false);
		btnSynergy.setText("Synergy");
		
		Button btnNewButton = new Button(compStatus, SWT.TOGGLE);
		if ( svi.isDatabaseRunning() ) {
			btnNewButton.setSelection(true);
			btnNewButton.setToolTipText("Database session is open");
		}
		
		btnNewButton.setEnabled(false);
		btnNewButton.setText("Database");
		if ( svi.isSynergyRunning() ) {
			btnSynergy.setSelection(true);
			btnSynergy.setToolTipText("Synergy session is open");
		}
			
		
		createActions();
//		restoreSelection();
	}

//	private void restoreSelection() {
//		if ( memento != null ) {
//			IMemento storedSelection = memento.getChild("StoredSelection");
//			if ( storedSelection != null ) {
//				viewer.setSelection(selection);
//			}
//		}
//	}
//	@Override
//	public void saveState(IMemento memento) {
//		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
//		if (!selection.isEmpty()) {
//			IMemento storedSelection = memento.createChild("StoredSelection");
//	 	// store the selection under storedSelection
//		}
//	}
	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
	
	private String buildDate(Date date) {
		String lastLogin = "Last Login: ";
		SimpleDateFormat formater = new SimpleDateFormat("EEEE, dd. MMMM yy HH:mm");
		lastLogin = lastLogin + formater.format(date);
		
		return lastLogin;
	}
}
