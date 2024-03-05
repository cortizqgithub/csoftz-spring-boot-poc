/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTSERVICE.JAVA                                         */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.product;

import com.acme.ecommerce.common.constants.GlobalConstants;
import com.acme.ecommerce.product.domain.Product;
import com.acme.ecommerce.product.domain.ProductMessageInfo;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Component
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(String productId) {
        return productRepository.getProduct(productId);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productRepository.getAll());
    }

    public List<ProductMessageInfo> addProducts(List<Product> products) {
        return products.stream().map(product -> {
            var prMessage = new ProductMessageInfo();
            var productId = product.getProductId();
            var productExist = productRepository.getProduct(productId);

            prMessage.setMsg(GlobalConstants.PRODUCT_WITH_ID_LEFT_BRACKET + productId + GlobalConstants.RIGHT_BRACKET);

            if (productExist == null) {
                productRepository.addProduct(product);
                prMessage.setDescription(GlobalConstants.PRODUCT_ADDED_SUCCESSFULLY);
            } else {
                prMessage.setDescription(GlobalConstants.PRODUCT_FOUND_NO_MODIFIED);
            }

            return prMessage;
        }).collect(Collectors.toList());
    }

    /**
     * Populates the product repository with data from products.txt
     *
     * @throws IOException
     */
    @PostConstruct
    public void populateProducts() throws IOException {
        try (Reader in = new InputStreamReader(getClass().getResourceAsStream(GlobalConstants.PRODUCTS_CSV))) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(GlobalConstants.PRODUCT_ID_FIELD, GlobalConstants.BRAND_FIELD, GlobalConstants.DESCRIPTION_FIELD, GlobalConstants.PRICE_FIELD)
                .withFirstRecordAsHeader()
                .parse(in);

            records.forEach(record -> {
                var product = new Product(record.get(GlobalConstants.PRODUCT_ID_FIELD), record.get(GlobalConstants.BRAND_FIELD), record.get(GlobalConstants.DESCRIPTION_FIELD), new BigDecimal(record.get(GlobalConstants.PRICE_FIELD)));

                logger.info(product.toString());
                productRepository.addProduct(product);
            });
        }

        logger.info(GlobalConstants.PRODUCTS_LOADED);
    }

    public List<Product> retrieveProductsByBrand(String brandName) {
        var products = getAllProducts();

        return products.stream()
            .filter(product -> product.getBrand().equalsIgnoreCase(brandName))
            .collect(Collectors.toList());
    }
}
