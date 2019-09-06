package com.dupcheck.strategy;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ReportFileTest{
	private ReportFileStrategy reportFile = null;
	private static List<File> sizeZero = null;
	private static List<File> listOfFiles = null;
	private static List<File> listOfDir = null;
	private static File desktop  = new File(System.getProperty("user.home")+"/Desktop");
	
	@BeforeAll
	public static void initListWithFiles(){
		sizeZero = new ArrayList<>();
		listOfFiles = new ArrayList<>();
		listOfFiles.add(new File(desktop,"/T/Tp.java"));     // file exist
		listOfFiles.add(new File(desktop,"/j/t2.txt"));                                       // file doesn't exist
		listOfFiles.add(new File(desktop,"/T/Tp.1java"));					//file exist
		listOfFiles.add(new File(desktop,"/dir/t.txt"));					// file doesn't exist
	}
	
	@BeforeAll
	public static void initListWithDir(){
		listOfDir = new ArrayList<>();
		listOfDir.add(new File(desktop,"/testDup/"));     // file exist
		listOfDir.add(new File(desktop,"/j/"));                                       // file doesn't exist
		listOfDir.add(new File(desktop,"/T"));					//file exist
		listOfDir.add(new File(desktop,"/dir"));					// file doesn't exist
	}
	
	@BeforeEach
	public void initObject(){
		reportFile = new ReportFileStrategy();
	}
	
	@Test
	public void testForNull(){
		assertThrows(NullPointerException.class,()->{
				reportFile.execute(null);
		});
	}
	
	@Test
	public void forListSizeZero(){
		assertDoesNotThrow(()->{
			reportFile.execute(sizeZero);
		});
	}
	
	@Test
	public void listWithFiles(){
		assertDoesNotThrow( ()->{
			reportFile.execute(listOfFiles);
		});
	}

	@Test
	public void listWithDir(){
		assertDoesNotThrow( ()->{
			reportFile.execute(listOfDir);
		});
	}
}
