// this file create a new file with .csv extension and add duplicate files.
package com.dupcheck.strategy;
import java.util.List;
import java.io.*;

public class CSVFileStrategy implements FeatureStrategy {
	
	BufferedWriter writer = null;

	@Override public void execute(List<File> list){
	
	
		try{
		writer = new BufferedWriter( new FileWriter( new File("DuplicateFiles.csv")));
		
		writer.write("Path,Size( in bytes)\n");	
		writer.flush();
		
		list.forEach(
			e -> {
				try{
				writer.write(e.toString());
				writer.write(",");
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
			System.out.println("Error occured in creating csv file.");
		}
		
	
	}

}
