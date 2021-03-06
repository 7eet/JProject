/**
* 	@author 7eet
*	@Version 1.0
*/

package com.dupcheck;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import com.dupcheck.list.*;
import com.dupcheck.strategy.*;
import java.nio.file.*;
import java.io.File;
import java.nio.charset.Charset;

public class Main{

	private static GetList  getList = new GetList();
	private static List<File>  duplicateFiles = new ArrayList<>();
	private static FeatureStrategy strategy = null;
	
	public static void main(String[] arg){
		
	
	
		long startTime = System.currentTimeMillis();

		if(arg.length > 0){

			Path path = Paths.get(arg[0]);
			if(path.toFile().exists()){
				duplicateFiles = getList.listOfDuplicateFiles(path);
			}else{
				System.out.format("Please specify correct directory.%n");
				
			}

			if(arg.length >1 ){
				String secondArgument = arg[1];


				switch(secondArgument){

					case "d" :

						strategy = new DeleteFileStrategy();
						strategy.execute(duplicateFiles);
						break;

					case "m" :
						Path movePath = null;
						try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,Charset.forName("UTF-8")))){
							System.out.println("Specify path where to move files: ");
							String inputPath = reader.readLine();
							movePath = Paths.get(inputPath);
						}catch(IOException io){
							System.out.println("Error in reading input.");
							//io.printStackTrace();
						}
						strategy = new MoveFileStrategy(movePath);
						strategy.execute(duplicateFiles);
						break;

					case "csv" :
						strategy = new CSVFileStrategy();
						strategy.execute(duplicateFiles);
						break;

					case "f" :

						strategy = new ReportFileStrategy();
						strategy.execute(duplicateFiles);
						break;

					default:
						System.out.format("To perform operations on duplicate files you have to give one more argument after path." +
								"%nOperations are as follows:" +
								"%n1. d\t-> to delete files" +
								"%n2. m\t-> to move files" +
								"%n3. csv\t-> to create report in \".csv\" form." +
								"%n4. f\t-> to create report in normal text file.%n");
						break;
				}
			}else{

				if(duplicateFiles.size() == 0){
					System.out.println("No Duplicate Files.")
				}else{
					System.out.format("Report for Duplicate Files%n");
					duplicateFiles.forEach(System.out::println);
				}
			}

		}else{
			System.out.format("Please run this program with two arguments." +
					"%nOne for path and another for operation.%n");
		}
		
		long endTime = System.currentTimeMillis();
		//System.out.println("Time Taken by application is: "+(endTime-startTime)+" ms for files "+getList.count());

	}

	
}

