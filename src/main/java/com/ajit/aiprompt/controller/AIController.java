package com.ajit.aiprompt.controller;

import com.ajit.aiprompt.service.AIService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ai")
@CrossOrigin
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/{type}")
    public String process(@PathVariable String type,
                          @RequestBody Map<String, Object> body) {
        return aiService.process(type, body);
    }
}