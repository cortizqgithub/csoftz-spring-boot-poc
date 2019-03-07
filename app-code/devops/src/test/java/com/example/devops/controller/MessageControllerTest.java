package com.example.devops.controller;

import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@AutoConfigureRestDocs(outputDir = "target/snippets", uriScheme = "http", uriHost = "api.example.com")
@WebFluxTest
public class MessageControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    /**
     * As MessageController is a WebFlux (it has Mono and Flux return types) it means that this test must use
     * Spring WebFlux
     *
     * @throws Exception Reports some error.
     */
    @Test
    public void shouldReturnMessage() throws Exception {
        this.webTestClient.get()
                .uri("/api/v1/msg/say")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .consumeWith(document("message"));
    }
}