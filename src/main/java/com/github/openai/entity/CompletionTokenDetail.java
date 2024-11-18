package com.github.openai.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CompletionTokenDetail {

    @JsonProperty("reasoning_tokens")
    private int reasoningTokens;

    @JsonProperty("accepted_prediction_tokens")
    private int acceptedPredictionTokens;

    @JsonProperty("rejected_prediction_tokens")
    private int rejectedPredictionTokens;
}
