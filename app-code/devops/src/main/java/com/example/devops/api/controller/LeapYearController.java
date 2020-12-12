/*----------------------------------------------------------------------------*/
/* Source File:   LEAPYEARCONTROLLER.JAVA                                     */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jul.24/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.devops.service.intr.LeapYearService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST Api for LeapYear end-points.
 * <p><b>NOTE:</b>This controller uses Spring WebFlux, this means it is reactive.</p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Dec.12/2020
 * @since 11 (JDK), Jul.24/2020
 */
@RestController
@RequestMapping("/api/v1/leap/year")
@RequiredArgsConstructor
public class LeapYearController {

    private final LeapYearService leapYearService;

    /**
     * Checks if the supplied parameter is a leap year.
     *
     * @param leapYear Value for year to check.
     * @return TRUE if it is a leap year wrapped in a map indicating the year and its result.
     */
    @GetMapping("/check")
    public Mono<Map<Integer, Boolean>> checkYear(@RequestParam Integer leapYear) {
        return Mono.just(leapYear).map(transformLeapYearToMap());
    }

    /**
     * Checks if list of years are leap years.
     *
     * @param leapYears Values of years to check.
     * @return TRUE for each year that is a leap year.
     */
    @GetMapping("/check/years")
    public Flux<Map<Integer, Boolean>> checkYears(@RequestParam List<Integer> leapYears) {
        return Flux.fromIterable(leapYears).map(transformLeapYearToMap());
    }

    private Function<Integer, Map<Integer, Boolean>> transformLeapYearToMap() {
        return leapYear -> {
            Map<Integer, Boolean> leapYearMap = new HashMap<>();
            leapYearMap.put(leapYear, leapYearService.check(leapYear));
            return leapYearMap;
        };
    }
}
