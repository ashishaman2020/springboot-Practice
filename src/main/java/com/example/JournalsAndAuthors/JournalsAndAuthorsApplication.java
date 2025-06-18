package com.example.JournalsAndAuthors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class JournalsAndAuthorsApplication {

	private static final Logger logger = LoggerFactory.getLogger("logger");

	public static void main(String[] args) {
		SpringApplication.run(JournalsAndAuthorsApplication.class, args);
		logger.info("Application Started");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
