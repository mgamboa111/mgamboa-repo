package com.demo.blackjack.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.blackjack.game.Game;

@Service
public class BlackJackService {
	
	private static long idSequence = 1;
	
	private static Map<Long, Game> games = new HashMap<Long, Game>();
	
	public Game newGame(Long gamblerStartingMoney) {
		
		Long id = new Long(idSequence);
		idSequence++;
		
		Game game = new Game(id, gamblerStartingMoney);
		
		games.put(id, game);
		
		return game;
		
	}
	
	public Game startRound(Long gameId, Long bet) {
		
		Game game = games.get(gameId);
		game.startRound(bet);
		
		game.setStatus("Playing");
		
		return game;
		
	}
	
	public Game gamblerHit(long gameId) {
		
		Game game = games.get(gameId);
		
		if (!game.getGambler().isStand() && game.getStatus().equals("Playing")) {
			
			if (game.gamblerHit()) gamblerBusted(game);
			
		}
		
		return game;
	}
	
	public Game gamblerStand(Long gameId) {
		
		Game game = games.get(gameId);
		game.gamblerStand();
		
		game = dealerHitOrStand(gameId);
		
		game = winner(gameId);
		
		return game;
	}
	
	public Game dealerHitOrStand(Long gameId) {
		
		Game game = games.get(gameId);
		
		if (game.getGambler().isStand()) {
			
			if (game.getDealer().hitOrStand(game.getGambler())) dealerBusted(game);
			
		}
		
		return game;
		
	}
	
	private void dealerBusted(Game game) {
		
		game.getGambler().updateMoney(game.getRoundBet());
		
		game.setStatus("Gambler wins");
		
	}
	
	private void gamblerBusted(Game game) {
		
		game.getGambler().updateMoney(game.getRoundBet() * -1);
		
		game.setStatus("Dealer wins");
		
	}
	
	public Game winner(Long gameId) {
		
		Game game = games.get(gameId);
		
		if ((game.getDealer().isStand()) && (game.getGambler().isStand())) {
			
			int result = game.compareHands();
			
			// greater than or equal dealer wins, less than gambler wins
			if (result >= 0) {
				// Dealer wins
				game.getGambler().updateMoney(game.getRoundBet() * -1);
				game.setStatus("Dealer wins");
			} else {
				// Gambler wins
				game.getGambler().updateMoney(game.getRoundBet());
				game.setStatus("Gambler wins");
			}
		
		}
		
		return game;
		
	}
	

}
