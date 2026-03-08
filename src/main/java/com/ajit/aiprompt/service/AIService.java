package com.ajit.aiprompt.service;

import com.ajit.aiprompt.client.OpenAIClient;
import com.ajit.aiprompt.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AIService {

    private final PromptFactory promptFactory;
    private final OpenAIClient openAIClient;

    public AIService(PromptFactory promptFactory,
                     OpenAIClient openAIClient) {
        this.promptFactory = promptFactory;
        this.openAIClient = openAIClient;
    }

    public String process(String type, Map<String, Object> context) {
        PromptTemplate template = promptFactory.getTemplate(type);
        String prompt = template.generate(context);
        return openAIClient.callAI(prompt);
    }
}