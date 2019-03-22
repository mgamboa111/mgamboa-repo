package com.demo.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> deck = null;
	
	public Deck() {
		
		deck = new ArrayList<Card>();
		
		for (Suite suite : Suite.values()) {
			
			for (Kind kind : Kind.values()) {
				
				deck.add(new Card(suite, kind));
				
			}
		}
		
	}
	
	public void shuffle() {
		
		Random rand = new Random();
		
		int deckSize = deck.size();
        
        for (int i = 0; i < deckSize; i++)  { 
            int r = i + rand.nextInt(deckSize - i); 
             
             Collections.swap(deck, i, r);
               
        } 
		
	}
	
	public Card dealCard() {
		
		Card card = null;
		
		if (deck.size() > 0) {
			
			card = deck.remove(deck.size() - 1);
			
		}
		
		return card;
	}
	
	public int currentDeckSize() {
		
		return deck.size();
	
	}
	
	public String toString() {
		
		StringBuilder strBuilder = new StringBuilder();
		for (Card card : deck) {
			strBuilder.append("|" + card.toString() + "|");
		}
		strBuilder.append("=" + deck.size());
		
		return strBuilder.toString();
	}
	

}
