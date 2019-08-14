 // this is a interface for features  and this package implements strategy pattern
 
package com.dupcheck.strategy;
import java.util.List;
import java.io.File;
public interface FeatureStrategy{
	
	void execute(List<File> list);
	
}
