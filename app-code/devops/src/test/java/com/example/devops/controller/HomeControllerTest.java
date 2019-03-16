/*----------------------------------------------------------------------------*/
/* Source File:   HOMECONTROLLERTEST.JAVA                                     */
/* Description:   Test REST Api for Home end-points.                          */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.01/2019                                                 */
/* Last Modified: Mar.16/2019                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.removeHeaders;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test REST Api for Home end-points.
 * Demo purpose for a Spring REST Docs sample
 * <a href="https://spring.io/guides/gs/testing-restdocs/#initial">Spring Rest Docs Guide</a>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Mar.16/2019
 * @since 1.8 (JDK), Mar.01/2019
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets", uriScheme = "http", uriHost = "api.example.com")
public class HomeControllerTest {
    private static final String HOME_URL = "/";

    @Autowired
    private MockMvc mockMvc;

    /**
     * Even tough project is configure to use Spring WebFlux (and reactor underneath). It also inherits
     * Spring MVC semantics. Because the endpoint is not a Flux, or Mono type it means that Spring MVC Testing
     * can be used.
     *
     * @throws Exception Reports some error.
     */
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get(HOME_URL).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")))
                .andDo(document("home",
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("message").description("The welcome message for the user.")
                        )
                ));
    }

    /**
     * WORK in Progress
     *
     * @throws Exception Raised and makes test to fail.
     */
    @Test
    public void shouldTake2() throws Exception {
        this.mockMvc.perform(get(HOME_URL).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")))
                .andDo(document("home2",

                        preprocessRequest(removeHeaders("Foo")),
                        preprocessResponse(prettyPrint())));
    }
}