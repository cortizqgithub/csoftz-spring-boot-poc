/*----------------------------------------------------------------------------*/
/* Source File:   HOMECONTROLLER.JAVA                                         */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.10/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.openrewrite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @GetMapping()
    public String index() {
        List<String> names = List.of("Carlos", "John");
        if (names != null) {
            return names.toString();
        } else {
            return takeBoth("Pepito ", 2, " Info 5");
        }
    }

    private String takeBoth(String first,
                            int times,
                            String third) {
        return first
                + times
                + third;
    }
}
