package com.bridgeit.javaObjectOrientedPrograms.Programs;

import java.util.Scanner;

import com.bridgeit.javaObjectOrientedPrograms.Utility.Utility;

public class RegularExpression {
	public static void main(String[] args) {
		String message="Hello <<name>>, We have your full name as <<full name>> in our system."
				+ " your contact number is 91-xxxxxxxxxx."
				+ " Please,let us know in case of any clarification"
				+ " Thank you BridgeLabz 01/01/2016.";
		
		Scanner scanner=new Scanner(System.in);
		try {
				System.out.println("Enter your Full name like First Name and Last Name: ");
				String name=scanner.nextLine();
				System.out.println("Enter your mobile number: ");
				String mobileNumber=scanner.nextLine();
				Utility.finalString(message,name,mobileNumber);
				
		} catch(Exception ex){
			ex.getMessage();
		} finally {
			scanner.close();
		}
	}
	

	
}
