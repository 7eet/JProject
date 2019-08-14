// this calculate the signatue of file and returns it.
package com.dupcheck.signature;
import java.security.MessageDigest;
import java.io.File;
import java.nio.file.*;

public class FileSignature{

	private MessageDigest md = null;
	
	private String result = null; 
	
	public String calculateMessageDigest(File file){
	
		try{
			md = MessageDigest.getInstance("SHA-256");
			byte[] bytes = Files.readAllBytes(file.toPath());
			result = new  String(md.digest(bytes)); 
			

		}catch(Exception e){
			System.out.println("Error");
			e.printStackTrace();
		}
		
		return result;
	}
}
