/*----------------------------------------------------------------------------*/
/* Source File:   SPRINGBOOTPOC.JAVA                                          */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point to the application.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.12/2020
 * @since 11 (JDK), Mar.01/2019
 */
@SpringBootApplication
public class SpringBootPOC {

    /**
     * Main entry point to application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootPOC.class, args);
    }
}
