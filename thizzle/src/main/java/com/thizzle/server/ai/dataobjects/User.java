package com.thizzle.server.ai.dataobjects;

//import javax.persistence.column;
//import javax.persistence.entity;
//import javax.persistence.id;
//import javax.persistence.table;

import lombok.Data;


@Data
//@Entity
//@Table(name="users")
public class User {
	
//	@Id
	private String id;
	
//	@Column(name = "username")
	private String username; 
//	@Column(name="user_password")
	private String password;
//	@Column(name="email")
	private String email;
//	@Column(name="gender")
	private Enum gender;
//	@Column(name="yearofbirth")
	private Integer yob;
	
	
	public User(String id, String username, String password, String email, Enum gender, Integer yob) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.yob = yob;
	}

	
}
