/*----------------------------------------------------------------------------*/
/* Source File:   EXCEPTIONCONSTANTS.JAVA                                     */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.common.constants;

/**
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
public class ExceptionConstants {

    public static final String PRODUCT_WITH_ID = "ProductRest ID [";
    public static final String NOT_FOUND = "] not found";
    public static final String PRODUCT_REQUEST_MUST_NOT_BE_NULL = "Payload 'products' must not be NULL.";
    public static final String PRODUCT_REQUEST_PRODUCTS_MUST_NOT_BE_EMPTY = "Payload 'products' must not be empty.";
    public static final String PRODUCT_REQUEST_PRODUCTS_SIZE_10_CONSTRAINT = "Payload 'products' can only contain up to 10 elements.";

    private ExceptionConstants() {
    }
}
