package com.amenity.workbench;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.amenity.engine.helper.synergy.SynergyLogin;

import dao.DaoFactory;
import dao.GeneralQueries;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.amenity.workbench"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		SessionSourceProvider.LOG4J_PROPERTIES = new Properties(); 
		URL url = this.getBundle().getResource("log4j.properties"); 
		System.err.println(url);
		SessionSourceProvider.LOG4J_PROPERTIES.load(url.openStream()); 
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES); 
		
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		closeDBServer();
		clearTempFolder();
		plugin = null;
		super.stop(context);
	}

	private void closeDBServer() {
		GeneralQueries generalQueries = DaoFactory.eINSTANCE.createGeneralQueries();
		generalQueries.shutdownDB();
		if ( SessionSourceProvider.SYNERGY_SID != null )
			new SynergyLogin().closeSynergySession(SessionSourceProvider.SYNERGY_SID);
		
	}

	private void clearTempFolder() {
		try {
			String amo = "cmd /C del /Q /F \"D:\\temp\\amenity\\*.*\"";
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(amo);
			try {
				System.out.println("--deleteing");
				p.waitFor();
				System.out.println("--finished deleteing");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
