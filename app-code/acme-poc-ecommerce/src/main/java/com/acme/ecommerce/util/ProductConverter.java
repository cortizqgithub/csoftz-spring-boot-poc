/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTCONVERTER.JAVA                                       */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.util;

import com.acme.ecommerce.product.domain.Product;
import com.acme.ecommerce.rs.product.domain.ProductData;
import com.acme.ecommerce.rs.product.domain.response.ProductResponse;
import java.util.List;
import java.util.stream.Collectors;

public class ProductConverter {

    private ProductConverter() {
    }

    public static ProductResponse convertToProductResponse(Product product) {
        return new ProductResponse(product.getProductId(), product.getBrand(), product.getPrice());
    }

    public static List<Product> convertToProductList(List<ProductData> products) {
        return products.stream()
            .map(ProductConverter::convertProductDataToProduct)
            .collect(Collectors.toList());
    }

    private static Product convertProductDataToProduct(ProductData productData) {
        return new Product(productData.getProductId(), productData.getBrand(), productData.getDescription(), productData.getPrice());
    }
}
