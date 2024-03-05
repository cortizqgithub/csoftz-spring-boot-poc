/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTMESSAGEINFO.JAVA                                     */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.product.domain;

import lombok.Data;

/**
 * Represents the ProductRest Message Information (response data to in endpoints).
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Data
public class ProductMessageInfo {
    private String msg;
    private String description;
}
