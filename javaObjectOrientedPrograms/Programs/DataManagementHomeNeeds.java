package com.bridgeit.javaObjectOrientedPrograms.Programs;

import java.io.File;
import com.bridgeit.javaObjectOrientedPrograms.Utility.Utility;

public class DataManagementHomeNeeds {
	public static void main(String [] args){
		File file =new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/HomeNeeds");
		Utility.writeOnFile(file);
		Utility.readOnFile(file);
    
	}
}
