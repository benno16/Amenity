package com.amenity.dbserver;

import java.io.IOException;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl.AclFormatException;

public class LocalDB {

	private org.hsqldb.server.Server server;
	
	public boolean start () {
		String rootDir = System.getenv("userprofile");
		rootDir = rootDir.replace('\\', '/');
		/**
		 * TODO
		 * change back to real db location
		 */
		// production
//		rootDir = "file:" + rootDir + "/temp/database/amenity;sql.enforce_strict_size=true";
		// Conti internal
		rootDir = "file:" + rootDir + "/git/Amenity/com.amenity.workbench/database/amenity;sql.enforce_strict_size=true";
		// Ben home
//		rootDir = "file:" + rootDir + "/Desktop/Arbeit/__Bachelor/amenity/git/Amenity/com.amenity.workbench/database/amenity;sql.enforce_strict_size=true";
		
		
		HsqlProperties p = new HsqlProperties();
		p.setProperty("server.database.0", rootDir);
		p.setProperty("server.dbname.0", "amenity");
		
		server = new org.hsqldb.server.Server();;
		
		try {
			server.setProperties(p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AclFormatException e) {
			e.printStackTrace();
		}
		server.start();
		if ( server.getState() > 0 )
			return true;
		else {
			return false;
		}
	}
	
	public void stop() {
		if ( server.getState() > 0 )
			server.stop();
	}
	
}
