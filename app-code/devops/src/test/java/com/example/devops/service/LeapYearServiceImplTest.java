/*----------------------------------------------------------------------------*/
/* Source File:   LEAPYEARSERVICEIMPL.JAVA                                    */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.28/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.service;

import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1600;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1700;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1800;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1900;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_2000;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_2019;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_2020;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.devops.service.intr.LeapYearService;

/**
 * Service implementation to handle Leap Year operations (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Dec.12/2020
 * @since 11 (JDK), Jan.28/2020
 */
class LeapYearServiceImplTest {
    /**
     * Service to Test.
     */
    private LeapYearService leapYearService;

    /**
     * Prepare helpers.
     *
     * @throws Exception When an error is raised.
     */
    @BeforeEach
    public void setUp() throws Exception {
        leapYearService = new LeapYearServiceImpl();
    }

    /**
     * When a Leap Year is supplied then it checks it is indeed so.
     */
    @Test
    void givenLeapYearThenReturnsCheckToTrue() {
        assertThat(leapYearService.check(LEAP_YEAR_TEST_2020))
            .isNotNull()
            .isTrue();
    }

    /**
     * When a non-Leap Year is supplied it checks that it is not.
     */
    @Test
    void givenNotLeapYearThenReturnsCheckToFalse() {
        assertThat(leapYearService.check(LEAP_YEAR_TEST_2019))
            .isNotNull()
            .isFalse();
    }

    /**
     * When a list of years is supplied, it validates each one to tell if it is a Leap year or not.
     */
    @Test
    void givenAListOfYearsThenReturnsAListOfChecksToEachOne() {
        List<Integer> yearList =
            Arrays.asList(LEAP_YEAR_TEST_2000,
                LEAP_YEAR_TEST_2019,
                LEAP_YEAR_TEST_1700,
                LEAP_YEAR_TEST_1800,
                LEAP_YEAR_TEST_1900,
                LEAP_YEAR_TEST_1600);

        List<Boolean> expectedLeapYearList = Arrays.asList(true, false, false, false, false, true);

        List<Boolean> actualLeapYearList = leapYearService.check(yearList);
        assertThat(actualLeapYearList).isEqualTo(expectedLeapYearList);
    }
}