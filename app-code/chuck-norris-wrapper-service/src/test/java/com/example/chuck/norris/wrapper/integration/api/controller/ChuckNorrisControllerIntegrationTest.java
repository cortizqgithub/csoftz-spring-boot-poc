/*----------------------------------------------------------------------------*/
/* Source File:   MESSAGECONTROLLERINTEGRATIONTEST.JAVA                       */
/* Description:   REST Api for ChuckNorrisData and ChuckNorrisWrapperData     */
/*                end-points.                                                 */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.15/2019                                                 */
/* Last Modified: Oct.15/2019                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.15/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.chuck.norris.wrapper.integration.api.controller;

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
import com.example.chuck.norris.wrapper.api.controller.ChuckNorrisController;

/**
 * REST Api for ChuckNorrisData and ChuckNorrisWrapperData end-points.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.15/2019
 * @since 11 (JDK), Oct.15/2019
 */
@RunWith(SpringRunner.class)
@AutoConfigureRestDocs(outputDir = "target/snippets", uriScheme = "http", uriHost = "api.example.com")
@WebFluxTest(ChuckNorrisController.class)
public class ChuckNorrisControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    /**
     * As ChuckNorrisController is a WebFlux (it has Mono and Flux return types) it means that this test must use
     * Spring WebFlux testing capabilities.
     */
    @Test
    public void shouldReturnChuckNorrisData() {
        this.webTestClient.get()
                .uri("/api/v1/chuck/norris/random/string")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .consumeWith(document("random-string", preprocessResponse(prettyPrint()) ));

    }
}