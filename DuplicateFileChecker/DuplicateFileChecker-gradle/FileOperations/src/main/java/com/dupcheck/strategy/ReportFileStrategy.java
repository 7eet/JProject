/**
* 	@author 7eet
*	@Version 1.0
*/
// this is file create a normal text file , which contains list of duplicate files.
package com.dupcheck.strategy;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.nio.charset.Charset;
public class ReportFileStrategy implements FeatureStrategy {
	
	private BufferedWriter writer = null;	
	
	@Override public void execute(List<File> list){
	
			try{
		
				if(Files.exists(Paths.get("DuplicateFiles.txt"))){
					writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("DuplicateFiles.txt"),true),Charset.forName("UTF-8")));
					createReport(writer,list);
				}else{
						writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("DuplicateFiles.txt")),Charset.forName("UTF-8")));
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
	}
	
	
	private void createReport(BufferedWriter bufferedWriter, List<File> list) throws IOException{
			list.forEach(
					e -> {
							if(Files.exists(e.toPath()) && !Files.isDirectory(e.toPath())){
									try{			
										bufferedWriter.write(e.toPath()+"\t "+e.length());
										bufferedWriter.newLine();
										bufferedWriter.flush(); 	
									}catch(IOException ioex){
										System.out.println("Error occured while writing file.");
										//ioex.printStackTrace();
									}
								}else{
									System.out.println("Files doesn't exist.");
								}
							}	
					);
					
			writer.write("\n");
					
		}	
}
