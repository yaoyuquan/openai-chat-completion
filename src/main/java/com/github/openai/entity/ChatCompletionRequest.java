package com.github.openai.entity;

import lombok.Data;

import java.util.List;

@Data
public class ChatCompletionRequest {

    /**
     * gpt-3.5-turbo
     */
    private String model;

    private List<ChatMessage> messages;

    private boolean stream;
}
