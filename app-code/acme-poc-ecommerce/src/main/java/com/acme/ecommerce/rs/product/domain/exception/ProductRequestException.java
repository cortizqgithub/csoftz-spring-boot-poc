/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTREQUESTEXCEPTON.JAVA                                 */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.product.domain.exception;

/**
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
public class ProductRequestException extends RuntimeException {

    public ProductRequestException(String message) {
        super(message);
    }
}
