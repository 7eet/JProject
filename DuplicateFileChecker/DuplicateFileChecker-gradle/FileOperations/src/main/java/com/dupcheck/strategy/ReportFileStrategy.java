/**
* 	@author 7eet
*	@Version 1.0
*/
// this is file create a normal text file , which contains list of duplicate files.
package com.dupcheck.strategy;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.LocalDateTime;
import java.io.*;
import java.time.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.nio.charset.Charset;
public class ReportFileStrategy implements FeatureStrategy {
	
	private BufferedWriter writer = null;
	
	private String filePath =System.getProperty("user.dir")+"/../DuplicateFiles.txt";	
	
	@Override public void execute(List<File> list){
	
			try{
		
				if(Files.exists(Paths.get(filePath))){
					writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filePath),true),Charset.forName("UTF-8")));
					createReport(writer,list);
					writer.write("\n");
				}else{
						writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filePath)),Charset.forName("UTF-8")));
						createReport(writer,list);
						writer.write("\n");
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
	
	LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		String[] stringDateTime = dateTime.format(format).split(",");	
	
	bufferedWriter.write(String.format("Date & Time:  %s  %s %n",stringDateTime[0].trim(),stringDateTime[1].trim() ));
			list.forEach(
					e -> {
							if(Files.exists(e.toPath()) && !Files.isDirectory(e.toPath())){
									try{			
										bufferedWriter.write(String.format("%s %n", e.toPath().toString()));
										//bufferedWriter.newLine();
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
