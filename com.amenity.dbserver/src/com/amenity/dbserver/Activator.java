package com.amenity.dbserver;

import java.io.IOException;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl.AclFormatException;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private org.hsqldb.server.Server server;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		String rootDir = System.getenv("userprofile").replace('\\', '/');
		/**
		 * TODO change back to real db location
		 */
		
		// production
		rootDir = rootDir + "/temp/database";
//		Conti internal D:/uidu1448/Amenity\Amenity\com.amenity.workbench
//		rootDir = "d:/uidu1448/Amenity/Amenity/com.amenity.workbench/database";
		// Ben home
		// C:\Users\Ben\Desktop\Arbeit\__Bachelor\amenity\New\Amenity\com.amenity.workbench\database
//		rootDir = rootDir + "/Desktop/Arbeit/__Bachelor/amenity/New/Amenity/com.amenity.workbench/database";
		
		/*
		 * Now check if root directory exists. If not CREATE! 
		 * This ensures the DB is created on first use
		 */
		java.io.File dbFolder = new java.io.File ( rootDir );
		if ( !dbFolder.exists() ) {
			dbFolder.mkdir();
		}
		
		/*
		 *  Adding DB specific folder settings
		 *  Maybe put into properties file 
		 */
		rootDir = "file:" + rootDir + "/amenity;hsqldb.default_table_type=cached;sql.enforce_strict_size=true";
		
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

	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		
		if ( server.getState() > 0 )
			server.shutdown();
		
	}

}
