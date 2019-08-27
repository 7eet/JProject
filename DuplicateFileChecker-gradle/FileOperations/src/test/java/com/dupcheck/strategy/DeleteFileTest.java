package com.dupcheck.strategy;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteFileTest{
	
	private static FeatureStrategy del = null;
	private static List<File> list =  null;
	private static String desktop  = System.getProperty("user.home")+"/Desktop";
	
	@BeforeEach
	public static void createReference(){
		del = new DeleteFileStrategy();
		list = new ArrayList<>();
	}
	
	@Test 
	public void testForNull(){
		assertThrows( NullPointerException.class , ()->{
			del.execute(null);
		});
	}
	
	@Test
	public void testForEmptyList(){
		assertDoesNotThrow(()-> {
			list = new ArrayList<>();
			del.execute(list);
		});
	}
	
	@Test
	public void forListSizeEqualsToFour(){
		assertDoesNotThrow(()-> {
			list.add(new File(desktop+"/T/Sample.java"));
			list.add(new File("/dummy/file.txt"));          // non exist file
			list.add(new File(desktop+"/T/run.sh"));
			list.add(new File("/dir/dir1/ij.jpg"));	//// non exist file
			del.execute(list);
		});
	}
	
	@Test
	public void listWithDirectories(){
			assertDoesNotThrow(()-> {
			list.add(new File(desktop+"/T/"));
			list.add(new File("/dummy/file.txt"));          // non exist file
			list.add(new File(desktop+"/T/testin/"));
			list.add(new File("/dir/dir1/ij.jpg"));	//// non exist file
			del.execute(list);
		});	
	}
}

