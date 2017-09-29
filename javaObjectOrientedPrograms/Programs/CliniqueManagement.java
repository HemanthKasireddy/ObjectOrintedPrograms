package com.bridgeit.javaObjectOrientedPrograms.Programs;



import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.bridgeit.javaObjectOrientedPrograms.Utility.Utility;

public class CliniqueManagement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try
		{
			LinkedList<Integer> list=Utility.genearteIds();
			boolean isContinue=true;
			do {	
				System.out.println("Enter your choice:");
				System.out.println("1. Add Doctor");
				System.out.println("2. Add Patient");
				System.out.println("3. Display Details");
				System.out.println("4. Fix Appointments");
				System.out.println("5. Exit");
				int choice = scanner.nextInt();
				switch(choice) {
				case 1 :	 Utility.addDoctor(list);
							 break;
				case 2 :	Utility.addPatient(list);
							break;
				case 3 :	System.out.println("Enter whose details you want to see press D for doctor and P for Patient ");
							String ch= scanner.next().toLowerCase();
							if(ch.equals("d")) {
								Utility.doctorsDetails();
							}
							if(ch.equals("p"))
							{
								Utility.patientDetails();
							}
				break;
				case 4: 	Utility.doctorAppointment();
				break;
				default : System.out.println("Wrong choice: ");
				
				
				} 
				System.out.println("You want continue press\"Y\" else press\"N\"");
				scanner.nextLine();
				String ueserEntry=scanner.nextLine().toLowerCase();
				if(ueserEntry.equals("y")) {
					isContinue=true;
				} else {
					isContinue=false;
				}
			} while(isContinue);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
