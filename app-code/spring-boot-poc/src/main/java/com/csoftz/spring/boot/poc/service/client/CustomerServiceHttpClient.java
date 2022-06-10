/*----------------------------------------------------------------------------*/
/* Source File:   CUSTOMSERVICEHTTPCLIENT.JAVA                                */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.09/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.boot.poc.service.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import com.csoftz.spring.boot.poc.domain.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerServiceHttpClient {
    @PostExchange("/api/v1/customers/")
    public Mono<Customer> createCustomer(@RequestBody Customer customer);

    @GetExchange("/api/v1/customers/")
    public Flux<Customer> retrieveCustomers();

    @GetExchange("/api/v1/customers/{customerId}")
    public Mono<Customer> retrieveCustomer(@PathVariable String customerId);

    @PutExchange("/api/v1/customers/{customerId}")
    public Mono<Customer> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer);

    @DeleteExchange("/api/v1/customers/{customerId}")
    public Mono<Void> deleteCustomer(@PathVariable String customerId);
}
