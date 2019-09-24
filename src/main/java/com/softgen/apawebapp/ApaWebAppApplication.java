package com.softgen.apawebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
//extends SpringBootServletInitializer
public class ApaWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApaWebAppApplication.class, args);
	}
	/*
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ApaWebAppApplication.class);
	}
	*/
}
