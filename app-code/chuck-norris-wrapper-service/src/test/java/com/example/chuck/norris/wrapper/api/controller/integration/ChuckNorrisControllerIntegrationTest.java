/*----------------------------------------------------------------------------*/
/* Source File:   MESSAGECONTROLLERINTEGRATIONTEST.JAVA                       */
/* Description:   REST Api for ChuckNorrisData and ChuckNorrisWrapperData     */
/*                end-points.                                                 */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.15/2019                                                 */
/* Last Modified: Jul.05/2020                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.15/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.chuck.norris.wrapper.api.controller.integration;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.chuck.norris.wrapper.api.controller.ChuckNorrisController;
import com.example.chuck.norris.wrapper.service.ChuckNorrisJokesService;

/**
 * <p>REST Api for ChuckNorrisData and ChuckNorrisWrapperData end-points.</p>
 * <p>As this is an integration test all of external services must be injected. That is why the @Import is there.</p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Jul.05/2020
 * @since 11 (JDK), Oct.15/2019
 */
@RunWith(SpringRunner.class)
@AutoConfigureRestDocs(outputDir = "target/snippets", uriScheme = "http", uriHost = "api.example.com")
@WebFluxTest(ChuckNorrisController.class)
@Import(ChuckNorrisJokesService.class)
public class ChuckNorrisControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    /**
     * As ChuckNorrisController is a WebFlux (it has Mono and Flux return types) it means that this test must use
     * Spring WebFlux testing capabilities.
     */
    @Test
    public void shouldReturnChuckNorrisData() {
        this.webTestClient
            .get()
            .uri("/api/v1/chuck/norris/random/string")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .consumeWith(document("random-string", preprocessResponse(prettyPrint())));
    }
}