package com.ai.gemini_chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/qna")
public class AIController {

    private final QnAService qnAService;

    @PostMapping(value = "/ask", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> askQuestion(@RequestBody Map<String, String> payload) {
        String question = payload.get("question");

        if (question == null || question.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Question cannot be empty");
        }

        log.info("Received question: {}", question);

        try {
            String response = qnAService.getAnswer(question);
            log.info("Successfully processed request");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error processing request", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed to process request: " + e.getMessage()
            );
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        log.error("Unhandled exception", e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", e.getMessage()));
    }
}