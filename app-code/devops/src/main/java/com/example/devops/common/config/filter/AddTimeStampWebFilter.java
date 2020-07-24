/*----------------------------------------------------------------------------*/
/* Source File:   ADDTIMESTAMPWEBFILTER.JAVA                                  */
/* Description:   Web Filter in Reactive stack.                               */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Jan.23/2020                                                 */
/* Last Modified: Jul.24/2020                                                 */
/* Version:       1.2                                                         */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.23/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.common.config.filter;

import java.time.LocalDateTime;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * <p>Web Filter in Reactive stack.
 * <a href="https://www.baeldung.com/spring-response-header">
 * How to Set a Header on a Response with Spring 5</a></p>
 *
 * <p>Adds a TimeStamp header to all responses.</p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Jul.24/2020
 * @since 11 (JDK), Jan.23/2020
 */
@Component
@Slf4j
@Order(1)
public class AddTimeStampWebFilter implements WebFilter {
    private static final String X_TIME_STAMP_HDR = "X-time-stamp";
    private static final String PROCESSED_HEADER_INCLUDED = "Executing filter to add Timestamp of request being processed!!! Header included {}";

    /**
     * Adds a TimeStamp header to all responses.
     *
     * @param exchange Represents the web/client execution model.
     * @param chain    Connects to other filters in a row.
     * @return A Mono indicating it is a process which adds a header to client request.
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        log.debug(PROCESSED_HEADER_INCLUDED, X_TIME_STAMP_HDR);
        exchange.getResponse()
            .getHeaders()
            .add(X_TIME_STAMP_HDR, LocalDateTime.now().toString());
        return chain.filter(exchange);
    }
}
