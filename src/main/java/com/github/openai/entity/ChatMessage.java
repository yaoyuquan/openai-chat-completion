package com.github.openai.entity;

import lombok.Data;

@Data
public class ChatMessage {

    private String role;

    private String content;
}
