package com.rt.control;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that handles script execution
 * 
 * @author Karavasilis Giannis
 *
 */
public final class ScriptExecutor {
	
	/** Class Logger */
	private static final Logger LOGGER = Logger.getLogger(ScriptExecutor.class.getName());
	
	/** Private Constructor */
	private ScriptExecutor(){}
	
	
	/**
	 * Execute batchfile
	 * @param pathToFile path to batch file
	 * @param filename name of the file
	 */
	public static void executeCommand(String pathToFile, String filename) {
		
		if ( CmdUtils.pathNotExists(pathToFile) ) {
			LOGGER.severe("File path error: path not exists");
		}
		
		if ( CmdUtils.pathIsNull(pathToFile) ) {
			LOGGER.severe("File path error: path is null");
		}
		
		try {
			String fullFilePath = pathToFile + filename;
			
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(fullFilePath);
			
			proc.waitFor();
			
			CmdUtils.printFileCommands( proc );
			
		} catch (Exception ex) {
			LOGGER.severe("Something went wrong while executing script...");
			LOGGER.log(Level.SEVERE, ex.toString());
		}
	}
}
