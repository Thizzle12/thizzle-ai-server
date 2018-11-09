package com.thizzle.server.dto.responses;

import lombok.Data;

@Data
public class TicMoveRs {
	
	
	public Integer[] board;
	
	public boolean winnerExists;
	
	public String winnerIs;
	
	public TicMoveRs(Integer[] board, boolean winnerExists) {
		this.board = board;
		this.winnerExists = winnerExists;
	}

}
