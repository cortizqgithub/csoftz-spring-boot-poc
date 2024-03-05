/*----------------------------------------------------------------------------*/
/* Source File:   UICONTROLLER.JAVA                                           */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.ui;

import com.acme.ecommerce.checkout.CartService;
import com.acme.ecommerce.inventory.InventoryService;
import com.acme.ecommerce.location.LocationService;
import com.acme.ecommerce.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {

    private ProductService productService;
    private LocationService locationService;
    private InventoryService inventoryService;
    private CartService cartService;

    public UiController(
        ProductService productService,
        LocationService locationService,
        InventoryService inventoryService,
        CartService cartService) {
        this.productService = productService;
        this.locationService = locationService;
        this.inventoryService = inventoryService;
        this.cartService = cartService;

    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }
}
