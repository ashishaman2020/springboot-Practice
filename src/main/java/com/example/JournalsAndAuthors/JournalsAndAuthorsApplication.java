package com.example.JournalsAndAuthors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JournalsAndAuthorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalsAndAuthorsApplication.class, args);
		System.out.println("Application Started");
	}

}
