/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTCONTROLLER.JAVA                                      */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.product;

import static com.acme.ecommerce.common.constants.ExceptionConstants.PRODUCT_REQUEST_MUST_NOT_BE_NULL;
import static com.acme.ecommerce.common.constants.ExceptionConstants.PRODUCT_REQUEST_PRODUCTS_MUST_NOT_BE_EMPTY;
import static com.acme.ecommerce.common.constants.ExceptionConstants.PRODUCT_REQUEST_PRODUCTS_SIZE_10_CONSTRAINT;
import static com.acme.ecommerce.common.constants.GlobalConstants.INT_TEN;
import static com.acme.ecommerce.common.constants.GlobalConstants.INT_ZERO;
import static com.acme.ecommerce.common.constants.GlobalConstants.PRODUCTS_BY_BRAND_NOT_FOUND;
import static com.acme.ecommerce.common.constants.GlobalConstants.RIGHT_BRACKET;

import com.acme.ecommerce.product.ProductService;
import com.acme.ecommerce.product.domain.Product;
import com.acme.ecommerce.product.domain.ProductMessageInfo;
import com.acme.ecommerce.rs.product.domain.exception.ProductNotFoundException;
import com.acme.ecommerce.rs.product.domain.exception.ProductRequestException;
import com.acme.ecommerce.rs.product.domain.exception.ProductsByNameNotFoundException;
import com.acme.ecommerce.rs.product.domain.request.ProductRequest;
import com.acme.ecommerce.rs.product.domain.response.ProductResponse;
import com.acme.ecommerce.util.ProductConverter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implements a Rest Service Facade to expose HTTP endpoints for dealing with {@code Products}.
 * One task implemented as part of this controller is to validate the PathVariable and the Request List.
 * <p>
 * Using <a href="https://www.baeldung.com/spring-validate-list-controller">Validaing Lists in Spring</a></p>
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@RestController
@RequestMapping("/product")
@Validated
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ProductResponse getProduct(@Valid @PathVariable @NotBlank String productId) {
        var product = productService.getProduct(productId);

        if (product == null) {
            throw new ProductNotFoundException(productId);
        }

        return ProductConverter.convertToProductResponse(product);
    }

    @GetMapping("/brand/{brandName}")
    public List<Product> retrieveProductsByBrand(@Valid @PathVariable @NotBlank String brandName) {
        var productList = productService.retrieveProductsByBrand(brandName);

        if (productList.size() == INT_ZERO) {
            throw new ProductsByNameNotFoundException(PRODUCTS_BY_BRAND_NOT_FOUND + brandName + RIGHT_BRACKET);
        }

        return productList;
    }

    @PostMapping
    public List<ProductMessageInfo> addProductList(@Valid @RequestBody ProductRequest request) {
        if (request.getProducts() == null) {
            throw new ProductRequestException(PRODUCT_REQUEST_MUST_NOT_BE_NULL);
        } else {
            if (request.getProducts().size() == INT_ZERO) {
                throw new ProductRequestException(PRODUCT_REQUEST_PRODUCTS_MUST_NOT_BE_EMPTY);
            }
            if (request.getProducts().size() > INT_TEN) {
                throw new ProductRequestException(PRODUCT_REQUEST_PRODUCTS_SIZE_10_CONSTRAINT);
            }
        }

        return productService.addProducts(ProductConverter.convertToProductList(request.getProducts()));
    }
}
