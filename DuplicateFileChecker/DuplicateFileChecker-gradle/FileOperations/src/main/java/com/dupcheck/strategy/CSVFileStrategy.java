/**
* 	@author 7eet
*	@Version 1.0
*/
// this file create a new file with .csv extension and add duplicate files.
package com.dupcheck.strategy;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.charset.Charset;
public class CSVFileStrategy implements FeatureStrategy {
	
	private BufferedWriter writer = null;
	
	private PosixFileAttributes attribute = null;
	
	private String filePath = System.getProperty("user.dir")+"/../DuplicateFiles.csv";

	@Override
	public void execute(List<File> list) {
			try {
			
				if (Files.exists(Paths.get(filePath))) {
				
					writer = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(new File(filePath),true),Charset.forName("UTF-8"))); 
					createReport(writer,list);
					writer.write("\n");
				} else {
					writer = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(new File(filePath)),Charset.forName("UTF-8")));
					writer.write("ReportDay,ReportTime,Path,Owner,Group,Size (bytes)\n");
					writer.flush();
					createReport(writer,list);
					writer.write("\n");
				}
				System.out.println("Created Report");
			} catch (IOException exception) {
				System.out.println("Error occured in creating csv file.");
			} finally {
				try {
				writer.close();
				} catch (IOException ioex) {
					System.out.println("Error occured in closing object.");
				}
			}
	}
	
	
	private void createReport(BufferedWriter bufferedWriter , List<File> list) throws IOException{
		
		writer.write(LocalDate.now().toString()+","+LocalTime.now().toString()+"\n");
		writer.flush();
		
		list.forEach(
			e -> {
			
			if (Files.exists(e.toPath()) && !Files.isDirectory(e.toPath())) {
				try {
					attribute = Files.readAttributes(e.toPath(), PosixFileAttributes.class);
				
					writer.write(",,"+e.toPath().toAbsolutePath().toString()+","+attribute.owner().getName()+","+attribute.group().getName()+","+e.length());
					writer.newLine();
					writer.flush(); 	
				} catch(IOException ioex) {
					System.out.println("Error occured while writing file.");
					//ioex.printStackTrace();
				}
			}
			}
		);
	}
}
