package com.example.thizzle.dto.responses;

public class UserRs {
	
	public enum Gender{
		MALE,FEMALE;
	}
	
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
	
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	

}
