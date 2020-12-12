/*----------------------------------------------------------------------------*/
/* Source File:   MESSAGECONTROLLER.JAVA                                      */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.api.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.devops.domain.Message;

import reactor.core.publisher.Mono;

/**
 * REST Api for Message end-points.
 * <p><b>NOTE:</b>This controller uses Spring WebFlux, this means it is reactive.</p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.3, Dec.12/2020
 * @since 11 (JDK), Mar.01/2019
 */
@RestController
@RequestMapping("/api/v1/msg")
public class MessageController {

    private static final String JDK_ZULU_11_USED = "JDK Zulu 11 Used";
    private static final String MSG_GENERATED = "Generated";

    /**
     * Says a message to the world.
     * <p>
     * GET /api/v1/msg/say
     * </p>
     *
     * @return A single Message via Reactor Mono
     */
    @GetMapping("/say")
    public Mono<Message> sayMessage() {
        LocalDateTime now = LocalDateTime.now();
        return Mono
            .just(
                Message.builder()
                    .dateTime(now)
                    .msg(String.format("%s -> %s - %s", JDK_ZULU_11_USED, MSG_GENERATED, now.toString()))
                    .build());
    }
}
