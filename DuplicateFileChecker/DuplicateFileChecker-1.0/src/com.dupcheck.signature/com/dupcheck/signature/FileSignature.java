/**
* 	@author 7eet
*	@Version 1.0
*/
// this calculate the signatue of file and returns it.
package com.dupcheck.signature;
import java.security.*;
import java.io.*;
import java.nio.file.*;

public class FileSignature{
	
	private MessageDigest md = null;
	
	private String result = null; 
	
	/**
	*	@param file is the file on which the signature will be calculated.
	*/
	public FileSignature(File file){	
		
		if(file != null){
			try{
				md = MessageDigest.getInstance("SHA-256");
				byte[] bytes = Files.readAllBytes(file.toPath());
				result = new  String(md.digest(bytes),"UTF-8"); 
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
	
	/**
	*	@returns the string of file's signature
	*/
	public String getSignature(){
		return result;
	}	
}
