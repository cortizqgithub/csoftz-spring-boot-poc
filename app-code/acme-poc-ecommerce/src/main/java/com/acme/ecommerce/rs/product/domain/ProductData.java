/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTDATA.JAVA                                            */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.product.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represent ProductRest information that needs to be validated.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Data
@AllArgsConstructor
public class ProductData {
    @NotEmpty(message = "'Product Id' is mandatory.")
    private String productId;

    @NotEmpty(message = "Product 'Brand' is mandatory.")
    private String brand;

    @NotEmpty(message = "Product 'Description' is mandatory.")
    private String description;

    @Positive
    private BigDecimal price;
}
