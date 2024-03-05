/*----------------------------------------------------------------------------*/
/* Source File:   GLOBALCONSTANTS.JAVA                                        */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.common.constants;

/**
 * General purpose application constants.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
public class GlobalConstants {

    public static final String PRODUCT_ID_FIELD = "productId";
    public static final String BRAND_FIELD = "brand";
    public static final String DESCRIPTION_FIELD = "description";
    public static final String PRICE_FIELD = "price";
    public static final String PRODUCTS_CSV = "/products.csv";
    public static final String PRODUCTS_LOADED = "Products loaded into product repository.";
    public static final String PRODUCT_WITH_ID_LEFT_BRACKET = "ProductRest with id=[";
    public static final String RIGHT_BRACKET = "]";
    public static final String PERIOD = ".";
    public static final String PRODUCT_FOUND_NO_MODIFIED = "ProductRest exist and not modified.";
    public static final String PRODUCT_ADDED_SUCCESSFULLY = "ProductRest added successfully.";
    public static final String PRODUCTS_BY_BRAND_NOT_FOUND = "No products found for brand=[";
    public static final String COLON_SPACE_DELIMITER = ": ";

    public static final int INT_ZERO = 0;
    public static final int INT_TEN = 10;

    /**
     * Utility class, thus no constructor allowed.
     */
    private GlobalConstants() {
    }
}
