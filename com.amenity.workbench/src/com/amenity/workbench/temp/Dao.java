package com.amenity.workbench.temp;

import java.util.Date;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.amenity.workbench.SessionSourceProvider;

import dao.DaoFactory;
import dao.UserDao;

public class Dao extends AbstractHandler {
	
	public Dao() {
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		UserDao userDao = DaoFactory.eINSTANCE.createUserDao();
		SessionSourceProvider.USER.setTimesUsed( SessionSourceProvider.USER.getTimesUsed() + 1 );
		SessionSourceProvider.USER.setLastUsed( new Date() );
		userDao.update(SessionSourceProvider.USER);
		
		return null;
	}

}
