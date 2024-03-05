/*----------------------------------------------------------------------------*/
/* Source File:   CARTSERVICE.JAVA                                            */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.checkout;

import com.acme.ecommerce.checkout.domain.CartCheckout;
import com.acme.ecommerce.inventory.InventoryService;
import com.acme.ecommerce.product.ProductService;
import com.acme.ecommerce.product.domain.Product;
import com.acme.ecommerce.rs.Location;
import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Component
public class CartService {

    private ProductService productService;
    private InventoryService inventoryService;
    private CartRepository cartRepository;

    public CartService(ProductService productService, InventoryService inventoryService, CartRepository cartRepository) {
        this.productService = productService;
        this.inventoryService = inventoryService;
        this.cartRepository = cartRepository;
    }

    public CartCheckout addToCart(String cartId, Product product, int quantity, Location location) throws Exception {

        CartCheckout cartCheckout;

        // Do we have a valid product?
        if (StringUtils.isNumeric(product.getProductId()) && product.getProductId().length() == 6 && !product.getBrand().isEmpty() && !product.getDescription().isEmpty() && product.getPrice() != null && product.getPrice().compareTo(BigDecimal.ZERO) == 1) {

            // is there enough inventory to sell this product?
            if (inventoryService.hasInventoryOnline(product, quantity) || inventoryService.hasInventoryInNearbyStores(product, quantity, location)) {

                // is there already a cartCheckout for this customer?
                if (cartId == null) {
                    cartCheckout = new CartCheckout();
                    cartRepository.addCart(cartCheckout);
                } else {
                    cartCheckout = cartRepository.getCart(cartId);
                    if (cartCheckout == null) {
                        cartCheckout = new CartCheckout();
                        cartRepository.addCart(cartCheckout);
                    }
                }

                //is this item already in the cartCheckout? If so add to the existing quantity
                var existingQuantity = cartCheckout.getProducts().get(product);

                if (existingQuantity != null) {
                    cartCheckout.getProducts().put(product, existingQuantity + quantity);
                } else {
                    cartCheckout.getProducts().put(product, quantity);
                }
            } else {
                throw new Exception("No inventory for this product");
            }
        } else {
            throw new Exception("Invalid ProductRest");
        }

        return cartCheckout;
    }
}

