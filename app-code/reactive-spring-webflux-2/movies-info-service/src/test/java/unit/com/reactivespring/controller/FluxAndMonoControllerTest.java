package com.reactivespring.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebFlux;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.util.AssertionErrors;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import java.util.Objects;

@WebFluxTest(controllers = FluxAndMonoController.class)
@AutoConfigureWebTestClient
public class FluxAndMonoControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void flux() {
        webTestClient.get().uri("/flux").exchange().expectStatus()
            .is2xxSuccessful()
            .expectBodyList(Integer.class)
            .hasSize(3);
    }

    @Test
    public void fluxApproach2() {
        var flux = webTestClient.get().uri("/flux").exchange().expectStatus()
            .is2xxSuccessful()
            .returnResult(Integer.class)
            .getResponseBody();
        StepVerifier.create(flux)
            .expectNext(1, 2, 3)
            .verifyComplete();
    }

    @Test
    public void fluxApproach3() {
        webTestClient.get().uri("/flux").exchange().expectStatus()
            .is2xxSuccessful()
            .expectBodyList(Integer.class)
            .consumeWith(listEntityExchangeResult -> {
              var responseBody = listEntityExchangeResult.getResponseBody();
              assert (Objects.requireNonNull(responseBody).size() == 3);
            } );
    }

    @Test
    public void mono() {
        webTestClient.get().uri("/mono").exchange().expectStatus()
            .is2xxSuccessful()
            .expectBody(String.class)
            .consumeWith(stringEntityExchangeResult -> {
                var responseBody = stringEntityExchangeResult.getResponseBody();
                Assertions.assertEquals("Hello World", responseBody);
            });
    }

    @Test
    public void stream() {
        var flux = webTestClient.get().uri("/stream").exchange().expectStatus()
            .is2xxSuccessful()
            .returnResult(Long.class)
            .getResponseBody();
        StepVerifier.create(flux)
            .expectNext(0L, 1L, 2L)
            .thenCancel()
        .verify();

    }

}
