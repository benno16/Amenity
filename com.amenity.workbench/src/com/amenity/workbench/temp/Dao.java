package com.amenity.workbench.temp;

import general.ContentObject;
import general.Snapshot;

import java.util.Date;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.amenity.workbench.SessionSourceProvider;

import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.FileDao;
import dao.SnapshotDao;
import dao.UserDao;

public class Dao extends AbstractHandler {
	
	public Dao() {
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

//		UserDao userDao = DaoFactory.eINSTANCE.createUserDao();
//		SessionSourceProvider.USER.setTimesUsed( SessionSourceProvider.USER.getTimesUsed() + 1 );
//		SessionSourceProvider.USER.setLastUsed( new Date() );
//		userDao.update(SessionSourceProvider.USER);
		
		ContentObjectDao contentObjectDao = DaoFactory.eINSTANCE.createContentObjectDao();
		SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();
		Snapshot snapshot = (Snapshot) snapshotDao.getById("47c90a1c-42ea-41dc-8a71-15e68d972c95");
		
		List<ContentObject> contentObjects = contentObjectDao.getListBySnapshot(snapshot);
		for ( ContentObject co : contentObjects) {
			System.out.println(co.getName());
			contentObjectDao.delete(co);
		}
		
		return null;
	}

}
