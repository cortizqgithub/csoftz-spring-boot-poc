/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMECONTROLLER.JAVA                                   */
/* Description:   REST Api for Palindrome end-points.                         */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.16/2019                                                 */
/* Last Modified: Oct.15/2019                                                 */
/* Version:       1.3                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
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

import lombok.extern.slf4j.Slf4j;

/**
 * REST Api for Palindrome end-points.
 * Demo purpose for a Spring REST Docs sample
 * <a href="https://spring.io/guides/gs/testing-restdocs/#initial">Spring Rest Docs Guide</a>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.3, Oct.15/2019
 * @since 11 (JDK), Mar.16/2019
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/palindrome")
public class PalindromeController {

    private final PalindromeService palindromeService;

    /**
     * Constructor with parameters.
     *
     * @param palindromeService Inject a service to check palindrome texts.
     */
    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    /**
     * Given text in URL checks if it is a Palindrome
     *
     * @param t Text to check
     * @return True if palindrome
     */
    @GetMapping("/check")
    public Boolean checkPalindromeFor(@RequestParam String t) {
        Boolean rslt = this.palindromeService.check(t);
        String msg = String.format("t=[%s] is a palindrome=%b", t, rslt);
        log.debug(msg);
        return rslt;
    }
}
