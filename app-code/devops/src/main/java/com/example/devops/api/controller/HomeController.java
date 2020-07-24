/*----------------------------------------------------------------------------*/
/* Source File:   HOMECONTROLLER.JAVA                                         */
/* Description:   REST Api for Home end-points.                               */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.01/2019                                                 */
/* Last Modified: Jul.24/2020                                                 */
/* Version:       1.2                                                         */
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
 * @version 1.2, Jul.24/2020
 * @since 11 (JDK), Mar.01/2019
 */
@RestController
public class HomeController {

    /**
     * Default entry point.
     * GET /
     *
     * @return A JSON representing a map of messages.
     */
    @GetMapping("/")
    public Map<String, Object> greeting() {
        return Collections.singletonMap("message", "Hello World");
    }
}
