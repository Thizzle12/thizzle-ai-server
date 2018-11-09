package com.thizzle.server.dto.responses;

import  com.thizzle.server.ai.dataobjects.Gender;

import lombok.Data;

@Data
public class UserRs {

	private Integer userid;
	private String name;
	private String email;
	private String password;
	private Gender gender;
	
	
	public UserRs(Integer userid, String name, String email, String password, Gender gender) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}
	
}
