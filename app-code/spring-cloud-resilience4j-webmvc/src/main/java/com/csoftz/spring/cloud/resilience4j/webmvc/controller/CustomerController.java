/*----------------------------------------------------------------------------*/
/* Source File:   CUSTOMERCONTROLLER.JAVA                                     */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.06/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.cloud.resilience4j.webmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csoftz.spring.cloud.resilience4j.webmvc.domain.Customer;
import com.csoftz.spring.cloud.resilience4j.webmvc.service.client.CustomerServiceFeignClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j()
@RequiredArgsConstructor
@RequestMapping("api/v1/client/customers")
public class CustomerController {
    private final CircuitBreakerFactory circuitBreakerFactory;
    private final CustomerServiceFeignClient customerServiceFeignClient;

    @PostMapping()
    public Customer createCustomer(@RequestBody Customer customer) {
        log.info("createCustomer");
        return circuitBreakerFactory.create("customer-service")
            .run(() -> customerServiceFeignClient.createCustomer(customer), throwable -> new Customer());
    }

    @GetMapping()
    public List<Customer> retrieveCustomers() {
        log.info("retrieveCustomers");
        return circuitBreakerFactory.create("customer-service")
            .run(customerServiceFeignClient::retrieveCustomers, throwable -> new ArrayList<>());
    }

    @GetMapping("/{customerId}")
    public Customer retrieveCustomer(@PathVariable String customerId) {
        log.info("retrieveCustomer");
        return circuitBreakerFactory.create("customer-service")
            .run(() -> customerServiceFeignClient.retrieveCustomer(customerId), throwable -> new Customer());
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        log.info("updateCustomer");
        return circuitBreakerFactory.create("customer-service")
            .run(() -> customerServiceFeignClient.updateCustomer(customerId, customer), throwable -> new Customer());
    }

    @DeleteMapping("/{customerId}")
    public Void deleteCustomer(@PathVariable String customerId) {
        log.info("deleteCustomer");
        return circuitBreakerFactory.create("customer-service")
            .run(() -> customerServiceFeignClient.deleteCustomer(customerId));
    }
}

