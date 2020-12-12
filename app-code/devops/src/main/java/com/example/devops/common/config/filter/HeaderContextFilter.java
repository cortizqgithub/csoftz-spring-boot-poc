/*----------------------------------------------------------------------------*/
/* Source File:   HEADERCONTEXTFILTER.JAVA                                    */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.23/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.common.config.filter;

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
 * @version 1.4, Dec.12/2020
 * @since 11 (JDK), Jan.23/2020
 */
@Component
@Order(3)
public class HeaderContextFilter implements WebFilter {

    private static final String HEADERS = "headers";

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
            .subscriberContext(ctx -> {
                ctx = ctx.put(HEADERS,
                    exchange.getRequest()
                        .getHeaders()
                        .toSingleValueMap()
                );
                return ctx;
            });
    }
}
