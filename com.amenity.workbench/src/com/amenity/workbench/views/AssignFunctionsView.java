package com.amenity.workbench.views;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import general.Container;
import general.ContentObject;
import general.File;
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
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.amenity.engine.helper.gui.filter.FunctionAssigned;
import com.amenity.engine.helper.gui.filter.FunctionNotAssigned;
import com.amenity.engine.helper.gui.filter.NoFilter;
import com.amenity.engine.helper.gui.labelProvider.GenericNameLabelProvider;
import com.amenity.engine.helper.gui.labelProvider.SnapshotStyledLabelProvder;
import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.dialogs.CreateFunctionDialog;

import dao.ContainerDao;
import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.FunctionDao;
import dao.SnapshotDao;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AssignFunctionsView extends ViewPart {
	public static String newFn = null;
	private Text functionNameText;
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	
	private ComboViewer functionComboViewer;
	private Combo functionCombo;
	private ComboViewer snapshotComboViewer;
	private Combo snapshotCombo;
	private TreeViewer snapshotTreeViewer;
	private TreeViewer functionTreeViewer;
	private Tree snapshotTree;
	private Tree functionTree;
	private Composite composite;
	
	// drag and drop source information
	private boolean isSnapshotItem;
	private boolean isFunctionItem;
	private boolean isFileAssoItem;
	
	
	// filters for tree
	protected Action actionShowAll, actionHideUsed, actionHideNotUsed;
	protected ViewerFilter filterShowAll, filterHideUsed, filterHideNotUsed;
	
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

	public AssignFunctionsView() {
//		contentObjects = new ArrayList<ContentObject>();
		log = LogManager.getLogger(AssignFunctionsView.class);
		
		CURRENT_FILE_LIST = new ArrayList<ContentObject>();
		
		CURRENT_FUNCTION_LIST = new ArrayList<Function>();
		CURRENT_FUNCTION_FILE_LIST = new ArrayList<ContentObject>();
		
		ORIGINAL_FUNCTION_LIST = new ArrayList<Function>();
		ORIGINAL_FUNCTION_FILE_LIST = new ArrayList<ContentObject>();
		CURRENT_FILE_LIST_WITH_FUNCTION = new ArrayList<ContentObject>();
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
	}

	@SuppressWarnings("unused")
	@Override
	public void createPartControl(Composite parent) {
		this.composite = parent;
		GridLayout gridLayout = new GridLayout(9,true);
		parent.setLayout(gridLayout);
		
		ComboViewer containerComboViewer = new ComboViewer(parent, SWT.NONE);
		Combo containerCombo = containerComboViewer.getCombo();
		containerCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// Container Combo JFace Settings
		containerComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Container>)inputElement ) .toArray();
			}
		});
		containerComboViewer.setLabelProvider(new GenericNameLabelProvider());
		containerComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( !structuredSelection.isEmpty() ) {
		        	if ( structuredSelection.getFirstElement() instanceof Container ) {
		        		SessionSourceProvider.CURRENT_CONTAINER = 
		        				(Container) structuredSelection.getFirstElement();
		        		fillSnapshotCombo();
		        	}
		        }
			}
			
		});
		
		snapshotComboViewer = new ComboViewer(parent, SWT.NONE);
		snapshotComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Snapshot>)inputElement ) .toArray();
			}
		});
		snapshotComboViewer.setLabelProvider(new GenericNameLabelProvider());
		snapshotComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
		        structuredSelection = (IStructuredSelection) objectSelection;
		        if ( !structuredSelection.isEmpty() ) {
		        	if ( structuredSelection.getFirstElement() instanceof Snapshot ) {
		        		SessionSourceProvider.CURRENT_SNAPSHOT = 
		        				(Snapshot) structuredSelection.getFirstElement();
		        		
		        		fillFunctionCombo( false );
		        		firstFillSnapshotTree();
		        		clearFunctionTree();
		        	}
		        }
			}
			
		});
		
		snapshotCombo = snapshotComboViewer.getCombo();
		snapshotCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		
		functionComboViewer = new ComboViewer(parent, SWT.NONE);
		functionCombo = functionComboViewer.getCombo();
		functionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		functionComboViewer.setLabelProvider(new GenericNameLabelProvider());
		functionComboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Snapshot>)inputElement ) .toArray();
			}
		});
		functionComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				objectSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;
				// may require not null check
				if ( CURRENT_FUNCTION_FILE_LIST != null )
				if ( !ORIGINAL_FUNCTION_FILE_LIST.containsAll(CURRENT_FUNCTION_FILE_LIST) ) {
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
								
								// clear the old content if any
								ORIGINAL_FUNCTION_FILE_LIST.clear();
								CURRENT_FUNCTION_FILE_LIST.clear();
								
								// set currently selection function
								SessionSourceProvider.CURRENT_FUNCTION = (Function) 
										structuredSelection.getFirstElement();
								
								// iterate through CURRENT_FILE_LIST_WITH_FUNCTION
								for ( ContentObject co : CURRENT_FILE_LIST_WITH_FUNCTION ) {
									
									// if the function list is not empty search through it and add
									if ( co.getFunction() != null || co.getFunction().size() > 0 ) {
										
										for ( Function f : co.getFunction() ) {
											/*
											 * TODO: Nullpointer Exception
											 */
											if ( f.getFunctionId().equals(
													SessionSourceProvider.CURRENT_FUNCTION.getFunctionId())) {

												ORIGINAL_FUNCTION_FILE_LIST.add(co);
												CURRENT_FUNCTION_FILE_LIST.add(co);
												
											}
										}

									}
								}
								
								functionTreeViewer.setInput( CURRENT_FUNCTION_FILE_LIST );
								
							}
						}
					}
				}
			}
		});
		
		Button btnAdd = new Button(parent, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ( SessionSourceProvider.CURRENT_SNAPSHOT != null ) {
					CreateFunctionDialog dialog = new CreateFunctionDialog(composite.getShell(), 
							newFn, SessionSourceProvider.CURRENT_SNAPSHOT.getName());
					if ( dialog.open() == Window.OK) {
						Function function = GeneralFactory.eINSTANCE.createFunction();
						function.setCreated(new Date());
						function.setSnapshot(SessionSourceProvider.CURRENT_SNAPSHOT);
						function.setName(newFn);
						function.setModified(new Date());
						CURRENT_FUNCTION_LIST.add(function);
						fillFunctionCombo(true);
					}
				}
				
			}
		});
		btnAdd.setText("Add");
		
		
		
		List dropzoneList = new List(parent, SWT.BORDER);
		
		DropTarget dropTarget_2 = new DropTarget(dropzoneList, DND.DROP_MOVE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		/**
		 * TODO: implement multi select
		 * SWT.MULTI
		 */
		snapshotTreeViewer = new TreeViewer( parent, SWT.BORDER );
		snapshotTree = snapshotTreeViewer.getTree();
		snapshotTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

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
							if (((Folder) co).getRootDirectory().getObjectId().equals(((Folder)inputElement).getObjectId()))
								children.add(co);
						}
						if ( co instanceof File ) {
							if (((File) co).getRootDir().getObjectId().equals(((Folder)inputElement).getObjectId()))
								children.add(co);
						}
					}
				}
				return children.toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				/*
				 * TODO: put this into own method
				 */
				
				return getFolderChildren((ContentObject)parentElement).toArray();
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
		snapshotTreeViewer.setLabelProvider(new SnapshotStyledLabelProvder ());
		/**
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
					event.data = firstElement.getObjectId();
				}
				setIsSnapshotItem();
			}
			
			@Override
			public void dragStart(DragSourceEvent event) {
			}

		});
		
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
				refreshSnapshotTree();
				functionTreeViewer.setInput(CURRENT_FUNCTION_FILE_LIST);
				setUndefinedItem();
				return false;
			}
			
			@Override
			public boolean validateDrop ( Object target, int operation, 
					TransferData transferType ) {
				System.out.println("snapshotStatus: " + isFunctionItem);
				return isFunctionItem;
			}
		});
	    
		snapshotTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
	    	
	    	public void selectionChanged(SelectionChangedEvent event) {
				setIsSnapshotItem();
	    	}
	    });
		Composite composite_1 = new Composite(parent, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		composite_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button arrowLeftLeft = new Button(composite_1, SWT.NONE);
		arrowLeftLeft.setText("<");
		
		Button arrowLeftRight = new Button(composite_1, SWT.NONE);
		arrowLeftRight.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/**
				 * TODO: Move over to middle tree
				 */
			}
		});
		arrowLeftRight.setText(">");
		
		functionTreeViewer = new TreeViewer(parent, SWT.BORDER);
		functionTree = functionTreeViewer.getTree();
		functionTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
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

				return getFolderChildren((ContentObject)parentElement).toArray();
				
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
		
	    functionTreeViewer.addDropSupport(operations, transfers, new ViewerDropAdapter(snapshotComboViewer) {

			public void drop ( DropTargetEvent event ) {
				int location = this.determineLocation(event);
				determineTarget ( event ) ;
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
					refreshSnapshotTree();
					functionTreeViewer.setInput(CURRENT_FUNCTION_FILE_LIST);
				} else {
					MessageDialog.openInformation(composite.getShell(), 
							"Information", "Please select or create a function first");
				}
				setUndefinedItem();
				return false;
			}

			@Override
			public boolean validateDrop(Object target, int operation,
					TransferData transferType) {
				if ( functionComboViewer.getSelection().isEmpty() )
					return false;
				return isSnapshotItem;
			}
			
		});
	    
	    functionTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
	    	
	    	public void selectionChanged(SelectionChangedEvent event) {
				setIsFunctionItem();
	    	}
	    });
	    
		Composite compositeM = new Composite(parent, SWT.NONE);
		compositeM.setLayout(new GridLayout(2, false));
		compositeM.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button arrowRightLeft = new Button(compositeM, SWT.NONE);
		arrowRightLeft.setText("<");
		
		Button arrowRightRight = new Button(compositeM, SWT.NONE);
		arrowRightRight.setText(">");
		
		Grid statusGrid = new Grid(parent, SWT.BORDER);
		statusGrid.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblFunctionName = new Label(parent, SWT.NONE);
		GridData gd_lblFunctionName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblFunctionName.widthHint = 85;
		lblFunctionName.setLayoutData(gd_lblFunctionName);
		lblFunctionName.setText("Function Name");
		new Label(parent, SWT.NONE);
		
		functionNameText = new Text(parent, SWT.BORDER);
		functionNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(parent, SWT.NONE);
		
		Button btnSetStatus = new Button(parent, SWT.NONE);
		btnSetStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnSetStatus.setText("Set Status");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblOverallStatus = new Label(parent, SWT.NONE);
		lblOverallStatus.setText("Overall Status");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblConfigured = new Label(parent, SWT.NONE);
		lblConfigured.setText("Configured");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		fillContainerCombo(containerComboViewer, containerCombo);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Button btnSave = new Button(parent, SWT.NONE);
		btnSave.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnSave.setText("Apply");
		btnSave.setImage(PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_ETOOL_SAVE_EDIT));
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ( MessageDialog.openQuestion(composite.getShell(), "" +
						"Confirmation Required", "Are you sure you want to add " +
								"the files to the selected function?") ) {
					saveBtnAction();
				}
			}
		});
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		
		createFiltersAndSorters();
		createActions();
		createMenus();
		
	}
	

	protected void clearFunctionTree() {
		functionTreeViewer.setInput(null);
	}

	/*
	 * TODO: persisting changes on apply
	 */
	protected void saveBtnAction () {
		
		if ( !CURRENT_FUNCTION_FILE_LIST.equals(ORIGINAL_FUNCTION_FILE_LIST) ) {
			
			ORIGINAL_FUNCTION_FILE_LIST = CURRENT_FUNCTION_FILE_LIST;
			ContentObjectDao coDao = DaoFactory.eINSTANCE.createContentObjectDao();
			for ( ContentObject co : CURRENT_FUNCTION_FILE_LIST ) {
				coDao.update(co);
			}
			
			
			
		}
		
//		if ( contentObjects.size() > 0 ) {
//			// Iterate through the content object list, store function and remove from list
//			GenericDao genDao = DaoFactory.eINSTANCE.createGenericDao();
//			
//			s = genDao.getSession(); //HibernateUtilImpl.getSessionFactoryEdefault().openSession();
//			tx = s.beginTransaction();
////			s.flush();
////			s.clear();
//			for ( Iterator<ContentObject> iter = contentObjects.iterator(); iter.hasNext(); ) {
//				ContentObject co = iter.next();
//
//				storeFunctionInfoInFile ( co );
//				
//				iter.remove();
//			}
//			tx.commit();
//			s.close();
//		} else {
//			MessageDialog.openInformation(composite.getShell(), 
//					"Information", "nothing to persist");
//		}
//		fillSnapshotTree();
	}

	protected void storeFunctionInfoInFile( ContentObject co ) {
		if ( co instanceof File || co instanceof Folder ) {
			
			for ( int i = 0 ; i < CURRENT_FILE_LIST.size() ; i++ ) {
				if ( CURRENT_FILE_LIST.get(i).getObjectId().equals(co.getObjectId())) {
					CURRENT_FILE_LIST.get(i).getFunction().add(SessionSourceProvider.CURRENT_FUNCTION);
					co = CURRENT_FILE_LIST.get(i);
				}
			}
			
//			co.getFunction().add(SessionSourceProvider.CURRENT_FUNCTION);
			CURRENT_FUNCTION_FILE_LIST.add(co);
			CURRENT_FILE_LIST_WITH_FUNCTION.add(co);
		}
		// if its a folder fetch children and perform same operation
		if ( co instanceof Folder ) {
			java.util.List<ContentObject> coList = getFolderChildren(co);
			for ( ContentObject subCo : coList ) {
				storeFunctionInfoInFile(subCo);
			}
		}
	}
	
	/*
	 * TODO: this can be used for the content providers as well
	 */
	public java.util.List<ContentObject> getFolderChildren ( ContentObject parentElement ) {
		

		java.util.List<ContentObject> children = new ArrayList<ContentObject>();
		for ( ContentObject co : CURRENT_FILE_LIST ) {
			if ( co instanceof Folder ) {
				if (((Folder)co).getRootDirectory() != null )
				if (((Folder) co).getRootDirectory().equals(((Folder)parentElement)))
					children.add(co);
			}
			if ( co instanceof File ) {
				if (((File) co).getRootDir().equals(((Folder)parentElement)))
					children.add(co);
			}
		}
		
		return children;
	}
	
	


	@SuppressWarnings("unchecked")
	protected void fillFunctionCombo(boolean added) {
		// if added its a new function selected and not one added
		if ( !added ) {
			ORIGINAL_FUNCTION_LIST.clear();
			CURRENT_FUNCTION_LIST.clear();
//			CURRENT_FUNCTION_FILE_LIST = null;
//			ORIGINAL_FUNCTION_FILE_LIST = null;
			FunctionDao functionDao = DaoFactory.eINSTANCE.createFunctionDao();
			CURRENT_FUNCTION_LIST = functionDao.getFunctionsBySnapshot(SessionSourceProvider.CURRENT_SNAPSHOT);
			ORIGINAL_FUNCTION_LIST = CURRENT_FUNCTION_LIST;
		} 

		functionTreeViewer.setInput(CURRENT_FUNCTION_FILE_LIST);
		functionComboViewer.setInput(CURRENT_FUNCTION_LIST);
	}

	@SuppressWarnings("unchecked")
	protected void fillSnapshotCombo() {
		SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
		java.util.List<Container> input = snapshotDao.getListByContainer
				(SessionSourceProvider.CURRENT_CONTAINER);

		snapshotComboViewer.setInput(input);
		if ( snapshotCombo.getItemCount() > 0 ) 
			snapshotCombo.select(0);
		input = null;
	}

	@SuppressWarnings("unchecked")
	private void fillContainerCombo(ComboViewer containerComboViewer, Combo containerCombo) {
		ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
		java.util.List<Container> input = containerDao.getListByOwner(Container.class, SessionSourceProvider.USER);
		
		containerComboViewer.setInput(input);
		if ( containerCombo.getItemCount() > 0 ) 
			containerCombo.select(0);
		input = null;
	}

	/*
	 * This method reads every content object of the snapshot
	 * including the function information
	 */
	@SuppressWarnings("unchecked")
	protected void firstFillSnapshotTree() {
		CURRENT_FILE_LIST_WITH_FUNCTION.clear();
		ContentObjectDao coDao = DaoFactory.eINSTANCE.createContentObjectDao();
		CURRENT_FILE_LIST = coDao
				.getListBySnapshot(SessionSourceProvider.CURRENT_SNAPSHOT);

		for ( int i = 0 ; i < CURRENT_FILE_LIST.size() ; i++ ) {
			// load the corresponding information!
			if ( CURRENT_FILE_LIST.get(i).getFunction().size() > 0 )
				CURRENT_FILE_LIST_WITH_FUNCTION.add(CURRENT_FILE_LIST.get(i));
		}
		
		refreshSnapshotTree();
		
	}
	
	protected void refreshSnapshotTree() {

		snapshotTree.removeAll();
		snapshotTreeViewer.setLabelProvider( new SnapshotStyledLabelProvder(CURRENT_FILE_LIST) );
		
		// find root Folder
		for ( int i = 0 ; i < CURRENT_FILE_LIST.size() ; i++ ) {
			
			if ( CURRENT_FILE_LIST.get(i) instanceof Folder ) {
				
				if ( ((Folder)CURRENT_FILE_LIST.get(i)).getRootDirectory() == null  ) {
					
					snapshotTreeViewer.setInput(((Folder)CURRENT_FILE_LIST.get(i)));
					
				}
				
			}
			
		}
		
	}
	
	protected void createActions() {
		actionShowAll = new Action("Show all items") {
			public void run() {
				updateFilter(actionShowAll);
			}
		};
		actionShowAll.setChecked(false);
		
		actionHideUsed = new Action("Hide items without function") {
			public void run() {
				updateFilter(actionHideUsed);
			}
		};
		actionHideUsed.setChecked(false);
		
		actionHideNotUsed = new Action("Hide items with function") {
			public void run() {
				updateFilter(actionHideNotUsed);
			}
		};
		actionHideNotUsed.setChecked(false);
		
	}

	protected void createFiltersAndSorters() {
		filterHideUsed = new FunctionAssigned();
		filterHideNotUsed = new FunctionNotAssigned();
		filterShowAll = new NoFilter();
	}
	
	/* Multiple filters can be enabled at a time. */
	protected void updateFilter(Action action) {
		if(action == actionShowAll) {
			if(action.isChecked()) {
				snapshotTreeViewer.addFilter(filterShowAll);
			} else {
				snapshotTreeViewer.addFilter(filterShowAll);
				snapshotTreeViewer.removeFilter(filterHideUsed);
				snapshotTreeViewer.removeFilter(filterHideNotUsed);
			}
		} else if(action == actionHideUsed) {
			if(action.isChecked()) {
				snapshotTreeViewer.addFilter(filterHideUsed);
			} else {
				snapshotTreeViewer.removeFilter(filterHideUsed);
				snapshotTreeViewer.addFilter(filterShowAll);
			}
		} else if(action == actionHideNotUsed) {
			if(action.isChecked()) {
				snapshotTreeViewer.addFilter(filterHideNotUsed);
			} else {
				snapshotTreeViewer.removeFilter(filterHideNotUsed);
				snapshotTreeViewer.addFilter(filterShowAll);
			}
		}
	}
	
	protected void createMenus() {
		IMenuManager rootMenuManager = getViewSite().getActionBars().getMenuManager();
		rootMenuManager.setRemoveAllWhenShown(true);
		rootMenuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager mgr) {
				fillMenu(mgr);
			}
		});
		fillMenu(rootMenuManager);
	}


	protected void fillMenu(IMenuManager rootMenuManager) {
		IMenuManager filterSubmenu = new MenuManager("Filters");
		rootMenuManager.add(filterSubmenu);
		filterSubmenu.add(actionShowAll);
		filterSubmenu.add(actionHideUsed);
		filterSubmenu.add(actionHideNotUsed);
//		
//		IMenuManager sortSubmenu = new MenuManager("Sort By");
//		rootMenuManager.add(sortSubmenu);
//		sortSubmenu.add(booksBoxesGamesAction);
//		sortSubmenu.add(noArticleAction);
	}

	
	private void setIsSnapshotItem () {
		isSnapshotItem = true;
		isFunctionItem = false;
		isFileAssoItem = false;
	}
	
	private void setIsFunctionItem () {
		isSnapshotItem = false;
		isFunctionItem = true;
		isFileAssoItem = false;
	}
	
	private void setIsFileAssoItem () {
		isSnapshotItem = false;
		isFunctionItem = false;
		isFileAssoItem = true;
	}
	
	private void setUndefinedItem () {
		isSnapshotItem = false;
		isFunctionItem = false;
		isFileAssoItem = false;
	}
	
	@Override
	public void setFocus() {}
}
