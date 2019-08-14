// this is file create a normal text file , which contains list of duplicate files.
package com.dupcheck.strategy;
import java.util.*;
import java.io.*;
public class ReportFileStrategy implements FeatureStrategy {
	
	BufferedWriter writer = null;
	
	@Override public void execute(List<File> list){
		
		try{
		writer = new BufferedWriter( new FileWriter( new File("DuplicateFiles.txt")));
		
		writer.write("Path\tSize( in bytes)\n");	
		writer.flush();
		
		list.forEach(
			e -> {
				try{
				writer.write(e.toString());
				writer.write("\t");
				writer.flush();
				writer.write(""+e.length());
				writer.newLine();
				writer.flush(); 	
				}catch(IOException ioex){
					ioex.printStackTrace();
				}
			}
		);
		
		}catch(IOException exception){
			System.out.println("Error occured in creating report file.");
		}
	}
	
}
