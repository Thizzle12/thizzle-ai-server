package com.cardgame.app.cardgame.cards;

import com.cardgame.app.cardgame.classes.ClassType;

public class SpellCard extends Card{
	
	private String description;
	
	public SpellCard(String name, ClassType classType) {
		super(name, classType);
		this.cardType = CardType.SPELL;
	}
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
