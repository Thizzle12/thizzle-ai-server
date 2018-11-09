package com.thizzle.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thizzle.server.ai.algorithms.AlphaBetaPruning;
import com.thizzle.server.ai.games.GameBoard;
import com.thizzle.server.ai.tictactoe.TicTacToBoard;
import com.thizzle.server.dto.requests.TicMoveRq;
import com.thizzle.server.dto.responses.TicMoveRs;

@Service
public class TicTacToeService {
	
	@Autowired
	private AlphaBetaPruning abPruning;
	
	
	public TicMoveRs computerMove(TicMoveRq playerMove) {
//		Logger log = Logger.getLogger(ThizzleApplication.class.getName());
//		for(Integer type: playerMove.getBoard()) {
//			log.error("The value of the test is: "+ type);
//		}
		
		GameBoard board = new TicTacToBoard(playerMove.getBoard());
		board.setRealBoard();
		if(board.isThereAWinner(1)) {
			TicMoveRs response = new TicMoveRs(playerMove.getBoard(), true);
			response.setWinnerIs("PLAYER");
			return response;
		}
		abPruning.alphaBetaPruning(board, 0);
		
		if(board.isThereAWinner(0)) {
			TicMoveRs response = new TicMoveRs(board.getBoard(), true);
			response.setWinnerIs("COMPUTER");
			return response;
		}
//		log.error("Is there a winner: "+ board.getWinner());
//		
//		for(Integer type: board.getBoard()) {
//			log.error("The value of the test is: "+ type);
//		}
		TicMoveRs response = new TicMoveRs(board.getBoard(), false);
		return response;
	}

}
