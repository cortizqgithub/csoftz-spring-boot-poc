/*----------------------------------------------------------------------------*/
/* Source File:   CUSTOMERCLIENTCONTROLLER.JAVA                               */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.05/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.cloud.resilience4j.webflux.controller;

import java.time.Duration;
import java.util.ArrayList;

import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.csoftz.spring.cloud.resilience4j.webflux.domain.Customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/client/customers")
public class CustomerController {
    private final WebClient webClient;
    private final ReactiveCircuitBreakerFactory reactiveCircuitBreakerFactory;

    @PostMapping()
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        log.info("createCustomer");
        return webClient.post()
            .uri("/api/v1/customers")
            //.header("Authorization", "Bearer MY_SECRET_TOKEN")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(Mono.just(customer), Customer.class)
            .retrieve()
            .bodyToMono(Customer.class)
            .timeout(Duration.ofMillis(10_000))
            .transform(it -> {
                ReactiveCircuitBreaker rcb = reactiveCircuitBreakerFactory.create("customer-service");
                return rcb.run(it, throwable -> Mono.just(Customer.builder().build()));
            });
    }

    @GetMapping()
    public Flux<Customer> retrieveCustomers() {
        log.info("retrieveCustomers");
        return webClient
            .get().uri("/api/v1/customers/")
            .retrieve()
            .bodyToFlux(Customer.class)
            .transform(it -> {
                ReactiveCircuitBreaker rcb = reactiveCircuitBreakerFactory.create("customer-service");
                return rcb.run(it, throwable -> Flux.fromIterable(new ArrayList<Customer>()));
            });
    }

    @GetMapping("/{customerId}")
    public Mono<Customer> retrieveCustomer(@PathVariable String customerId) {
        log.info("retrieveCustomer");
        return webClient
            .get().uri("/api/v1/customers/" + customerId)
            .retrieve()
            .bodyToMono(Customer.class)
            .transform(it -> {
                ReactiveCircuitBreaker rcb = reactiveCircuitBreakerFactory.create("customer-service");
                return rcb.run(it, throwable -> Mono.just(Customer.builder().build()));
            });
    }

    @PutMapping("/{customerId}")
    public Mono<Customer> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        log.info("updateCustomer");
        return webClient.put()
            .uri("/api/v1/customers/" + customer.getCustomerId())
            //.header("Authorization", "Bearer MY_SECRET_TOKEN")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(Mono.just(customer), Customer.class)
            .retrieve()
            .bodyToMono(Customer.class)
            .transform(it -> {
                ReactiveCircuitBreaker rcb = reactiveCircuitBreakerFactory.create("customer-service");
                return rcb.run(it, throwable -> Mono.just(Customer.builder().build()));
            });
    }

    @DeleteMapping("/{customerId}")
    public Mono<String> deleteCustomer(@PathVariable String customerId) {
        log.info("deleteCustomer");
        return webClient.delete()
            .uri("/api/v1/customers/" + customerId)
            .retrieve()
            .bodyToMono(String.class)
            .transform(it -> {
                ReactiveCircuitBreaker rcb = reactiveCircuitBreakerFactory.create("customer-service");
                return rcb.run(it, throwable -> Mono.just(customerId));
            });
    }
}
