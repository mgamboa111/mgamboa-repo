package com.demo.blackjack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.blackjack.dto.GameData;
import com.demo.blackjack.game.Game;
import com.demo.blackjack.service.BlackJackService;

@RestController
public class BlackJackOperationController {
	
	@Autowired
	BlackJackService blackJackService;
	
	@RequestMapping("/startround")
	public GameData startRound(@RequestParam Long gameId, @RequestParam Long bet) {
		
		Game game = blackJackService.startRound(gameId, bet);
		
		GameData gameData = new GameData();
		gameData.setDealerHand(game.getDealer().getHand());
		gameData.setGamblerHand(game.getGambler().getHand());
		gameData.setStatus(game.getStatus());
		gameData.setGamblerMoney(game.getGambler().getMoney());
		gameData.setGamblerHandsPlayed(game.getGambler().getHandsPlayed());
		gameData.setGamblerHandsWon(game.getGambler().getHandsWon());
		return gameData;
		
	}
	
	@RequestMapping("/gamblerhit")
	public GameData gamblerHit(@RequestParam Long gameId) {
		
		Game game = blackJackService.gamblerHit(gameId);
		
		GameData gameData = new GameData();
		gameData.setDealerHand(game.getDealer().getHand());
		gameData.setGamblerHand(game.getGambler().getHand());
		gameData.setStatus(game.getStatus());
		gameData.setGamblerMoney(game.getGambler().getMoney());
		gameData.setGamblerHandsPlayed(game.getGambler().getHandsPlayed());
		gameData.setGamblerHandsWon(game.getGambler().getHandsWon());
		return gameData;
		
	}
	
	@RequestMapping("/gamblerstand")
	public GameData gamblerStand(@RequestParam Long gameId) {
		
		Game game = blackJackService.gamblerStand(gameId);
		
		GameData gameData = new GameData();
		gameData.setDealerHand(game.getDealer().getHand());
		gameData.setGamblerHand(game.getGambler().getHand());
		gameData.setStatus(game.getStatus());
		gameData.setGamblerMoney(game.getGambler().getMoney());
		gameData.setGamblerHandsPlayed(game.getGambler().getHandsPlayed());
		gameData.setGamblerHandsWon(game.getGambler().getHandsWon());
		return gameData;
		
	}
	
	

}
