package com.dupcheck.strategy;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MoveFileTest{
	/*
	private static File dir  = new File(System.getProperty("user.dir")+"/../test-class-dir/dirStrat/forMove");

	private static List<File> listWithZeroSize = null;
	private static List<File> listWithFourFiles = null;
	private static List<File> listWithThreeDir = null;
	private MoveFileStrategy mvFile = null;

	@BeforeEach
	public void initConstructorWithValidPath(){
			mvFile = new MoveFileStrategy(Paths.get(dir+"/move"));
	}
	
	@BeforeAll
	public static void initList(){
		listWithZeroSize = new ArrayList<>();
		listWithFourFiles = new ArrayList<>();
		listWithThreeDir = new ArrayList<>();
	}
	
	@BeforeAll
	public static void addElementsToDirList(){
		listWithThreeDir.add(new File(dir,"/empt"));                      // empty dir
		listWithThreeDir.add(new File(dir,"/nonEmpt"));		// non empty dir
		listWithThreeDir.add(new File(dir,"/dum"));			// non exist dir
	}

	@BeforeAll
	public static void addElementsToFileList(){
		
		// #2 and #4 file are nonexist file.
		// rest two are exist.
		
		listWithFourFiles.add(new File(dir,"/first.txt"));
		listWithFourFiles.add(new File(dir,"nofile.txt"));
		listWithFourFiles.add(new File(dir,"/second.txt"));
		listWithFourFiles.add(new File(dir,"/f/y.txt"));
	}
	
	@Test
	public void passingNullToConstructor(){
		MoveFileStrategy mv = new MoveFileStrategy(null);
		assertDoesNotThrow( ()->{mv.execute(null);});
	}
	
	@Test
	public void passingFileToConstructor(){
		MoveFileStrategy mv = new MoveFileStrategy(Paths.get(dir+"/firstc.txt"));
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
*/
}

