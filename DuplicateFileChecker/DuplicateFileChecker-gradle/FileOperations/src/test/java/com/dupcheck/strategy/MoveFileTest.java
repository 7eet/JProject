package com.dupcheck.strategy;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class MoveFileTest{
	
	private static File desktop  = new File(System.getProperty("user.home")+"/Desktop");

	private static List<File> listWithZeroSize = null;
	private static List<File> listWithFourFiles = null;
	private static List<File> listWithThreeDir = null;
	private MoveFileStrategy mvFile = null;

	@BeforeEach
	public void initConstructorWithValidPath(){
			mvFile = new MoveFileStrategy(Paths.get(desktop+"/T"));
	}
	
	@BeforeAll
	public static void initList(){
		listWithZeroSize = new ArrayList<>();
		listWithFourFiles = new ArrayList<>();
		listWithThreeDir = new ArrayList<>();
	}
	
	@BeforeAll
	public static void addElementsToDirList(){
		listWithThreeDir.add(new File(desktop,"/T/empt"));                      // empty dir
		listWithThreeDir.add(new File(desktop,"/T"));		// non empty dir
		listWithThreeDir.add(new File(desktop,"/dum/dir"));			// non exist dir
	}

	@BeforeAll
	public static void addElementsToFileList(){
		
		// 2 and 4 files are nonexist file.
		// rest two are exist.
		
		listWithFourFiles.add(new File(desktop,"/T/Sample.java"));
		listWithFourFiles.add(new File(desktop,"nofile.txt"));
		listWithFourFiles.add(new File(desktop,"/T/otherFile.txt"));
		listWithFourFiles.add(new File(desktop,"/f/y.txt"));
	}
	
	@Test
	public void passingNullToConstructor(){
		MoveFileStrategy mv = new MoveFileStrategy(null);
		assertDoesNotThrow( ()->{mv.execute(null);});
	}
	
	@Test
	public void passingFileToConstructor(){
		MoveFileStrategy mv = new MoveFileStrategy(Paths.get(desktop+"/T/otherFile"));
		assertDoesNotThrow( ()->{mv.execute(null);});
	}
	

	@Test
	public void testForSizeZero(){
			assertDoesNotThrow(()->{mvFile.execute(listWithZeroSize);});
	}
	
	@Test
	public void testWithListOfDir(){
		assertDoesNotThrow(()->{mvFile.execute(listWithThreeDir);});
	}
	
	@Test
	public void testWithListOfFiles(){
		assertDoesNotThrow(()->{mvFile.execute(listWithFourFiles);});
	}
	

	
}

