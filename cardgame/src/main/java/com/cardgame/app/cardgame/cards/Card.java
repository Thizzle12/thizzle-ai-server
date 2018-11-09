package com.cardgame.app.cardgame.cards;

import com.cardgame.app.cardgame.classes.ClassType;

public abstract class Card {
	
	private String name;
	
	private ClassType classType;
	
	private int manaCost;
	
	private CardRanking cardRanking;
	
	protected CardType cardType;

	public Card(String name, ClassType classType) {
		super();
		this.name = name;
		this.classType = classType;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public ClassType getClassType() {
		return this.classType;
	}
	
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	
	public int getManaCost() {
		return this.manaCost;
	}
	
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	
	public CardRanking getCardRankig() {
		return this.cardRanking;
	}
	
	public void setCardRanking(CardRanking cardRanking) {
		this.cardRanking = cardRanking;
	}
	
	
}
