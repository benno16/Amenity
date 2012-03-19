package com.amenity.engine.helper.synergy;

import general.File;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.eclipse.core.runtime.Platform;

public class SynergyGetFile {

//	private String ccmEXEFolder = "M:\\pmtqtools\\Synergy71\\Synergy_client7103\\bin\\ccm";
	private String sessionID;

	private String ccmEXEFolder = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYCCM_EXE" , "M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin\\ccm.exe" , null );
	
	private String ccmHomeFolder = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYCCM_DIR" , "M:\\pmtqtools\\Synergy71\\Synergy_client7105" , null );
	
	private String ccmIniFile = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYINI_FILE" , System.getenv("userprofile").replace('\\', '/') + "\\ccm71.ini" , null );
	
	
	@SuppressWarnings("unused")
	private SynergyGetFile () {
	}
	
	public SynergyGetFile ( String sessionID ) {
		
		this.sessionID = sessionID;
//		openFile(file1);
	}

	public SynergyGetFile ( String sessionID, File file1, 
			File file2) throws IOException {
		
		this.sessionID = sessionID;
		
//		compareFile(file1, file2);
		
	}

	public void openFile(File file) {

		ProcessBuilder pb = new ProcessBuilder ("cmd", "/c", 
				ccmEXEFolder,
				"view",
				file.getObjectName() );
//		String query = "cmd /C M:\\pmtqtools\\Synergy71\\Synergy_client7103\\bin\\ccm edit " + file.getObjectName();
//		System.out.println("openening " + query );
//		ProcessBuilder pb = new ProcessBuilder(query);

		Map<String, String> env = pb.environment();

		env.put("CCM_HOME", ccmHomeFolder);
		env.put("CCM_INI_FILE", ccmIniFile);
		env.put("CCM_ADDR", sessionID);
//		env.put("CCM_HOME", ccmHomeFolder);
//		env.put("CCM_ADDR", sessionID);
//		env.put("PATH","D:/ts_mirr/etoolset/cw70d;M:/pmtqtools/Synergy71/Synergy_client7103/bin;M:/pmtqtools/Synergy71/Synergy_client7103/bin/util;M:/pmtqtools/ccmscripts1015;M:/pmtqtools/ccmscripts1015/perl/bin;M:/pmtqtools/ccmscripts1015/cygwin/bin;C:/Program Files/Microsoft Office/Office;M:/pmtqtools/ts_ref/STM_RiMC/STMTS/v8.5;%PATH%");
//		env.put("TS_LOCAL","d:/ts_mirr");
//		env.put("TS_CTL","M:/pmtqtools/ts_ref/comptab");
//		env.put("CWL","d:/ts_mirr/etoolset/cw70d");
//		env.put("SHELL","d:/ts_mirr/etoolset/cyg132d/bin");
//		env.put("GHS_LMHOST","@ls_rb_ghs_rb_1.conti.de");
//		env.put("GHS_LMWHICH","ghs");
//		env.put("CWINI","%USERPROFILE%/cwright.ini");
//		env.put("CWPST","%USERPROFILE%/cwright.pst");
//		env.put("CCM_INI_FILE", ccmIniFile);
		
		Process pr;
		try {
			pr = pb.start();
//			pr.waitFor();
//			sessionID = new BufferedReader(new InputStreamReader(pr.getInputStream())).readLine();
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String resultset = null;
			
			while (( resultset = br.readLine()) != null ){
				System.out.println("> " + resultset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void compareFile(File file1, File file2) {

	}
	
}
