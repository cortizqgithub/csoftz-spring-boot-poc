/*----------------------------------------------------------------------------*/
/* Source File:   CUSTOMERCONTROLLER.JAVA                                     */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.05/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.webflux.customer.svc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.csoftz.webflux.customer.svc.domain.Customer;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private List<Customer> customerList = new ArrayList<>();

    @PostMapping()
    public ResponseEntity createCustomer(@RequestBody Customer customer, UriComponentsBuilder uriBuilder) {

        if (customer.getCustomerId() == null) {
            customer.setCustomerId(UUID.randomUUID().toString());
        }
        customerList.add(customer);

        var location = uriBuilder
            .path("/api/v1/customers/{customerId}")
            .buildAndExpand(customer.getCustomerId())
            .toUri();
        return ResponseEntity.created(location)
            .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
            .body(customer);
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> retrieveCustomers() {
        return ResponseEntity.ok(customerList);
    }

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<Customer> retrieveCustomer(@PathVariable String customerId) {
        return ResponseEntity
            .ok(customerList.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst()
                .orElseGet(() -> new Customer()));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        customerList.stream()
            .filter(c -> c.getCustomerId().equals(customerId))
            .findFirst()
            .ifPresent(c -> {
                c.setFirstName(customer.getFirstName());
                c.setLastName(customer.getLastName());
                c.setAddress(customer.getAddress());
            });
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId) {
        customerList.removeIf(c -> c.getCustomerId().equals(customerId));
        return ResponseEntity.noContent().build();
    }
}
