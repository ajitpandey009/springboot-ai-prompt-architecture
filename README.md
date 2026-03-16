# Spring Boot AI Prompt Architecture

A clean backend architecture for integrating AI prompts using **Spring Boot and SOLID principles**.

This project demonstrates how to build maintainable AI integrations in real backend systems.

---

## Features

- Spring Boot AI integration
- Clean layered architecture
- Extensible prompt templates
- OpenAI Responses API integration
- Secure API key configuration

---

## Architecture

Client Request → Controller → Service → OpenAI Client → OpenAI API

---

## Tech Stack

- Java
- Spring Boot
- WebClient
- OpenAI API
- Maven

---

## Running the Application

Start the server:
mvn spring-boot:run
Application runs at:
http://localhost:8080
---

## Example API Call
curl -X POST http://localhost:8080/ai/summary 
-H “Content-Type: application/json” 
-d ‘{“text”:“AI is transforming backend architecture.”}’
---

## API Key Setup

Never store API keys in code.

Set environment variable:
export OPENAI_API_KEY=your_api_key
Then in `application.yml`:

openai:
api:
key: ${OPENAI_API_KEY}

---

## Author

Ajit Pandey  
Java | Spring Boot | AI Integration
