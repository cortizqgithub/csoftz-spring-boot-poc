/*----------------------------------------------------------------------------*/
/* Source File:   ADDITEM.JAVA                                                */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.cart.domain;

import com.acme.ecommerce.rs.Location;
import lombok.Data;

/**
 * Represents Items to Add into a cart information.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Data
public class CartRestItemInfo {

    private String productId;
    private int quantity;
    private Location location;
}
