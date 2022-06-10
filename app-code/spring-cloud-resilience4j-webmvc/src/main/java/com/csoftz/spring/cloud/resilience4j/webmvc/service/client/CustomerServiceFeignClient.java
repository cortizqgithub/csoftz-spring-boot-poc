/*----------------------------------------------------------------------------*/
/* Source File:   CUSTOMERSERVICEFEIGNCLIENT.JAVA                             */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.09/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.cloud.resilience4j.webmvc.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csoftz.spring.cloud.resilience4j.webmvc.domain.Customer;

@FeignClient(value = "customer-service", url = "http://localhost:8500")
public interface CustomerServiceFeignClient {
    @PostMapping("/api/v1/customers/")
    public Customer createCustomer(@RequestBody Customer customer);

    @GetMapping("/api/v1/customers/")
    public List<Customer> retrieveCustomers();

    @GetMapping("/api/v1/customers/{customerId}")
    public Customer retrieveCustomer(@PathVariable String customerId);

    @PutMapping("/api/v1/customers/{customerId}")
    public Customer updateCustomer(@PathVariable String customerId, @RequestBody Customer customer);

    @DeleteMapping("/api/v1/customers/{customerId}")
    public Void deleteCustomer(@PathVariable String customerId);
}
