/**
* 	@author 7eet
*	@Version 1.0
*/
// this file is used for moving duplicate files to new directory.
package com.dupcheck.strategy;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
public class MoveFileStrategy implements FeatureStrategy {

	private Path movePath = null;

	private int count=0;
	
	public MoveFileStrategy(Path path) {
		movePath = path;
	}
		
	@Override public void execute(List<File> list) {
	
	if (movePath != null) {
	
		if (Files.exists(movePath) && Files.isDirectory(movePath)) {
			list.stream()
					.forEach(e -> {
						if (Files.exists(e.toPath())) {
							try {
								Files.move(e.toPath(), movePath.resolve(e.toPath().getFileName()), StandardCopyOption.REPLACE_EXISTING);
								count++;
							} catch (IOException io) {
								//io.printStackTrace();
								System.out.println("Error occured when moving files.");
							}
						} else {
							System.out.println(e.toPath() + " not exists.");
						}
					});
			System.out.println("Moved " + count + " Files.");
		} else {
				System.out.println("Invalid Path!!");
			}
		} else {
			System.out.println("Given path is null.");
		}
	}
}
