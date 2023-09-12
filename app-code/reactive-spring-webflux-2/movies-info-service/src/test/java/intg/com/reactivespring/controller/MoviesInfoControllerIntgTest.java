package com.reactivespring.controller;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.repository.MovieInfoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
public class MoviesInfoControllerIntgTest {

    public static final String ENDPOINT_MOVIEINFOS_CALL = "/v1/movieinfos/";
    @Autowired
    MovieInfoRepository movieInfoRepository;

    @Autowired
    WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        var movieinfos = List.of(new MovieInfo(null, "Batman Begins",
                2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15")),
            new MovieInfo(null, "The Dark Knight",
                2008, List.of("Christian Bale", "HeathLedger"), LocalDate.parse("2008-07-18")),
            new MovieInfo("abc", "Dark Knight Rises",
                2012, List.of("Christian Bale", "Tom Hardy"), LocalDate.parse("2012-07-20")));

        movieInfoRepository.saveAll(movieinfos)
            .blockLast();
    }

    @AfterEach
    void tearDown() {
        movieInfoRepository.deleteAll().block();
    }

    @Test
    public void addMovieInfo() {
        //given
        var movieInfo = new MovieInfo(null, "Batman Begins",
            2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        //when
        webTestClient.post().uri(ENDPOINT_MOVIEINFOS_CALL)
            .bodyValue(movieInfo)
            .exchange()
            .expectStatus()
            .isCreated()
            .expectBody(MovieInfo.class)
            .consumeWith(movieInfoEntityExchangeResult -> {
                var savedMovieInfo = movieInfoEntityExchangeResult.getResponseBody();
                assert movieInfo != null;
                assert savedMovieInfo.getMovieInfoId() != null;

            });

        //then
    }

    @Test
    public void getAllMoviesInfo() {

        webTestClient.get().uri(ENDPOINT_MOVIEINFOS_CALL)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBodyList(MovieInfo.class)
            .hasSize(3);
    }

    @Test
    public void getAllMoviesInfoStream() {
        //given
        var movieInfo = new MovieInfo(null, "Batman Begins",
            2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        webTestClient.post().uri(ENDPOINT_MOVIEINFOS_CALL)
            .bodyValue(movieInfo)
            .exchange()
            .expectStatus()
            .isCreated()
            .expectBody(MovieInfo.class)
            .consumeWith(movieInfoEntityExchangeResult -> {
                var savedMovieInfo = movieInfoEntityExchangeResult.getResponseBody();
                assert movieInfo != null;
                assert savedMovieInfo.getMovieInfoId() != null;

            });


        //when
        var moviesStreamFlux = webTestClient.get().uri(ENDPOINT_MOVIEINFOS_CALL + "/stream")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .returnResult(MovieInfo.class)
                .getResponseBody();
        StepVerifier.create(moviesStreamFlux)
            .assertNext(movieInfo1 -> {
                assert movieInfo1.getMovieInfoId() != null;
            })
            .thenCancel()
            .verify();

    }

    @Test
    public void getAllMoviesInfoByYear() {

        var uri = UriComponentsBuilder.fromUriString(ENDPOINT_MOVIEINFOS_CALL)
                .queryParam("year", 2005)
                    .buildAndExpand().toUri();

        webTestClient.get().uri(uri)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBodyList(MovieInfo.class)
            .hasSize(1);
    }

    @Test
    public void getAllMoviesById() {

        var movieInfoId = "abc";
        webTestClient.get().uri(ENDPOINT_MOVIEINFOS_CALL + "{id}", movieInfoId)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody()
            .jsonPath("$.name").isEqualTo("Dark Knight Rises");
            /*
            .expectBody(MovieInfo.class)
            .consumeWith(movieInfoEntityExchangeResult -> {
                var movieInfo = movieInfoEntityExchangeResult.getResponseBody();
                Assertions.assertNotNull(movieInfo);
            });*/
    }

    @Test
    public void getAllMoviesByIdNotFound() {

        var movieInfoId = "def";
        webTestClient.get().uri(ENDPOINT_MOVIEINFOS_CALL + "{id}", movieInfoId)
            .exchange()
            .expectStatus()
            .isNotFound();
            /*
            .expectBody(MovieInfo.class)
            .consumeWith(movieInfoEntityExchangeResult -> {
                var movieInfo = movieInfoEntityExchangeResult.getResponseBody();
                Assertions.assertNotNull(movieInfo);
            });*/
    }

    @Test
    public void updateMovieInfo() {
        //given
        var movieInfo = new MovieInfo(null, "Dark Knight Rises1",
            2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        var movieInfoId = "abc";
        //when
        webTestClient.put().uri(ENDPOINT_MOVIEINFOS_CALL + "{id}",movieInfoId)
            .bodyValue(movieInfo)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody(MovieInfo.class)
            .consumeWith(movieInfoEntityExchangeResult -> {
                var updatedMovieInfo = movieInfoEntityExchangeResult.getResponseBody();
                assert updatedMovieInfo != null;
                assert updatedMovieInfo.getMovieInfoId() != null;
                Assertions.assertEquals("Dark Knight Rises1", updatedMovieInfo.getName());

            });

        //then
    }

    @Test
    public void updateMovieInfoNotFound() {
        //given
        var movieInfo = new MovieInfo(null, "Dark Knight Rises1",
            2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        var movieInfoId = "def";
        //when
        webTestClient.put().uri(ENDPOINT_MOVIEINFOS_CALL + "{id}",movieInfoId)
            .bodyValue(movieInfo)
            .exchange()
            .expectStatus()
            .isNotFound();

        //then
    }

    @Test
    public void deleteMovieInfo() {

        //given
        var movieInfoId = "abc";
        //when
        webTestClient.delete().uri(ENDPOINT_MOVIEINFOS_CALL + "{id}",movieInfoId)
            .exchange()
            .expectStatus()
            .isNoContent();
    }
}
