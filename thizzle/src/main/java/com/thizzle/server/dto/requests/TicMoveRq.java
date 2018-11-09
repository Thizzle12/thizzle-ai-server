package com.thizzle.server.dto.requests;


public class TicMoveRq {
	
	public Integer[] getBoard() {
		return board;
	}

	public void setBoard(Integer[] board) {
		this.board = board;
	}

	public enum TileType{
		BLANK,X,O;
	}
	
	private Integer[] board;
	
	public TicMoveRq() {
		board = new Integer[9];
		for(int i = 0; i < 9; i++) {
			board[i] = 0;
		}
	}
	
	public TicMoveRq(Integer[] currentBoard) {
		board = currentBoard;
	}

}
