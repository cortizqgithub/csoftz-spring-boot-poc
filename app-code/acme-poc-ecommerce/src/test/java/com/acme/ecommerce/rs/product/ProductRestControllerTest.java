/*----------------------------------------------------------------------------*/
/* Source File:   PRODUCTCONTROLLERTEST.JAVA                                  */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.product;

import static org.assertj.core.api.Assertions.assertThat;

import com.acme.ecommerce.common.constants.ExceptionConstants;
import com.acme.ecommerce.product.domain.Product;
import com.acme.ecommerce.product.domain.ProductMessageInfo;
import com.acme.ecommerce.rs.product.domain.ProductData;
import com.acme.ecommerce.rs.product.domain.request.ProductRequest;
import com.acme.ecommerce.rs.product.domain.response.ProductResponse;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductRestControllerTest {

    public static final String PRODUCT_RETRIEVE_ITEM_PATH = "/product/";
    public static final String PRODUCT_RETRIEVE_BY_BRAND_NAME_PATH = "/product/brand/";
    public static final String PRODUCT_ADD_ITEMS_PATH = "/product";
    public static final String PRODUCT_ID = "123456";
    public static final String PRODUCT_ID1 = "902235";
    public static final String PRODUCT_ID_VALID = PRODUCT_ID;
    public static final String PRODUCT_ID_INVALID = "999998";
    public static final String PRODUCT_BRAND = "AEI";
    public static final String PRODUCT_ID_NOT_FOUND = "ProductRest ID [" + PRODUCT_ID_INVALID + "] not found.";
    public static final String PRODUCT_BRAND_NAME_VALID = "AEI";
    public static final String PRODUCT_BRAND_NAME_INVALID = "AEI_NONE";
    public static final String PRODUCTS_BY_BRAND_NO_FOUND = "No products found for brand=[AEI_NONE]";
    public static final String PRODUCT_BRAND_COMING_SOON = "Coming Soon";
    public static final String PRODUCT_DESCRIPTION = "ProductRest 66";

    public static final double PRODUCT_PRICE = 10.0;

    public static final int INT_ZERO = 0;
    public static final int INT_ONE = 1;
    public static final int INT_TWO = 2;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturn200WhenRetrievingAProduct() {
        var entity = this.testRestTemplate.getForEntity(PRODUCT_RETRIEVE_ITEM_PATH + PRODUCT_ID_VALID, ProductResponse.class);

        assertThat(entity).isNotNull()
            .satisfies(re -> {
                assertThat(re.getStatusCode()).isEqualTo(HttpStatus.OK);
                assertThat(re.getBody()).isNotNull().isEqualTo(new ProductResponse(PRODUCT_ID, PRODUCT_BRAND, new BigDecimal(PRODUCT_PRICE)));
            });
    }

    @Test
    public void shouldReturn404WhenRetrievingAProduct() {
        var entity = this.testRestTemplate.getForEntity(PRODUCT_RETRIEVE_ITEM_PATH + PRODUCT_ID_INVALID, String.class);

        assertThat(entity).isNotNull()
            .satisfies(re -> {
                assertThat(re.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
                assertThat(re.getBody()).isNotNull().contains(PRODUCT_ID_NOT_FOUND);
            });
    }

    @Test
    public void shouldReturn200WhenRetrievingProductsByName() {
        var entity = this.testRestTemplate.getForEntity(PRODUCT_RETRIEVE_BY_BRAND_NAME_PATH + PRODUCT_BRAND_NAME_VALID, Product[].class);

        assertThat(entity).isNotNull()
            .satisfies(re -> {
                assertThat(re.getStatusCode()).isEqualTo(HttpStatus.OK);
                assertThat(re.getBody()).hasSize(INT_TWO);
            });
    }

    @Test
    public void shouldReturn404WhenRetrievingProductsByName() {
        var entity = this.testRestTemplate.getForEntity(PRODUCT_RETRIEVE_BY_BRAND_NAME_PATH + PRODUCT_BRAND_NAME_INVALID, String.class);

        assertThat(entity).isNotNull()
            .satisfies(re -> {
                assertThat(re.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
                assertThat(re.getBody()).contains(PRODUCTS_BY_BRAND_NO_FOUND);
            });
    }

    @Test
    public void shouldReturn200WhenAddingNewProducts() {
        var productRequest = buildProductRequest();
        var entity = this.testRestTemplate.postForEntity(PRODUCT_ADD_ITEMS_PATH, productRequest, ProductMessageInfo[].class);

        assertThat(entity).isNotNull()
            .satisfies(re -> {
                assertThat(re.getStatusCode()).isEqualTo(HttpStatus.OK);
                assertThat(re.getBody()).hasSize(INT_TWO)
                    .satisfies(a -> {
                        assertThat(a[INT_ZERO].getMsg()).isEqualTo("ProductRest with id=[123456]");
                        assertThat(a[INT_ZERO].getDescription()).isEqualTo("ProductRest exist and not modified.");
                        assertThat(a[INT_ONE].getMsg()).isEqualTo("ProductRest with id=[902235]");
                        assertThat(a[INT_ONE].getDescription()).isEqualTo("ProductRest added successfully.");
                    });
            });
    }

    @Test
    public void shouldReturn400WhenAddingNewProducts() {
        var productRequest = buildProductRequestEmpty();
        var entity = this.testRestTemplate.postForEntity(PRODUCT_ADD_ITEMS_PATH, productRequest, String.class);

        assertThat(entity).isNotNull()
            .satisfies(re -> {
                assertThat(re.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
                assertThat(re.getBody()).contains(ExceptionConstants.PRODUCT_REQUEST_PRODUCTS_MUST_NOT_BE_EMPTY);
            });
    }

    @Test
    public void shouldReturn400WhenAddingMoreThanTenNewProducts() {
        var productRequest = buildRequestBulkTenProducts();
        var entity = this.testRestTemplate.postForEntity(PRODUCT_ADD_ITEMS_PATH, productRequest, String.class);

        assertThat(entity).isNotNull()
            .satisfies(re -> {
                assertThat(re.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
                assertThat(re.getBody()).contains(ExceptionConstants.PRODUCT_REQUEST_PRODUCTS_SIZE_10_CONSTRAINT);
            });
    }

    private ProductRequest buildProductRequestEmpty() {
        return new ProductRequest(List.of());
    }

    private ProductRequest buildProductRequest() {
        return new ProductRequest(List.of(buildProductData(), buildProductData1()));
    }

    private ProductRequest buildRequestBulkTenProducts() {
        return new ProductRequest(
            List.of(
                buildProductData(), buildProductData(), buildProductData(),
                buildProductData(), buildProductData(), buildProductData(),
                buildProductData(), buildProductData(), buildProductData(),
                buildProductData(), buildProductData()));
    }

    private ProductData buildProductData() {
        return new ProductData(PRODUCT_ID, PRODUCT_BRAND_COMING_SOON, PRODUCT_DESCRIPTION, new BigDecimal(PRODUCT_PRICE));
    }

    private ProductData buildProductData1() {
        return new ProductData(PRODUCT_ID1, PRODUCT_BRAND_COMING_SOON, PRODUCT_DESCRIPTION, new BigDecimal(PRODUCT_PRICE));
    }

}
