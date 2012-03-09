package com.amenity.engine.helper.synergy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SynergyLogin {

	private String ccmEXEFolder = "M:\\pmtqtools\\Synergy71\\Synergy_client7103\\bin\\ccm";
	private String ccmHomeFolder = "M:\\pmtqtools\\Synergy71\\Synergy_client7103";
	private String sessionID;
	
	public  SynergyLogin() {
	}
	
	public void closeSynergySession( String sessionID) {
		this.sessionID = sessionID;
		try {
			long start = System.currentTimeMillis();

			ProcessBuilder pb = new ProcessBuilder("cmd",  "/c", 
					ccmEXEFolder,
					"quit");
			
			Map<String, String> env = pb.environment();
			
			env.put("CCM_ADDR", sessionID);

			Process pr = pb.start();
			pr.waitFor();
			
			long end = System.currentTimeMillis();
			System.out.println("Session Close Time: "+(end-start)/1000+" s.");
			
		} catch (Exception ex ){
			System.out.println(ex.getMessage());
		}
	}

	public String getSynergySessionId() {
		sessionID = null;
		long start = System.currentTimeMillis();
		ProcessBuilder pb = new ProcessBuilder ( "cmd", 
				"/c" , 
				ccmEXEFolder,
				"start", "-q", "-m", "-nogui", 
				"-f", 
				"\"%userprofile%\\ccm71.ini\""
				);
		Map<String, String> env = pb.environment();
		
//		env.put("CCM_HOME", ccmHomeFolder);
//		env.put("CCM_INI_FILE", "%USERPROFILE%\\ccm71.ini");
//		env.put("PATH", "D:\\ts_mirr\\etoolset\\cw70d;" +
//				"M:\\pmtqtools\\Synergy71\\Synergy_client7103\\bin;" +
//				"M:\\pmtqtools\\Synergy71\\Synergy_client7103\\bin\\util;" +
//				"M:\\pmtqtools\\ccmscripts1015;" +
//				"M:\\pmtqtools\\ccmscripts1015\\perl\\bin;" +
//				"M:\\pmtqtools\\ccmscripts1015\\cygwin\\bin;" +
//				"C:\\Program Files\\Microsoft Office\\Office;" +
//				"M:\\pmtqtools\\ts_ref\\STM_RiMC\\STMTS\\v8.5;%PATH%");
		env.put("CCM_HOME","M:/pmtqtools/Synergy71/Synergy_client7103");
		env.put("PATH","D:/ts_mirr/etoolset/cw70d;M:/pmtqtools/Synergy71/Synergy_client7103/bin;M:/pmtqtools/Synergy71/Synergy_client7103/bin/util;M:/pmtqtools/ccmscripts1015;M:/pmtqtools/ccmscripts1015/perl/bin;M:/pmtqtools/ccmscripts1015/cygwin/bin;C:/Program Files/Microsoft Office/Office;M:/pmtqtools/ts_ref/STM_RiMC/STMTS/v8.5;%PATH%");
		env.put("TS_LOCAL","d:/ts_mirr");
		env.put("TS_CTL","M:/pmtqtools/ts_ref/comptab");
		env.put("CWL","d:/ts_mirr/etoolset/cw70d");
		env.put("SHELL","d:/ts_mirr/etoolset/cyg132d/bin");
		env.put("GHS_LMHOST","@ls_rb_ghs_rb_1.conti.de");
		env.put("GHS_LMWHICH","ghs");
		env.put("CWINI","%USERPROFILE%/cwright.ini");
		env.put("CWPST","%USERPROFILE%/cwright.pst");
		env.put("CCM_INI_FILE","%USERPROFILE%/ccm71.ini");
		
		Process pr;
		try {
			pr = pb.start();
			pr.waitFor();
			sessionID = new BufferedReader(new InputStreamReader(pr.getInputStream())).readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end1 = System.currentTimeMillis();
		
		System.out.println("Session start time was "+ 
				(end1-start)/1000+" s.");
		
		return sessionID;
	}
	public List<String> getRawProjectList( String sessionID ) {
		this.sessionID = sessionID;
		List<String> projectList = new ArrayList<String>();
		ProcessBuilder pb = new ProcessBuilder ("cmd", "/c", 
				ccmEXEFolder,
				"show",
				"-p",
				"-f",
				"\"%displayname\""
				);

		Map<String, String> env = pb.environment();

		env.put("CCM_HOME", ccmHomeFolder);
		env.put("CCM_INI_FILE", "%USERPROFILE%\\ccm71.ini");
		env.put("CCM_ADDR", sessionID);
		
		Process pr;
		try {
			pr = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String resultset = null;
			
			while (( resultset = br.readLine()) != null ){
				int index = resultset.indexOf(")");
				if ( index > 1 ){
					projectList.add(resultset.substring(index + 1).trim());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return projectList;
	}
}
