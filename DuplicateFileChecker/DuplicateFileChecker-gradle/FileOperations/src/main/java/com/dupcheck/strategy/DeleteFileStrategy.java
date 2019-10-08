/**
* 	@author 7eet
*	@Version 1.0
*/
// this file is used for deleting duplicate files.
package com.dupcheck.strategy;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DeleteFileStrategy implements FeatureStrategy {
	private int count=0;
	
		@Override
		public void execute(List<File> list) {
			list.forEach(e -> {
					try {
						if(Files.exists(e.toPath())){
							count++;
							Files.delete(e.toPath());
						}
					} catch (IOException exception) {
						//exception.printStackTrace();
						System.out.println("Error Occurred when deleting files.");
					}
				});
			System.out.println("Deleted "+ count + " Files.");
		}
}
