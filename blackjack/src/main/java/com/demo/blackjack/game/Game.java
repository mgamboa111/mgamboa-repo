package com.demo.blackjack.game;

import com.demo.blackjack.players.Dealer;
import com.demo.blackjack.players.Gambler;

public class Game {
	
	private Long id = null;
	
	private Dealer dealer = null;
	
	private Gambler gambler = null;
	
	private Long roundBet = null;
	
	private String status = null;
	
	public Game(Long id, Long gamblerStartingMoney) {
		
		this.id = id;
		
		dealer = new Dealer();
		gambler = new Gambler(gamblerStartingMoney);
		
		dealer.getDeck().shuffle();
		
	}
	
	public void startRound(Long bet) {
		
		roundBet = bet;
		
		// Clear both dealer and gambler hands.
		dealer.getHand().clear();
		gambler.getHand().clear();
		
		// Deal order can be modified at this stage.
		
		// Deal to dealer, one card showing and one card hidden
		dealer.getHand().addCard(dealer.dealCard(), false);
		dealer.getHand().addCard(dealer.dealCard());
		
		// Deal to gamber both showing
		gambler.getHand().addCard(dealer.dealCard());
		gambler.getHand().addCard(dealer.dealCard());
		
	}
	
	public boolean gamblerHit() {
		return gambler.hit(dealer.dealCard());
	}
	
	public void gamblerStand() {
		
		gambler.setStand(true);
		
	}
	
	public int compareHands() {
		
		// greater than or equal 0 dealer wins, less than 0 gambler wins
		return dealer.getHand().value() - gambler.getHand().value();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Gambler getGambler() {
		return gambler;
	}

	public void setGambler(Gambler gambler) {
		this.gambler = gambler;
	}

	public Long getRoundBet() {
		return roundBet;
	}

	public void setRoundBet(Long roundBet) {
		this.roundBet = roundBet;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
