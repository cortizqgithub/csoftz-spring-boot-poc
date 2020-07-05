/*----------------------------------------------------------------------------*/
/* Source File:   LEAPYEARSERVICEIMPL.JAVA                                    */
/* Description:   Service implementation to handle Leap Year operations       */
/*                (Tests)                                                     */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Jan.28/2020                                                 */
/* Last Modified: Jul.05/2020                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.28/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.devops.service.intr.LeapYearService;

/**
 * Service implementation to handle Leap Year operations (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Jul.05/2020
 * @since 11 (JDK), Jan.28/2020
 */
public class LeapYearServiceImplTest {
    private static final int LEAP_YEAR_TEST_1600 = 1600;
    private static final int LEAP_YEAR_TEST_1700 = 1700;
    private static final int LEAP_YEAR_TEST_1800 = 1800;
    private static final int LEAP_YEAR_TEST_1900 = 1900;
    private static final int LEAP_YEAR_TEST_2000 = 2000;
    private static final int LEAP_YEAR_TEST_2019 = 2019;
    private static final int LEAP_YEAR_TEST_2020 = 2020;

    /**
     * Service to Test.
     */
    private LeapYearService leapYearService;

    /**
     * Prepare helpers.
     *
     * @throws Exception When an error is raised.
     */
    @Before
    public void setUp() throws Exception {
        leapYearService = new LeapYearServiceImpl();
    }

    /**
     * When a Leap Year is supplied then it checks it is indeed so.
     */
    @Test
    public void givenLeapYearThenReturnsCheckToTrue() {
        Boolean isLeapYear = leapYearService.check(LEAP_YEAR_TEST_2020);
        assertThat(isLeapYear)
            .isNotNull()
            .isTrue();
    }

    /**
     * When a non-Leap Year is supplied it checks that it is not.
     */
    @Test
    public void givenNotLeapYearThenReturnsCheckToFalse() {
        Boolean isLeapYear = leapYearService.check(LEAP_YEAR_TEST_2019);
        assertThat(isLeapYear)
            .isNotNull()
            .isFalse();
    }

    /**
     * When a list of years is supplied, it validates each one to tell if it is a Leap year or not.
     */
    @Test
    public void givenAListOfYearsThenReturnsAListOfChecksToEachOne() {
        List<Integer> yearList =
            Arrays.asList(LEAP_YEAR_TEST_2000,
                LEAP_YEAR_TEST_2019,
                LEAP_YEAR_TEST_1700,
                LEAP_YEAR_TEST_1800,
                LEAP_YEAR_TEST_1900,
                LEAP_YEAR_TEST_1600);

        List<Boolean> expectedLeapYearList = Arrays.asList(true, false, false, false, false, true);

        List<Boolean> actualLeapYearList = leapYearService.check(yearList);
        assertThat(actualLeapYearList)
            .isEqualTo(expectedLeapYearList);
    }
}