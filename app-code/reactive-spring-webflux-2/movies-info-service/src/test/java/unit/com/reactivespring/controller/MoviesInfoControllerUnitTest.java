package com.reactivespring.controller;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.service.MovieInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;

@WebFluxTest(controllers = MoviesInfoController.class)
@AutoConfigureWebTestClient
public class MoviesInfoControllerUnitTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private MovieInfoService movieInfoServiceMock;

    public static final String ENDPOINT_MOVIEINFOS_CALL = "/v1/movieinfos/";

    @Test
    public void getAllMoviesInfo() {

        var movieinfos = List.of(new MovieInfo(null, "Batman Begins",
                2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15")),
            new MovieInfo(null, "The Dark Knight",
                2008, List.of("Christian Bale", "HeathLedger"), LocalDate.parse("2008-07-18")),
            new MovieInfo("abc", "Dark Knight Rises",
                2012, List.of("Christian Bale", "Tom Hardy"), LocalDate.parse("2012-07-20")));

        when(movieInfoServiceMock.getAllMoviesInfos()).thenReturn(Flux.fromIterable(movieinfos));

        webTestClient.get().uri(ENDPOINT_MOVIEINFOS_CALL)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBodyList(MovieInfo.class)
            .hasSize(3);

    }

    @Test
    public void getMovieInfoById() {

        var movieinfo = new MovieInfo("abc", "Dark Knight Rises",
                2012, List.of("Christian Bale", "Tom Hardy"), LocalDate.parse("2012-07-20"));

        var movieInfoId = "abc";
        when(movieInfoServiceMock.getAllMoviesInfoById(anyString())).thenReturn(Mono.just(movieinfo));

        webTestClient.get().uri(ENDPOINT_MOVIEINFOS_CALL + "{id}", movieInfoId)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody(MovieInfo.class)
            .consumeWith(movieInfoEntityExchangeResult -> {
                var movieInfo = movieInfoEntityExchangeResult.getResponseBody();
                Assertions.assertEquals(movieInfoId, movieInfo.getMovieInfoId());
            });

    }

    @Test
    public void addMovieInfo() {
        //given
        var movieInfo = new MovieInfo("mockId", "Batman Begins",
            2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        //when
        when(movieInfoServiceMock.addMovieInfo(isA(MovieInfo.class))).thenReturn(Mono.just(movieInfo));
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
                Assertions.assertEquals("mockId", savedMovieInfo.getMovieInfoId());

            });

        //then
    }

    @Test
    public void addMovieInfoValidation() {
        //given
        var movieInfo = new MovieInfo(null, "",
            -2005, List.of(""), LocalDate.parse("2005-06-15"));

        webTestClient.post().uri(ENDPOINT_MOVIEINFOS_CALL)
            .bodyValue(movieInfo)
            .exchange()
            .expectStatus()
            .isBadRequest()
            .expectBody(String.class)
            .consumeWith(stringEntityExchangeResult -> {
                var responseBody = stringEntityExchangeResult.getResponseBody();
                System.out.println("responseBody: "+ responseBody);
                assert responseBody != null;
                Assertions.assertEquals("movieInfo.cast must be present,movieInfo.name must be present,movieInfo.year must be a positive value", responseBody);
            });


        //then
    }

    @Test
    public void updateMovieInfo() {
        //given
        var movieInfo = new MovieInfo(null, "Dark Knight Rises1",
            2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        var movieInfoId = "abc";
        //when
        when(movieInfoServiceMock.updateMovieInfo(isA(MovieInfo.class), anyString())).thenReturn(Mono.just(new MovieInfo(movieInfoId, "Dark Knight Rises1",
            2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"))));

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
    public void deleteMovieInfo() {

        //given
        var movieInfoId = "abc";
        when(movieInfoServiceMock.deleteMovieInfo(anyString())).thenReturn(Mono.empty());

        //when
        webTestClient.delete().uri(ENDPOINT_MOVIEINFOS_CALL + "{id}",movieInfoId)
            .exchange()
            .expectStatus()
            .isNoContent();
    }
}
