package com.example.thizzle.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.thizzle.configuration.TestProperties;
import com.example.thizzle.dto.responses.UserRs;
import com.example.thizzle.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TestProperties configs;

	
	
	@ResponseBody
	@RequestMapping("")
	public HttpEntity<UserRs> sayThings() {
		return new ResponseEntity<UserRs>(userService.getUser(), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping("/{id}")
	public HttpEntity<UserRs> getUser(@PathVariable("id") String id) {
		UserRs response = userService.getUserViaId(id);
		return new ResponseEntity<UserRs>(response, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="", method=RequestMethod.POST)
	public HttpEntity<String> createSomething() {
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="", method=RequestMethod.POST)
	public HttpEntity<UserRs> create(){
		UserRs response = new UserRs();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
