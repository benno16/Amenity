package com.amenity.workbench.views.interfaces.temp;

import general.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amenity.workbench.SessionSourceProvider;
import com.amenity.workbench.views.interfaces.IStartupView;

public class StartupViewImpl implements IStartupView {

	/**
	 * this is just something temporary for the presentation
	 * in future this will be in external modules
	 * hence the usage of interfaces! 
	 */
	private static StartupViewImpl instance = new StartupViewImpl();

	// private because its a singleton! 
	private StartupViewImpl(){
	}
	
	public static StartupViewImpl getInstance() {
        return instance;
    }
	
	@Override
	public Date getLastLogin() {
		return SessionSourceProvider.USER.getLastUsed();
	}

	@Override
	public int getTimesUsed() {
		return SessionSourceProvider.USER.getTimesUsed();
	}

	@Override
	public List<String> getLastErrors() {
		List<String> errors = new ArrayList<String>();
		for ( int i = 0; i < 10 ; i++ ) {
			errors.add("Error on " + new Date().toString() + " number " + i);
		}
		return errors;
	}

	@Override
	public boolean isMKSRunning() {
		return true;
	}

	@Override
	public boolean isSynergyRunning() {
		return false;
	}

	@Override
	public boolean isDatabaseRunning() {
		return true;
	}

	@Override
	public User getCurrentUser() {
		return SessionSourceProvider.USER;
	}
	
}
