/*----------------------------------------------------------------------------*/
/* Source File:   CUSTOMER.JAVA                                               */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.05/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.boot.poc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String address;
}
