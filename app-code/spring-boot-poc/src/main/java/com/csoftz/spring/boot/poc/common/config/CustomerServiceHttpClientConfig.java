/*----------------------------------------------------------------------------*/
/* Source File:   CustomerServiceHttpClientConfig.java                        */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.09/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.boot.poc.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.csoftz.spring.boot.poc.common.exception.MyServiceException;
import com.csoftz.spring.boot.poc.service.http.client.CustomerServiceHttpClient;

import reactor.core.publisher.Mono;

/*
https://www.baeldung.com/spring-6-http-interface
https://medium.com/digitalfrontiers/declarative-rest-clients-with-spring-framework-6-c671be1dfee
https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#rest-http-interface
 */
@Configuration
public class CustomerServiceHttpClientConfig {

    private static final String BACKEND_SERVICE_REPLIED_MSG = "Service replied with ";

    @Bean
    CustomerServiceHttpClient customerServiceHttpClient() {

        return HttpServiceProxyFactory
            .builder(
                WebClientAdapter.forClient(WebClient.builder()
                    .baseUrl("http://localhost:8500")
                    .defaultStatusHandler(
                        httpStatusCode -> HttpStatus.NOT_FOUND == httpStatusCode,
                        response -> Mono.empty()
                    )
                    .defaultStatusHandler(
                        HttpStatusCode::is5xxServerError,
                        response -> Mono.error(new MyServiceException(BACKEND_SERVICE_REPLIED_MSG + response.statusCode().value()))
                    )
                    .build())
            )
            .build()
            .createClient(CustomerServiceHttpClient.class);
    }
}
