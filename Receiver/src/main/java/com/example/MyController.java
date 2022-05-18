package com.example;

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @SqsListener("MyQueue")
    public void getMessage(String message) {
        System.out.println("I got message from Producer " + message);
    }
}
