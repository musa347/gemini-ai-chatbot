package com.ai.gemini_chat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GeminiChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeminiChatApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner() {
		return args -> System.out.println("🚀 App booted successfully");
	}

}

