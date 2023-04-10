/*----------------------------------------------------------------------------*/
/* Source File:   CustomController.java                                       */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.09/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.boot.poc.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csoftz.spring.boot.poc.domain.Customer;
import com.csoftz.spring.boot.poc.service.http.client.CustomerServiceHttpClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("api/v1/client/customers")
public record CustomerController(CustomerServiceHttpClient customerServiceHttpClient) {

    @PostMapping()
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        log.info("createCustomer");
        return customerServiceHttpClient.createCustomer(customer);
    }

    @GetMapping()
    public Flux<Customer> retrieveCustomers() {
        log.info("retrieveCustomers");
        return customerServiceHttpClient.retrieveCustomers();
    }

    @GetMapping("/{customerId}")
    public Mono<Customer> retrieveCustomer(@PathVariable String customerId) {
        log.info("retrieveCustomer");
        return customerServiceHttpClient.retrieveCustomer(customerId);
    }

    @PutMapping("/{customerId}")
    public Mono<Customer> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        log.info("updateCustomer");
        return customerServiceHttpClient.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/{customerId}")
    public Mono<Void> deleteCustomer(@PathVariable String customerId) {
        log.info("deleteCustomer");
        return customerServiceHttpClient.deleteCustomer(customerId);
    }

}
