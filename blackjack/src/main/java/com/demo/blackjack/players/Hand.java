package com.demo.blackjack.players;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.demo.blackjack.cards.Card;
import com.demo.blackjack.cards.Kind;

public class Hand {
	
	private ArrayList<Card> cards = null;
	
	public Hand() {
		
		cards = new ArrayList<Card>();
		
	}
	
	public ArrayList<Card> getCards() {
		
		return cards;
		
	}

	public void addCard(Card card) {
		
		addCard(card, true);
		
	}
	
	public void addCard(Card card, boolean show) {
		
		card.setShow(show);
		cards.add(card);
		
	}
	
	public int value() {
		
		int value = cards.stream().collect(Collectors.summingInt(x -> x.getKind().getValue()));
		
		if (value > 21) {
			
			// Check if any Ace's that can be made to have value of one
			for (Card card : cards) {
				
				if (card.getKind() == Kind.ACE) {
					
					value = value - 10;
					if (value <= 21) {
						break;
					}
					
				}
				
			}
		}
		
		return value;
	}
	
	public void clear() {
		
		cards.clear();
		
	}
	
	public String toString() {
		
		StringBuilder strBuilder = new StringBuilder();
		for (Card card : cards) {
			strBuilder.append("|" + card.toString() + "|");
		}
		strBuilder.append("=" + cards.size());
		
		return strBuilder.toString();
	}

}
