/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMECONTROLLERINTEGRATIONCONTROLLER.JAVA              */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.16/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.api.controller.integration;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * REST Api for Palindrome end-points (Tests).
 * Demo purpose for a Spring REST Docs sample
 * <a href="https://spring.io/guides/gs/testing-restdocs/#initial">Spring Rest Docs Guide</a>.
 * <p>
 * This is an integration test as it loads the whole context to test the web layer.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.4, Dec.12/2020
 * @since 11 (JDK), Mar.16/2019
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "api.example.com")
class PalindromeControllerIntegrationTest {
    private static final String PALINDROME_URL = "/api/v1/palindrome/check";
    private static final String URI_PARAM_PALINDROME_TEXT = "Text of palindrome to check";

    @Autowired
    private MockMvc mockMvc;

    /**
     * When invoking the Endpoint it returns valid JSON data.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    void givenPalindromeControllerWhenSettingAPalindromeTextReturnsTrue() throws Exception {
        String PALINDROME_FULL_URL = PALINDROME_URL + "?t=A nut for a jar of tuna";
        mockMvc.perform(get(PALINDROME_FULL_URL))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isBoolean())
            .andExpect(jsonPath("$").value(true))
            .andDo(document("palindrome/valid",
                preprocessResponse(prettyPrint()),
                requestParameters(
                    parameterWithName("t").description(URI_PARAM_PALINDROME_TEXT)
                )
            ));
    }

    /**
     * When invoking the Endpoint it returns valid JSON data.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    void givenPalindromeControllerWhenSettingANonPalindromeTextReturnsTrue() throws Exception {
        String URI = PALINDROME_URL + "?t=Car";
        mockMvc.perform(get(URI))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isBoolean())
            .andExpect(jsonPath("$").value(false))
            .andDo(document("palindrome/invalid",
                preprocessResponse(prettyPrint()),
                requestParameters(
                    parameterWithName("t").description(URI_PARAM_PALINDROME_TEXT)
                )
            ));
    }
}