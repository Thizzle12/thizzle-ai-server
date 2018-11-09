package com.thizzle.server.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thizzle.server.dto.responses.SlidingPuzzRs;
import com.thizzle.server.services.SlidingPuzzleService;


@RestController
@RequestMapping("/api/slidingpuzzle")
public class SlidingPuzzleController {
	
	@Autowired
	private SlidingPuzzleService spService;
	
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	@ResponseBody
	public HttpEntity<SlidingPuzzRs> get() {
		SlidingPuzzRs response = spService.createRandomBoard();
		return new ResponseEntity<SlidingPuzzRs>(response, HttpStatus.OK);
	}

}
