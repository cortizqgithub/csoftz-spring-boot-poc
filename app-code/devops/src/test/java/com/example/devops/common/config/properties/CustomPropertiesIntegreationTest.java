/*----------------------------------------------------------------------------*/
/* Source File:   CUSTOMPROPERTIESINTEGREATIONTEST.JAVA                       */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.28/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.common.config.properties;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Custom Properties Integration Tests.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.12/2020
 * @since 11 (JDK), Mar.16/2019
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource("classpath:customproperties.properties")
class CustomPropertiesIntegreationTest {

    private static final String HTTP_LOCALHOST = "http://localhost";
    private static final int TIME_OUT_MILLISECONDS = 2000;

    @Autowired
    private CustomProperties customProperties;

    /**
     * Validates that the file properties contains valid settings.
     */
    @Test
    void whenUrlPropertyQueriedThenReturnsPropertyValue() {
        assertThat(customProperties).isNotNull();
        assertThat(customProperties.getUrl()).isEqualTo(HTTP_LOCALHOST);
        assertThat(customProperties.getTimeoutInMilliSeconds()).isEqualTo(TIME_OUT_MILLISECONDS);
    }
}