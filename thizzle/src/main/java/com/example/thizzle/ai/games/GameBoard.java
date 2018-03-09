package com.example.thizzle.ai.games;

import java.util.List;

public interface GameBoard {
	public final int PLAYER = 2, COMPUTER = 1;
	
	
	public boolean isGameOver(int turn);
	public int getWinner();
	public List<Integer> getAvailableMoves();
	public void setBoardTile(int place,  int value);
	public Integer[] getBoard();
	public GameBoard copyBoard(GameBoard board);
	public void setRealBoard();
	public boolean isThereAWinner(int turn);
	
	

}
