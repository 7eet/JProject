// this file create a new file with .csv extension and add duplicate files.
package com.dupcheck.strategy;
import java.util.List;
import java.time.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class CSVFileStrategy implements FeatureStrategy {
	
	private BufferedWriter writer = null;
	
	private PosixFileAttributes attribute = null;

	@Override public void execute(List<File> list){
	
		if(list != null){
			
			try{	
			
				if(Files.exists(Paths.get("DuplicateFiles.csv"))){
				
					writer = new BufferedWriter( new FileWriter( new File("DuplicateFiles.csv"),true));
					createReport(writer,list);
					writer.write("\n");
				}else{
					writer = new BufferedWriter( new FileWriter( new File("DuplicateFiles.csv")));
					writer.write("ReportDay,ReportTime,Path,Owner,Group,Size (bytes)\n");
					writer.flush();
					createReport(writer,list);
					writer.write("\n");
				}
			}catch(IOException exception){
				System.out.println("Error occured in creating csv file.");
			}finally{
				try{
				writer.close();
				}catch(IOException ioex){
					System.out.println("Error occured in closing object.");
				}
			}
		}else{
			System.out.println("Null argument is passed.");
		}
	}
	
	
	private void createReport(BufferedWriter bufferedWriter , List<File> list) throws IOException{
		
		writer.write(LocalDate.now().toString()+","+LocalTime.now().toString()+"\n");
		writer.flush();
		
		list.forEach(
			e -> {
				try{				
					attribute = Files.readAttributes(e.toPath(), PosixFileAttributes.class);
				
					writer.write(",,"+e.toPath().toAbsolutePath().toString()+","+attribute.owner().getName()+","+attribute.group().getName()+","+e.length());
					writer.newLine();
					writer.flush(); 	
				}catch(IOException ioex){
					System.out.println("Error occured while writing file.");
					//ioex.printStackTrace();
				}
			}
		);
	}
}