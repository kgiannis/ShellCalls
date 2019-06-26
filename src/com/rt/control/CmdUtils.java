package com.rt.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Helper class for command line arguments
 * 
 * @author Karavasilis Giannis
 *
 */
public final class CmdUtils {
	
	
	/** Class Logger */
	private static final Logger LOGGER = Logger.getLogger(CmdUtils.class.getName());
	
	/** Private Constructor */
	private CmdUtils(){}
	
	
	public static boolean filenameArgumentPassed(String[] args){
		return args.length > 0 ? true : false;
	}
	
	public static boolean pathIsNull( String pathToFile ){
		return pathToFile == null ? true : false;
	}
	
	public static boolean pathNotExists( String pathToFile ){
		File path = new File( pathToFile );
		return !path.exists() ? true : false;
	}
	
	public static boolean pathFormatIsWrong( String pathWithFilename ){
		return !pathWithFilename.contains("/") ? true : false;
	}
	
	public static String convertToUnixSlashes( String pathWithFilename ){
		String replacedString;
		replacedString = pathWithFilename.replace("\\", "/");
		return replacedString;
	}
	
	public static String getPath( String pathWithFilename ){
		int lastSlashPosition = pathWithFilename.lastIndexOf('/');
		return pathWithFilename.substring(0, lastSlashPosition+1);
	}
	
	public static String getFilename( String pathWithFilename ){
		int lastSlashPosition = pathWithFilename.lastIndexOf('/');
		return pathWithFilename.substring(lastSlashPosition+1, pathWithFilename.length());
	}
	
	public static void printFileCommands( Process proc ){
		StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = "";                       
        try {
			while ((line = reader.readLine())!= null) {
			        output.append(line + "\n");
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error while reading file contents");
			LOGGER.severe(e.getMessage());
			
		}
        LOGGER.info("[--- File Contents ---]" + output);
	}
	

}
