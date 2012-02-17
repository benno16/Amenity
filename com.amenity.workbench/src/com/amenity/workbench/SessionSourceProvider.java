package com.amenity.workbench;

import general.User;
import general.UserList;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class SessionSourceProvider extends AbstractSourceProvider {
	
	public final static String SESSION_STATE = "com.amenity.workbench.sessionState"; 
	private final static String LOGGED_IN = "loggedIn"; 
    private final static String LOGGED_OUT = "loggedOut"; 
    public static String USERID = "-";
    public static User USER = null;
    public static UserList USERS = null;
    boolean loggedIn;
    
    public void setLoggedIn ( boolean loggedIn ) {
    	if ( this.loggedIn == loggedIn )
    		return;
    	this.loggedIn = loggedIn;
    	String currentState = loggedIn?LOGGED_IN:LOGGED_OUT;
        fireSourceChanged(ISources.WORKBENCH, SESSION_STATE, currentState);
    }

    public void setUserId ( String userId ) {
    	SessionSourceProvider.USERID = userId;
    }

    public String getUserId () {
    	return SessionSourceProvider.USERID;
    }
    
	@Override
	public void dispose() {
	}

	@Override
	public Map<String, String> getCurrentState() {
		Map<String, String> currentState = new HashMap<String, String>(1);
        String currentState2 =  loggedIn?LOGGED_IN:LOGGED_OUT;
        currentState.put(SESSION_STATE, currentState2);
        return currentState;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[] {SESSION_STATE};
	}

}
