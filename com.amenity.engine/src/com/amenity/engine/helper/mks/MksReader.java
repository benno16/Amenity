package com.amenity.engine.helper.mks;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import general.Connection;
import general.File;
import general.Folder;
import general.GeneralFactory;
import general.Snapshot;

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

import dao.DaoFactory;
import dao.FolderDao;
import dao.FileDao;

public class MksReader {

	private int port = 7001;
	private Session mySession = null;
	private Snapshot snapshot;
	private Connection connection;
	private List<Folder> folders;
	private FolderDao folderDao;
	private FileDao fileDao;
	
	public MksReader () {
	}
	
	public MksReader ( Connection connection, Snapshot snapshot ) {
		this.connection = connection;
		this.snapshot = snapshot;
		folders = new ArrayList<Folder>();
		Folder root = GeneralFactory.eINSTANCE.createFolder();
		root.setLevel(0);
		root.setName(connection.getProject());
		folders.add(root);
	}
	
	@SuppressWarnings("deprecation")
	public boolean getProjectFiles() {
		boolean noError = true;
		try {
			IntegrationPointFactory ipf = IntegrationPointFactory.getInstance();
			IntegrationPoint ip = ipf.createIntegrationPoint(connection.getDatabase(), port);
			
			mySession = ip.createSession("uidu1448","\"Wsx3edc");
			
			CmdRunner myCmdRunner = mySession.createCmdRunner();
			
			myCmdRunner.setDefaultHostname(connection.getDatabase());
			myCmdRunner.setDefaultPort(port);
			myCmdRunner.setDefaultUsername(connection.getUsername());
			myCmdRunner.setDefaultPassword(connection.getPassword());
			
			Command myCmd = new Command ( Command.SI , "viewproject");
			myCmd.addOption(new Option ( "-R"));	// recursive
			myCmd.addOption(new Option ( "-Y"));	// say always yes
			myCmd.addOption(new Option("project",connection.getProject()));
			myCmd.addOption(new Option("fields=name,memberrev,membertimestamp,labels,state,type,attributes"));
			
			Response myResponse = myCmdRunner.execute(myCmd);
			WorkItemIterator wii = myResponse.getWorkItems();
			
			folderDao = DaoFactory.eINSTANCE.createFolderDao();
			fileDao = DaoFactory.eINSTANCE.createFileDao();
			
			while ( wii.hasNext() ) {
				WorkItem wi = wii.next();
				generateContentObject(wi);
				
			}
			
			
		} catch (APIException ae) {
	        System.out.println("--[ Exception ]---------------------------");
	        ResponseUtil.printAPIException(ae, 1, System.out);
	        System.out.println("--[ Response In Which It Occured ]--------");
	        ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
	        noError = false;
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
	            noError = false;
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    }
		
		return noError;
	}

	public boolean getSandboxFiles() {
		
		
		return false;
	}
	
	public void generateContentObject( WorkItem wi ) {
		
		String idOut = "";
		String stateOut = "";
		String nameOut = "";
		String memberrevOut = "";
		String labelsOut = "";
		String membertimestampOut = "";
		String typeOut = "";
		String parentOut ="";

		if ( true ) {
			idOut =wi.getId();
		}
		if ( wi.contains("parent") ) {
			parentOut = wi.getField("parent").getValue().toString();
		}
		if ( wi.contains("type") ) {
			typeOut = wi.getField("type").getValue().toString();
		}
		if ( wi.contains("state") ) {
			stateOut = wi.getField("state").getValue().toString();
		}
		if ( wi.contains("name") ) {
			nameOut = wi.getField("name").getValue().toString();
		}
		if ( wi.contains("memberrev") ) {
			memberrevOut = wi.getField("memberrev").getItem().getId();
		}
		if ( wi.contains("labels") ) {
			for ( int i = 0 ; i < wi.getField("labels").getList().size() ; i++ ) {
				labelsOut = labelsOut + wi.getField("labels").getList().get(i).toString();
			}
		}
		if ( wi.contains("membertimestamp") ) {
			membertimestampOut = wi.getField("membertimestamp").getValueAsString();
		}
		
		if ( typeOut.contains("project ") ) {
			// its a folder! 
			Folder folder = GeneralFactory.eINSTANCE.createFolder();
			folder.setName(nameOut);
			folder.setPartOf(snapshot);
			folder.setRelease(memberrevOut);
			Folder root = GeneralFactory.eINSTANCE.createFolder();
			root = getParentFolder(parentOut);
			folder.setRootDirectory(root);
			folder.setLevel(root.getLevel() + 1 );
			folder.setVersion(labelsOut);
			folder.setModfiedDate(getFileDate(membertimestampOut));
			folders.add(folder);
			folderDao.create(folder);
			folder = null;
		} else {
			// its a file!
			File file = GeneralFactory.eINSTANCE.createFile();
			file.setCreationDate(getFileDate(membertimestampOut));
			Folder root = GeneralFactory.eINSTANCE.createFolder();
			root = getParentFolder(parentOut);
			file.setRootDir(root);
			file.setLevel(root.getLevel() + 1);
			file.setModfiedDate(getFileDate(membertimestampOut));
			file.setName(idOut);
			file.setObjectName(nameOut);
			file.setRelease(memberrevOut);
			file.setStatus(stateOut);
			file.setVersion(labelsOut);
			fileDao.create(file);
			root.getChildren().add(file);
			folderDao.update(root);
			file = null;
		}
	}
	
	private Folder getParentFolder ( String parent ) {
		for ( Folder f : folders ) {
			if ( f.getName().equals(parent) ) {
				return f;
			}
		}
		return null;
	}
	
	private Date getFileDate ( String date ) {
		/**
		 * TODO
		 * Do that string conversion shit. Code OK. Test to be done! 
		 */
		Date returnDate = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		
		try {
			returnDate = df.parse(date);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println( "return: " + df.format(returnDate));
		
		return returnDate;
	}
	
}
