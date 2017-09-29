package com.bridgeit.javaObjectOrientedPrograms.Programs;

import java.util.Scanner;

import com.bridgeit.javaObjectOrientedPrograms.Utility.Utility;

public class Stock {
	public static void main(String []args) {
		System.out.println("Enter Number of Stacks you want: ");
		Scanner scanner=new Scanner(System.in);

	     try {	
				int  numberOfStocks=scanner.nextInt();
			//	StockPortfolio StockPortfolio=new StockPortfolio();
				for(int i=1;i<=numberOfStocks;i++) {
					System.out.print("Enter share name: ");
					String shareName=scanner.next();
					System.out.print("Enter Number of Shares you want: ");
					String numberOfShares=scanner.next();
					System.out.print("Enter number the Share price");
					String sharePrice=scanner.next();
					
					Utility.creatingStocks(shareName,numberOfShares,sharePrice);

				}
				System.out.println();
				Utility.valueOfEachStock();
				Utility.valueOfTotalStock();
		 } catch(Exception ex) {
			System.out.println(ex);
		 } finally {
			scanner.close();
	      }
	}
}
