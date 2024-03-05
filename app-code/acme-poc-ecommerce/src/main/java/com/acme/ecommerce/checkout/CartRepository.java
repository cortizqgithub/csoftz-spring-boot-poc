/*----------------------------------------------------------------------------*/
/* Source File:   CARTREPOSITORY.JAVA                                                   */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.checkout;

import com.acme.ecommerce.checkout.domain.CartCheckout;
import com.acme.ecommerce.util.Cache;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Repository
public class CartRepository {
    private Map<String, CartCheckout> carts = new Cache<>();

    public void addCart(CartCheckout cart) {
        carts.put(cart.getCartId().toString(), cart);
    }

    public CartCheckout getCart(String cartId) {
        return carts.get(cartId);
    }
}
