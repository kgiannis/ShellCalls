package com.rt.control;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Call batch files from command line 
 * 
 * Run this class from CMD
 * Path: C:\Users\<USERNAME>\workspace\ShellCalls\target\classes
 * Command: java com.rt.control.RunScriptFile <argument> 
 * Command: java com.rt.control.RunScriptFile C:/Users/<USERNAME>/Desktop/<BATCH_FILE_NAME.bat>
 * 
 * @author Karavasilis Giannis
 *
 */
public final class RunScriptFile {
	
	/** Class Logger */
	private static final Logger LOGGER = Logger.getLogger(RunScriptFile.class.getName());
	
	/** Full path containing filename */
	static String pathWithFilename;
	
	/** Private Constructor */
	private RunScriptFile(){}

	
	
	public static void main(String[] args) {
		LOGGER.log(Level.INFO, "Class loaded successfully");
		
		if ( !CmdUtils.filenameArgumentPassed( args ) ) {
			LOGGER.severe("Wrong arguments. Please pass filename as argument");
			return;
		}
		
		if ( CmdUtils.pathNotExists( args[0] ) ) {
			LOGGER.severe("Path error. Path not exists");
			return;
		}
		
		if ( CmdUtils.pathFormatIsWrong( args[0] ) ) {
			LOGGER.severe("Wrong arguments. Please pass filename as argument");
			return;
		}
		
		pathWithFilename = args[0];
		
		String path = CmdUtils.getPath(pathWithFilename);
		String filename = CmdUtils.getFilename(pathWithFilename);
		
		ScriptExecutor.executeCommand(path, filename);
		
	}

}
