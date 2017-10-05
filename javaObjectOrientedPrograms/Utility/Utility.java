package com.bridgeit.javaObjectOrientedPrograms.Utility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utility {
	private enum Suits {
	    SPADES,
	    HEARTS,
	    DIAMONDS,
	    CLUBS;
	}
	private enum Ranks { Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King } 

	static String  userName;
	/**
	 * @param file
	 * @author Hemanth
	 * <p> This method for reading data from file
	 */
	public static void readOnFile(File file) {
	
		try {
			
				FileReader fileReader=new FileReader(file);
				JSONParser parser=new JSONParser();
				JSONObject json=(JSONObject)parser.parse(fileReader);
		
				Iterator<?> iterator = json.keySet().iterator(); 
				
				while(iterator.hasNext()) {
					
				    String outerKey = (String) iterator.next();
					JSONObject jsonObject=(JSONObject)json.get(outerKey);
					
					Iterator<?> iterator1 = jsonObject.keySet().iterator(); 
					
					while(iterator1.hasNext()) {
						
						String key=(String) iterator1.next();
						System.out.println(key+" : "+jsonObject.get(key));
						
					 }
					System.out.println();
					System.out.println("The Toatal cost of "+jsonObject.get("Name")+" is: "
					+ Integer.parseInt(jsonObject.get("Price").toString()) *
					  Integer.parseInt(jsonObject.get("Weight").toString())  );
					System.out.println("*****************************************");

				 }
			
			} catch (IOException | ParseException e) {
					e.printStackTrace();
		     }
	}
	
	/**
	 * @param file
	 * @author Hemanth
	 * <p> This method for writing data in to file
	 */
	@SuppressWarnings({ "unchecked" })
	public static void writeOnFile(File file) {
		try {
				FileWriter fileWriter=new FileWriter(file);
				
				JSONObject products=new JSONObject();
		
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("Name", "Sona Masuri");
				jsonObject.put("Weight", 50);
				jsonObject.put("Price", 55);
				
				JSONObject jsonObject1=new JSONObject();
				jsonObject1.put("Name", "wheat101");
				jsonObject1.put("Weight", 50);
				jsonObject1.put("Price", 45);
				
				JSONObject jsonObject2=new JSONObject();
				jsonObject2.put("Name", "Moong dal");
				jsonObject2.put("Weight", 50);
				jsonObject2.put("Price", 150);
				
				
				products.put("Rice", jsonObject);
				products.put("Wheat", jsonObject1);
				products.put("Pulses", jsonObject2);
				//System.out.println(products);
				fileWriter.write(JSONValue.toJSONString(products));
				fileWriter.flush();
				fileWriter.close();
				
			
		} catch (IOException e) {
				e.printStackTrace();
			}
	}
	/**
	 * @param message
	 * @param name
	 * @param mobileNumber
	 * @author Hemanth
	 * <p> This method for replacing user values with standard string template using regex
	 */
	public static void finalString(String message, String name, String mobileNumber){
		String []arrayName=name.split(" ");
		message=message.replace("<<name>>", arrayName[0]);
		message=message.replace("<<full name>>", name);
		message=message.replace("xxxxxxxxxx", mobileNumber);
		
	    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    Date dateobj = new Date();
	    String []today=df.format(dateobj).toString().split(" ");
	    message=message.replace("01/01/2016",today[0]);

		System.out.println(message);
	}
	
	static ArrayList<ArrayList<String>> stocs=new ArrayList<ArrayList<String>>();

	/**
	 * @param shareName
	 * @param numberOfShares
	 * @param sharePrice
	 * @return
	 * @author Hemanth
	 * <p> This method for creating stocks 
	 */
	public static  ArrayList<ArrayList<String>> creatingStocks( String shareName, String numberOfShares, String sharePrice) {

		try {
			  ArrayList<String> stock=new ArrayList<String>();
			  stock.add(shareName);
			  stock.add(numberOfShares);
			  stock.add(sharePrice);
			  stocs.add(stock);
		} catch(Exception ex) {
			ex.getMessage();
		}
		return stocs;
	}
	/**
	 * @author Hemanth
	 * <p> This method for calculate value of each stock
	 */
	public static void valueOfEachStock() {
		try {
			  for (ArrayList<String> value:stocs) {
		
				 System.out.println("*****************************************");
				 System.out.println("Share Name: "+value.get(0));
				 System.out.println("Number of shares are: "+value.get(1));
				 System.out.println("Share Price is: "+value.get(2));
				 System.out.println();
				 System.out.println(value.get(0)+" Stock value is: "+Integer.parseInt(value.get(1).toString())*Integer.parseInt(value.get(2).toString()));

			  }
		 } catch(Exception ex) {
			System.out.println(ex);		
		  }
	}
	/**
	 * @author Hemanth
	 * <p> This method for calculate value of total stocks
	 */
	public static void valueOfTotalStock() {
		int total=0;
		try{
			  for (ArrayList<String> value:stocs) {
			     total=total+Integer.parseInt(value.get(1))*Integer.parseInt(value.get(2));
			 }
				System.out.println("*****************************************");

			System.out.println("The total Stock Price is : "+total);
		} catch(Exception ex) {
			System.out.println(ex);
		 }
	}
	/**
	 * @return
	 * <p> This method for know the current balance in  user account 
	 */
	public static double valueOf() {
		FileReader fileReader=null;
		File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/StcokAccountsFile.json");

		try {
			fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			JSONObject json=(JSONObject)parser.parse(fileReader);
			System.out.println("The account balance is: "+json.get("Balance"));
			 
			} catch ( IOException | ParseException e) {
			
				e.printStackTrace();
		}		
		return 1;
	}
	
	/**
	 * @param amount
	 * @param symbol
	 * @author Hemanth
	 * <p>This method for buying shares
	 * <p>if share does not exist adding that share to file
	 */
	static LinkedList<String> soldTransactions=new LinkedList<String>();
	static LinkedList<String> boughtTransactions=new LinkedList<String>();
	static LinkedList<String> buyTime=new LinkedList<String>();
	static LinkedList<String> sellTime=new LinkedList<String>();
 
	@SuppressWarnings({ "unchecked", "unchecked" })
	public static void buy(int amount, String symbol) {
		
		JSONObject object=null;
		JSONObject obj=null;
		JSONParser parser=null;
		FileReader fileReader=null;
		FileWriter fileWriter=null;
		try {
			 fileReader=new FileReader(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
			 parser=new JSONParser();
			 object=(JSONObject) parser.parse(fileReader);
			 int numshare=0;
			 int finalShares=0;
			 Iterator<String> itr=object.keySet().iterator();
			
			 boolean isShareExist=true;
			 while(itr.hasNext()) {
				
				String key=(String) itr.next();
				obj=(JSONObject)object.get(key);
				
				if(key.equals(symbol)) {
					boughtTransactions.add(symbol);
					numshare=amount/Integer.parseInt(obj.get("SharePrice").toString());
					
					if(numshare<=Integer.parseInt(obj.get("NumberOfShares").toString())) {
						
						finalShares=Integer.parseInt(obj.get("NumberOfShares").toString())-numshare;
						
					} 
					isShareExist=false;
					
				}
			}
			 if(isShareExist) {
					JSONObject ob=new JSONObject();
					ob.put("SharePrice",100);
					ob.put("NumberOfShares", 1000);
					object.put(symbol,ob);
					fileWriter =new FileWriter(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
					fileWriter.write(JSONValue.toJSONString(object));
					fileWriter.flush();
					System.out.println("new Share is added successfully");
					System.out.println("We need to update our databae please re run the program thanks. ");
					System.exit(0);
				}
			 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 Date date = new Date();
			 buyTime.add(dateFormat.format(date));
			String check="buy";
		//	System.out.println(finalShares);
			userAccountUpdated(numshare,amount,check);
			// saving sahre details in with new share values
			save(finalShares,symbol);
			
			
		} catch (  IOException | ParseException ex) {
			ex.printStackTrace();
			System.out.println("Exception is:"+ex);
		}
		
		}
	/**
	 * @author Hemanth
	 * <p>This method for display share transactions 
	 */
	public static  void shareTransactions() {
		System.out.println("sold stacks are: ");
		for(String str:soldTransactions) {
			System.out.println(str +"  "+ sellTime.removeFirst());
		}
		System.out.println("bought stacks are: ");
		for(String str:boughtTransactions) {
			System.out.println(str +"   "+buyTime.removeFirst());
		}
	}
	/**
	 * @param symbol
	  * @author Hemanth
	 * <p>This method for selling shares
	 */
	public static void sell(String symbol) {
		 JSONObject obj=null;
		 JSONParser parser=null;
		 JSONObject object=null;
		 Scanner scanner=null;
		 FileReader fileReader=null;
		try {
			 fileReader=new FileReader(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
			 parser=new JSONParser();
			 object=(JSONObject) parser.parse(fileReader);
			 
			 scanner=new Scanner(System.in);
			 System.out.println("number of shares: ");
			 int userNumber=scanner.nextInt();
			 
			 int amount=0;
			 int numShares=0;
			 Iterator<?> itr=object.keySet().iterator();
			 
		   	 while(itr.hasNext()) {
				
				String key=(String) itr.next();
				obj=(JSONObject)object.get(key);
				
				if(key.equals(symbol)) {
					soldTransactions.add(symbol);
					 amount=Integer.parseInt(obj.get("SharePrice").toString())*userNumber;
					 numShares=Integer.parseInt(obj.get("NumberOfShares").toString())+userNumber;
				}
			
			} 
		   	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			 Date date = new Date();
			 sellTime.add(dateFormat.format(date));
		   	 String check="sell";
		   	 save(numShares,symbol);
		   	 userAccountUpdated(userNumber,amount,check);
		//System.out.println(numShares);
		
		} catch (IOException | ParseException ex) {

			ex.printStackTrace();
			System.out.println("Exception is:"+ex);
		}
			
	}
	
	/**
	 * @param numShares
	 * @param amount
	 * @param check
	 * @author Hemanth
	 * <p>This method for  update the user account details after each transactions
	 */
	@SuppressWarnings({ "unchecked" })
	public static void userAccountUpdated(int numShares, int amount, String check) {
		JSONObject object=null;
		FileReader fileReader=null;
		FileWriter fileWriter=null;
		File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/StcokAccountsFile.json");

		try {
			fileReader=new FileReader(file);
			JSONParser parser=new JSONParser();
			 object=(JSONObject) parser.parse(fileReader); 
				 if(check.equals("sell")) {
					if(object.get("Name").equals(userName)){
						int finalShares=Integer.parseInt(object.get("NumberOfShares").toString())-numShares;

						object.remove("NumberOfShares");
						object.put("NumberOfShares", finalShares);
						double finalAmount=Double.parseDouble(object.get("Balance").toString())+amount;
						object.remove("Balance");
						object.put("Balance", finalAmount);
					}
				 } if(check.equals("buy")) {
					 if(object.get("Name").equals(userName)){
							int finalShares=Integer.parseInt(object.get("NumberOfShares").toString())+numShares;

							object.remove("NumberOfShares");
							object.put("NumberOfShares", finalShares);
							double finalAmount=Double.parseDouble(object.get("Balance").toString())-amount;
							object.remove("Balance");
							object.put("Balance", finalAmount);
						}
				 }
					fileWriter =new FileWriter(file);
					fileWriter.write(JSONValue.toJSONString(object));
					fileWriter.flush();
					
					System.out.println("User Account is updated succesfully: ");
				
		}catch(Exception ex){
			System.out.println(ex);
		}
		 
	}
	/**
	 * @param numShares
	 * @param symbol
	 * @author Hemanth
	 * <p>This method for  update the share account details after each transactions 
	 */
	@SuppressWarnings({ "unchecked", "unchecked" })
	public static void save(int numShares,String symbol) {
		FileReader fileReader=null;
		FileWriter fileWriter=null;
		try {
			fileReader=new FileReader(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
			JSONParser parser1=new JSONParser();
			JSONObject json=(JSONObject) parser1.parse(fileReader);
			
			try {
                 Iterator<?> iterator1 = json.keySet().iterator(); 
				
				 while(iterator1.hasNext()) {
					
					String key1=(String) iterator1.next();
					JSONObject obj=(JSONObject)json.get(key1);

					if(key1.equals(symbol)){
						obj.remove("NumberOfShares");
						obj.put("NumberOfShares", numShares);
						
						}
					}
				fileWriter =new FileWriter(new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/ShareDetails.json"));
				fileWriter.write(JSONValue.toJSONString(json));
				fileWriter.flush();
				
				System.out.println("Shares Account is udated succesfully: ");

			} catch (IOException ex) {
				ex.printStackTrace();
				System.out.println("Exception is:"+ex);

			} 
		}catch(Exception ex){
			System.out.println(ex);
			ex.printStackTrace();
		}
	}

	/**
	 * @author Hemanth
	 * <p> This method for displaying all the details 
	 */
	public static void printReport() {
		JSONParser parser=null;
		JSONObject object=null;
		FileReader fileReader=null;

		File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/StcokAccountsFile.json");

		try {
			 fileReader=new FileReader(file);
			 parser=new JSONParser();
			 object=(JSONObject) parser.parse(fileReader);
			Iterator<?> itr=object.keySet().iterator();
			 while(itr.hasNext()) {
				
				 String key=(String) itr.next();
				 System.out.println(key+" : "+object.get(key));
			}
		} catch(Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
	}
   
	/**
	 * @param name
	 * @param balance
	 * @author Hemanth
	 * <p> This method for creating user account  
	 */
	@SuppressWarnings("unchecked")
	public static void createAccount(String name, double balance) {
		FileWriter fileWriter=null;
		File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/StcokAccountsFile.json");

		JSONObject json=new JSONObject();
		json.put("Name", name);
		json.put("Balance", balance);
		json.put("NumberOfShares", 1000);
		
		try {
			  fileWriter =new FileWriter(file);
			  fileWriter.write(JSONValue.toJSONString(json));
			  fileWriter.flush();
			  System.out.println("Account is created succesfully: ");

		} catch (IOException ex) {
			System.out.println("Exception is: "+ex);
			ex.printStackTrace();
		} 
	}
    
    /**
     * @param num
     * @author Hemanth
     *<p> This method for allow to buy or sell the shares after user name verified
     */
    public static void userAccount(int num) {
    	  JSONParser parser=null;
    	  JSONObject object=null;
    	  FileReader fileReader=null;
  		  File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/StcokAccountsFile.json");
  		 Scanner  scanner=new Scanner(System.in);
    	  try {
	    	
    		  fileReader=new FileReader(file);
			  parser=new JSONParser();
			  object=(JSONObject) parser.parse(fileReader);
			
			  System.out.println("Enter User Name: ");
			    userName=scanner.nextLine();
			
			  if(object.get("Name").equals(userName)) {
						
				  System.out.println("Enter share symbol want to buy  [!,@,#]: ");
				  String symbol=scanner.next();
				  System.out.println("For buying shares pres -b or  For selling shares press- s");
				  String choice=scanner.next().toLowerCase();
				
				if(choice.equals("b")) {
					System.out.println("Enter your amount to buy shares: ");
					int amount=scanner.nextInt();
					//calling buy method
					buy(amount,symbol);
				} else { 
					//calling sell method
					  sell(symbol);
				}
				
			 } else {
				System.out.println("Enter wrong choice: ");
			 }
		
					
		} catch(Exception ex) {
			System.out.println(ex);
		} finally {
			scanner.close();
		}
	}
    static JSONArray stockJsonArray=new JSONArray();
  	/**
  	 * @param shareName
  	 * @param numberOfShares
  	 * @param sharePrice
  	 * @author Hemanth
  	 * <p> This method for creating stocks 
  	 */
  	@SuppressWarnings("unchecked")
	public static void creatingStocksInventor(String shareName, String numberOfShares, String sharePrice) {
  		JSONObject shareObject=new JSONObject();
  		shareObject.put("shareName", shareName);
  		shareObject.put("numberOfShares", numberOfShares);
  		shareObject.put("sharePrice", sharePrice);
  		stockJsonArray.add(shareObject );
  	}
  	/** 
  	 * @author Hemanth
  	 * <p>This method for writing on file
  	 */
  	public static void writeOnFile() {
  		File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/InventoryManagerStock.json");

  		try {
  				FileWriter fileWriter=new FileWriter(file);
  				fileWriter.write(JSONValue.toJSONString(stockJsonArray));
  				fileWriter.flush();
  				fileWriter.close();
  		} catch(Exception ex) {
  			System.out.println(ex);
  		} 
  	}
  	/**
  	 *  @author Hemanth
  	 * <p>This method for calculate value of each stock
  	 */
  	public static void valueOfEachStockInventor() {
  		File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/InventoryManagerStock.json");

  		try {
  			
  			FileReader fileReader=new FileReader(file);
  			JSONParser parser=new JSONParser();
  			JSONObject json=(JSONObject)parser.parse(fileReader);
  	
  			Iterator<?> iterator = json.keySet().iterator(); 
  			
  			while(iterator.hasNext()) {
  				
  			    String outerKey = (String) iterator.next();
  				JSONObject jsonObject=(JSONObject)json.get(outerKey);
  				
  				Iterator<?> iterator1 = jsonObject.keySet().iterator(); 
  				System.out.println("*****************************************");

  				while(iterator1.hasNext()) {
  					
  					String key=(String) iterator1.next();
  					System.out.println(key+" : "+jsonObject.get(key));
  					
  				}
  				System.out.println("The Toatal cost of "+jsonObject.get("shareName")+" is: "
  						+ Integer.parseInt(jsonObject.get("numberOfShares").toString()) *
  						  Integer.parseInt(jsonObject.get("sharePrice").toString())  );
  						//System.out.println("*****************************************");

  					 
  			}
  		} catch (IOException | ParseException e) {
  						e.printStackTrace();
  	     }
  		
  	}

  	/**
  	 * <p>This method for calculate total value of stocks
  	 */
  	public static void valueOfTotalStockInventor() {
  		File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/InventoryManagerStock.json");

  		try {
  			
  				FileReader fileReader=new FileReader(file);
  				JSONParser parser=new JSONParser();
  				JSONObject json=(JSONObject)parser.parse(fileReader);
  				int total=0;
  				Iterator<?> iterator = json.keySet().iterator(); 
  			
  				while(iterator.hasNext()) {
  				
  					String outerKey = (String) iterator.next();
  					JSONObject jsonObject=(JSONObject)json.get(outerKey);				
  					total=total+ Integer.parseInt(jsonObject.get("numberOfShares").toString()) *
  						  Integer.parseInt(jsonObject.get("sharePrice").toString())  ;
  						
  				}
  				System.out.println("*****************************************");
  				System.out.println("The Total Stock price is : "+total);
  		} catch (IOException | ParseException e) {
  						
  			e.printStackTrace();
  	     }
  		
  	}
			    
	/**
	 * 
	 * @param file
	 *  @author Hemanth
	 * <p> This method for adding person to Address book
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public static void addPerson(File file) {
		Scanner scanner=null;
		FileWriter fileWriter=null;
		FileReader fileReader=null;
				
		scanner=new Scanner(System.in);
			try {
					System.out.println("Enter Your First Name: ");
					String userFirstName=scanner.nextLine();
				
					System.out.println("Enter your Last Name: ");
					String userLastName=scanner.nextLine();
				
					System.out.println("Enter your Address: ");
					String userAddress=scanner.nextLine();
				
					System.out.println("Enter your City: ");
					String userCity=scanner.nextLine();
				
					System.out.println("Enter your State: ");
					String userState=scanner.nextLine();
				
					System.out.println("Enter your ZIP: ");
					int userZIP=scanner.nextInt();
				
					System.out.println("Enter your Mobile No: ");
					long userMobileNumber=scanner.nextLong();
				
					fileReader=new FileReader(file);
					JSONParser parser=new JSONParser();
					JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
					//JSONArray jsonArray=new JSONArray();
					JSONObject jsonObject=new JSONObject();
					jsonObject.put("FirstName",userFirstName);
					jsonObject.put("LastName", userLastName);
					jsonObject.put("Address", userAddress);
					jsonObject.put("City", userCity);
					jsonObject.put("State", userState);
					jsonObject.put("Zip", userZIP);
					jsonObject.put("MobileNumber", userMobileNumber);
					jsonArray.add(jsonObject);
				
					fileWriter=new FileWriter(file);
					fileWriter.write(JSONValue.toJSONString(jsonArray));
					fileWriter.flush();
					fileWriter.close();
				
			} catch(Exception ex) {
					ex.printStackTrace();
			} finally {
				scanner.close();
			}
	}

	/**
	 * @param file
	 *  @author Hemanth
	 * <p> This method for editing person details in Address book
	 */
	@SuppressWarnings("unchecked")
	public static void editPerson(File file) {
				
		FileWriter fileWriter=null;
		FileReader fileReader=null;
				
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name you want edit: ");
		
		try {
			    String userEntry=scanner.nextLine();
				fileReader=new FileReader(file);
				JSONParser parser=new JSONParser();
				JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
				Iterator<?> iterator=jsonArray.iterator();
				
				boolean isExist=false;
				while(iterator.hasNext()) {
						
			   //     int key=(int) iterator.next();
					JSONObject jsonObject= (JSONObject)iterator.next();
					
					if(jsonObject.get("FirstName").equals(userEntry)) {
						
						System.out.println("Select what you want to edit: \n 1. Address \n2. City \n 3. State \n 4. ZIP \n 5. Mobile Number \n 6. Edit All ");
						int choice=scanner.nextInt();
						
						switch(choice){
							
							case 1:	 System.out.println("Enter your Address: ");
									 scanner.nextLine();
									 String userAddress=scanner.nextLine();
										
									// jsonObject.remove("Address");
									 
									 jsonObject.put("Address", userAddress);
										
										break;
							
							case 2 : System.out.println("Enter your City: ");
									scanner.nextLine();

									 String userCity=scanner.nextLine();
									// jsonObject.remove("City");
									 jsonObject.put("City", userCity);

									 break;
									 
							case 3 : System.out.println("Enter your State: ");
									 scanner.nextLine();

									 String userState=scanner.nextLine();
									// jsonObject.remove("State");
									 jsonObject.put("State", userState);
									 break;
									 
							case 4 : System.out.println("Enter your ZIP: ");
									 scanner.nextLine();
							 
									 int userZIP=scanner.nextInt();
								//	 jsonObject.remove("Zip");
									 jsonObject.put("Zip", userZIP);

									 break;
									 
							case 5 : System.out.println("Enter your Mobile No: ");
									 scanner.nextLine();

									 long userMobileNumber=scanner.nextLong();
									// jsonObject.remove("MobileNumber");
									 jsonObject.put("MobileNumber", userMobileNumber);

									 break;
									 
							case 6 :
									 System.out.println("Enter your Address: ");
									 scanner.nextLine();
									 String userAddress1=scanner.nextLine();
							
									 System.out.println("Enter your City: ");
									 //scanner.nextLine();
									 String userCity1=scanner.nextLine();
							
									 System.out.println("Enter your State: ");
									// scanner.nextLine();
									 String userState1=scanner.nextLine();
							
									 System.out.println("Enter your ZIP: ");
									// scanner.nextLine();
									 int userZIP1=scanner.nextInt();
							
									 System.out.println("Enter your Mobile No: ");
									// scanner.nextLine();
									 long userMobileNumber1=scanner.nextLong();	
									 
									 jsonObject.put("Address", userAddress1);
									 jsonObject.put("City", userCity1);
									 jsonObject.put("State", userState1);
									 jsonObject.put("Zip", userZIP1);
									 jsonObject.put("MobileNumber", userMobileNumber1);
									 
									 break;
									 
							default:
								System.out.println("Wrong choice: ");
						}								
						fileWriter=new FileWriter(file);
						fileWriter.write(JSONValue.toJSONString(jsonArray));
						fileWriter.flush();
						fileWriter.close();
						System.out.println("Edited");
						isExist=true;
						
						break;
					} 
					
				}
				if (isExist==false) {
					System.out.println("User does not exist: ");
				}
     	} catch ( IOException | org.json.simple.parser.ParseException e) {
					e.printStackTrace();
				} finally {
					scanner.close();
				}
				
			}

	/**
	 * @param file
	 *  @author Hemanth
	 * <p> This method for deleting person details in Address book
	 */
	public static void deletePerson(File file) {
		 
		FileWriter fileWriter=null;
		FileReader fileReader=null;
					
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name you want delete: ");
		try {
			    String userEntry=scanner.nextLine();
				fileReader=new FileReader(file);
				JSONParser parser=new JSONParser();
				JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
				Iterator<?> iterator=jsonArray.iterator();
				boolean isExist=false;	
			    while(iterator.hasNext()) {
							
					JSONObject jsonObject= (JSONObject) iterator.next();
							
					if(jsonObject.get("FirstName").equals(userEntry)) {
							
						jsonArray.remove(jsonObject);
						
						System.out.println("Deleted successfully: ");
						isExist=true;
						break;
					} 
					
				 }
			    
			    fileWriter=new FileWriter(file);
				fileWriter.write(JSONValue.toJSONString(jsonArray));
				fileWriter.flush();
				fileWriter.close();
				if(isExist==false) {
					System.out.println("User does not exist: ");
				}
		} catch ( IOException | org.json.simple.parser.ParseException e) {
							e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	/**
	 * @param file
	 *  @author Hemanth
	 * <p>This method for sort details of person according to his particulars
	 */
	@SuppressWarnings("unchecked")
	public static void sortDetails(File file) {
				
		class SortDetails implements Comparator<Object> {
			 String string=null;
			 public SortDetails(String string) {
				 this.string=string;
			 }

			@Override
			 public int compare(Object o1, Object o2) {
				 JSONObject json1=(JSONObject)o1;  
				 JSONObject json2=(JSONObject)o2;  
							  
				return (json1.get(string).toString().toLowerCase()).compareTo(json2.get(string).toString().toLowerCase());
			}

		}

		FileReader fileReader=null;
		Scanner scanner=new Scanner(System.in);
		
		try {
				fileReader=new FileReader(file);
				JSONParser parser=new JSONParser();
				JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
					
				boolean check=true;
				do {
					    System.out.println("Sort according to \n 1.First Name \n 2.Last Name \n 3. Address \n 4.City \n 5.State \n 6.Zip \n 7.Mobile Number  ");
						int choice=scanner.nextInt();
						switch(choice) {
								case 1 : 
									     System.out.println("Sorting according to First Names: ");
								
									     
										Collections.sort(jsonArray,new SortDetails("FirstName"));	

										 Iterator<?> nameIterator=jsonArray.iterator(); 
										 
										 while(nameIterator.hasNext()) {  
											 JSONObject json=(JSONObject)nameIterator.next();  
											 System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
												   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")		
													 );
										 	}  
										 break;
										 
								 case 2 : //Last Name sorting
								         System.out.println("Sorting according to Last Names: ");
								         
										 Collections.sort(jsonArray,new SortDetails("LastName"));	

										 Iterator<?> lastNameIterator=jsonArray.iterator();  
									
										 while(lastNameIterator.hasNext()){  
										
											 JSONObject json=(JSONObject)lastNameIterator.next();  
											 System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
													   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
												);
										 }  		 
										 break;
								 case 3: // Address sorting
									 		System.out.println("Sorting according to Address : ");
											Collections.sort(jsonArray,new SortDetails("Address"));	
											Iterator<?> addressIterator=jsonArray.iterator();  
											while(addressIterator.hasNext()){  
												JSONObject json=(JSONObject)addressIterator.next();  
												System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
															   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
													);
											}
											break;
								
							 	case 4: //City sorting
							 				System.out.println("Sorting according to City : ");
						
											Collections.sort(jsonArray,new SortDetails("City"));	

											Iterator<?> cityIterator=jsonArray.iterator();  
											while(cityIterator.hasNext()){  
												JSONObject json=(JSONObject)cityIterator.next();  
												System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
															   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
													);
											}
											break;
									
								 case 5: //State Sorting
						 					System.out.println("Sorting according to State : ");
	 					
											Collections.sort(jsonArray,new SortDetails("State"));	

											Iterator<?> stateIterator=jsonArray.iterator();  
											while(stateIterator.hasNext()){  
												JSONObject json=(JSONObject)stateIterator.next();  
												System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
															   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
													);
											}
											break;
								 case 6: //Zip sorting
					 						System.out.println("Sorting according to Zip : ");
						
											Collections.sort(jsonArray,new SortDetails("Zip"));	

											Iterator<?> zipIterator=jsonArray.iterator();  
											while(zipIterator.hasNext()){  
												JSONObject json=(JSONObject)zipIterator.next();  
												System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
															   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
													);
											}
											break;
								 case 7: // Mobile number sorting
				 							System.out.println("Sorting according to Mobile number : ");
				 						
											Collections.sort(jsonArray,new SortDetails("MobileNumber"));	

											Iterator<?> mobileNumberIterator=jsonArray.iterator();  
											while(mobileNumberIterator.hasNext()){  
												JSONObject json=(JSONObject)mobileNumberIterator.next();  
												System.out.println(json.get("FirstName")+"  "+json.get("LastName")+" "+json.get("Address")
															   +" "+json.get("City")+" "+" "+json.get("State")+" "+json.get("Zip")+" "+json.get("MobileNumber")
													);
											}
											
											break;
								 default:
									 		System.out.println("Wrong Choice :");
									 		
						}
						System.out.println("you want try again press\"Y\" else press \"N\" ");
						String ch=scanner.next().toLowerCase();
						if(ch.equals("y")) {
							check=true;
						} else {
							check=false;
						}
					}while(check);
					
				} catch ( IOException |  org.json.simple.parser.ParseException e) {
					
					e.printStackTrace();
				} finally {
					scanner.close();
				}
				
			}

	/**
	 * @param file
	 *  @author Hemanth
	 * <p>This method for displaying person details 
	 */
	public static void personDetails(File file) {
		FileReader fileReader=null;
		Scanner scanner=new Scanner(System.in);

		try {
			 	System.out.println("Enter a name want to search : ");
				String userName=scanner.nextLine();
					
				fileReader=new FileReader(file);
				JSONParser parser=new JSONParser();
				JSONArray jsonArray=(JSONArray) parser.parse(fileReader);
				Iterator<?> iterator=jsonArray.iterator();
					
				while(iterator.hasNext()) {
						
					 JSONObject jsonObject= (JSONObject) iterator.next();
					 if (jsonObject.get("FirstName").equals(userName)) {
							 
						 Iterator<?> iterator1=  jsonObject.keySet().iterator();
						 while(iterator1.hasNext()) {
								 
							 String jsonKey=(String) iterator1.next();
					    	
							 System.out.println(jsonKey+" :" +jsonObject.get(jsonKey));
							 }
						 }
					 }
				 } catch ( IOException |  org.json.simple.parser.ParseException e) {
					e.printStackTrace();
				} finally {
					scanner.close();
				}
				
			}
	//DECK OF CARD
	/**
	 * @param deck
	 * @return
	 *  @author Hemanth
	 * <p>This method for initializing array with numbers
	 */
	public static int [] initialize(int[] deck) {
			// Initialize cards
		for (int i = 0; i < deck.length; i++) {
		      deck[i] =i;
		    }
			return deck;
	}		
		
	/**
	 * @param arr
	 * @param deck
	 * @return
	 * @author Hemanth
	 * <p>This method for generating card 
	 */
	public static String[] generateCard(String[] arr, int[] deck) {
		for (int i = 0; i < 52; i++) {
		      String suit = Suits.values()[deck[i] / 13].name();
		      String rank = Ranks.values()[deck[i] % 13].name();
		      arr[i]=( rank + "->" + suit);
		 }
		return arr;
	}

	/**
	 * @param deck
	 * @param arr
	 * @author Hemanth
	 * <p> This method for shuffling cards and distribute the cards to each player
	 */
	public static void distribute(int[] deck, String[] arr) {
		String arr1[][] = new String[4][9];
         // shuffling cards
	    for (int i = 0; i < arr.length; i++) {
	           
	        // Random for remaining positions.
	    	int randomNum = ThreadLocalRandom.current().nextInt(i, 52);
	             
	        //swapping the elements
	        String temp = arr[randomNum];
	        arr[randomNum] = arr[i];
	        arr[i] = temp;
	     }
	    int cardIndex=0;
		for(int i=0;i<4;i++) {
			
			for(int j=0;j<9;j++) {	
				
				arr1[i][j] = arr[cardIndex++];
			}
		}
		for(int i=0;i<arr1.length;i++) {	
			
			System.out.print("Player"+(i+1)+": ");
			
			for(int j=0;j<arr1[i].length;j++) {
				
				System.out.print(arr1[i][j]+"\t\t");
			}
				System.out.println();
			}	
		sortedCards(arr1);
		}
	
	/**
	 * @param arr1
	 * @author Hemanth
	 * <P>This method for sort the user cards according to rank 
	 */
	public static void sortedCards(String [][] arr1) {
		System.out.println("Sorted Cards of each Player: ");
		String [][]arr=new String[4][9];
		int index=0;
		
		for(int i=0;i<4;i++) {
			//System.out.println("Player"+(i+1)+": ");

			for(int k=0;k<13;k++) {

				for(int j=0;j<9;j++) {
				
					String [] strArray=arr1[i][j].split("->");
					if(strArray[0].equals(Ranks.values()[k].name())) {
						arr[i][index]=arr1[i][j];
						index++;
					}	
					
				}
			}
			System.out.println();

			index=0;
		}
	    for ( String[]array : arr) {
	        for(String str:array) {
	        	System.out.print(str +"   ");
	        }
	        System.out.println();
	    }
	}
	/**
	 * @author Hemanth
	 * <p> This method for displaying patient details
	 */
	public static void patientDetails() 
	{
		Scanner scanner = new Scanner(System.in);

		try {
			File file = new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/Patient.json");
			
			if(file.exists()) {
				if(file.canRead() && file.canWrite()) {
					FileReader fr = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONArray array = (JSONArray) parser.parse(fr);
					Iterator<?> itr = array.iterator();
					while (itr.hasNext()) {
						JSONObject obj = (JSONObject) itr.next();				
						System.out.println("Name : "+obj.get("Name")+"\tID : "+obj.get("Id")+"\tAge : "+obj.get("Age")+"\tMob: "+obj.get("Mob"));
					}
				} else {
					System.out.println("File can't have read permissions.");
				}
			} else {
				System.out.println("File does not exits on disk.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
	}

	/**
	 * @author Hemanth
	 * <p>This method for add patient
	 */
	@SuppressWarnings("unchecked")
	public static void addPatient() {
		Scanner scanner = new Scanner(System.in);
		try {
			File file = new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/Patient.json");
			if(file.exists()) {
				if(file.canRead() && file.canWrite()) {
					FileReader filereader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONArray array = (JSONArray) parser.parse(filereader);
					JSONObject json = new JSONObject();
			        System.out.println("Enter Patient Name:");
			        String name = scanner.nextLine();
			        System.out.println("Enter Mobile number:");
			        String mob = scanner.nextLine();
			        System.out.println("Enter age:");
			        String age = scanner.nextLine();
					
			        json.put("Name",name);
			        json.put("Id", ThreadLocalRandom.current().nextInt(0, 1000));
			        json.put("Mob", mob);
			        json.put("Age", age);
			        
			        array.add(json);
			        System.out.println("Added Successfully.");
			        FileWriter fileWriter = new FileWriter(file);
			        fileWriter.write(JSONArray.toJSONString(array));
			        fileWriter.flush();
			        fileWriter.close();
					
				} else {
					System.out.println("File can't have read permissions.");
				}
			} else {
				System.out.println("File does not exits on disk.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		 } finally {
			 scanner.close();
		 }
		
	}

	/**
	 * @author Hemanth
	 * <p>This method for displaying doctors details
	 */
	public static void doctorsDetails() {
		Scanner scanner = new Scanner(System.in);

		try {
			File file = new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/Doctor.json");
			if(file.exists()) {
				if(file.canRead() && file.canWrite()) {
					FileReader fr = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONArray array = (JSONArray) parser.parse(fr);
					Iterator<?> itr = array.iterator();
					System.out.println("Enter doctor id");
					String id = scanner.nextLine();
					while (itr.hasNext()) {
						JSONObject obj = (JSONObject) itr.next();
						//System.out.println("Name : "+obj.get("Name")+"\tID : "+obj.get("Id")+"\tSpecialization : "+obj.get("Specialization")+"\t\tAvailability : "+obj.get("Availability"));
						String key = obj.get("Id").toString();
						if(key.equals(id)) {
							//System.out.println(obj.get("Patient"));
							System.out.println(obj);
						}
					}
				} else {
					System.out.println("File can't have read permissions.");
				}
			} else {
				System.out.println("File does not exits on disk.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
	}

	/**
	 * @author Hemanth
	 * <p>This method for add doctor
	 */
	@SuppressWarnings("unchecked")
	public static void addDoctor() {
		Scanner scanner = new Scanner(System.in);

		try {
			File file = new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/Doctor.json");
			if(file.exists()) {
				
				if(file.canRead() && file.canWrite()) {
					
					FileReader fr = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONArray array = (JSONArray) parser.parse(fr);
					JSONObject json = new JSONObject();
			        System.out.println("Enter Doctor Name:");
			        String name = scanner.nextLine();
			     
			        System.out.println("Enter Specialization:");
			        String specialization = scanner.nextLine();
			        System.out.println("Enter Availability:");
			        String availability = scanner.nextLine();
			        
					JSONArray patientArray = new JSONArray();

			        json.put("Name",name);
			        json.put("Id", ThreadLocalRandom.current().nextInt(0, 1000));
			        json.put("Specialization", specialization);
			        json.put("Availability", availability);
			        json.put("Patient", patientArray);
			        array.add(json);
			        System.out.println("Added Successfully.");
			        FileWriter fileWriter = new FileWriter(file);
			        fileWriter.write(JSONArray.toJSONString(array));
			        fileWriter.flush();
			        fileWriter.close();
				} else {
					System.out.println("File can't read and write");
				}
			} else {
				System.out.println("File not exits on disk.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
	}

	/**
	 * @author Hemanth
	 * <p> This method for fixing patient appointment to respective doctor
	 */
	@SuppressWarnings("unchecked")
	public static void doctorAppointment() {
		Scanner scanner = new Scanner(System.in);

	   try {
			File file = new File ("/home/bridgeit/Desktop/Hemanth_WorkSpace/Doctor.json");
			File file1 = new File ("/home/bridgeit/Desktop/Hemanth_WorkSpace/Patient.json");
			if(file.exists() && file.exists()) {
				if(file.canWrite() && file.canRead() && file1.canWrite() && file1.canRead()) {
					JSONParser parser = new JSONParser();
					FileReader doctor = new FileReader(file);
					JSONArray docArray = (JSONArray) parser.parse(doctor);
					
					FileReader patient = new FileReader(file1);
					JSONArray patArray = (JSONArray) parser.parse(patient);
					
					Iterator<?> iterator = patArray.iterator();
					System.out.println("Enter the Patient id to get appointment");
					String pid = scanner.nextLine();
					boolean flag=false;
					while (iterator.hasNext()) {
						JSONObject object = (JSONObject) iterator.next();
						String key = object.get("Id").toString();
						if (pid.equals(key)) {
							System.out.println("Enter the doctor id to assign patient");
							String did = scanner.nextLine();
							Iterator<?> iterator1 = docArray.iterator();
							
							while (iterator1.hasNext()) {
								JSONObject object1 = (JSONObject) iterator1.next();
								String key1 = object1.get("Id").toString();
								if (key1.equals(did)) {
									JSONArray array = (JSONArray) object1.get("Patient");
					
									if (array.size()>5) {
										System.out.println("Doctor appointment is full ... Take appointment next day.");
										break;
									} else {
										array.add(object);
										object1.put("Patient", array);
										FileWriter fileWriter = new FileWriter(file);
										fileWriter.write(JSONValue.toJSONString(docArray));
										fileWriter.flush();
										fileWriter.close();
										flag = true;
										break;
									}
								}
							}
							break;
						}
					} if(flag==false) {
						System.out.println("Wrong user id");
					}
				} else {
					System.out.println("File can not read or write");
				}
			} else {
				System.out.println("File Not exits in disk.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
