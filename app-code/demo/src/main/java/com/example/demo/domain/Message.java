package com.example.demo.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {
    private LocalDateTime dateTime;
    private String msg;
}
