/*----------------------------------------------------------------------------*/
/* Source File:   LEAPYEARSERVICEIMPL.JAVA                                    */
/* Description:   Service implementation to handle Leap Year operations       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Jan.28/2020                                                 */
/* Last Modified: Jan.20/2020                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.28/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.devops.service.intr.LeapYearService;

/**
 * Service implementation to handle Leap Year operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Jan.20/2020
 * @since 11 (JDK), Jan.20/2020
 */
public class LeapYearServiceImpl implements LeapYearService {

    /**
     * <p></p>Given a 'year', determines if it is a leap year.</p>
     * <p>This is based on
     * <a href="https://www.tutorialspoint.com/Java-program-to-find-if-the-given-number-is-a-leap-year">
     * Java program to find if the given number is a leap year?</a></p>.
     *
     * @param year A valid year.
     * @return True if is a Leap Year.
     */
    @Override
    public Boolean check(Integer year) {
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

    /**
     * Given a 'year' list, determines if it is a leap year.
     *
     * @param yearList A valid year list with integers.
     * @return A list indicating in each position it is a Leap Year or not.
     */
    @Override
    public List<Boolean> check(List<Integer> yearList) {
        return yearList
            .stream()
            .map(this::check)
            .collect(Collectors.toList());
    }
}
