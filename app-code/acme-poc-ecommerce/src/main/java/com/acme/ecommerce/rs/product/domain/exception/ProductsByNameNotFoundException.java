/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTBYNAMENOTFOUNDEXCEPTION.JAVA                         */
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
public class ProductsByNameNotFoundException extends RuntimeException {

    public ProductsByNameNotFoundException(String message) {
        super(message);
    }
}
