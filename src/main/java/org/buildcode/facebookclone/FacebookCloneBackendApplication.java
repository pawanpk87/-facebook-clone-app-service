package org.buildcode.facebookclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacebookCloneBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(FacebookCloneBackendApplication.class, args);
		System.out.println("App started...");
	}
}
