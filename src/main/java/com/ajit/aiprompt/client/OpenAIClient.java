package com.ajit.aiprompt.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class OpenAIClient {

    private final WebClient webClient;

    @Value("${openai.api.key}")
    private String apiKey;



    public OpenAIClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.openai.com/v1").build();
    }

    public String callAI(String prompt) {
        Map<String, Object> request = Map.of(
                "model", "gpt-3.5-turbo",
                "input", prompt
        );

        return webClient.post()
                .uri("/responses")
                .header("Authorization", "Bearer " + apiKey.trim())
                .header("Content-Type", "application/json")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}