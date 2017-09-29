package com.bridgeit.javaObjectOrientedPrograms.Programs;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgeit.javaObjectOrientedPrograms.Utility.Utility;

public class DataManagementHomeNeeds {
	public static void main(String [] args){
		File file =new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/HomeNeeds");
		Utility.writeOnFile(file);
		Utility.readOnFile(file);
    
	}
}
