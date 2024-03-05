package com.acme.ecommerce.util;

import static org.assertj.core.api.Assertions.assertThat;

import com.acme.ecommerce.rs.product.domain.ProductData;
import com.acme.ecommerce.rs.product.domain.response.ProductResponse;
import com.acme.ecommerce.product.domain.Product;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class ProductRestConverterTest {

    private static final String PRODUCT_ID = "123456";
    private static final String PRODUCT_ID_2 = "902242";
    private static final String PRODUCT_BRAND = "AEI";
    private static final String PRODUCT_DESCRIPTION = "Tent";
    private static final String PRODUCT_DESCRIPTION_2 = "ProductRest 2";

    private static final double PRODUCT_PRICE = 12.95;

    @Test
    public void shouldConvertProductToProductResponse() {
        var productResponseExpected = buildProductResponse();
        var product = buildProduct();

        var productResponse = ProductConverter.convertToProductResponse(product);

        assertThat(productResponse).isNotNull().isEqualTo(productResponseExpected);
    }

    @Test
    public void shoudConvertProductDataListToProductList() {
        var productDataList = buildProductDataList();
        var productListExpected = buildProductList();

        var productList = ProductConverter.convertToProductList(productDataList);

        assertThat(productList)
            .isNotNull()
            .isEqualTo(productListExpected);
    }

    private List<Product> buildProductList() {
        return List.of(buildProduct(), buildProduct2());
    }

    private List<ProductData> buildProductDataList() {
        return List.of(buildProductData(), buildProductData2());
    }

    private ProductData buildProductData() {
        return new ProductData(PRODUCT_ID, PRODUCT_BRAND, PRODUCT_DESCRIPTION, new BigDecimal(PRODUCT_PRICE));
    }

    private ProductData buildProductData2() {
        return new ProductData(PRODUCT_ID_2, PRODUCT_BRAND, PRODUCT_DESCRIPTION_2, new BigDecimal(PRODUCT_PRICE));
    }

    private ProductResponse buildProductResponse() {
        return new ProductResponse(PRODUCT_ID, PRODUCT_BRAND, new BigDecimal(PRODUCT_PRICE));
    }

    private Product buildProduct() {
        return new Product(PRODUCT_ID, PRODUCT_BRAND, PRODUCT_DESCRIPTION, new BigDecimal(PRODUCT_PRICE));
    }

    private Product buildProduct2() {
        return new Product(PRODUCT_ID_2, PRODUCT_BRAND, PRODUCT_DESCRIPTION_2, new BigDecimal(PRODUCT_PRICE));
    }
}