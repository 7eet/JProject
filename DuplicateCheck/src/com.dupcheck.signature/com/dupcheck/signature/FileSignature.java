// this calculate the signatue of file and returns it.
package com.dupcheck.signature;
import java.security.*;
import java.io.*;
import java.nio.file.*;

public class FileSignature{

	private MessageDigest md = null;
	
	private String result = null; 
	
	public FileSignature(File file){	
		
		if(file != null){
	
			try{
				md = MessageDigest.getInstance("SHA-256");
				byte[] bytes = Files.readAllBytes(file.toPath());
				result = new  String(md.digest(bytes)); 
			

			}catch(NoSuchAlgorithmException noAlgo){
					noAlgo.printStackTrace();
			}catch(IOException io){
				System.out.println("Error occured in Signature.");
				//io.printStackTrace();
			}
		}else{
			System.out.println("Null Argument is passed.");
		}	
		
	}
	
	public String getSignature(){
		return result;
	}
	
}
