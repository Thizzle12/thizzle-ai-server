package com.example.thizzle.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.thizzle.ThizzleApplication;
import com.example.thizzle.dto.responses.SlidingPuzzRs;

@Service
public class SlidingPuzzleService {
	
	public SlidingPuzzRs createRandomBoard() {
		SlidingPuzzRs newBoard = new SlidingPuzzRs();
		newBoard.setBoard(randomizeBoard());
		
		return newBoard;
		
	}
	
	public Integer[][] randomizeBoard(){
		Logger log = Logger.getLogger(ThizzleApplication.class.getName());
		List<Integer> boardNumbers = new ArrayList<>();
		for (int i = 0; i < 16; i++) {
			boardNumbers.add(i);
		}
//		log.info("size of board " + boardNumbers.size());
		int idx = 0;
		Collections.shuffle(boardNumbers);
		Integer[][] board = new Integer[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
//				log.info("The value of idx before is: " + idx);
				board[i][j] = boardNumbers.get(idx);
				idx++;
//				log.info("The value of idx after is: " + idx);
			}
		}
		return board;
	}

}
