package com.example.thizzle.api;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.thizzle.ThizzleApplication;
import com.example.thizzle.dto.requests.TicMoveRq;
import com.example.thizzle.dto.responses.TicMoveRs;
import com.example.thizzle.services.TicTacToeService;

@RestController
@RequestMapping("/tic")
public class TicTacToeController {
	
	@Autowired
	private TicTacToeService tttService;
	
	
	@RequestMapping("/move")
	@ResponseBody
	public HttpEntity<TicMoveRs> solveTicTacToeGame(@RequestBody final TicMoveRq ticMoveRq) {
		Logger log = Logger.getLogger(ThizzleApplication.class.getName());
		TicMoveRs response = tttService.computerMove(ticMoveRq);
		return new ResponseEntity<TicMoveRs>(response, HttpStatus.OK);
	}

}
