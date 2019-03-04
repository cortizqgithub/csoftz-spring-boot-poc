package com.example.demo.controller;

import com.example.demo.domain.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/msg")
public class MessageController {

    @GetMapping("/say")
    public Message sayMessage() {
        var s = "JDK Zulu 11 Used";
        Message msg = new Message();
        msg.setDateTime(LocalDateTime.now());
        msg.setMsg(String.format("%s -> %s - %s", s, "Generated", msg.getDateTime().toString()));
        return msg;
    }
}
