package com.dupcheck.strategy;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DeleteFileTest{
	
	private FeatureStrategy del = null;
	private List<File> list =  null;
	private static File dir  = new File(System.getProperty("user.dir")+"/../test-class-dir/dirStrat");
	
	@BeforeEach
	public void createReference(){
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
			list.add(new File(dir,"forDelete/first.txt"));
			list.add(new File(dir,"/file.txt"));          // non exist file
			list.add(new File(dir,"/forDelete/second.txt"));
			list.add(new File(dir,"/ij.jpg"));	//// non exist file
			del.execute(list);
		});
	}
	
	@Test
	public void listWithDirectories(){
			assertDoesNotThrow(()-> {
			list.add(new File(dir,"/forDelete/empt"));
			list.add(new File(dir,"/direct"));          // non exist file
			list.add(new File(dir,"/forDelete/nonEmpt"));
			list.add(new File(dir,"/ij.jpg"));	//// non exist file
			del.execute(list);
		});	
	}
}

