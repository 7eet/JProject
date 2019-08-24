// this returns the list of duplicate files.

package com.dupcheck.list;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import com.dupcheck.signature.FileSignature;
public class GetList{


	private class FileInfo{
		String messageDigest = null;
		File file = null;
		
		FileInfo(String messageDigest, File file){
			this.messageDigest = messageDigest;
			this.file = file;
		}
		
		public String getMessageDigest(){
			return messageDigest;
		}
		
		public File getFile(){
			return file;
		}
		
		public int hashCode(){
			return messageDigest.hashCode() * 9;
		}
		
		public boolean equals(Object object){
			if(! (object instanceof FileInfo))
				return false;
			FileInfo fileInfo = (FileInfo)object;
			return this.messageDigest.equals(fileInfo.messageDigest);
		}
		
	}
	
	private HashSet<FileInfo> set = new HashSet<>();
	
	// field map is used for storing messagedigest of file and file.
	//private Map<String, File> map = new HashMap<>();
	
	//field listOfDuplicates is used to store duplicate files. 	
	private List<File> duplicateFiles = new ArrayList<>();
	
	private FileSignature signature = null;
	
	
	public List<File> listOfDuplicateFiles(Path p){
	
	if(p != null){
	
		if(Files.exists(p)){

		
		File[] files = (p.toFile()).listFiles();
		
		for(var i=0 ; i < files.length ; i++){
		
			if( ! files[i].isFile()) continue;
		
			signature = new FileSignature(files[i]);
			
			FileInfo fileInfo = new FileInfo(signature.getSignature(),files[i]);
						
			if(set.isEmpty()){
				set.add(fileInfo);
			}else{
				if(set.contains(fileInfo)){
					duplicateFiles.add(files[i]);
				}else{
					set.add(fileInfo);
				}	
			}		
		}
		return duplicateFiles;			
	}else{
		System.out.println("Path does not exists.");
		return null;
	}
	}else{
		System.out.println("Path is null.");
		return null;
	}
	}		
}
