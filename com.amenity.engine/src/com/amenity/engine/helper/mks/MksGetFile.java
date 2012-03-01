package com.amenity.engine.helper.mks;

import general.Connection;
import general.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mks.api.CmdRunner;
import com.mks.api.Command;
import com.mks.api.IntegrationPoint;
import com.mks.api.IntegrationPointFactory;
import com.mks.api.Option;
import com.mks.api.Session;
import com.mks.api.response.APIException;
import com.mks.api.si.SIModelTypeName;
import com.mks.api.util.ResponseUtil;

public class MksGetFile {

	private Connection connection;
	private int port = 7001;
	private boolean isSandbox = false;
	private Session mySession = null;
	private File file = null;
	private String fileName;
	private String amenityTempFolder = "D:\\temp\\amenity\\";
	
	public MksGetFile () {
	}
	
	public MksGetFile ( Connection connection, File file ) {
		this.connection = connection;
		this.file = file;
	}
	
	public String openFile() throws IOException {
		
//		String amenityTempFolder = "D:\\temp\\amenity\\";
//		java.io.File f = new java.io.File(amenityTempFolder);
//		
//		Runtime r = Runtime.getRuntime();
//		Process p;
//		if ( !f.isDirectory() ) {
//			String amo = "cmd /C mkdir " + amenityTempFolder;
//			System.err.println(amo);
//			p = r.exec(amo);
//		}
//		
//		String filename = amenityTempFolder + UUID.randomUUID().toString() + "_" + file.getName();
//		String fetchFileAmo = "cmd /C si viewrevision -P " + 
//				file.getFullName().replace(file.getName(), "project.pj") +
//				"  --revision=" + file.getVersion() + " \"" +
//				file.getName() + "\"" + " > \"" + filename + "\"";
//		String openFileAmo = "cmd /C \"" + filename + "\"";
//		try {
//			p = r.exec(fetchFileAmo);
//			try {
//				System.out.println("--starting waiting");
//				p.waitFor();
//				Thread.sleep(100);
//				System.out.println("--finished waiting");
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			p = r.exec(openFileAmo);
////			p = r.exec(filename);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		
		try {
			IntegrationPointFactory ipf = IntegrationPointFactory.getInstance();
			IntegrationPoint ip = ipf.createIntegrationPoint(connection.getDatabase(), 
					port, false , 4 , 10);
			
			mySession = ip.createSession(connection.getUsername(),connection.getPassword());
			
			CmdRunner myCmdRunner = mySession.createCmdRunner();
			myCmdRunner.setDefaultHostname(connection.getDatabase());
			myCmdRunner.setDefaultPort(port);
			myCmdRunner.setDefaultUsername(connection.getUsername());
			myCmdRunner.setDefaultPassword(connection.getPassword());

			java.io.File f = new java.io.File(amenityTempFolder);
			
			if ( !f.isDirectory() ) {
				String amo = "cmd /C mkdir " + amenityTempFolder;
				Runtime.getRuntime().exec(amo);
			}
			
			fileName = "remote://" + amenityTempFolder + 
					UUID.randomUUID().toString() + "_" +file.getName();
			
			Command myCmd = new Command ( Command.SI , "projectco");
			myCmd.addOption( new Option( "project" , connection.getProject() ) );
			myCmd.addOption( new Option( "targetfile", fileName ) );
			myCmd.addOption( new Option( "cpid", ":none" ) );
			myCmd.addOption( new Option( "nolock" ) );
			myCmd.addSelection(file.getName());
			myCmdRunner.execute(myCmd);
			
			
		} catch (APIException ae) {
	        System.out.println("--[ Exception ]---------------------------");
	        ResponseUtil.printAPIException(ae, 1, System.out);
	        System.out.println("--[ Response In Which It Occured ]--------");
	        ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
	    } finally {
	        try {
	            if(mySession!=null){
	                mySession.release();
	            }
	        } catch (APIException ae){
	            System.out.println("--[ Exception ]---------------------------");
	            ResponseUtil.printAPIException(ae, 1, System.out);
	            System.out.println("--[ Response In Which It Occured ]--------");
	            ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    }
		openLocalFile();
		return fileName;
	}
	
	private void openLocalFile() {
		// strip of remote://
		String openFileAmo = "cmd /C \"" + fileName.substring(9) + "\"";
		try {
			Runtime.getRuntime().exec(openFileAmo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
