package com.dupcheck.signature;
import java.security.MessageDigest;
import java.io.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;


public class FileSignatureTest{

	private static File dummyFile = new File("Dummy.txt");
	
	private static File desktopPath = new File(System.getProperty("user.home")+"/Desktop");
	private static File file =  new File(desktopPath,"/T/Tp.java");
	private static File dir =  new File(desktopPath,"/T");

	@Test 
	public void testForNullArgument(){
		assertNull( new FileSignature(null).getSignature());
	}
	
	@Test
	public void testForNonExistFile(){
		assertNull(new FileSignature(dummyFile).getSignature());
	}

	@Test
	public void testForExistFile(){
		assertNotNull(new FileSignature(file).getSignature());	
	}
	
	@Test
	public void testForValidDirectory(){
		assertNull(new FileSignature(dir).getSignature());	
	}
}
