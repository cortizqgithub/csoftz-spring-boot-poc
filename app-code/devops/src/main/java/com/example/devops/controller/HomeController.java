/*----------------------------------------------------------------------------*/
/* Source File:   HOMECONTROLLER.JAVA                                         */
/* Description:   REST Api for Home end-points.                               */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.01/2019                                                 */
/* Last Modified: Mar.16/2019                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * REST Api for Home end-points.
 * Demo purpose for a Spring REST Docs sample
 * <a href="https://spring.io/guides/gs/testing-restdocs/#initial">Spring Rest Docs Guide</a>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.16/2019
 * @since 1.8 (JDK), Mar.01/2019
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
