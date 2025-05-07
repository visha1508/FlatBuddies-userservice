package com.find.flat_buddies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.find.flat_buddies")
public class FlatBuddiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlatBuddiesApplication.class, args);
	}

}
