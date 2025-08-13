package com.music.search.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MusicSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicSearchApplication.class, args);
	}

}
