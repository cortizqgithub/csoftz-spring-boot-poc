/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMESERVICE.JAVA                                      */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.16/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.service.intr;

/**
 * Service interface to handle Palindrome operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.12/2020
 * @since 11 (JDK), Mar.16/2019
 */
public interface PalindromeService {
    /**
     * Validates if info is a Palindrome text. A palindrome sentence is those
     * that can be spelled the same way forward an backward.
     *
     * @param info Data information to validate
     * @return True if text is palindrome.
     */
    Boolean check(String info);
}
