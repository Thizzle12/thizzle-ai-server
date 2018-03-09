package com.example.thizzle.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.thizzle.dto.responses.SlidingPuzzRs;
import com.example.thizzle.services.SlidingPuzzleService;


@RestController
@RequestMapping("/slidingpuzzle")
public class SlidingPuzzleController {
	
	@Autowired
	private SlidingPuzzleService spService;
	
	
	@RequestMapping("/new")
	@ResponseBody
	public HttpEntity<SlidingPuzzRs> getRandomBoard() {
		SlidingPuzzRs response = spService.createRandomBoard();
		return new ResponseEntity<SlidingPuzzRs>(response, HttpStatus.OK);
	}

}
