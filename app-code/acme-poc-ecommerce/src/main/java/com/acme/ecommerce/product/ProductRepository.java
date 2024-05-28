/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTREPOSITORY.JAVA                                      */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.product;

import com.acme.ecommerce.product.domain.Product;
import com.acme.ecommerce.util.Cache;
import java.util.Collection;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Repository
public class ProductRepository {

    private Map<String, Product> products = new Cache<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public Collection<Product> getAll() {
        return products.values();
    }
}
