// this file is used for moving duplicate files to new directory.
package com.dupcheck.strategy;
import java.util.Scanner;
import java.util.List;
import java.io.*;
import java.nio.file.*;
public class MoveFileStrategy implements FeatureStrategy{

	private Path movePath = null;
	
	public MoveFileStrategy(Path path){
		movePath = path;
	}
	
		
	@Override public void execute(List<File> list){
	
	
		if(Files.exists(movePath) && Files.isDirectory(movePath)){
			
	//		Path dirPath = Paths.get(movePath.toString()+"/DuplicateFiles");
	//		Path target = Files.createDirectory(dirPath);
			list.stream()
				.forEach( e -> {
					try{
					Files.move(e.toPath(),movePath.resolve(e.toPath().getFileName()),StandardCopyOption.REPLACE_EXISTING);
					
					}catch(IOException io){
						//io.printStackTrace();
						System.out.println("Error occured when moving files.");
						
						}
					});
				}
		
			else{
				System.out.println("Invalid Path!!");
			}
	}
}
