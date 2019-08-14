// this returns the list of duplicate files.

package com.dupcheck.list;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import com.dupcheck.signature.FileSignature;
public class GetList{
	
	// field map is used for storing messagedigest of file and file.
	private Map<String, File> map = new HashMap<>();
	
	//field listOfDuplicates is used to store duplicate files. 	
	private List<File> duplicateFiles = new ArrayList<>();
	
	private FileSignature signature = new FileSignature();
	
	
	public List<File> listOfDuplicateFiles(Path p){
		File[] files = (p.toFile()).listFiles();
		
		for(var i=0 ; i < files.length ; i++){
			
			String messageDigest = signature.calculateMessageDigest(files[i]);
			if(map.isEmpty()){
				map.put(messageDigest , files[i] );
			}else{
				if(map.containsKey(messageDigest)){
					duplicateFiles.add(files[i]);
				}else{
					map.put(messageDigest,files[i]);
				}
				
				/*try{
					map.put(messageDigest , files[i] );
				}catch(IllegalArgumentException added){
					duplicateFiles.add(files[i]);
					continue;
				}*/	
			}		
		}
		return duplicateFiles;			
	}		
}
