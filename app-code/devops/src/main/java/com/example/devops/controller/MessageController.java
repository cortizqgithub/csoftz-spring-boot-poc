package com.example.devops.controller;

import com.example.devops.domain.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/msg")
public class MessageController {

    @GetMapping("/say")
    public Mono<Message> sayMessage() {
        var s = "JDK Zulu 11 Used";
        Message msg = new Message();
        msg.setDateTime(LocalDateTime.now());
        msg.setMsg(String.format("%s -> %s - %s", s, "Generated", msg.getDateTime().toString()));
        return Mono.just(msg);
    }
}
