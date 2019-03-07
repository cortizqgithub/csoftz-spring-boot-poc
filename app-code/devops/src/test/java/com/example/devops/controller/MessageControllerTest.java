package com.example.devops.controller;

import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.documentationConfiguration;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.ApplicationContext;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
// As Mar.07/2019 this annotation for WebFlux Rest Docs is not working, snippets get creeated in 'generated-snippets' folder.
@WebFluxTest
public class MessageControllerTest {
    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Autowired
    ApplicationContext context;

    private WebTestClient webTestClient;

    @Before
    public void setUp() {
        this.webTestClient = WebTestClient.bindToApplicationContext(context)
                .configureClient().baseUrl("https://api.example.com")
                .filter(documentationConfiguration(restDocumentation))
                .build();
    }

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