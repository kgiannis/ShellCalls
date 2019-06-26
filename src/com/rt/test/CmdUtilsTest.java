package com.rt.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rt.control.CmdUtils;

/**
 * 
 * @author Karavasilis Giannis
 *
 */
public class CmdUtilsTest {
	
	
	/**
	 * filenameArgumentPassed
	 */
	
	@Test
	public void filenameArgumentPassed_correct_UNIX(){
		String[] correctPath = {"C:/Path/"};
		assertTrue( CmdUtils.filenameArgumentPassed(correctPath) );
	}
	
	@Test
	public void filenameArgumentPassed_correct_WIN(){
		String[] correctPath = {"C:\\Path\\"};
		assertTrue( CmdUtils.filenameArgumentPassed(correctPath) );
	}
	
	@Test
	public void filenameArgumentPassed_error(){
		String[] wrongPath = new String[0];
		assertFalse( CmdUtils.filenameArgumentPassed(wrongPath) );
	}
	
	
	/**
	 * pathIsNull
	 */
	
	@Test
	public void pathIsNull_correct(){
		String path = null;
		assertTrue( CmdUtils.pathIsNull(path) );
	}
	
	@Test
	public void pathIsNull_error(){
		String path = "C:/Path/";
		assertFalse( CmdUtils.pathIsNull(path) );
	}
	
	
	/**
	 * pathNotExists
	 */
	
	@Test
	public void pathNotExists_correct(){
		String path = "C:/Path/";
		assertTrue( CmdUtils.pathNotExists(path) );
	}
	
	@Test
	public void pathNotExists_error(){
		String path = "C:/Users/ykarav/Desktop/";
		assertFalse( CmdUtils.pathNotExists(path) );
	}
	
	
	/**
	 * pathFormatIsWrong
	 */

	@Test
	public void pathFormatIsWrong_correct(){
		String path = "somePath";
		assertTrue( CmdUtils.pathFormatIsWrong(path) );
	}
	
	@Test
	public void pathFormatIsWrong_error(){
		String path = "C:/Path/";
		assertFalse( CmdUtils.pathFormatIsWrong(path) );
	}
	
	
	/**
	 * convertToUnixSlashes
	 */
	
	@Test
	public void convertToUnixSlashes_correct(){
		String pathWindows = "C:\\somepath\\";
		String pathUnix = "C:/somepath/";
		assertEquals( pathUnix, CmdUtils.convertToUnixSlashes(pathWindows) );
	}
	
	@Test
	public void convertToUnixSlashes_error(){
		String pathWindows = "C:\\somepath\\";
		String pathUnix = "C:\\somepath\\";
		assertNotEquals( pathUnix, CmdUtils.convertToUnixSlashes(pathWindows) );
	}
	
	
	/**
	 * getPath
	 */
	
	@Test
	public void getPath_correct(){
		String fullPath = "C:/Users/ykarav/Desktop/giannis.bat";
		String folderPath = "C:/Users/ykarav/Desktop/";
		assertEquals( folderPath, CmdUtils.getPath(fullPath) );
	}
	
	@Test
	public void getPath_error(){
		String fullPath = "C:/Users/ykarav/Desktop/giannis.bat";
		String folderPath = "C:/Users/ykarav/";
		assertNotEquals( folderPath, CmdUtils.getPath(fullPath) );
	}
	
	
	/**
	 * getFilename
	 */
	
	@Test
	public void getFilename_correct(){
		String fullPath = "C:/Users/ykarav/Desktop/giannis.bat";
		String fileName = "giannis.bat";
		assertEquals( fileName, CmdUtils.getFilename(fullPath) );
	}
	
	@Test
	public void getFilename_error(){
		String fullPath = "C:/Users/ykarav/Desktop/giannis.bat";
		String fileName = "wrongName.bat";
		assertNotEquals( fileName, CmdUtils.getFilename(fullPath) );
	}
}
