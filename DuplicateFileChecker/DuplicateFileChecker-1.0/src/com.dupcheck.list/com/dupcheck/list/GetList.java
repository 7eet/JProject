
package com.dupcheck.list;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import com.dupcheck.signature.FileSignature;
public class GetList{

		// this inner class store file's signature and file path
	private class FileInfo{
		String messageDigest = null;
		File file = null;
		
		FileInfo(String messageDigest, File file){
			this.messageDigest = messageDigest;
			this.file = file;
		}
				
		public int hashCode(){
			return messageDigest.hashCode() * 9;
		}
		
		public boolean equals(Object object){
			if( object != null ) {
				if(! (object instanceof FileInfo))
					return false;
				FileInfo fileInfo = (FileInfo)object;
				return this.messageDigest.equals(fileInfo.messageDigest);
			}else{
				//System.out.println("null object.");
				return false;
			}
			
		}
		
	}
	
	// set contains fileInfo object.
	private HashSet<FileInfo> setOfObject = new HashSet<>();
	
	private Set<String> setOfSignature = new HashSet<>();
	
	//field listOfDuplicates is used to store duplicate files. 	
	private List<File> duplicateFiles = new ArrayList<>();
	
	private FileSignature signature = null;
	
	private static long countFiles = 0;
	
	
	public List<File> listOfDuplicateFiles(Path p){
	
		if(p != null){
			traversePath(new File(p.toString()));
			System.out.println("Total files: "+countFiles);
			return duplicateFiles;		
		}else{
			System.out.println("Path is null");
			return null;
		}
	
	}
	
	private void traversePath(File file){
		if(file.exists()){
			if(! file.isDirectory()){
				++countFiles;
			
				signature = new FileSignature(file);
			
				FileInfo fileInfo = new FileInfo(signature.getSignature(),file);
						
				if(setOfObject.isEmpty()){
					setOfObject.add(fileInfo);
				}else{
					if(setOfObject.contains(fileInfo)){
							duplicateFiles.add(file);
					}else{
						setOfObject.add(fileInfo);
					}
				}
			}else{
				if(file.length() > 0){
					File[] files = file.listFiles();
					for(File filesInArray : files){
						traversePath(filesInArray);
					}
				}
			}
		}else{
			System.out.println("File doesnot exist.");
		}			
	}
}

