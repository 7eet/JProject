package com.dupcheck.signature;
import java.security.MessageDigest;
import java.io.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;


public class FileSignatureTest{
/*
	private static File nonExistFile = new File("Dummy.txt");
	private static File nonExistDir = new File("non/dir/");	
	private static File dirPath = new File(System.getProperty("user.dir")+"/../test-class-dir");
	private static File validFile =  new File(dirPath,"/dirSig/first.txt");
	private static File validDir =  new File(dirPath,"/dirSig/nonEmpt");

	@Test 
	public void testForNullArgument(){
		assertNull( new FileSignature(null).getSignature());
	}
	
	@Test
	public void testForNonExistFile(){
		assertNull(new FileSignature(nonExistFile).getSignature());
	}

	@Test
	public void testForExistFile(){
		assertNotNull(new FileSignature(validFile).getSignature());	
	}
	
	@Test
	public void testForValidDirectory(){
		assertNull(new FileSignature(validDir).getSignature());	
	}
	
	@Test
	public void testForNonExistDir(){
		assertEquals(null,new FileSignature(nonExistDir).getSignature());
	}  */
}
