package com.bootcamp.enterprise.active.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.logging.Logger;

@SpringBootApplication
public class LoanApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(LoanApplication.class.toString());

	@Autowired
	private Environment env;

	@Override
	public void run(String... args) throws Exception {

		//logger.log(Level.INFO, env.getProperty("spring.application.name"));
		logger.info("Java version: " + env.getProperty("java.version"));
		logger.info("Application name: " + env.getProperty("spring.application.name"));
		logger.info("Properties file upload status: " + env.getProperty("my-own-app.properties.status"));
		logger.info("Swagger: http://localhost:" + env.getProperty("server.port") +"/" + env.getProperty("springdoc.swagger-ui.path"));
	}

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}
