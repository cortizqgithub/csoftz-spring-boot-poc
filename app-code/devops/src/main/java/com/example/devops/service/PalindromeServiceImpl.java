/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMESERVICEIMPL.JAVA                                  */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.16/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.service;

import org.springframework.stereotype.Service;

import com.example.devops.service.intr.PalindromeService;

import lombok.extern.slf4j.Slf4j;

/**
 * Service implementation to handle Palindrome operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.4, Dec.12/2020
 * @since 11 (JDK), Mar.19/2019
 */
@Slf4j
@Service
public class PalindromeServiceImpl implements PalindromeService {
    /**
     * Validates if info is a Palindrome text. A palindrome sentence is those
     * that can be spelled the same way forward an backward.
     *
     * @param info Data information to validate
     * @return True if text is palindrome.
     */
    @Override
    public Boolean check(String info) {
        log.debug("Executing check()");
        log.debug("Parameter info=[{}]", info);
        if (info == null) {
            return false;
        }
        String infoWork =
            info.toLowerCase()
                .trim()
                .replace(" ", "");
        String infoReversed =
            new StringBuilder(info)
                .reverse()
                .toString()
                .toLowerCase()
                .trim()
                .replace(" ", "");

        return infoWork.equalsIgnoreCase(infoReversed);
    }
}
