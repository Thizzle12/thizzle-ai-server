package com.thizzle.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thizzle.server.configuration.TestProperties;
import com.thizzle.server.dto.requests.LoginRq;
import com.thizzle.server.dto.requests.UserInfoRq;
import com.thizzle.server.dto.responses.LoginRs;
import com.thizzle.server.dto.responses.UserCreatedRs;
import com.thizzle.server.dto.responses.UserRs;
import com.thizzle.server.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TestProperties configs;
	
	
	
	@ResponseBody
	@RequestMapping(value="", method=RequestMethod.GET)
	public HttpEntity<UserRs> sayThings() {
		return new ResponseEntity<UserRs>(userService.getUser(), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public HttpEntity<UserRs> get(@PathVariable("id") String id) {
		UserRs response = userService.getUserViaId(id);
		return new ResponseEntity<UserRs>(response, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="", method=RequestMethod.POST)
	public HttpEntity<UserCreatedRs> create(@RequestBody final UserInfoRq userInfoRq){
		log.info("Creating user with id: " + userInfoRq.getId());
		UserCreatedRs response = new UserCreatedRs();
		try {
			response.setResponseString(userService.createUser(userInfoRq));
			return new ResponseEntity<UserCreatedRs>(response, HttpStatus.OK);
		}catch(Exception e) {
			response.setResponseString("Failed");
			return new ResponseEntity<UserCreatedRs>(response, HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public HttpEntity<LoginRs> login(@RequestBody final LoginRq loginRq){
		
		LoginRs response = userService.getLoginInfo(loginRq);
		
		
		return new ResponseEntity<LoginRs>(response, HttpStatus.OK);
		
	}

}
