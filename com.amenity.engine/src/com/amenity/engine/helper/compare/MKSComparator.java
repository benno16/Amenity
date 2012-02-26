package com.amenity.engine.helper.compare;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import general.ContentObject;
import general.File;
import general.Folder;

public class MKSComparator {

	// General things
	private List<ContentObject> contentObjects1;
	private List<ContentObject> contentObjects2;
	private List<GridItem> gridItems;
	private List<CompareViewObject> compareViewObjects;
	
	// Snapshot left
	private List<Folder> folders1;
	private List<File> files1;
	
	// Snapshot right
	private List<Folder> folders2;
	private List<File> files2;
	
	public MKSComparator() {
		/**
		 * TODO maybe a smarter way of handling this,
		 * but I simply love exceptions
		 * this is not allowed! 
		 */
		throw new UnsupportedOperationException();
	}
	
	public MKSComparator ( List<ContentObject> contentObjects1, 
			List<ContentObject> contentObjects2 ) {
		
		this.contentObjects1 = contentObjects1;
		this.contentObjects2 = contentObjects2;
		

		// Instantiate the arrays 
		compareViewObjects = new ArrayList<CompareViewObject>();
		gridItems = new ArrayList<GridItem>();
		
		folders1 = new ArrayList<Folder>();
		files1 = new ArrayList<File>();
		
		folders2 = new ArrayList<Folder>();
		files2 = new ArrayList<File>();
		
		
	}
	
	private void createCompareViewObjects() {

		files1.clear();
		folders1.clear();
		files2.clear();
		folders2.clear();
		
		// fill lists with corresponding file and folder data
		for ( ContentObject co1 : contentObjects1 ) {
			if ( co1 instanceof File)
				files1.add((File)co1);
			else 
				folders1.add((Folder)co1);
		}
		
		for ( ContentObject co2 : contentObjects2 ) {
			if ( co2 instanceof File)
				files2.add((File)co2);
			else 
				folders2.add((Folder)co2);
		}
		
		CompareViewObject cvo;
		
		/*
		 *  run through list and create the Compare View Objects
		 *  folders1 should contain the "older" version
		 *  and hence folder 2 should always contain the earlier versions files
		 */
		
		for ( Folder f1 : folders1 ) {
			boolean foundFolder = false;
			for ( Folder f2 : folders2 ) {
				if ( f1.getName().equals(f2.getName()) ){
					// folder found
					// create CompareViewObject and add it to list
					cvo = new CompareViewObject(f1, f2, "==");
					compareViewObjects.add(cvo);
					// set found folder to true and clear object
					// remove the found folder from folders2 to shorten the runtime
					foundFolder = true;
					cvo = null;
					folders2.remove(f2);
//					System.out.println("-- folder found");
					break;
				} // else do nothing
			}
			if ( !foundFolder ) {
				// folder 1 did not exist in new snapshot
				cvo = new CompareViewObject(f1, null, "!=");
				compareViewObjects.add(cvo);
				cvo = null;
//				System.out.println("-- folder did not exist in folder2");
			}
		}
		// Now we have to worry about folders that are in folder2 but not in folder1
		for ( Folder f2 : folders2 ) {
			cvo = new CompareViewObject(null, f2, "!=");
			compareViewObjects.add(cvo);
			cvo = null;
//			System.out.println("-- folder did not exist in folder1");
		}
		
		/*
		 * next the same with the files
		 */
		for ( File f1 : files1 ) {
			boolean foundFile = false;
			for ( File f2 : files2 ) {
				if ( f1.getName().equals(f2.getName()) ){
					// folder found
					// now lets check the version and modification date
					String differenciator = null;
					if ( f1.getModfiedDate().after(f2.getModfiedDate() )) {
						// f1 is newer
						differenciator = ">";
					} else if ( f1.getModfiedDate().before(f2.getModfiedDate() )) {
						differenciator = "<";
					} else {
						differenciator = "==";
					}
					// create CompareViewObject and add it to list
					cvo = new CompareViewObject(f1, f2, differenciator);
					compareViewObjects.add(cvo);
					// set found folder to true and clear object
					// remove the found folder from folders2 to shorten the runtime
					foundFile = true;
					cvo = null;
					files2.remove(f2);
//					System.out.println("-- folder found");
					break;
				} // else do nothing
			}
			if ( !foundFile ) {
				// folder 1 did not exist in new snapshot
				cvo = new CompareViewObject(f1, null, "!=");
				compareViewObjects.add(cvo);
				cvo = null;
				System.out.println("-- file did not exist in folder2");
			}
		}
		// Now we have to worry about folders that are in folder2 but not in folder1
		for ( File f2 : files2 ) {
			cvo = new CompareViewObject(null, f2, "!=");
			compareViewObjects.add(cvo);
			cvo = null;
			System.out.println("-- file did not exist in folder1");
		}
	}
	
	public List<GridItem> getComparableGrid( Grid grid ) {

		createCompareViewObjects();
		
		files1.clear();
		folders1.clear();
		files2.clear();
		folders2.clear();
		
		List<CompareViewObject> compareViewFolderObjects = new ArrayList<CompareViewObject>();
		List<CompareViewObject> compareViewFileObjects = new ArrayList<CompareViewObject>();
		
		// fill lists with corresponding file and folder data
		for ( CompareViewObject cvo : compareViewObjects ) {
			
			if ( cvo.getFile1() != null || cvo.getFile2() != null ) {
				// its a file
				compareViewFileObjects.add(cvo);
//				System.err.println("--"+cvo.getFile1().getName()+
//						"--"+cvo.getFile2().getName()+"--"+cvo.getDifferenciator()+"--");
			} else {
				// its a folder
				compareViewFolderObjects.add(cvo);
			}
		}
		
		
		GridItem gridItem;
		// create folders
		int noLevelResult = 0;
		SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
		
		for ( int i = 0 ; i < 999 ; i++ ){
			int itemsFound = 0;
			// break operation to not waste runtime! 
			if ( noLevelResult > 2 ) {
				break;
			}
			for ( CompareViewObject cvfo : compareViewFolderObjects ) {
				if ( cvfo.getFolder1().getLevel() == i ) { // || cvfo.getFolder2().getLevel() == i) {
					/*
					 * now we use the differenciator to diff between the folders
					 * in order to know what folder to use
					 */
					if ( cvfo.getDifferenciator().equalsIgnoreCase("==") || 
							cvfo.getDifferenciator().equalsIgnoreCase("<") || 
							cvfo.getDifferenciator().equalsIgnoreCase(">") ) {
						// They both exist, so we use Folder1 as "main" folder
						
//						System.err.println("--" + cvfo.getFolder1().getName() + "--"
//								+cvfo.getFolder2().getName() + "--" + cvfo.getDifferenciator()+"--" + 
//								cvfo.getFolder1().getRootDirectory() + "--" + 
//								cvfo.getFolder2().getRootDirectory()  + "--" );
						
						if ( cvfo.getFolder1().getRootDirectory() == null ) {
							// folder is root! 
							// static new root creation!
							gridItem = new GridItem ( grid, SWT.NONE );
							gridItem.setExpanded(true);
						} else {
							// it has a daddy which is already created and hence is looked up
							gridItem = new GridItem ( 
									getParentGrid(cvfo.getFolder1().getRootDirectory()), SWT.NONE);
						}
					} else if ( cvfo.getDifferenciator().equalsIgnoreCase("!=")) {
						
						if ( cvfo.getFolder1() == null ) {
							// we use folder 2 as master
							gridItem = new GridItem ( 
									getParentGrid(cvfo.getFolder2().getRootDirectory()), SWT.NONE);
							
						} else {
							// we use folder 1 as master
							gridItem = new GridItem ( 
									getParentGrid(cvfo.getFolder1().getRootDirectory()), SWT.NONE);
						}
						
					} else {
						/*
						 * TODO
						 * nicer messages
						 */
						System.out.println("an error occured");
						continue;
					}
					if ( cvfo.getFolder1() != null ) {
						gridItem.setText(0,cvfo.getFolder1().getName().toString());
						gridItem.setText(3,cvfo.getFolder1().getObjectId());
					}
					if ( cvfo.getFolder2() != null ) {
						gridItem.setText(5,cvfo.getFolder2().getName().toString());
						gridItem.setText(8,cvfo.getFolder2().getObjectId());
					}
					gridItem.setText(4, cvfo.getDifferenciator());
					gridItem.setImage(0,PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJ_FOLDER));
					gridItem.setImage(5,PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJ_FOLDER));
					
					gridItems.add(gridItem);
					itemsFound++;
				}
			}
			if ( itemsFound < 1 ) 
				noLevelResult++;
		}

		/**
		 * TODO
		 * add this stupid second folder option...
		 */
		
		noLevelResult = 0;
		// now lets check out the files
		for ( int i = 0 ; i < 999 ; i++ ){
			int itemsFound = 0;
			// break operation to not waste runtime! 
			if ( noLevelResult > 2 ) {
				break;
			}
			for ( CompareViewObject cvfo : compareViewFileObjects ) {
				if ( cvfo.getFile1().getLevel() == i  ) { //|| cvfo.getFile1().getLevel() == i ) {
					/*
					 * now we use the differenciator to diff between the folders
					 * in order to know what folder to use
					 */
					if ( cvfo.getDifferenciator().equalsIgnoreCase("==") || 
							cvfo.getDifferenciator().equalsIgnoreCase("<") || 
							cvfo.getDifferenciator().equalsIgnoreCase(">") ) {
						// They both exist, so we use Folder1 as "main" folder
						
						// it has a daddy which is already created and hence is looked up
						gridItem = new GridItem ( 
								getParentGrid(cvfo.getFile1().getRootDir()), SWT.NONE);

						
						if ( cvfo.getDifferenciator().equalsIgnoreCase("<") || 
								cvfo.getDifferenciator().equalsIgnoreCase(">") ) {
//							System.out.println("set color " + cvfo.getFile1().getRootDir());
							gridItem.setBackground(0, new Color(Display.getCurrent(), 230, 184, 184));
							gridItem.setBackground(1, new Color(Display.getCurrent(), 230, 184, 184));
							gridItem.setBackground(2, new Color(Display.getCurrent(), 230, 184, 184));
							gridItem.setBackground(3, new Color(Display.getCurrent(), 230, 184, 184));
							gridItem.setBackground(4, new Color(Display.getCurrent(), 230, 184, 184));
							gridItem.setBackground(5, new Color(Display.getCurrent(), 230, 184, 184));
							gridItem.setBackground(6, new Color(Display.getCurrent(), 230, 184, 184));
							gridItem.setBackground(7, new Color(Display.getCurrent(), 230, 184, 184));
							gridItem.setBackground(8, new Color(Display.getCurrent(), 230, 184, 184));
							getParentGrid(cvfo.getFile1().getRootDir()).setExpanded(true);
						}
					} else if ( cvfo.getDifferenciator().equalsIgnoreCase("!=")) {
						
						if ( cvfo.getFile1() == null ) {
							// we use folder 2 as master
							gridItem = new GridItem ( 
									getParentGrid(cvfo.getFile2().getRootDir()), SWT.NONE);
							
						} else {
							// we use folder 1 as master
							gridItem = new GridItem ( 
									getParentGrid(cvfo.getFile1().getRootDir()), SWT.NONE);
						}
						gridItem.setBackground(0, new Color(Display.getCurrent(), 192, 80, 77));
						gridItem.setBackground(1, new Color(Display.getCurrent(), 192, 80, 77));
						gridItem.setBackground(2, new Color(Display.getCurrent(), 192, 80, 77));
						gridItem.setBackground(3, new Color(Display.getCurrent(), 192, 80, 77));
						gridItem.setBackground(4, new Color(Display.getCurrent(), 192, 80, 77));
						gridItem.setBackground(5, new Color(Display.getCurrent(), 192, 80, 77));
						gridItem.setBackground(6, new Color(Display.getCurrent(), 192, 80, 77));
						gridItem.setBackground(7, new Color(Display.getCurrent(), 192, 80, 77));
						gridItem.setBackground(8, new Color(Display.getCurrent(), 192, 80, 77));
						
					} else {
						/*
						 * TODO
						 * nicer messages
						 */
						System.out.println("an error occured");
						continue;
					}
					if ( cvfo.getFile1() != null ) {
						gridItem.setText(0,cvfo.getFile1().getName().toString());
						gridItem.setText(1,cvfo.getFile1().getVersion());
						gridItem.setText(2,df.format(cvfo.getFile1().getModfiedDate()));
						gridItem.setText(3,cvfo.getFile1().getObjectId());
					}
					if ( cvfo.getFile2() != null ) {
						gridItem.setText(5,cvfo.getFile2().getName().toString());
						gridItem.setText(6,cvfo.getFile2().getVersion());
						gridItem.setText(7,df.format(cvfo.getFile2().getModfiedDate()));
						gridItem.setText(8,cvfo.getFile2().getObjectId());
					}
					gridItem.setText(4, cvfo.getDifferenciator());
					gridItem.setImage(0,PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJ_FILE));
					gridItem.setImage(5,PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJ_FILE));
					
					gridItems.add(gridItem);
					itemsFound++;
				}
			}
			if ( itemsFound < 1 ) 
				noLevelResult++;
		}
		
		
		
		return gridItems;
	}
	
	public GridItem getParentGrid(Folder rootDirectory) {
		for ( GridItem gi : gridItems ) {
			if ( gi.getText(3).equals(rootDirectory.getObjectId() )) {
				return gi;
			} 
			if ( gi.getText(8).equals(rootDirectory.getObjectId() )) {
				return gi;
			}
		}
		System.err.println("--- Grid does not exist");
		return null;
	}
	
	/**
	 * TODO 
	 * AUSLAGERN
	 * @param suffix
	 * @return
	 */
//	private Image getImageIcon(String suffix) {
//		return null;
//	}
}
