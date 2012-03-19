package com.amenity.workbench.supporter;

import java.util.ArrayList;
import java.util.List;

import general.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;

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
