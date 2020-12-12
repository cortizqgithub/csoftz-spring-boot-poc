/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMECONTROLLER.JAVA                                   */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.16/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.devops.service.intr.PalindromeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * REST API for Palindrome end-points.
 * <p><b>NOTE:</b>This controller uses Spring MVC, this means it is non-reactive.</p>
 * <p>Demo purpose for a Spring REST Docs sample
 * <a href="https://spring.io/guides/gs/testing-restdocs/#initial">Spring Rest Docs Guide</a>
 * </p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.5, Dec.12/2020
 * @since 11 (JDK), Mar.16/2019
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/palindrome")
@RequiredArgsConstructor
public class PalindromeController {

    private static final String CHECKING_FOR_A_PALINDROME = "Checking t=[{}] is a palindrome={}";

    private final PalindromeService palindromeService;

    /**
     * Given text in URL checks if it is a Palindrome
     *
     * @param t Text to check
     * @return True if palindrome
     */
    @GetMapping("/check")
    public Boolean checkPalindromeFor(@RequestParam String t) {
        Boolean rslt = this.palindromeService.check(t);

        log.debug(CHECKING_FOR_A_PALINDROME, t, rslt);
        return rslt;
    }
}
