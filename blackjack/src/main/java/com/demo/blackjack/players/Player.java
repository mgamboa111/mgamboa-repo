package com.demo.blackjack.players;

public abstract class Player {
	
	protected Hand hand;
	
	protected boolean stand;
	
	protected int handsPlayed = 0;
	
	protected int handsWon = 0;
	
	public Player() {
		
		hand = new Hand();
		
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public boolean isStand() {
		return stand;
	}

	public void setStand(boolean stand) {
		this.stand = stand;
	}

	public int getHandsPlayed() {
		return handsPlayed;
	}

	public void setHandsPlayed(int handsPlayed) {
		this.handsPlayed = handsPlayed;
	}

	public int getHandsWon() {
		return handsWon;
	}

	public void setHandsWon(int handsWon) {
		this.handsWon = handsWon;
	}

}
