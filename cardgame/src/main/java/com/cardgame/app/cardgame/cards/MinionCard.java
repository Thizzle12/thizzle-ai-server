package com.cardgame.app.cardgame.cards;

import com.cardgame.app.cardgame.classes.ClassType;

public class MinionCard extends Card{
	
	private int attack, deffence;
	
	private MinionType minionType;
	
	private Special special;
	
	private String specialDescription;
	
	public MinionCard(String name, ClassType classType) {
		super(name, classType);
		this.cardType = CardType.MINION;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDeffence() {
		return deffence;
	}

	public void setDeffence(int deffence) {
		this.deffence = deffence;
	}

	public MinionType getMinionType() {
		return minionType;
	}

	public void setMinionType(MinionType minionType) {
		this.minionType = minionType;
	}

	public Special getSpecial() {
		return special;
	}

	public void setSpecial(Special special) {
		this.special = special;
	}

	public String getSpecialDescription() {
		return specialDescription;
	}

	public void setSpecialDescription(String specialDescription) {
		this.specialDescription = specialDescription;
	}
	
	

}
