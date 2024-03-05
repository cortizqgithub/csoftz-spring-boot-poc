/*----------------------------------------------------------------------------*/
/* Source File:   CARTCONTROLLER.JAVA                                         */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.cart;

import com.acme.ecommerce.checkout.CartService;
import com.acme.ecommerce.checkout.domain.CartCheckout;
import com.acme.ecommerce.product.ProductService;
import com.acme.ecommerce.rs.cart.domain.CartRest;
import com.acme.ecommerce.rs.cart.domain.CartRestItem;
import com.acme.ecommerce.rs.cart.domain.CartRestItemInfo;
import com.acme.ecommerce.rs.product.domain.ProductRest;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private ProductService productService;
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping
    @ResponseBody
    public String test() {
        return "test";
    }

    @PostMapping("/{cartId}")
    @ResponseBody
    public CartRest addToCart(@PathParam("cartId") String cartId,
                              @RequestBody CartRestItemInfo cartRestItemInfo) throws Exception {

        return transform(cartService.addToCart(cartId, productService.getProduct(cartRestItemInfo.getProductId()), cartRestItemInfo.getQuantity(), cartRestItemInfo.getLocation()));
    }

    private CartRest transform(CartCheckout cartCheckout) {
        return new CartRest(cartCheckout.getCartId().toString(), cartCheckout.getProducts().entrySet().stream().map(entry -> new CartRestItem(entry.getKey().getProductId(), entry.getValue())).toList());
    }

    private ProductRest transform(com.acme.ecommerce.product.domain.Product product) {
        return new ProductRest(product.getProductId(), product.getDescription(), product.getBrand());
    }
}
