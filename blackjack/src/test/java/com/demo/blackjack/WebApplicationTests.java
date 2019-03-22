package com.demo.blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.blackjack.cards.Card;
import com.demo.blackjack.cards.Deck;
import com.demo.blackjack.cards.Kind;
import com.demo.blackjack.cards.Suite;
import com.demo.blackjack.players.Dealer;
import com.demo.blackjack.players.Hand;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void setupDeck() {
		
		Deck deck = new Deck();
		
		System.out.println(deck.toString());
		
		assertEquals(52, deck.currentDeckSize());
		
		deck.shuffle();
		
		System.out.println(deck.toString());
		
		assertEquals(52, deck.currentDeckSize());
		
	}
	
	@Test
	public void setupDealing() {
		
		Dealer dealer = new Dealer();
		
		dealer.shuffle();
		
		System.out.println(dealer.getDeck().toString());
		
		dealer.getHand().addCard(dealer.dealCard(), false);
		dealer.getHand().addCard(dealer.dealCard());
		
		System.out.println(dealer.getHand().toString());
		System.out.println(dealer.getHand().value());
		
		assertEquals(2, dealer.getHand().getCards().size());
		
	}
	
	@Test
	public void checkAces() {
		
		Hand hand = new Hand();
		hand.addCard(new Card(Suite.DIAMOND, Kind.KING));
		hand.addCard(new Card(Suite.DIAMOND, Kind.TEN));
		hand.addCard(new Card(Suite.DIAMOND, Kind.ACE));
		
		System.out.println(hand.value());
		assertEquals(21, hand.value());
		
		Hand hand2 = new Hand();
		hand2.addCard(new Card(Suite.DIAMOND, Kind.KING));
		hand2.addCard(new Card(Suite.DIAMOND, Kind.ACE));
		
		System.out.println(hand2.value());
		assertEquals(21, hand2.value());
		
		Hand hand3 = new Hand();
		hand3.addCard(new Card(Suite.DIAMOND, Kind.NINE));
		hand3.addCard(new Card(Suite.DIAMOND, Kind.ACE));
		hand3.addCard(new Card(Suite.HEART, Kind.ACE));
		
		System.out.println(hand3.value());
		assertEquals(21, hand3.value());
		
	}
}