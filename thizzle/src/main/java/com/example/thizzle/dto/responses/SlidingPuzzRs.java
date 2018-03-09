package com.example.thizzle.dto.responses;

public class SlidingPuzzRs {
	
	private Integer[][] board;
	
	public SlidingPuzzRs() {
		board = new Integer[4][4];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	

	public Integer[][] getBoard() {
		return board;
	}

	public void setBoard(Integer[][] board) {
		this.board = board;
	}
	
	

}
