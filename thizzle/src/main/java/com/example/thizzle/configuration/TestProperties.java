package com.example.thizzle.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.example.thizzle.ThizzleApplication;

import org.apache.log4j.Logger;

@Configuration
@ConfigurationProperties("conf_dev_prop")
public class TestProperties {
	
	
	
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
