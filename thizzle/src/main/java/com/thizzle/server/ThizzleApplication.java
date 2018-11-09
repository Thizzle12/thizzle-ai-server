package com.thizzle.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.thizzle")

@Slf4j
public class ThizzleApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(ThizzleApplication.class, args);
	}
}
