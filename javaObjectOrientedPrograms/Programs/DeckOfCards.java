package com.bridgeit.javaObjectOrientedPrograms.Programs;

import com.bridgeit.javaObjectOrientedPrograms.Utility.Utility;

public class DeckOfCards {
	public static void main(String[] args) 
	{   
		
		int[] deck = new int[52];
		String[] arr= new String[52];
		int []cardsArray=Utility.initialize(deck);
		String[] shuffleCardsArray=Utility.generateCard(arr,cardsArray);
		Utility.distribute(deck,shuffleCardsArray);
	}
}
