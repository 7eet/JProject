package com.dupcheck.strategy;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CSVFileTest{
/*	private CSVFileStrategy reportFile = null;
	private static List<File> sizeZero = null;
	private static List<File> listOfFiles = null;
	private static List<File> listOfDir = null;
	private static File dir  = new File(System.getProperty("user.dir")+"/../test-class-dir/dirStrat/");
	
	@BeforeAll
	public static void initListFile(){
		sizeZero = new ArrayList<>();
		listOfFiles = new ArrayList<>();
		listOfFiles.add(new File(dir,"/first.txt"));     // file exist
		listOfFiles.add(new File(dir,"/j/t2.txt"));                                       // file doesn't exist
		listOfFiles.add(new File(dir,"second.txt"));					//file exist
		listOfFiles.add(new File(dir,"/dir/t.txt"));					// file doesn't exist
	}
	
	@BeforeAll
	public static void initListDir(){
		listOfDir = new ArrayList<>();
		listOfDir.add(new File(dir,"/empt/"));     // dir exist
		listOfDir.add(new File(dir,"/j/"));                                       // dir doesn't exist
		listOfDir.add(new File(dir,"/dirMove/"));					//dir exist
		listOfDir.add(new File(dir,"/dir"));					// dir doesn't exist
	}
	
	@BeforeEach
	public void initObject(){
		reportFile = new CSVFileStrategy();
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
	public void testWithFiles(){
		assertDoesNotThrow(()->{
			reportFile.execute(listOfFiles);
		});
	}
	
	@Test
	public void testWithDirs(){
		assertDoesNotThrow(()->{
			reportFile.execute(listOfDir);
		});
	} */
}
