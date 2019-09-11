package com.dupcheck.strategy;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFileTest{
	private CSVFileStrategy reportFile = null;
	private static List<File> sizeZero = null;
	private static List<File> listOfFiles = null;
	private static List<File> listOfDir = null;
	private static File dir  = new File(System.getProperty("user.dir"));
	
	@BeforeAll
	public static void createFileNDir(){
		try{
		Files.createDirectory(Paths.get(dir.toString()+"/dirOne"));
		Files.createDirectory(Paths.get(dir.toString()+"/dirTwo"));
		Files.createFile(Paths.get(dir.toString()+"/dirOne/first.txt"));
		Files.createFile(Paths.get(dir.toString()+"/dirOne/second.txt"));
		}catch(IOException io){
			System.out.println(io);
		}
	}
	
	@BeforeAll
	public static void initListDir(){
		sizeZero = new ArrayList<>();
		listOfFiles = new ArrayList<>();
		listOfFiles.add(new File(dir,"/first.txt"));     // file exist
		listOfFiles.add(new File(dir,"/j/t2.txt"));                                       // file doesn't exist
		listOfFiles.add(new File(dir,"/second.txt"));					//file exist
		listOfFiles.add(new File(dir,"/dir/t.txt"));					// file doesn't exist
	}
	
	@BeforeAll
	public static void initList(){
		listOfDir = new ArrayList<>();
		listOfDir.add(new File(dir,"/dirOne/"));     // file exist
		listOfDir.add(new File(dir,"/j/"));                                       // file doesn't exist
		listOfDir.add(new File(dir,"/dirTwo"));					//file exist
		listOfDir.add(new File(dir,"/dir"));					// file doesn't exist
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
	}
	
	@AfterAll
	public static void deleteFileNDir(){
		try{
		Files.delete(Paths.get(dir.toString()+"/dirOne/first.txt"));
		Files.delete(Paths.get(dir.toString()+"/dirOne/second.txt"));
		Files.delete(Paths.get(dir.toString()+"/dirOne"));
		Files.delete(Paths.get(dir.toString()+"/dirTwo"));		
		}catch(IOException io){
			System.out.println(io);
		}
	}
}
