/*----------------------------------------------------------------------------*/
/* Source File:   HOMECONTROLLER.JAVA                                         */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.api.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Api for Home end-points.
 * Demo purpose for a Spring REST Docs sample
 * <a href="https://spring.io/guides/gs/testing-restdocs/#initial">Spring Rest Docs Guide</a>
 * <p><b>NOTE:</b>This controller uses Spring WebFlux, this means it is reactive.</p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.3, Dec.12/2020
 * @since 11 (JDK), Mar.01/2019
 */
@RestController
public class HomeController {

    private static final String MESSAGE_KEY = "message";
    private static final String MESSAGE_VALUE = "Hello World";

    /**
     * Default entry point.
     * GET /
     *
     * @return A JSON representing a map of messages.
     */
    @GetMapping("/")
    public Map<String, Object> greeting() {
        return Collections.singletonMap(MESSAGE_KEY, MESSAGE_VALUE);
    }
}
