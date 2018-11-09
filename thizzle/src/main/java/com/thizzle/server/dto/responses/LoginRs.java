package com.thizzle.server.dto.responses;

import java.util.UUID;

import lombok.Data;

@Data

public class LoginRs {
	
	private String username;
	private UUID id;
	
	public LoginRs() {
		
	}
	
	public LoginRs(UUID id, String username) {
		this.id = id;
		this.username = username;
	}

}
