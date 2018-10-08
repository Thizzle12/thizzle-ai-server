package com.example.thizzle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.apache.log4j.Logger;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.example")

public class ThizzleApplication {
	
	final static Logger log = Logger.getLogger(ThizzleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ThizzleApplication.class, args);
	}

}
