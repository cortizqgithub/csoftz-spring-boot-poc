/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTNOTFOUNDEXCEPTION.JAVA                               */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.product.domain.exception;

import com.acme.ecommerce.common.constants.ExceptionConstants;
import com.acme.ecommerce.common.constants.GlobalConstants;

/**
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String productId) {
        super(ExceptionConstants.PRODUCT_WITH_ID + productId + ExceptionConstants.NOT_FOUND + GlobalConstants.PERIOD);
    }
}
