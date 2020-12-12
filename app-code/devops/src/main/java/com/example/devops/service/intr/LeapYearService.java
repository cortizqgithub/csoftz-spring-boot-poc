/*----------------------------------------------------------------------------*/
/* Source File:   LEAPYEARSERVICE.JAVA                                        */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.16/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.service.intr;

import java.util.List;

/**
 * Service interface to handle Leap Year operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.12/2020
 * @since 11 (JDK), Jan.28/2020
 */
public interface LeapYearService {
    /**
     * <p></p>Given a 'year', determines if it is a leap year.</p>
     * <p>This is based on
     * <a href="https://www.tutorialspoint.com/Java-program-to-find-if-the-given-number-is-a-leap-year">
     * Java program to find if the given number is a leap year?</a></p>.
     *
     * @param year A valid year.
     * @return True if is a Leap Year.
     */
    Boolean check(Integer year);

    /**
     * Given a 'year' list, determines if it is a leap year.
     *
     * @param yearList A valid year list with integers.
     * @return A list indicating in each position it is a Leap Year or not.
     */
    List<Boolean> check(List<Integer> yearList);
}
