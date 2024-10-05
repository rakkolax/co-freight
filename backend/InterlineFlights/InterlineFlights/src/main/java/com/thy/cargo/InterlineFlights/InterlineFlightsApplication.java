package com.thy.cargo.InterlineFlights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class InterlineFlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterlineFlightsApplication.class, args);
	}

}
