package com.ai.gemini_chat;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping("/api/qna")
public class AIController {

    private final QnAService qnAService;

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String, String> payload){
        String question = payload.get("question");
        log.info("question: {}", question);
        String answer = qnAService.getAnswer(question);
        log.info("answer: {}", answer);
        return ResponseEntity.ok(answer);
    }
}
