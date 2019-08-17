// this is file create a normal text file , which contains list of duplicate files.
package com.dupcheck.strategy;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
public class ReportFileStrategy implements FeatureStrategy {
	
	BufferedWriter writer = null;
	
	PosixFileAttributes attr = null;
	
	@Override public void execute(List<File> list){
		
		try{
		writer = new BufferedWriter( new FileWriter( new File("DuplicateFiles.txt"),true));
		
		writer.write("FileName\t Owner\tGroup\tSize (bytes)\n");
		
		list.forEach(
			e -> {
				try{
				
				attr = Files.readAttributes(e.toPath() ,PosixFileAttributes.class);
				
				writer.write(e.getName()+"\t "+attr.owner().getName()+"\t "+attr.group().getName()+"\t "+e.length());
				writer.newLine();
				writer.flush(); 	
				}catch(IOException ioex){
					System.out.println("Error occured while writing file.");
					//ioex.printStackTrace();
				}		
			}
		);

		writer.write("\n\n");
		
		}catch(IOException exception){
			//excecption.printStackTrace();
			System.out.println("Error occured in creating report file.");
		}finally{
			try{
			writer.close();
			}catch(IOException ioex){
				System.out.println("Error occured in closing object.");
			}
		}
	}
	
}
