package com.github.openai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.openai.entity.ChatCompletionRequest;
import com.github.openai.entity.ChatCompletionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v1/chat/completions")
public class ChatCompletionController {

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public SseEmitter chatCompletion(@RequestBody ChatCompletionRequest request) throws IOException {


        log.info("request is {}", objectMapper.writeValueAsString(request));

        String json = """
                    {
                        "id": "2927",
                        "object": "chat.completion.chunk",
                        "created": 1731919127,
                        "model": "test",
                        "choices": [
                            {
                                "index": 0,
                                "delta": {
                                    "role": "assistant",
                                    "content": "什么事"
                                },
                                "logprobs": null,
                                "finish_reason": "stop"
                            }
                        ],
                        "usage": null
                    }
                """;

        ChatCompletionResponse response = objectMapper.readValue(json, ChatCompletionResponse.class);
        response.setId(UUID.randomUUID().toString());

        log.info("response is {}", objectMapper.writeValueAsString(response));

        SseEmitter.SseEventBuilder event = SseEmitter.event();
        event.data(response);

        SseEmitter emitter = new SseEmitter();
        emitter.send(event);

        return emitter;
    }
}
