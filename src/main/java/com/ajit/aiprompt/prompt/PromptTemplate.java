package com.ajit.aiprompt.prompt;

import java.util.Map;

public interface PromptTemplate {
    String getType();
    String generate(Map<String, Object> context);
}