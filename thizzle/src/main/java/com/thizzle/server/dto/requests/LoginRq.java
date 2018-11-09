package com.thizzle.server.dto.requests;

import lombok.Data;

@Data
public class LoginRq {
	
	private String username;
	private String password;
	
	public LoginRq() {
		
	}

}
