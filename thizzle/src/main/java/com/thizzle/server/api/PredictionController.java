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

import com.thizzle.server.dto.requests.PredictNumberRq;
import com.thizzle.server.dto.responses.PredictNumberRs;
import com.thizzle.server.services.PredictionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/preditction")
public class PredictionController {
	
	@Autowired
	private PredictionService predictionService;
	

	@RequestMapping(value="/predictNumber", method = RequestMethod.POST)
	@ResponseBody
	public HttpEntity<PredictNumberRs> post(@RequestBody final PredictNumberRq predictNumberRq) {
		
		log.error("The height of the canvas is: "+ predictNumberRq.getCanvasHeight());
		predictionService.transformToImgMatrix(predictNumberRq);
		PredictNumberRs response = new PredictNumberRs();
		response.setRespone("Well Done");
		
		return new ResponseEntity<PredictNumberRs>(response, HttpStatus.OK);
	}

}
