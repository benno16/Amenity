package com.amenity.workbench.supporter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import general.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;

import com.amenity.engine.helper.compare.CompareViewObject;
import com.amenity.engine.helper.compare.SnapshotComparator;
import com.amenity.workbench.SessionSourceProvider;

import dao.ContainerDao;
import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.FileFunctionStatusDao;
import dao.FunctionDao;
import dao.GenericDao;
import dao.SnapshotDao;


public class AssignFunctionViewMethods {

	private Logger log;
	private static AssignFunctionViewMethods instance; // 
	
	/*
	 *  singleton, because the view can be opened multiple times
	 */
	private AssignFunctionViewMethods (){
		log = LogManager.getLogger(AssignFunctionViewMethods.class);
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
		log.info("Assign Function View Methods Instantiated");
	}
	
	public static synchronized AssignFunctionViewMethods getInstance() {
		if ( instance == null ) 
			instance = new AssignFunctionViewMethods();
        return instance;
    }
	
	/*
	 * File Function Status Methods
	 */
	public List<FileFunctionStatus> deleteFileFunctionStatus ( FileFunctionStatus ffs, List<FileFunctionStatus> ffss ) {
		
		FileFunctionStatusDao ffsDao = DaoFactory.eINSTANCE.createFileFunctionStatusDao();
		
		try {
			ffsDao.delete(ffs);
			ffss.remove(ffs);
			
			logInfo("item was deleted" , true );
			
		} catch ( Exception ex ) {

			logInfo("item could not be deleted" , true );
		}
		
		return ffss;
	}
	
	public FileFunctionStatus createUpdateFFS ( FileFunctionStatus ffs ) {

		FileFunctionStatusDao ffsDao = DaoFactory.eINSTANCE.createFileFunctionStatusDao();
		try {
			ffsDao.update(ffs);
			logInfo("item was added" , true);
		} catch ( Exception ex ) {
			logError("item could not be added", true);
		}
		return ffs;
	}
	
	@SuppressWarnings("unchecked")
	public List<Snapshot> getSnapshots ( Container container ) {
		SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
		
		return snapshotDao.getListByContainer
				(SessionSourceProvider.CURRENT_CONTAINER);
	}
	
	@SuppressWarnings("unchecked")
	public List<Function> getFunctions ( Snapshot snapshot ) {
		FunctionDao functionDao = DaoFactory.eINSTANCE.createFunctionDao();
		
		return functionDao.getFunctionsBySnapshot(snapshot);
	}
	
	@SuppressWarnings("unchecked")
	public List<ContentObject> getContentObjects ( Snapshot snapshot ) {
		ContentObjectDao coDao = DaoFactory.eINSTANCE.createContentObjectDao();
		
		return coDao.getListBySnapshot( snapshot );
	}
	
	public List<ContentObject> getContentObjectsFunctions ( List<ContentObject> inboundContentObjects) {
		List<ContentObject> outboundContentObjects = new ArrayList<ContentObject>();
		
		for ( int i = 0 ; i < inboundContentObjects.size() ; i++ ) {
			// load the corresponding information!
			if ( inboundContentObjects.get(i).getFunction().size() > 0 )
				outboundContentObjects.add(inboundContentObjects.get(i));
		}
		
		return outboundContentObjects;
	}
	
	public Folder getRootFolder ( List<ContentObject> contentObjects ) {
		
		for ( int i = 0 ; i < contentObjects.size() ; i++ ) {
			
			if ( contentObjects.get(i) instanceof Folder ) {
				
				if ( ((Folder)contentObjects.get(i)).getRootDirectory() == null  ) {
					
					return (Folder)contentObjects.get(i);
					
				}
				
			}
			
		} 
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<FileFunctionStatus> getFileFunctionStatus ( Function function ) {
		FileFunctionStatusDao ffsDao = 
				DaoFactory.eINSTANCE.createFileFunctionStatusDao();
		
		return ffsDao.getFileFunctionStatusByFunction(function);
	}
	
	public List<ContentObject> getContentObjectsWithFunction ( 
			List<ContentObject> FullcontentObjectsWithFunction ) {
		
		List<ContentObject> contentObjectsWithFunction = new ArrayList<ContentObject>();

		if ( SessionSourceProvider.CURRENT_FUNCTION != null ) { 
			for ( ContentObject co : FullcontentObjectsWithFunction ) {
				
				// if the function list is not empty search through it and add
				if ( co.getFunction() != null || co.getFunction().size() > 0 ) {
					
					for ( Function f : co.getFunction() ) {
						if ( f.getFunctionId().equals(
								SessionSourceProvider.CURRENT_FUNCTION.getFunctionId())) {
							
							contentObjectsWithFunction.add(co);
							break;
					
						}
	
					}
				
				}
		
			}
		
		}
		
		return contentObjectsWithFunction;
	}
	
	public Function addFunction ( Function function ) {
		
		FunctionDao fDao = DaoFactory.eINSTANCE.createFunctionDao();
		
		fDao.update(function);
		
		function = (Function) fDao.getById(function.getFunctionId());
		
		return function;
	}
	
	public List<ContentObject> getFolderChildren ( Folder folder, List<ContentObject> coList ) {
		
		java.util.List<ContentObject> children = new ArrayList<ContentObject>();
		
		for ( ContentObject co : coList ) {
			
			if ( co instanceof Folder ) {
				
				if (((Folder)co).getRootDirectory() != null )
					
					if (((Folder) co).getRootDirectory().equals(folder))
						
						children.add(co);
				
			} else 
				if ( co instanceof File ) {
				
					if ( ((File) co).getRootDir().equals(folder) )
						
						children.add(co);
				
			}
			
		}
		
		return children;
	}
	
	public List<ContentObject> addFunctionToContentObject ( List<ContentObject> contentObjects, Function function, ContentObject co ) {
		
		List<ContentObject> newObjects = new ArrayList<ContentObject>();
		// for every inbound object find match and add
		for ( int i = 0 ; i < contentObjects.size() ; i++ ) {
			if ( contentObjects.get(i).getObjectId().equals(co.getObjectId() ) ) {
				boolean functionAlreadyInPlace = false;
				for ( Function f : contentObjects.get(i).getFunction() ) {
					
					if ( f.getFunctionId().equals(function.getFunctionId() )) 
						
						functionAlreadyInPlace = true;
					
				}
				if ( !functionAlreadyInPlace ) 
					contentObjects.get(i).getFunction().add(function);
				break;
			}
		}
		
		
		return newObjects;
	}
	
	@SuppressWarnings("unchecked")
	public List<Container> getContainerList ( User user ) {
		ContainerDao containerDao = DaoFactory.eINSTANCE.createContainerDao();
		
		return containerDao.getListByOwner(Container.class, user);
	}
	
	public void saveFunctionAssignment ( List<ContentObject> contentObjects, String name, Function function ) {
		
		GenericDao genDao = DaoFactory.eINSTANCE.createGenericDao();
		
		Session s = (Session) genDao.getSession();
		
		s.beginTransaction();
		
		SnapshotDao sDao = DaoFactory.eINSTANCE.createSnapshotDao();

		function = (Function) s.createQuery( "from " + Function.class.getName().toString()
				+ " where functionId = '" + 
				function.getFunctionId() + "'" ).list().get(0);
		
		sDao.getById(contentObjects.get(0).getPartOf().getSnapshotId());
		
		for ( ContentObject co : contentObjects ) {
			
			co = (ContentObject) s.createQuery("from " + ContentObject.class.getName().toString() + 
					" where objectId = '" + co.getObjectId() + "'").list().get(0);
			boolean set = false;
			for ( Function f: co.getFunction()) {
				if (f.getFunctionId().equals(function)) {
					set = true;
					break;
				}
			}
			if (!set) {

				co.getFunction().add(function);
				s.update(co);
			}
			
		}
		
		if ( !function.getName().equals(name) ) {

			function.setName(name);
			s.update(function);
			
		}
		
		s.getTransaction().commit();
		s.close();
	}
	
	// creates new functions from old snapshot
	@SuppressWarnings("unchecked")
	public List<Function> copyFunctionInfo ( Snapshot oldSnapshot, Snapshot newSnapshot ) {
		
		List<Function> oldFunctions = new ArrayList<Function>();
		List<Function> newFunctions = new ArrayList<Function>();
		
		
		
		FunctionDao fDao = DaoFactory.eINSTANCE.createFunctionDao();
		oldFunctions = fDao.getFunctionsBySnapshot(oldSnapshot);
		
		Function tempFunction = null;
		
		for ( Function fn : oldFunctions ) {
			
			tempFunction = GeneralFactory.eINSTANCE.createFunction();
			tempFunction.setCreated(fn.getCreated());
			tempFunction.setModified(new Date());
			tempFunction.setName(fn.getName());
			tempFunction.setOverallStatus(fn.getOverallStatus());
			tempFunction.setSnapshot(newSnapshot);
			newFunctions.add(tempFunction);
			
		}
		
		for ( Function fn : newFunctions) {
			fDao.create(fn);
		}
		
		// to ensure previously created functions are copied as well
		return fDao.getFunctionsBySnapshot( newSnapshot );
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ContentObject> getContentObjectWithFunctionAssigned ( Snapshot oldSnapshot, 
			Snapshot newSnapshot, List<Function> functions ) {
		
		GenericDao gDao = DaoFactory.eINSTANCE.createGenericDao();
		
		String query1 = "from " + ContentObject.class.getName().toString() + 
		" where partOf = '" + newSnapshot.getSnapshotId() + "'";

		String query2 = "from " + ContentObject.class.getName().toString() + 
		" where partOf = '" + oldSnapshot.getSnapshotId() + "'";
		
		// CO1 = new <> CO2 = old
		SnapshotComparator compare = new SnapshotComparator( (List<ContentObject>) gDao.getByQuery(query1), 
	    		(List<ContentObject>) gDao.getByQuery(query2));
	    
		// now I have the list containing both
		List<CompareViewObject> compareViewObjects = compare.createCompareViewObjects();
	    
	    Session session = gDao.getSession();
	    session.beginTransaction();
	    
	    List<ContentObject> returnObjects = new ArrayList<ContentObject>();
	    List<ContentObject> returnObjectsWithFunction = new ArrayList<ContentObject>();
	    
	    oldSnapshot = (Snapshot) session.createQuery("from " + 
	    		Snapshot.class.getName().toString() + 
	    		" where snapshotId='" + oldSnapshot.getSnapshotId() + 
	    		"'").list().get(0);
	    
	    newSnapshot = (Snapshot) session.createQuery("from " + 
	    		Snapshot.class.getName().toString() + 
	    		" where snapshotId='" + newSnapshot.getSnapshotId() + 
	    		"'").list().get(0);
	    
	    for ( CompareViewObject cvo : compareViewObjects ) {
	    	
	    	// just the "old" ones are interesting
	    	
	    	if ( cvo.getFile2() != null ) {
	    		// Its a file object
	    		
	    		if ( cvo.getFile1() != null ) {
	    			// there is a previous file version available
	    			// detach old objects with clear
	    			session.clear();
	    			// put object to persistent state
	    			cvo.setFile1((File) getContentObject ( session, cvo.getFile1() ) );
	    			cvo.setFile2((File) getContentObject ( session, cvo.getFile2() ) );
	    			if ( cvo.getFile2().getFunction() != null && 
	    					cvo.getFile2().getFunction().size() > 0 ) {
	    				// check if there are functions
	    				for ( Function f : cvo.getFile2().getFunction() ) {
	    					// add functions

	    					f = getMatchingFunction ( f, functions );
		    				cvo.getFile1().getFunction().add(f);
		    				returnObjectsWithFunction.add(cvo.getFile1());
		    			}

//	    				session.saveOrUpdate(cvo.getFile1());
	    				
	    			}
	    			
	    		}
	    		
	    	} else if ( cvo.getFolder2() != null ) {
	    		// Its a folder object
	    		
	    		if ( cvo.getFolder1() != null ) {
	    			// there is a previous file version available
	    			// detach old objects with clear
	    			session.clear();
	    			// put object to persistent state
	    			cvo.setFolder1((Folder) getContentObject ( session, cvo.getFolder1() ) );
	    			cvo.setFolder2((Folder) getContentObject ( session, cvo.getFolder2() ) );
	    			
	    			if ( cvo.getFolder2().getFunction() != null && 
	    					cvo.getFolder2().getFunction().size() > 0 ) {
	    				// check if there are functions
	    				
	    				for ( Function f : cvo.getFolder2().getFunction() ) {
	    					// add functions

	    					f = getMatchingFunction ( f, functions );
		    				cvo.getFolder1().getFunction().add(f);
		    				returnObjectsWithFunction.add(cvo.getFolder1());
		    				
		    			}
	    				
//	    				session.saveOrUpdate(cvo.getFolder1());
	    				
	    			}
	    			
	    		}
	    		
	    	} else {
	    		/*
	    		 * TODO: dummy creation
	    		 */
	    	}
	    	// now add the new and added content objects to return list
	    	if ( cvo.getFile1() != null ) {
	    		returnObjects.add(cvo.getFile1());
	    	} else if ( cvo.getFolder1() != null ) {
	    		returnObjects.add(cvo.getFolder1());
	    	}
	    	
	    }
	    
	    for ( ContentObject co : returnObjectsWithFunction ) {
	    	session.merge(co);
	    }
	    
	    session.getTransaction().commit();
	    session.close();
	    
	    return returnObjects;
	    
	}
	
	private Function getMatchingFunction ( Function function, List<Function> functions ) {
		
		for ( Function f : functions ) {
			
			if (f.getName().equals(function.getName()) )
				
					return f;
			
		}
		
		return null;
		
	}
	
	private ContentObject getContentObject ( Session session, ContentObject co ) {
		return (ContentObject) session.createQuery("from " + 
				ContentObject.class.getName().toString() + 
				" where objectId = '" + co.getObjectId() + "'").list().get(0);
	}
	
	/*
	 * Event logging Functions
	 */
	private void logError(String message, boolean userRelevant ) {
		if ( userRelevant ) 
			message = message + "#1";
		log.error(message);
	}
	
	@SuppressWarnings("unused")
	private void logFatal(String message, boolean userRelevant ) {
		if ( userRelevant ) 
			message = message + "#1";
		log.fatal(message);
	}
	
	@SuppressWarnings("unused")
	private void logWarning(String message, boolean userRelevant ) {
		if ( userRelevant ) 
			message = message + "#1";
		log.warn(message);
	}
	
	private void logInfo(String message, boolean userRelevant ) {
		if ( userRelevant ) 
			message = message + "#1";
		log.info(message);
	}
	
	@SuppressWarnings("unused")
	private void logdeburg(String message, boolean userRelevant ) {
		if ( userRelevant ) 
			message = message + "#1";
		log.debug(message);
	}
	
	/*
	 * End of Event logging Functions
	 */
}
