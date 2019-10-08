/**
* 	@author 7eet
*	@Version 1.0
*/
 // this is a interface for features and
// this package implements strategy pattern
package com.dupcheck.strategy;
import java.util.List;
import java.io.File;

public interface FeatureStrategy {
	/**
	*@param list is the list of duplicate files.
	*/
	void execute(List<File> list);
	
}
