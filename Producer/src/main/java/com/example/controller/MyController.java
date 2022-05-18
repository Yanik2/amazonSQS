package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Value("${cloud.aws.end-point-uri}")
    private String url;

    private QueueMessagingTemplate queueMessagingTemplate;

    public MyController(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    @GetMapping("/sqs")
    public void sendMessage() {
        queueMessagingTemplate.send(url, MessageBuilder.withPayload("Message from producer").build());
    }
}
