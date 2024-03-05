/*----------------------------------------------------------------------------*/
/* Source File:   CARTITEM.JAVA                                               */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.cart.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represet the items in a cart.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Data
@AllArgsConstructor
public class CartRestItem {
    private String productId;
    private int quantity;
}
