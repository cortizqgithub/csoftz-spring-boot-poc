/*----------------------------------------------------------------------------*/
/* Source File:   MESSAGECONTROLLERINTEGRATIONTEST.JAVA                       */
/* Description:   REST Api for Message end-points.                            */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.01/2019                                                 */
/* Last Modified: Jan.27/2020                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.api.controller.integration;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.devops.api.controller.MessageController;

/**
 * Test REST Api for Message end-points.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Jan.27/2020
 * @since 11 (JDK), Mar.01/2019
 */
@RunWith(SpringRunner.class)
@AutoConfigureRestDocs(outputDir = "target/snippets", uriScheme = "http", uriHost = "api.example.com")
@WebFluxTest(MessageController.class)
public class MessageControllerIntegrationTest {
    private static final String MSG_SAY_URL = "/api/v1/msg/say";

    @Autowired
    private WebTestClient webTestClient;

    /**
     * As MessageController is a WebFlux (it has Mono and Flux return types) it means that this test must use
     * Spring WebFlux testing capabilities.
     */
    @Test
    public void shouldReturnMessage() {
        this.webTestClient.get()
            .uri(MSG_SAY_URL)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .consumeWith(document("message", preprocessResponse(prettyPrint())));
    }
}