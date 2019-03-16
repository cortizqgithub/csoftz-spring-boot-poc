/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMESERVICEIMPLTEST.JAVA                              */
/* Description:   Service implementation to handle Palindrome operations      */
/*                (Tests).                                                    */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.16/2019                                                 */
/* Last Modified: Mar.16/2019                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.16/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.devops.service.intr.PalindromeService;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Service implementation to handle Palindrome operations (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.16/2019
 * @since 1.8 (JDK), Mar.16/2019
 */
public class PalindromeServiceImplTest {
    /*
     * Service to test.
     */
    private static PalindromeService palindromeService;

    /**
     * Prepare helpers.
     */
    @BeforeClass
    public static void init() {
        palindromeService = new PalindromeServiceImpl();
    }

    /**
     * Checks if the Empty String is a Palindrome.
     */
    @Test
    public void givenPalindromeWhenInfoIsEmptyThenReturnsTrue() {
        String info = "";

        Boolean isPalindrome = palindromeService.check(info);
        assertThat(isPalindrome).isTrue();
    }

    /**
     * Checks if non empty text that is known as a Palindrome text is checked as TRUE.
     */
    @Test
    public void givenPalindromeWhenPuttingAPalindromeTextThenReturnsTrue() {
        String info = "A nut for a jar of tuna";

        Boolean isPalindrome = palindromeService.check(info);
        assertThat(isPalindrome).isTrue();
    }

    /**
     * Given a null string, it returns false.
     */
    @Test
    public void givenPalindromeWhenPuttingANullStringThenReturnsFalse() {
        Boolean isPalindrome = palindromeService.check(null);
        assertThat(isPalindrome).isFalse();
    }
}