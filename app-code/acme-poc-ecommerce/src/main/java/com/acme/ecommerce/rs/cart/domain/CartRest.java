/*----------------------------------------------------------------------------*/
/* Source File:   CARTDTO.JAVA                                                */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.cart.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents the CartCheckout Information.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Data
@AllArgsConstructor
public class CartRest {

    private String cartId;
    private List<CartRestItem> items;
}
