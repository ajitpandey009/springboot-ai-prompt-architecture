package com.ajit.aiprompt.prompt;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class SummaryPromptTemplate implements PromptTemplate {

    @Override
    public String getType() {
        return "summary";
    }

    @Override
    public String generate(Map<String, Object> context) {
        String text = (String) context.get("text");
        return "Summarize the following text in 3 bullet points:\n" + text;
    }
}