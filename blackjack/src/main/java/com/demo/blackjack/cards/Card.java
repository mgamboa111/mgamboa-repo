package com.demo.blackjack.cards;

public class Card {
	
	private Suite suite;
	
	private Kind kind;
	
	private boolean show = true;
	
	public Card(Suite suite, Kind kind) {
		this(suite, kind, true);
	}
	
	public Card(Suite suite, Kind kind, boolean show) {
		this.suite = suite;
		this.kind = kind;
		this.show = show;
	}

	public Suite getSuite() {
		return suite;
	}

	public void setSuite(Suite suite) {
		this.suite = suite;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}
	
	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public String toString() {
		
		return kind.name() + "-" + suite.name();
	}

}
