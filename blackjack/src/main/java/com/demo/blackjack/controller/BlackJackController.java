package com.demo.blackjack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.blackjack.game.Game;
import com.demo.blackjack.service.BlackJackService;

@Controller
public class BlackJackController {
	
	@Autowired
	BlackJackService blackJackService;
	
	@RequestMapping("/play")
	public String play(Model model) {
		
		Game game = blackJackService.newGame(new Long(1000));
		
		model.addAttribute("gameId", game.getId());
		
		return "play";
		
	}

}
