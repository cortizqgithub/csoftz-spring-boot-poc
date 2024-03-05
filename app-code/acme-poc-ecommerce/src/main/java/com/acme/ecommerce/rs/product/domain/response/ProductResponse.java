/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTRESPONSE.JAVA                                        */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.product.domain.response;

import java.math.BigDecimal;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents a response for ProductRest information.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Data
@AllArgsConstructor
public class ProductResponse {
    private String productId;
    private String brand;
    private BigDecimal price;
}
