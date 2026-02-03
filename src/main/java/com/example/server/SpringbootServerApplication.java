package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringbootServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServerApplication.class, args);
	}

}
