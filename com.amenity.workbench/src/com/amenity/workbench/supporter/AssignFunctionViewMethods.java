package com.amenity.workbench.supporter;

import java.util.ArrayList;
import java.util.List;

import general.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.amenity.workbench.SessionSourceProvider;

import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.FileFunctionStatusDao;
import dao.FunctionDao;
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
	public List<FileFunctionStatus> deleteFFS ( FileFunctionStatus ffs, List<FileFunctionStatus> ffss ) {
		
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
