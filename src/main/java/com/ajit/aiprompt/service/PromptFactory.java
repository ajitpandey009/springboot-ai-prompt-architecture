package com.ajit.aiprompt.service;

import com.ajit.aiprompt.prompt.PromptTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PromptFactory {

    private final Map<String, PromptTemplate> templateMap;

    public PromptFactory(List<PromptTemplate> templates) {
        this.templateMap = templates.stream()
                .collect(Collectors.toMap(PromptTemplate::getType, t -> t));
    }

    public PromptTemplate getTemplate(String type) {
        PromptTemplate template = templateMap.get(type);
        if (template == null) {
            throw new IllegalArgumentException("Invalid prompt type: " + type);
        }
        return template;
    }
}