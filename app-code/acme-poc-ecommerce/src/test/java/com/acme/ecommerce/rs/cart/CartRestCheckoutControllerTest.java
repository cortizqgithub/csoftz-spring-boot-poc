/*----------------------------------------------------------------------------*/
/* Source File:   CARTCONTROLLERTEST.JAVA                                     */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.rs.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.acme.ecommerce.rs.Location;
import com.acme.ecommerce.rs.cart.domain.CartRest;
import com.acme.ecommerce.rs.cart.domain.CartRestItemInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartRestCheckoutControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturn200WhenSendingRequestCart() {
        CartRestItemInfo cartRestItemInfo = new CartRestItemInfo();

        cartRestItemInfo.setProductId("123456");
        cartRestItemInfo.setQuantity(1);
        cartRestItemInfo.setLocation(Location.SEATTLE);

        ResponseEntity<CartRest> entity = this.testRestTemplate.postForEntity(
            "/cart/123456", cartRestItemInfo, CartRest.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

}
