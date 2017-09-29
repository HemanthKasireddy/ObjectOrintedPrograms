package com.bridgeit.javaObjectOrientedPrograms.Programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;  
public class JsonTest {

	public static void main(String args[]){    
	/*	File file =new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/PersionalDetails.json");
	writeJsonFile(file);
	readJsonFile(file);
	}

	private static void readJsonFile(File file) {
		try {
			FileReader fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			JSONObject json=(JSONObject)parser.parse(fileReader);
			String name=(String)json.get("Name");
			String email=(String)json.get("Email");

			long age=(long)json.get("Age");

			long salary=(long)json.get("Salary");

			System.out.println("Name: "+name);
			System.out.println("Email: "+email);
			System.out.println("Age: "+age);
			System.out.println("Salary: "+salary);
			JSONArray about=(JSONArray)json.get("About");
			Iterator itr=about.iterator();
			while(itr.hasNext()){
				System.out.println("  "+itr.next());
			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeJsonFile(File file) {
     if(file.exists()){
    	 if(file.canWrite()){
    		 try {
				FileWriter fileWriter=new FileWriter(file);
				JSONObject json=new JSONObject();
				json.put("Name", "Hemanth");
				json.put("Email", "hemanthreddysunny@gmail.com");
				json.put("Age", 21);
				json.put("Salary", 1000000);
				JSONArray jsonArray=new JSONArray();
				jsonArray.add("Good Person");
				jsonArray.add("Charming guy");
				json.put("Name", "sunny");
				json.put("Email", "hemanthreddysunny@gmail.com");
				json.put("Age", 22);
				json.put("Salary", 10000000);
	
				jsonArray.add("Good Person");
				jsonArray.add("creative man");
				json.put("About",jsonArray);
				
				System.out.println(json);
				fileWriter.write(json.toJSONString());
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
     }
		
	  */
		File file =new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/HomeNeeds");
		writeOnFile(file);
		readOnFile(file);
	}

	private static void readOnFile(File file) {
		
		try {
			FileReader fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			JSONObject json=(JSONObject)parser.parse(fileReader);
		
			/*JSONObject rice=(JSONObject)json.get("Rice");
			String name=(String)rice.get("Name");
			long weight=(long)rice.get("Weight");
			long price=(long)rice.get("Price");
		//	String name=(String)rice.get("Name");
			System.out.println("Name: "+name);
			System.out.println("Weight: "+weight);
			System.out.println("Price: "+price);*/


			Iterator<?> iterator = json.keySet().iterator(); 
			
			while(iterator.hasNext()) {
				
			    String outerKey = (String) iterator.next();
				JSONObject jsonObject=(JSONObject)json.get(outerKey);
				Iterator<?> iterator1 = jsonObject.keySet().iterator(); 
				
				while(iterator1.hasNext()) {
					
					String key=(String) iterator1.next();
					System.out.println(key+" : "+jsonObject.get(key));
					
				}
				System.out.println("The Toatal cost of "+jsonObject.get("Name")+" is: "+Integer.parseInt(jsonObject.get("Price").toString())*Integer.parseInt(jsonObject.get("Weight").toString()));
			  /* System.out.println("Name: "+jsonObject.get("Name"));
			   System.out.println("weight: "+jsonObject.get("Weight"));
			   System.out.println("price: "+jsonObject.get("Price"));*/

			}
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	private static void writeOnFile(File file) {
	try {
		FileWriter fileWriter=new FileWriter(file);
		
		JSONObject products=new JSONObject();
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("Name", "Sona Masuri");
		jsonObject.put("Weight", 50);
		jsonObject.put("Price", 2400);
		//JSONObject riceObject=new JSONObject();
		//riceObject.put("Rice", jsonObject);
		
		JSONObject jsonObject1=new JSONObject();
		jsonObject1.put("Name", "wheat101");
		jsonObject1.put("Weight", 50);
		jsonObject1.put("Price", 2200);
		
		JSONObject jsonObject2=new JSONObject();
		jsonObject2.put("Name", "Moong dal");
		jsonObject2.put("Weight", 50);
		jsonObject2.put("Price", 5000);
		
		
		products.put("Rice", jsonObject);
		products.put("Wheat", jsonObject1);
		products.put("Pulses", jsonObject2);
		fileWriter.write(JSONValue.toJSONString(products));
		fileWriter.flush();
		fileWriter.close();
		

		System.out.println(JSONValue.toJSONString(products));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}	

}
