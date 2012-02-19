package com.amenity.dbserver;

import java.io.IOException;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl.AclFormatException;

public class LocalDB {

	private org.hsqldb.server.Server server;
	
	public boolean start () {
		String rootDir = System.getenv("userprofile");
		rootDir = rootDir.replace('\\', '/');
		rootDir = "file:" + rootDir + "/temp/database/amenity;sql.enforce_strict_size=true";
		
		HsqlProperties p = new HsqlProperties();
		p.setProperty("server.database.0", rootDir);
		p.setProperty("server.dbname.0", "amenity");
		
		server = new org.hsqldb.server.Server();;
		
		try {
			server.setProperties(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AclFormatException e) {
			// TODO Auto-generated catch block
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
