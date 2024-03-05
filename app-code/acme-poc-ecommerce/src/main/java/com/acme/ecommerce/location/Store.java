/*----------------------------------------------------------------------------*/
/* Source File:   STORE.JAVA                                                  */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.location;

import lombok.Data;

/**
 * Represents Store information.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Data
public class Store {
    private String storeName;

    public Store(String storeName) {
        this.storeName = storeName;
    }
}
