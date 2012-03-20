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
		
		Map<String, String> env = pb.environment();

		env.put("CCM_HOME", ccmHomeFolder);
		env.put("CCM_INI_FILE", ccmIniFile);
		env.put("CCM_ADDR", sessionID);
		
		Process pr;
		try {
			pr = pb.start();
			pr.waitFor();

			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String resultset = null;
			
			while (( resultset = br.readLine()) != null ){
				
				System.out.println("> " + resultset);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unused")
	private void compareFile(File file1, File file2) {
	}
	
}
