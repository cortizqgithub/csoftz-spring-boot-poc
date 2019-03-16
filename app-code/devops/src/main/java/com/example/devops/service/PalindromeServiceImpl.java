/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMESERVICEIMPL.JAVA                                  */
/* Description:   Service implementation to handle Palindrome operations.     */
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

import com.example.devops.service.intr.PalindromeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service implementation to handle Palindrome operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.3, Sep.10/2018
 * @since 1.8 (JDK), May.19/2018
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
