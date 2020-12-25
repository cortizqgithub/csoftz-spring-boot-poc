/*----------------------------------------------------------------------------*/
/* Source File:   CZEXAMPLESAPPLICATIONTESTS.JAVA                             */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Dec.24/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.cz.examples;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Spring Boot Context test.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.24/2020
 * @since 15 (JDK), Dec.24/2020
 */
@SpringBootTest
class CzExamplesApplicationTests {
    @Autowired
    private ApplicationContext appContext;

    /**
     * Load Spring Boot App to validate it is well configured.
     */
    @Test
    void contextLoads() {
        assertThat(appContext).isNotNull();
    }

}
