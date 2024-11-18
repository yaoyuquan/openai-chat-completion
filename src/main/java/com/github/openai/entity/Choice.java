package com.github.openai.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Choice {

    private int index;

    private ChatMessage delta;

    private Integer logprobs;

    @JsonProperty("finish_reason")
    private String finishReason;
}
