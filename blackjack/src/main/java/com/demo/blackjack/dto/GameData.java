package com.demo.blackjack.dto;

import com.demo.blackjack.players.Hand;

public class GameData {
	
	private Hand dealerHand = null;
	
	private Hand gamblerHand = null;

	private String status = null;
	
	private Long gamblerMoney = null;
	
	private Integer gamblerHandsPlayed = null;
	
	private Integer gamblerHandsWon = null;

	public Hand getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(Hand dealerHand) {
		this.dealerHand = dealerHand;
	}

	public Hand getGamblerHand() {
		return gamblerHand;
	}

	public void setGamblerHand(Hand gamblerHand) {
		this.gamblerHand = gamblerHand;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getGamblerMoney() {
		return gamblerMoney;
	}

	public void setGamblerMoney(Long gamblerMoney) {
		this.gamblerMoney = gamblerMoney;
	}

	public Integer getGamblerHandsPlayed() {
		return gamblerHandsPlayed;
	}

	public void setGamblerHandsPlayed(Integer gamblerHandsPlayed) {
		this.gamblerHandsPlayed = gamblerHandsPlayed;
	}

	public Integer getGamblerHandsWon() {
		return gamblerHandsWon;
	}

	public void setGamblerHandsWon(Integer gamblerHandsWon) {
		this.gamblerHandsWon = gamblerHandsWon;
	}

}
