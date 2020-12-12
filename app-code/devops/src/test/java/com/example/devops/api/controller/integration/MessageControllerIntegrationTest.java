/*----------------------------------------------------------------------------*/
/* Source File:   MESSAGECONTROLLERINTEGRATIONTEST.JAVA                       */
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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.devops.api.controller.MessageController;

/**
 * Test REST Api for Message end-points.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Dec.12/2020
 * @since 11 (JDK), Mar.01/2019
 */
@ExtendWith(SpringExtension.class)
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "api.example.com")
@WebFluxTest(MessageController.class)
class MessageControllerIntegrationTest {
    private static final String MSG_SAY_URL = "/api/v1/msg/say";

    @Autowired
    private WebTestClient webTestClient;

    /**
     * As MessageController is a WebFlux (it has Mono and Flux return types) it means that this test must use
     * Spring WebFlux testing capabilities.
     */
    @Test
    void shouldReturnMessage() {
        this.webTestClient.get()
            .uri(MSG_SAY_URL)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .consumeWith(document("message", preprocessResponse(prettyPrint())));
    }
}