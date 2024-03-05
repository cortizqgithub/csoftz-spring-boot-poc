/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTREQUEST.JAVA                                         */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.product.domain.request;

import com.acme.ecommerce.rs.product.domain.ProductData;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a request payload data for ProductRest.
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private List<@Valid ProductData> products;
}
