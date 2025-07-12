package com.ai.gemini_chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/")
    public String hello() {
        return "✅ Spring Boot is running!";
    }
}
