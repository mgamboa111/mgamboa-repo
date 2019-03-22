package com.demo.blackjack.players;

import com.demo.blackjack.cards.Card;
import com.demo.blackjack.cards.Deck;

public class Dealer extends Player {
	
	private Deck deck = null;
	
	public Dealer() {
		
		super();
		
		deck = new Deck();
		
	}

	public void shuffle() {
		
		deck.shuffle();
		
	}
	
	public Card dealCard() {
		
		Card card = null;
		
		if (deck.currentDeckSize() > 0) {
			
			card = deck.dealCard();
		
		} else {
			
			// Out of cards in this deck.  Create new deck, shuffle and deal card.
			
			deck = new Deck();
			
			shuffle();
			
			card = deck.dealCard();
			
		}
		
		return card;
		
	}
	
	public void showDownCard() {
		
		// First card will be down card
		hand.getCards().get(0).setShow(true);
		
	}
	
	public boolean hitOrStand(Gambler gambler) {
		
		boolean busted = false;
		
		int opponentValue = gambler.getHand().value();
		
		while (hand.value() < opponentValue) {
			
			hand.addCard(dealCard());
			
		}

		if (hand.value() <= 21) {
			stand = true;
		} else {
			busted = true;
		}
		
		return busted;
		
	}
	
	public Deck getDeck() {
		
		return deck;
		
	}

	public void setDeck(Deck deck) {
		
		this.deck = deck;
		
	}
	
}
