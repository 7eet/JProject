// this file is used for moving duplicate files to new directory.
package com.dupcheck.strategy;
import java.util.Scanner;
import java.util.List;
import java.io.*;
import java.nio.file.*;
public class MoveFileStrategy implements FeatureStrategy{
	
		
	@Override public void execute(List<File> list){
		
		System.out.println("\nSpecify Path: ");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.next();	 	
		Path movePath = Paths.get(path);
		if(Files.exists(movePath) && Files.isDirectory(movePath)){
			list.stream()
				.forEach( e -> {
					try{
					Files.move(e.toPath() , movePath);
					}catch(IOException io){
						System.out.println("Error occured when moving files.");
					}
				});
		
		}else{
			System.out.println("Invalid Path!!");
		}
				
	
	}
}
