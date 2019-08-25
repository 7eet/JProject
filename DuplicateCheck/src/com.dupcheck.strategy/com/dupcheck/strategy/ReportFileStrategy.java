// this is file create a normal text file , which contains list of duplicate files.
package com.dupcheck.strategy;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
public class ReportFileStrategy implements FeatureStrategy {
	
	private BufferedWriter writer = null;	
	
	@Override public void execute(List<File> list){
	
		if(list != null ){
	
			try{
		
				if(Files.exists(Paths.get("DuplicateFiles.txt"))){
					writer = new BufferedWriter( new FileWriter( new File("DuplicateFiles.txt"),true));
					createReport(writer,list);
				}else{
						writer = new BufferedWriter( new FileWriter( new File("DuplicateFiles.txt")));
						writer.write("FileName\tSize (bytes)\n");
						writer.write("\n");	
						writer.flush();
						createReport(writer,list);
				}
			}catch(IOException exception){
					//excecption.printStackTrace();
					System.out.println("Error occured in creating file.");
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
	
	
	private void createReport(BufferedWriter bufferedWriter, List<File> list) throws IOException{
			list.forEach(
					e -> {
							try{			
								bufferedWriter.write(e.getName()+"\t "+e.length());
								bufferedWriter.newLine();
								bufferedWriter.flush(); 	
							}catch(IOException ioex){
								System.out.println("Error occured while writing file.");
								//ioex.printStackTrace();
							}		
						}
					);
					
			writer.write("\n");
					
		}	
}
