package com.amenity.workbench.views;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import general.Container;
import general.ContentObject;
import general.File;
import general.FileFunctionStatus;
import general.Folder;
import general.Function;
import general.GeneralFactory;
import general.Snapshot;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener;
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Text;

import com.amenity.engine.helper.gui.editingSupport.DataTypeEditingSupport;
import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.engine.helper.gui.labelProvider.SnapshotStyledLabelProvder;
import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.dialogs.CreateFunctionDialog;
import com.amenity.workbench.supporter.AssignFunctionViewFilters;
import com.amenity.workbench.supporter.AssignFunctionViewMethods;

import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.FileFunctionStatusDao;
import dao.SnapshotDao;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AssignFunctionsView extends ViewPart {
	public static String newFn = null;
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	
	private ComboViewer containerComboViewer;
	private ComboViewer functionComboViewer;
	private Combo functionCombo;
	private ComboViewer snapshotComboViewer;
	private Combo snapshotCombo;
	private TreeViewer snapshotTreeViewer;
	private TreeViewer functionTreeViewer;
	private Tree snapshotTree;
	private Tree functionTree;
	private Composite composite;
	private TableViewer tableViewer;
	
	private Button btnAdd;
	private Button btnSave;
	private Label lblDate;
	private Text functionNameText;
	private Table table;
	private Label lblDeleteffs;
	
//	private java.util.List<ContentObject> contentObjects;
	private Logger log;
	// stores the total snapshot content
	private static java.util.List<ContentObject> CURRENT_FILE_LIST;
	// stores the total snapshot content
	private static java.util.List<ContentObject> CURRENT_FILE_LIST_WITH_FUNCTION;
	// stores the current function content
	private static java.util.List<Function> CURRENT_FUNCTION_LIST;
	// stores the originally read function content
	private static java.util.List<Function> ORIGINAL_FUNCTION_LIST;
	// stores the current function content objects
	private static java.util.List<ContentObject> CURRENT_FUNCTION_FILE_LIST;
	// stores the originally read function content objects
	private static java.util.List<ContentObject> ORIGINAL_FUNCTION_FILE_LIST;
	// stores the originally read function content objects
	private static java.util.List<FileFunctionStatus> CURRENT_FUNCTION_FILE_STATUS_LIST;
	// stores the originally read function content objects
	private static java.util.List<FileFunctionStatus> ORIGINAL_FUNCTION_FILE_STATUS_LIST;

	public AssignFunctionsView() {
//		contentObjects = new ArrayList<ContentObject>();
		log = LogManager.getLogger(AssignFunctionsView.class);
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
		PlatformUI.getWorkbench();
		CURRENT_FILE_LIST = new ArrayList<ContentObject>();
		
		CURRENT_FUNCTION_LIST = new ArrayList<Function>();
		CURRENT_FUNCTION_FILE_LIST = new ArrayList<ContentObject>();
		
		ORIGINAL_FUNCTION_LIST = new ArrayList<Function>();
		ORIGINAL_FUNCTION_FILE_LIST = new ArrayList<ContentObject>();
		CURRENT_FILE_LIST_WITH_FUNCTION = new ArrayList<ContentObject>();
		
		CURRENT_FUNCTION_FILE_STATUS_LIST = new ArrayList<FileFunctionStatus>();
		ORIGINAL_FUNCTION_FILE_STATUS_LIST = new ArrayList<FileFunctionStatus>();
		
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
		log.info("Assign Function view openend");
	}

	@SuppressWarnings("unused")
	@Override
	public void createPartControl(Composite parent) {
		this.composite = parent;
		
		GridLayout gridLayout = new GridLayout(8,false);
		
		parent.setLayout(gridLayout);

		/*
		 * Container drop down starts here
		 */
		containerComboViewer = new ComboViewer(parent, SWT.NONE);
		
		Combo containerCombo = containerComboViewer.getCombo();
		
		containerCombo.setToolTipText("Select Container");
		
		containerCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		
		// Container Combo JFace Settings - reviewed 14.03.2012
		containerComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Container>)inputElement ) .toArray();
			}
		});
		containerComboViewer.setLabelProvider(new GenericNameLabelProvider());
		
		// reviewed 14.03.2012
		containerComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				
		        structuredSelection = (IStructuredSelection) event.getSelection();
		        
		        if ( !structuredSelection.isEmpty() ) {
		        	
		        	if ( structuredSelection.getFirstElement() instanceof Container ) {
		        		
		        		SessionSourceProvider.CURRENT_CONTAINER = 
		        				(Container) structuredSelection.getFirstElement();
		        		clearSnapshotTree();
		        		snapshotComboViewer.setInput( AssignFunctionViewMethods.getInstance()
		        			.getSnapshots(SessionSourceProvider.CURRENT_CONTAINER) );
		        		snapshotComboViewer.refresh();
		        		
		        	}
		        	
		        }
		        
			}
			
		});
		
		
		/*
		 * Snapshot drop down starts here
		 */
		snapshotComboViewer = new ComboViewer(parent, SWT.NONE);
		
		// reviewed 14.03.2012
		snapshotComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Snapshot>)inputElement ) .toArray();
			}
		});
		
		// reviewed 14.03.2012
		snapshotComboViewer.setLabelProvider(new GenericNameLabelProvider());

		// reviewed 14.03.2012
		snapshotComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				
				objectSelection = event.getSelection();
				
		        structuredSelection = (IStructuredSelection) objectSelection;
		        
		        if ( !structuredSelection.isEmpty() ) {
		        	
		        	if ( structuredSelection.getFirstElement() instanceof Snapshot ) {
		        		
		        		SessionSourceProvider.CURRENT_SNAPSHOT = 
		        				(Snapshot) structuredSelection.getFirstElement();
		        		
//		        		// delete all the old content and lists
//		        		clearSnapshotTree();
//		        		
//		        		// get snapshot functions and add to combo and List
//		        		CURRENT_FUNCTION_LIST = AssignFunctionViewMethods.getInstance()
//		        			.getFunctions(SessionSourceProvider.CURRENT_SNAPSHOT);
//		        		
//		        		ORIGINAL_FUNCTION_LIST = CURRENT_FUNCTION_LIST;
//		        		
//		        		functionComboViewer.setInput(CURRENT_FUNCTION_LIST);
//		        		functionComboViewer.refresh();
//		        		
//		        		CURRENT_FILE_LIST = AssignFunctionViewMethods.getInstance()
//		        				.getContentObjects(SessionSourceProvider.CURRENT_SNAPSHOT);
//		        		CURRENT_FILE_LIST_WITH_FUNCTION = AssignFunctionViewMethods.getInstance()
//		        				.getContentObjectsFunctions(CURRENT_FILE_LIST);
//		        		
//		        		snapshotTreeViewer.setInput(AssignFunctionViewMethods.getInstance()
//		        				.getRootFolder(CURRENT_FILE_LIST));
//		        		
//		        		snapshotTreeViewer.refresh();
		        		
		        		initializeSnapshotTree();
		        		
		        	}
		        	
		        }
		        
			}
			
		});
		
		snapshotCombo = snapshotComboViewer.getCombo();
		snapshotCombo.setToolTipText("Select Snapshot");
		snapshotCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		
		functionComboViewer = new ComboViewer(parent, SWT.NONE);
		functionCombo = functionComboViewer.getCombo();
		functionCombo.setToolTipText("Select Function");
		functionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		// reviewed 14.03.2012
		functionComboViewer.setLabelProvider(new GenericNameLabelProvider());

		// reviewed 14.03.2012
		functionComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Snapshot>)inputElement ) .toArray();
			}
		});

		// reviewed 14.03.2012
		functionComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
		
			/*
			 * (non-Javadoc)
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * If selection is changed the current snapshot content object list is iterated
			 * and in case the CO is part of the current function the file will be added
			 * to the current function list. if not next object
			 */
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;
				
				// may require not null check
				if ( CURRENT_FUNCTION_FILE_LIST != null && 
						!ORIGINAL_FUNCTION_FILE_LIST.containsAll(CURRENT_FUNCTION_FILE_LIST) ) {
					MessageDialog.openWarning(composite.getShell(), "Warning", 
							"You have to apply the changes");
				} else {
					
					// check if list is not empty
					if ( !structuredSelection.isEmpty()) {
						
						// ensure element is of correct instance
						if ( structuredSelection.getFirstElement() instanceof Function) {
							
							// if a new element is selected clear list and repaint the tree
							if ( SessionSourceProvider.CURRENT_FUNCTION == null || 
									!SessionSourceProvider.CURRENT_FUNCTION.equals((Function) 
									structuredSelection.getFirstElement()) ) {

								// clear everything
								clearFunctionTree();
								
								// start rebuilding here
								// set selected function
								SessionSourceProvider.CURRENT_FUNCTION = (Function) 
										structuredSelection.getFirstElement();
								
								// Add the static existent file function status objects to Table
								CURRENT_FUNCTION_FILE_STATUS_LIST = AssignFunctionViewMethods.getInstance()
										.getFileFunctionStatus(SessionSourceProvider.CURRENT_FUNCTION);
								ORIGINAL_FUNCTION_FILE_STATUS_LIST = CURRENT_FUNCTION_FILE_STATUS_LIST;
								tableViewer.setInput(CURRENT_FUNCTION_FILE_STATUS_LIST);
								
								// set additional labels
								functionNameText.setText(SessionSourceProvider.CURRENT_FUNCTION.getName());
								lblDate.setText(SessionSourceProvider.CURRENT_FUNCTION.getModified().toString());
								
								
								// iterate through CURRENT_FILE_LIST_WITH_FUNCTION
								CURRENT_FUNCTION_FILE_LIST = AssignFunctionViewMethods.getInstance()
										.getContentObjectsWithFunction( CURRENT_FILE_LIST_WITH_FUNCTION );
								ORIGINAL_FUNCTION_FILE_LIST = CURRENT_FUNCTION_FILE_LIST;

								functionTreeViewer.setInput( CURRENT_FUNCTION_FILE_LIST );
								
							}
						}
					}
				}
			}
		});
		
		/*
		 * TODO: Testing
		 */
		// reviewed 14.03.2012
		btnAdd = new Button(parent, SWT.NONE);
		btnAdd.setToolTipText("Add new Function to List");
		btnAdd.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnAdd.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gtk-add.png"));
		// reviewed 14.03.2012
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ( SessionSourceProvider.CURRENT_SNAPSHOT != null ) {
					CreateFunctionDialog dialog = new CreateFunctionDialog(composite.getShell(), 
							newFn, SessionSourceProvider.CURRENT_SNAPSHOT.getName());
					if ( dialog.open() == Window.OK) {
						// create object
						Function function = GeneralFactory.eINSTANCE.createFunction();
						function.setCreated(new Date());
						function.setSnapshot(SessionSourceProvider.CURRENT_SNAPSHOT);
						function.setName(newFn);
						function.setModified(new Date());
						// store object in database and get ID
						SessionSourceProvider.CURRENT_FUNCTION = AssignFunctionViewMethods.getInstance().addFunction(function);
						// add function object to list
						CURRENT_FUNCTION_LIST.add(SessionSourceProvider.CURRENT_FUNCTION);
						// add to combobox and refresh it
						functionComboViewer.setInput(CURRENT_FUNCTION_LIST);
						functionComboViewer.refresh();
					}
				}
				
			}
		});
		btnAdd.setText("Add");
		
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		lblDeleteffs = new Label(parent, SWT.NONE);
		// reviewed 14.03.2012
		lblDeleteffs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				objectSelection = tableViewer.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;

				if ( !structuredSelection.isEmpty()) {
					CURRENT_FUNCTION_FILE_STATUS_LIST = AssignFunctionViewMethods
							.getInstance().deleteFileFunctionStatus((FileFunctionStatus) 
									structuredSelection.getFirstElement(), 
									CURRENT_FUNCTION_FILE_STATUS_LIST);
					getViewSite().getActionBars().getStatusLineManager().setMessage ("item deleted");
				}
			}
		});
		// reviewed 14.03.2012
		lblDeleteffs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ( e.keyCode == SWT.DEL)
					objectSelection = tableViewer.getSelection();
					structuredSelection = (IStructuredSelection) objectSelection;

					if ( !structuredSelection.isEmpty()) {
						CURRENT_FUNCTION_FILE_STATUS_LIST = AssignFunctionViewMethods
								.getInstance().deleteFileFunctionStatus((FileFunctionStatus) 
										structuredSelection.getFirstElement(), 
										CURRENT_FUNCTION_FILE_STATUS_LIST);
						getViewSite().getActionBars().getStatusLineManager().setMessage ("item deleted");
				}
			}
		});
		// reviewed 14.03.2012
		lblDeleteffs.setTouchEnabled(true);
		lblDeleteffs.setToolTipText("Remove Document Definition From List");
		lblDeleteffs.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/gtk-delete.png"));
		lblDeleteffs.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		/*
		 * TODO: implement multi select
		 * SWT.MULTI
		 */
		new Label(parent, SWT.NONE);
		snapshotTreeViewer = new TreeViewer( parent, SWT.BORDER );
		snapshotTree = snapshotTreeViewer.getTree();
		snapshotTree.setToolTipText("Items of selected snapshot");
		snapshotTree.setLinesVisible(true);
		snapshotTree.setHeaderVisible(true);
		snapshotTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		// reviewed 14.03.2012
		snapshotTreeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public void dispose() {}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

			@Override
			public Object[] getElements(Object inputElement) {
				java.util.List<ContentObject> children = new ArrayList<ContentObject>();
				if ( inputElement instanceof File ) {
					children.add((File)inputElement);
				} else {
					for ( ContentObject co : CURRENT_FILE_LIST ) {
						if ( co instanceof Folder ) {

							if (((Folder)co).getRootDirectory() != null )
								if (((Folder) co).getRootDirectory().getObjectId()
										.equals(((Folder)inputElement).getObjectId()))
									children.add(co);
						}
						if ( co instanceof File ) {
							if (((File) co).getRootDir().getObjectId()
									.equals(((Folder)inputElement).getObjectId()))
								children.add(co);
						}
					}
				}
				return children.toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				
				return AssignFunctionViewMethods.getInstance()
						.getFolderChildren( (Folder)parentElement , 
								CURRENT_FILE_LIST ).toArray();
				
			}

			@Override
			public Object getParent(Object element) {
				return null;
			}

			@Override
			public boolean hasChildren(Object element) {
				return element instanceof Folder;
			}
			
		});

		// reviewed 14.03.2012
		snapshotTreeViewer.setLabelProvider(new SnapshotStyledLabelProvder ());
		
		
		/*
		 * TODO: Temp sorter implementation
		 * Issue here its basically sorting strictly by name not type! 
		 */
		snapshotTreeViewer.setSorter(new ViewerSorter() {
			public int compare ( TreeViewer snapshotTreeViewer, Object obj1, Object obj2) {
				if ( obj1 instanceof File && obj2 instanceof File ) {
					return ((File) obj1).getName().compareTo(((File) obj2).getName());
				} else if ( obj1 instanceof Folder && obj2 instanceof Folder ) {
					return ((Folder) obj1).getName().compareTo(((Folder) obj2).getName());
				} else if ( obj1 instanceof Folder && obj2 instanceof File ) {
					return 1;
				} 
				return 0;
			}	
		});
		
		// static filter!
//		snapshotTreeViewer.addFilter(new FunctionAssigned());
		int operations = DND.DROP_MOVE | DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { TextTransfer.getInstance() };
		Transfer[] transfers2 = new Transfer[] { TextTransfer.getInstance() };

		// reviewed 14.03.2012
	    snapshotTreeViewer.addDragSupport(operations, transfers, new DragSourceListener() {

			@Override
			public void dragFinished(DragSourceEvent event) {
			}
			@Override
			public void dragSetData(DragSourceEvent event) {
				// Here you do the convertion to the type which is expected.
				IStructuredSelection selection = (IStructuredSelection) snapshotTreeViewer.getSelection();
				ContentObject firstElement = (ContentObject) selection.getFirstElement();
				
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					// drags the ID of the Content Object 
					event.data = firstElement.getObjectId();
					
				}
				AssignFunctionViewFilters.getInstance().setIsSnapshotItem();
			}
			
			@Override
			public void dragStart(DragSourceEvent event) {
			}

		});
		/*
		 * Review to be checked 14.03.
		 */
		snapshotTreeViewer.addDropSupport(operations, transfers2, new ViewerDropAdapter ( snapshotTreeViewer ) {
			public void drop ( DropTargetEvent event ) {
				determineTarget(event);
				super.drop(event);
			}
			
			@Override
			public boolean performDrop ( Object data ) {
				
				/*
				 * TODO: removing the files and folders from the iterator
				 */
				for ( Iterator<ContentObject> coIter = CURRENT_FUNCTION_FILE_LIST.iterator(); 
						coIter.hasNext(); ) {
					ContentObject co = coIter.next();
					if ( co.getObjectId().equals(data.toString())) {
						
						for ( Iterator<Function> fun = co.getFunction().iterator(); fun.hasNext(); ) {
							if ( fun.next().getFunctionId()
									.equals(SessionSourceProvider.CURRENT_FUNCTION.getFunctionId() ))
								fun.remove();
						}
						
						coIter.remove();
						for ( Iterator<ContentObject> coIter2 = CURRENT_FILE_LIST_WITH_FUNCTION.iterator(); 
								coIter2.hasNext(); ) {
							
							if ( coIter2.next().equals(co) ) {
								coIter2.remove();
								break;
							}
							
						}
						break;
						
					}
				}
				
				snapshotTreeViewer.setLabelProvider( new SnapshotStyledLabelProvder( CURRENT_FILE_LIST ) );
        		snapshotTreeViewer.setInput(AssignFunctionViewMethods.getInstance()
        				.getRootFolder(CURRENT_FILE_LIST));
        		
				functionTreeViewer.setInput(CURRENT_FUNCTION_FILE_LIST);
        		snapshotTreeViewer.refresh();
        		
				AssignFunctionViewFilters.getInstance().setUndefinedItem();
				return false;
			}
			
			@Override
			public boolean validateDrop ( Object target, int operation, 
					TransferData transferType ) {
				return AssignFunctionViewFilters.getInstance().isFunctionItem();
			}
		});
		
		TreeColumn trclmnAllItems = new TreeColumn(snapshotTree, SWT.NONE);
		trclmnAllItems.setWidth(200);
		trclmnAllItems.setText("All Items");

		// reviewed 14.03.2012
		snapshotTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
	    	
	    	public void selectionChanged(SelectionChangedEvent event) {
	    		AssignFunctionViewFilters.getInstance().setIsSnapshotItem();
	    	}
	    });
		
		Composite composite_1 = new Composite(parent, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		composite_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button arrowLeftLeft = new Button(composite_1, SWT.NONE);
		arrowLeftLeft.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		arrowLeftLeft.setText("<");
		
		Button arrowLeftRight = new Button(composite_1, SWT.NONE);
		
		arrowLeftRight.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/*
				 * TODO: Move over to middle tree
				 */
			}
		});
		arrowLeftRight.setText(">");
		
		functionTreeViewer = new TreeViewer(parent, SWT.BORDER);
		functionTree = functionTreeViewer.getTree();
		functionTree.setLinesVisible(true);
		functionTree.setHeaderVisible(true);
		functionTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		TreeColumn trclmnFilesOfFunction = new TreeColumn(functionTree, SWT.NONE);
		trclmnFilesOfFunction.setWidth(200);
		trclmnFilesOfFunction.setText("Files of Function");
		
		functionTreeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public void dispose() {}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

			@Override
			public Object[] getElements(Object inputElement) {
				/*
				 *  the input elements are just allowed to be the lowest level elements
				 *  this means if a content object has a root folder it should
				 *  not be displayed within the root but this specific folder
				 *  
				 */
				java.util.List<ContentObject> retObj = new ArrayList<ContentObject>();
				
				for ( ContentObject coOuter : CURRENT_FUNCTION_FILE_LIST ) {
					boolean isRoot = true;
					for ( ContentObject coInner : CURRENT_FUNCTION_FILE_LIST ) {
						if ( coInner instanceof Folder ) {
							if ( coOuter instanceof Folder ) {
								
								if ( ((Folder)coOuter).getRootDirectory()
										.getObjectId().equals(((Folder)coInner).getObjectId()) ) {
									isRoot = false;
									break;
								}
								
							} else if ( coOuter instanceof File ) {
								
								if ( ((File)coOuter).getRootDir()
										.getObjectId().equals(((Folder)coInner).getObjectId()) ) {
									isRoot = false;
									break;
								}
								
							}
						}
					}
					if ( isRoot ) 
						retObj.add(coOuter);
				}
				return retObj.toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {

				return AssignFunctionViewMethods.getInstance()
						.getFolderChildren( (Folder)parentElement , 
								CURRENT_FILE_LIST ).toArray();
				
			}

			@Override
			public Object getParent(Object element) {
				return null;
			}

			@Override
			public boolean hasChildren(Object element) {
				return element instanceof Folder;
			}
			
		});
		functionTreeViewer.setLabelProvider(new GenericNameLabelProvider());

		functionTreeViewer.addDragSupport(operations, transfers2, new DragSourceListener() {

			@Override
			public void dragStart(DragSourceEvent event) {}

			@Override
			public void dragSetData(DragSourceEvent event) {
				IStructuredSelection selection = (IStructuredSelection) functionTreeViewer.getSelection();
				ContentObject firstElement = (ContentObject) selection.getFirstElement();
				
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = firstElement.getObjectId();
				}
			}

			@Override
			public void dragFinished(DragSourceEvent event) {}
			
		});
		
	    functionTreeViewer.addDropSupport(operations, transfers, new ViewerDropAdapter(functionTreeViewer) {

			public void drop ( DropTargetEvent event ) {
				int location = this.determineLocation(event);
				determineTarget ( event ) ;
				btnSave.setText("Apply *");
				super.drop(event); 
			}
			
			@Override
			public boolean performDrop(Object data) {
				/*
				 * TODO: getting content right
				 * refreshing the snapshottreeviewer
				 */
				if ( SessionSourceProvider.CURRENT_FUNCTION != null ) {
					for ( ContentObject co : CURRENT_FILE_LIST )
						if ( co.getObjectId().equals(data.toString() )) {
							
							storeFunctionInfoInFile(co);
							
							break;
						}
					
					snapshotTree.removeAll();
					
					snapshotTreeViewer.setLabelProvider( new SnapshotStyledLabelProvder(CURRENT_FILE_LIST) );
					snapshotTreeViewer.setInput(AssignFunctionViewMethods.getInstance().getRootFolder(CURRENT_FILE_LIST) );

					functionTreeViewer.setInput(CURRENT_FUNCTION_FILE_LIST);
				} else {
					MessageDialog.openInformation(composite.getShell(), 
							"Information", "Please select or create a function first");
				}
				AssignFunctionViewFilters.getInstance().setUndefinedItem();
				return false;
			}

			@Override
			public boolean validateDrop(Object target, int operation,
					TransferData transferType) {
				if ( functionComboViewer.getSelection().isEmpty() )
					return false;
				return AssignFunctionViewFilters.getInstance().isSnapshotItem();
			}
			
		});
	    
	    functionTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
	    	
	    	public void selectionChanged(SelectionChangedEvent event) {
	    		AssignFunctionViewFilters.getInstance().setIsFunctionItem();
	    	}
	    });
	    
		Composite compositeM = new Composite(parent, SWT.NONE);
		compositeM.setLayout(new GridLayout(2, false));
		compositeM.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button arrowRightLeft = new Button(compositeM, SWT.NONE);
		arrowRightLeft.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		arrowRightLeft.setText("<");
		
		Button arrowRightRight = new Button(compositeM, SWT.NONE);
		arrowRightRight.setText(">");
		
		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		/*
		 * TODO: Table viewer
		 */
		tableViewer.addDropSupport(operations, transfers2, new ViewerDropAdapter(tableViewer){

			@Override
			public boolean performDrop(Object data) {
				FileFunctionStatus ffs = GeneralFactory.eINSTANCE.createFileFunctionStatus();

				FileFunctionStatusDao ffsDao = DaoFactory.eINSTANCE.createFileFunctionStatusDao();
				
				ContentObjectDao coDao = DaoFactory.eINSTANCE.createContentObjectDao();

				ffs = (FileFunctionStatus) ffsDao.createFfsWithFunctionIdObjectId(
						(File)coDao.getById(data.toString()), 
						SessionSourceProvider.CURRENT_FUNCTION, 
						ffs);
				
				CURRENT_FUNCTION_FILE_STATUS_LIST.add(ffs);
				
				tableViewer.setInput(CURRENT_FUNCTION_FILE_STATUS_LIST);
				tableViewer.refresh();
				
				return false;
			}

			@Override
			public boolean validateDrop(Object target, int operation,
					TransferData transferType) {
				return AssignFunctionViewFilters.getInstance().isFunctionItem();
			}
			
		});
		tableViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<FileFunctionStatus>)inputElement ) .toArray();
			}
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		        // fired when cell content changes
		    }
		});
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnFileType = tableViewerColumn.getColumn();
		
		tableViewerColumn.setEditingSupport(new DataTypeEditingSupport(tableViewerColumn.getViewer()));
		tableViewer.getColumnViewerEditor().addEditorActivationListener(
				new ColumnViewerEditorActivationListener() {

					@Override
					public void beforeEditorActivated(
							ColumnViewerEditorActivationEvent event) {}

					@Override
					public void afterEditorActivated(
							ColumnViewerEditorActivationEvent event) {}

					@Override
					public void beforeEditorDeactivated(
							ColumnViewerEditorDeactivationEvent event) {}

					@Override
					public void afterEditorDeactivated(
							ColumnViewerEditorDeactivationEvent event) {
						tableViewer.refresh();
					}
			
		});
		getSite().setSelectionProvider(tableViewer);
		
		tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				return element == null ? "" : ((FileFunctionStatus)element).getType().getLiteral();
			}
		});
		tblclmnFileType.setWidth(100);
		tblclmnFileType.setText("File Type");
		
		ComboBoxViewerCellEditor typeEditor = 
				new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);

		
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnFileName = tableViewerColumn_1.getColumn();
		tableViewerColumn_1.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				return element == null ? "" : ((FileFunctionStatus)element).getOfFile().getName();
			}
		});
		
		tblclmnFileName.setWidth(100);
		tblclmnFileName.setText("File Name");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblFunctionName = new Label(parent, SWT.NONE);
		GridData gd_lblFunctionName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblFunctionName.widthHint = 85;
		lblFunctionName.setLayoutData(gd_lblFunctionName);
		lblFunctionName.setText("Function Name");
		
		functionNameText = new Text(parent, SWT.BORDER);
		functionNameText.setToolTipText("You can change the function name here");
		functionNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Button btnCompareTo = new Button(parent, SWT.NONE);
		btnCompareTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if ( SessionSourceProvider.CURRENT_CONTAINER == null ||
						SessionSourceProvider.CURRENT_SNAPSHOT == null ) {
					
					MessageDialog.openWarning(composite.getShell(), "Warning", 
							"No container or snapshot selected");
					
				} else {
					
					ListDialog listDialog = new ListDialog(composite.getShell());
					listDialog.setTitle("Select Snapshot");
					listDialog.setMessage("Select the snapshot you wish to copy the information from");
					listDialog.setContentProvider(ArrayContentProvider.getInstance());
					listDialog.setLabelProvider(new GenericNameLabelProvider());
					SnapshotDao sDao = DaoFactory.eINSTANCE.createSnapshotDao();
					listDialog.setInput(
							sDao.getSnapshotsWithFunction(
									SessionSourceProvider.CURRENT_CONTAINER) );
					
					if ( listDialog.open() == Dialog.OK ){
						
						/*
						 * TODO: Put the relevant link to the function in here
						 */
						
						// at first get the old functions and create new ones
						functionComboViewer.setInput( CURRENT_FUNCTION_LIST =
								ORIGINAL_FUNCTION_LIST = AssignFunctionViewMethods.getInstance()
								.copyFunctionInfo( (Snapshot)listDialog.getResult()[0], 
								SessionSourceProvider.CURRENT_SNAPSHOT ) );
						
						functionComboViewer.refresh();
						log.info("fetched " + CURRENT_FUNCTION_LIST.size() + " functions#1");
						
						CURRENT_FILE_LIST = 
								AssignFunctionViewMethods.getInstance().getContentObjectWithFunctionAssigned( 
								(Snapshot)listDialog.getResult()[0], 
								SessionSourceProvider.CURRENT_SNAPSHOT, CURRENT_FUNCTION_LIST);
						
//						CURRENT_FILE_LIST_WITH_FUNCTION = AssignFunctionViewMethods.getInstance()
//		        				.getContentObjectsFunctions(CURRENT_FILE_LIST);
//						
//						snapshotTreeViewer.setInput(AssignFunctionViewMethods.getInstance()
//		        				.getRootFolder(CURRENT_FILE_LIST));
//						snapshotTreeViewer.refresh();
						
						initializeSnapshotTree();
					}
				}
			}
		});
		btnCompareTo.setImage(ResourceManager.getPluginImage("com.amenity.workbench", 
				"icons/workbench/general/splash green.png"));
		btnCompareTo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		btnCompareTo.setText("Compare To...");
		new Label(parent, SWT.NONE);
		
		Label lblOverallStatus = new Label(parent, SWT.NONE);
		lblOverallStatus.setText("Overall Status");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Button btnSetStatus = new Button(parent, SWT.NONE);
		btnSetStatus.setToolTipText("Open Properties Window");
		btnSetStatus.setImage(ResourceManager.getPluginImage("com.amenity.workbench", 
				"icons/workbench/general/up.png"));
		btnSetStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnSetStatus.setText("Set Status");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblConfigured = new Label(parent, SWT.NONE);
		lblConfigured.setText("Configured");
		
		lblDate = new Label(parent, SWT.NONE);
		lblDate.setText("");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		btnSave = new Button(parent, SWT.NONE);
		btnSave.setToolTipText("Save Function Content");
		btnSave.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnSave.setText("Apply ");
		btnSave.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_ETOOL_SAVE_EDIT));
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if ( MessageDialog.openQuestion(composite.getShell(), "" +
						"Confirmation Required", "Are you sure you want to add " +
								"the files to the selected function?") ) {
					
					AssignFunctionViewMethods.getInstance().saveFunctionAssignment(CURRENT_FUNCTION_FILE_LIST, 
							functionNameText.getText(), SessionSourceProvider.CURRENT_FUNCTION );
					
					btnSave.setText("Apply");
					
				}
			}
		});
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		containerComboViewer.setInput(AssignFunctionViewMethods.getInstance().getContainerList(SessionSourceProvider.USER) );
		
		new Label(parent, SWT.NONE);
		
		AssignFunctionViewFilters.getInstance().createFiltersAndSorters();
		AssignFunctionViewFilters.getInstance().createActions(snapshotTreeViewer);
		AssignFunctionViewFilters.getInstance().createMenus(getViewSite().getActionBars().getMenuManager());
		
	}
	

	protected void initializeSnapshotTree() {

		// delete all the old content and lists
		clearSnapshotTree();
		
		// get snapshot functions and add to combo and List
		CURRENT_FUNCTION_LIST = AssignFunctionViewMethods.getInstance()
			.getFunctions(SessionSourceProvider.CURRENT_SNAPSHOT);
		
		ORIGINAL_FUNCTION_LIST = CURRENT_FUNCTION_LIST;
		
		functionComboViewer.setInput(CURRENT_FUNCTION_LIST);
		functionComboViewer.refresh();
		
		CURRENT_FILE_LIST = AssignFunctionViewMethods.getInstance()
				.getContentObjects(SessionSourceProvider.CURRENT_SNAPSHOT);
		CURRENT_FILE_LIST_WITH_FUNCTION = AssignFunctionViewMethods.getInstance()
				.getContentObjectsFunctions(CURRENT_FILE_LIST);
		
		snapshotTreeViewer.setInput(AssignFunctionViewMethods.getInstance()
				.getRootFolder(CURRENT_FILE_LIST));
		
		snapshotTreeViewer.refresh();
		
	}

	private void clearFunctionTree() {
		// clears every information related to a selected function 
		SessionSourceProvider.CURRENT_FUNCTION = null;
		CURRENT_FUNCTION_FILE_LIST.clear();
		ORIGINAL_FUNCTION_FILE_LIST.clear();
		CURRENT_FUNCTION_FILE_STATUS_LIST.clear();
		ORIGINAL_FUNCTION_FILE_STATUS_LIST.clear();
		functionTreeViewer.setInput(CURRENT_FUNCTION_FILE_LIST);
		tableViewer.setInput(CURRENT_FUNCTION_FILE_STATUS_LIST);
		functionNameText.setText("");
		lblDate.setText("");
	}
	
	private void clearSnapshotTree() {
		clearFunctionTree();
		CURRENT_FILE_LIST.clear();
		CURRENT_FILE_LIST_WITH_FUNCTION.clear();
		CURRENT_FUNCTION_LIST.clear();
		ORIGINAL_FUNCTION_LIST.clear();
		snapshotTreeViewer.setInput(CURRENT_FILE_LIST);
	}

	protected void storeFunctionInfoInFile( ContentObject co ) {
		if ( co instanceof File || co instanceof Folder ) {
			
			for ( int i = 0 ; i < CURRENT_FILE_LIST.size() ; i++ ) {
				
				if ( CURRENT_FILE_LIST.get(i).getObjectId().equals(co.getObjectId())) {
					
					boolean functionAlreadyInPlace = false;
					
					for ( Function f : CURRENT_FILE_LIST.get(i).getFunction() ) {
						
						if ( f.getFunctionId().equals(SessionSourceProvider.CURRENT_FUNCTION.getFunctionId() )) {

							functionAlreadyInPlace = true;
							break; 
							
						}
						
					}
					if ( !functionAlreadyInPlace ) 
						CURRENT_FILE_LIST.get(i).getFunction().add(SessionSourceProvider.CURRENT_FUNCTION);
					
					co = CURRENT_FILE_LIST.get(i);
					break;
					
				}
				
			}
			
//			co.getFunction().add(SessionSourceProvider.CURRENT_FUNCTION);
			CURRENT_FUNCTION_FILE_LIST.add(co);
			CURRENT_FILE_LIST_WITH_FUNCTION.add(co);
		}
		// if its a folder fetch children and perform same operation
		if ( co instanceof Folder ) {
			java.util.List<ContentObject> coList = AssignFunctionViewMethods.getInstance().getFolderChildren( (Folder)co , CURRENT_FILE_LIST );
			for ( ContentObject subCo : coList ) {
				storeFunctionInfoInFile(subCo);
			}
		}
	}
	
	@Override
	public void setFocus() {}
}
