package com.demo.blackjack.players;

import com.demo.blackjack.cards.Card;

public class Gambler extends Player {
	
	private long money;
	
	private long startMoney;
	
	public Gambler(long startMoney) {
		
		super();
		
		this.startMoney = startMoney;
		this.money = startMoney;
		
	}
	
	public boolean hit(Card card) {
		
		boolean busted = false;
		
		hand.addCard(card);
		
		if (hand.value() > 21) {
			
			busted = true;
			
		}
		
		return busted;
		
	}
	
	public long updateMoney(long bet) {
		
		money = money + bet;
		
		handsPlayed = handsPlayed + 1;
		if (bet > 0) {
			handsWon = handsWon + 1;
		}
		
		return money;
		
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public long getStartMoney() {
		return startMoney;
	}

	public void setStartMoney(long startMoney) {
		this.startMoney = startMoney;
	}

}
