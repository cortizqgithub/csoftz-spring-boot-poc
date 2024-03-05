/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTDTO.JAVA                                             */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents ProductRest information.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Data
@AllArgsConstructor
public class ProductRest {
    private String productId;
    private String brand;
    private String description;
}
