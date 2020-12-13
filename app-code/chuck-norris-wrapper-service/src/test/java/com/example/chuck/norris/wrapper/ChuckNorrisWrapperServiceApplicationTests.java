/*----------------------------------------------------------------------------*/
/* Source File:   CHUCKNORRISWRAPPERSERVICEAPPLICATIONTESTS.JAVA              */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.11/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.chuck.norris.wrapper;

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
 * @version 1.2, Dec.12/2020
 * @since 11 (JDK), Oct.11/2019
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ChuckNorrisWrapperServiceApplicationTests {
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
