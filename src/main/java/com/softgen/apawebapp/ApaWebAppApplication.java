package com.softgen.apawebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApaWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApaWebAppApplication.class, args);
	}

}
