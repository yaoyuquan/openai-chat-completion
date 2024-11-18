package com.github.openai.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ChatCompletionResponse {

    private String id;

    private String object;

    private long created;

    private String model;

    @JsonProperty("system_fingerprint")
    private String systemFingerprint;

    private List<Choice> choices;

    private Usage usage;
}
