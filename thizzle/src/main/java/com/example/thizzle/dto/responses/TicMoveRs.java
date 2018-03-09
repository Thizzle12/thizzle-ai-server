package com.example.thizzle.dto.responses;

public class TicMoveRs {
	
	
	public Integer[] board;
	
	public boolean winnerExists;
	
	public String winnerIs;
	
	public TicMoveRs(Integer[] board, boolean winnerExists) {
		this.board = board;
		this.winnerExists = winnerExists;
	}

	public Integer[] getBoard() {
		return board;
	}

	public void setBoard(Integer[] board) {
		this.board = board;
	}

	public boolean isWinnerExists() {
		return winnerExists;
	}

	public void setWinnerExists(boolean winnerExists) {
		this.winnerExists = winnerExists;
	}

	public String getWinnerIs() {
		return winnerIs;
	}

	public void setWinnerIs(String winnerIs) {
		this.winnerIs = winnerIs;
	}

	
	
	
	

}
