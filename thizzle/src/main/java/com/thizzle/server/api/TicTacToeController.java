package com.thizzle.server.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thizzle.server.configuration.TestProperties;
import com.thizzle.server.dto.requests.TicMoveRq;
import com.thizzle.server.dto.responses.TicMoveRs;
import com.thizzle.server.services.TicTacToeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/tictactoe")
public class TicTacToeController {
	
	@Autowired
	private  TestProperties testProps;
	
	
	@Autowired
	private TicTacToeService tttService;
	
	
	
	@RequestMapping(value="/move", method=RequestMethod.POST)
	@ResponseBody
	public HttpEntity<TicMoveRs> post(@RequestBody final TicMoveRq ticMoveRq) {
		log.info("This is a test of properties " + testProps.getTest());
		TicMoveRs response = tttService.computerMove(ticMoveRq);
		return new ResponseEntity<TicMoveRs>(response, HttpStatus.OK);
	}

}
