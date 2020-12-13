/*----------------------------------------------------------------------------*/
/* Source File:   CHUCKNORRISWRAPPERSERVICEAPPLICATION.JAVA                   */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.11/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.chuck.norris.wrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point to the application.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.12/2020
 * @since 11 (JDK), Oct.11/2019
 */
@SpringBootApplication
public class ChuckNorrisWrapperServiceApplication {

    /**
     * Main entry point to application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(ChuckNorrisWrapperServiceApplication.class, args);
    }

}
