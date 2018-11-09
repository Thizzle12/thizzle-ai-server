package com.thizzle.server.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("conf_database")
public class DatabaseConfiguration {
	
	private String path, filedb;
	
	public String getPath() {
		return this.path;
	}
	
	public String getFiledb() {
		return this.filedb;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setFiledb(String filedb) {
		this.filedb = filedb;
	}
	
	
	

}
