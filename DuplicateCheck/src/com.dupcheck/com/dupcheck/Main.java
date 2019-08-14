// main application file


package com.dupcheck;
import java.util.*;
import com.dupcheck.list.*;
import com.dupcheck.strategy.*;
import java.nio.file.*;
import java.io.File;

public class Main{
	private GetList getList = new GetList();
	private List<File> duplicateFiles = new ArrayList<>(); 
	public static void main(String[] arg){
		Main main = new Main();
		 
		if(arg[0] != null){
			String argument = arg[0];
			Path p = Paths.get(argument);
			if(p.toFile().exists()){
				main.duplicateFiles = main.getList.listOfDuplicateFiles(p);
				if(arg.length >= 2){
				main.forSecondArgument(main.duplicateFiles,arg[1]);
				}else{
					System.out.format("Report for Duplicate Files%n");
					main.duplicateFiles.forEach(System.out::println);
				}
			}else{
				System.out.format("Please specify correct directory.%n");			
			}
		
		}else{
			System.out.format("Please run this program with two parameter.%nOne for path and another for operation.%n");
		}
		
	}
	
	private void forSecondArgument(List<File> list , String operation){
		 FeatureStrategy strategy = null;
		if(operation.equals("d")){
			strategy = new DeleteFileStrategy();
			strategy.execute(list);
		}if(operation.equals("m")){
			strategy = new MoveFileStrategy();
			strategy.execute(list);
		}if(operation.equals("csv")){
			strategy = new CSVFileStrategy();
			strategy.execute(list);
		}if(operation.equals("f")){
			strategy = new ReportFileStrategy();
			strategy.execute(list);
		}else{
			System.out.format("To perform operations on duplicate files you have to give parameter after path.%nOperations are as follows:%n1. -d\t-> to delete files%2. -m\t-> to move files%n3. -csv\t-> to create report in \".csv\" form.%n4. -f\t-> to create report in normal text file.%n");	
		}
		
	
	}
}
