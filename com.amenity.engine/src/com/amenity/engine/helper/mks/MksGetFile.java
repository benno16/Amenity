package com.amenity.engine.helper.mks;

import general.Connection;
import general.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mks.api.CmdRunner;
import com.mks.api.Command;
import com.mks.api.IntegrationPoint;
import com.mks.api.IntegrationPointFactory;
import com.mks.api.Option;
import com.mks.api.Session;
import com.mks.api.response.APIException;
import com.mks.api.response.Response;
import com.mks.api.response.WorkItem;
import com.mks.api.response.WorkItemIterator;
import com.mks.api.util.ResponseUtil;

public class MksGetFile {

	private Connection connection;
	private int port = 7001;
	private boolean isSandbox = false;
	private Session mySession = null;
	private File file = null;
	
	public MksGetFile () {
	}
	
	public MksGetFile ( Connection connection, File file ) {
		this.connection = connection;
		this.file = file;
	}
	
	@SuppressWarnings("deprecation")
	public String openFile() {
		
		Runtime r = Runtime.getRuntime();
		String test = "cmd /C si viewrevision -P " + connection.getProject() +
				"  --revision=" + file.getVersion() + " " +
				file.getName() + " > \"D:/temp/" + file.getName() + "\"";
		System.out.println(test);
		try {
			Process p = r.exec(test);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		
//		try {
//			IntegrationPointFactory ipf = IntegrationPointFactory.getInstance();
//			IntegrationPoint ip = ipf.createIntegrationPoint(connection.getDatabase(), port);
//			
//			mySession = ip.createSession(connection.getUsername(),connection.getPassword());
//			
//			CmdRunner myCmdRunner = mySession.createCmdRunner();
//			
//			myCmdRunner.setDefaultHostname(connection.getDatabase());
//			myCmdRunner.setDefaultPort(port);
//			myCmdRunner.setDefaultUsername(connection.getUsername());
//			myCmdRunner.setDefaultPassword(connection.getPassword());
//			
//			Command myCmd = new Command ( Command.SI , "viewrevision");
//			myCmd.addOption( new Option( "-P" , connection.getProject() ) );
//			myCmd.addOption( new Option( "revision" , file.getVersion() ) );
//			myCmd.addSelection(file.getName());
////			myCmd.addOption( new Option( " " + file.getName() ) );
//			myCmd.addOption( new Option( " > d:/temp/output.txt" ) );
//			
////			Response myResponse = 
//					myCmdRunner.execute(myCmd);
////			WorkItemIterator wii = myResponse.getWorkItems();
////			
////			while ( wii.hasNext() ) {
////				WorkItem wi = wii.next();
////				wi.getDisplayId();
////			}
//		} catch (APIException ae) {
//	        System.out.println("--[ Exception ]---------------------------");
//	        ResponseUtil.printAPIException(ae, 1, System.out);
//	        System.out.println("--[ Response In Which It Occured ]--------");
//	        ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
//	    } finally {
//	        try {
//	            if(mySession!=null){
//	                mySession.release();
//	            }
//	        } catch (APIException ae){
//	            System.out.println("--[ Exception ]---------------------------");
//	            ResponseUtil.printAPIException(ae, 1, System.out);
//	            System.out.println("--[ Response In Which It Occured ]--------");
//	            ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
//	        } catch (IOException ioe) {
//	            System.out.println(ioe.getMessage());
//	        }
//	    }
		
		return "d:/temp/output.txt";
	}
}
