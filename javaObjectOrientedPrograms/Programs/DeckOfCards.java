package com.bridgeit.javaObjectOrientedPrograms.Programs;

import com.bridgeit.javaObjectOrientedPrograms.Utility.Utility;

public class DeckOfCards {
	public enum Suit {
	    SPADES,
	    HEARTS,
	    DIAMONDS,
	    CLUBS;
	}
	public enum Ranks { Ace, Two, Three, Four, Five, six, seven, eight, nine, ten, Jack, Queen, King } 

	public static void main(String[] args) 
	{   
		
		int[] deck = new int[52];
		String[] arr= new String[52];
		
		//String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		//String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		int []cardsArray=Utility.initialize(deck);
	//	int []cardsArray=Utility.shuffleCards(deck);
		String[] shuffleCardsArray=Utility.generateCard(arr,cardsArray);
		Utility.distribute(deck,shuffleCardsArray);
	}
}
