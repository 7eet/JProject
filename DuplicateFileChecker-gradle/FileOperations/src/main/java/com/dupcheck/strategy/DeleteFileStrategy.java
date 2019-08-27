// this file is used for deleting duplicate files.

package com.dupcheck.strategy;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
public class DeleteFileStrategy implements FeatureStrategy{
	
		@Override public void execute(List<File> list){
			list.forEach(e -> {
					try{
						Files.deleteIfExists(e.toPath());
					}catch(IOException exception){
						//exception.printStackTrace();
						System.out.println("Error Occured when deleting files.");
					}
				});
		}
}
