/*----------------------------------------------------------------------------*/
/* Source File:   HEADERCONTEXTFILTER.JAVA                                    */
/* Description:   Web Filter in Reactive stack.                               */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Jan.23/2020                                                 */
/* Last Modified: Jan.23/2020                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.23/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.config.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

/**
 * <p>Web Filter in Reactive stack.
 * <a href="https://java-focus.com/pass-header-to-reactive-webclient-spring-webflux/">
 * Pass header to reactive webclient – Spring webflux</a></p>
 *
 * <p>This filter adds all request headers to all the WebClient requests.</p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Jan.23/2020
 * @since 11 (JDK), Jan.23/2020
 */
@Component
@Order(3)
public class HeaderContextFilter implements WebFilter {

    /**
     * Adds all request headers to be available to any WebClient.
     *
     * @param exchange Represents the web/client execution model.
     * @param chain    Connects to other filters in a row.
     * @return A Mono indicating it is a process which adds a header to client request.
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return chain
            .filter(exchange)
            .subscriberContext(context -> {
                context = context.put("headers",
                    exchange.getRequest()
                        .getHeaders()
                        .toSingleValueMap()
                );
                return context;
            });
    }
}
