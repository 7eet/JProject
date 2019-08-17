// this file create a new file with .csv extension and add duplicate files.
package com.dupcheck.strategy;
import java.util.List;
import java.time.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class CSVFileStrategy implements FeatureStrategy {
	
	BufferedWriter writer = null;
	
	PosixFileAttributes attr = null;

	@Override public void execute(List<File> list){
	
	
		try{
		writer = new BufferedWriter( new FileWriter( new File("DuplicateFiles.csv"),true));
		writer.write("ReportDate: "+LocalDate.now().toString()+",ReportTime: "+LocalTime.now().toString()+"\n\n");
		writer.write("Path,Owner,Group,Size\n");	
		writer.flush();

		list.forEach(
			e -> {
				try{
				
				attr = Files.readAttributes(e.toPath(), PosixFileAttributes.class);
				
				writer.write(e.toPath().toAbsolutePath().toString()+","+attr.owner().getName()+","+attr.group().getName()+","+e.length()+" bytes");
				writer.newLine();
				writer.flush(); 	
				}catch(IOException ioex){
					System.out.println("Error occured while writing file.");
					//ioex.printStackTrace();
				}
			}
		);
		writer.write("\n\n");
		writer.flush();
		
		}catch(IOException exception){
			System.out.println("Error occured in creating csv file.");
		}finally{
			try{
			writer.close();
			}catch(IOException ioex){
				System.out.println("Error occured in closing object.");
			}
		}
		
	
	}

}
