package com.reactivespring.controller;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.reactivespring.domain.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
@AutoConfigureWireMock(port = 8084)
@TestPropertySource(
    properties = {
        "restClient.moviesInfoUrl=http://localhost:8084/v1/movieinfos",
        "restClient.reviewsUrl=http://localhost:8084/v1/reviews"
    }
)
public class MoviesControllerIntgTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void retrieveMovieById() {
        //given
        var movieId = "abc";
        stubFor(get(urlEqualTo("/v1/movieinfos/"+ movieId))
            .willReturn(aResponse()
                .withHeader("Content-type", "application/json")
                    .withBodyFile("movieinfo.json")
            ));

        stubFor(get(urlPathEqualTo("/v1/reviews"))
            .willReturn(aResponse()
                .withHeader("Content-type", "application/json")
                .withBodyFile("reviews.json")
            ));

        //when
        webTestClient.get()
            .uri("/v1/movies/{id}", movieId)
            .exchange()
            .expectStatus().isOk()
            .expectBody(Movie.class)
            .consumeWith(movieEntityExchangeResult -> {
                var movie = movieEntityExchangeResult.getResponseBody();
                assert Objects.requireNonNull(movie).getReviewList().size() == 2;
                Assertions.assertEquals("Batman Begins", movie.getMovieInfo().getName());
            });


        //then

    }

    @Test
    void retrieveMovieById404() {
        //given
        var movieId = "abc";
        stubFor(get(urlEqualTo("/v1/movieinfos/"+ movieId))
            .willReturn(aResponse()
                .withStatus(404)
            ));

        stubFor(get(urlPathEqualTo("/v1/reviews"))
            .willReturn(aResponse()
                .withHeader("Content-type", "application/json")
                .withBodyFile("reviews.json")
            ));

        //when
        webTestClient.get()
            .uri("/v1/movies/{id}", movieId)
            .exchange()
            .expectStatus().is4xxClientError()
            .expectBody(String.class)
            .isEqualTo("There is no movie info available for the passed in Id: abc");


        //then
        WireMock.verify(1, getRequestedFor(urlEqualTo("/v1/movieinfos/"+ movieId)));

    }

    @Test
    void retrieveMovieByIdReview404() {
        //given
        var movieId = "abc";
        stubFor(get(urlEqualTo("/v1/movieinfos/"+ movieId))
            .willReturn(aResponse()
                .withHeader("Content-type", "application/json")
                .withBodyFile("movieinfo.json")
            ));

        stubFor(get(urlPathEqualTo("/v1/reviews"))
            .willReturn(aResponse()
                .withStatus(404)
            ));

        //when
        webTestClient.get()
            .uri("/v1/movies/{id}", movieId)
            .exchange()
            .expectStatus().isOk()
            .expectBody(Movie.class)
            .consumeWith(movieEntityExchangeResult -> {
                var movie = movieEntityExchangeResult.getResponseBody();
                assert Objects.requireNonNull(movie).getReviewList().size() == 0;
                Assertions.assertEquals("Batman Begins", movie.getMovieInfo().getName());
            });


        //then

    }

    @Test
    void retrieveMovieById500() {
        //given
        var movieId = "abc";
        stubFor(get(urlEqualTo("/v1/movieinfos/"+ movieId))
            .willReturn(aResponse()
                .withStatus(500)
                .withBody("Movie unavailable")
            ));

        //when
        webTestClient.get()
            .uri("/v1/movies/{id}", movieId)
            .exchange()
            .expectStatus().is5xxServerError()
            .expectBody(String.class)
            .isEqualTo("Server Exception in Movies info Service: Movie unavailable");


        //then
        WireMock.verify(4, getRequestedFor(urlEqualTo("/v1/movieinfos/"+ movieId)));

    }

    @Test
    void retrieveMovieByIdReview500() {
        //given
        var movieId = "abc";
        stubFor(get(urlEqualTo("/v1/movieinfos/"+ movieId))
            .willReturn(aResponse()
                .withHeader("Content-type", "application/json")
                .withBodyFile("movieinfo.json")
            ));

        stubFor(get(urlPathEqualTo("/v1/reviews"))
            .willReturn(aResponse()
                .withStatus(505)
                .withBody("Review Service Not Available")
            ));

        //when
        webTestClient.get()
            .uri("/v1/movies/{id}", movieId)
            .exchange()
            .expectStatus().is5xxServerError()
            .expectBody(String.class)
            .isEqualTo("Server Exception in Reviews Service: Review Service Not Available");


        //then
        WireMock.verify(4, getRequestedFor(urlPathMatching("/v1/reviews*")));

    }

}
