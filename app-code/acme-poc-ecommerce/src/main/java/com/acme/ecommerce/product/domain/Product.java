/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCT.JAVA                                                */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.product.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents ProductRest information.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Data
@AllArgsConstructor
public class Product {
    private String productId;
    private String brand;
    private String description;
    private BigDecimal price;
}
