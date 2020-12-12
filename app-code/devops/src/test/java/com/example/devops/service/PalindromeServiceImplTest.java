/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMESERVICEIMPLTEST.JAVA                              */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.16/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.devops.service.intr.PalindromeService;

/**
 * Service implementation to handle Palindrome operations (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Dec.12/2020
 * @since 11 (JDK), Mar.16/2019
 */
class PalindromeServiceImplTest {
    /*
     * Service to test.
     */
    private static PalindromeService palindromeService;

    /**
     * Prepare helpers.
     */
    @BeforeAll
    public static void init() {
        palindromeService = new PalindromeServiceImpl();
    }

    /**
     * Checks if the Empty String is a Palindrome.
     */
    @Test
    void givenPalindromeWhenInfoIsEmptyThenReturnsTrue() {
        String info = "";

        assertThat(palindromeService.check(info)).isTrue();
    }

    /**
     * Checks if non empty text that is known as a Palindrome text is checked as TRUE.
     */
    @Test
    void givenPalindromeWhenPuttingAPalindromeTextThenReturnsTrue() {
        String info = "A nut for a jar of tuna";

        assertThat(palindromeService.check(info)).isTrue();
    }

    /**
     * Given a null string, it returns false.
     */
    @Test
    void givenPalindromeWhenPuttingANullStringThenReturnsFalse() {
        assertThat(palindromeService.check(null)).isFalse();
    }
}