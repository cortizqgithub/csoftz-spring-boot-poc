/*----------------------------------------------------------------------------*/
/* Source File:   CART.JAVA                                                   */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.checkout.domain;

import com.acme.ecommerce.product.domain.Product;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Data;

/**
 * Represents CartCheckout information.
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Data
public class CartCheckout {
    private UUID cartId = UUID.randomUUID();
    private Map<Product, Integer> products = new ConcurrentHashMap<>();
}
