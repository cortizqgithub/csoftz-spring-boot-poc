/*----------------------------------------------------------------------------*/
/* Source File:   CHUCKNORRISCONTROLLER.JAVA                                  */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.11/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.chuck.norris.wrapper.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chuck.norris.wrapper.domain.ChuckNorrisData;
import com.example.chuck.norris.wrapper.domain.wrapper.ChuckNorrisDataWrapper;
import com.example.chuck.norris.wrapper.service.intr.JokesService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST Api for ChuckNorris end-point.
 * <p> This controller accesses the <a href="https://api.chucknorris.io">chucknorris.io is a free JSON API for hand curated Chuck Norris facts.</a>
 * and as such it is considered as a wrapper to that service for educational purposes.
 * </p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Dec.12/2020
 * @since 11 (JDK), Oct.11/2019
 */
@RestController
@RequestMapping("/api/v1/chuck/norris")
@Slf4j
public class ChuckNorrisController {
    private final JokesService jokesService;

    /**
     * Default constructor.
     *
     * @param jokesService Injects a reference for retrieving Chuck Norries Jokes.
     */
    public ChuckNorrisController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    /**
     * Retrieves a random Chuck Norris joke.<br/>
     * GET /random/string
     *
     * @return A JSON representing Chuck Norris joke in a 'string' object.
     */
    @GetMapping(value = "/random/string", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> retrieveRandomJokeWithString() {
        return jokesService.retrievePlainRandomJoke();
    }

    /**
     * Retrieves a random Chuck Norris joke.<br/>
     * GET /random/chuck-norris-data
     *
     * @return A JSON representing Chuck Norris joke in a '{@link ChuckNorrisData}' object.
     */
    @GetMapping("/random/chuck-norris-data")
    public Mono<ChuckNorrisData> retrieveRandomJokeWithChuckNorrisData() {
        return jokesService.retrieveRandomJoke();
    }

    /**
     * Retrieves 3 random Chuck Norris jokes.<br/>
     * GET /random/three/string
     *
     * @return A JSON representing Chuck Norris joke in a 'String' object.
     */
    @GetMapping(value = "/random/three/string", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<String> retrieveThreeRandomJokesWithString() {
        return Flux
            .concat(jokesService.retrievePlainRandomJoke())
            .concatWith(jokesService.retrievePlainRandomJoke())
            .concatWith(jokesService.retrievePlainRandomJoke());
    }

    /**
     * Retrieves 3 random Chuck Norris jokes.<br/>
     * GET /random/three/chuck-norris-data
     *
     * @return A JSON representing Chuck Norris joke in a '{@link ChuckNorrisData}' object.
     */
    @GetMapping("/random/three/chuck-norris-data")
    public Flux<ChuckNorrisData> retrieveFourRandomJokesWithChuckNorrisData() {
        return Flux.merge(jokesService.retrieveRandomJoke())
            .mergeWith(jokesService.retrieveRandomJoke())
            .mergeWith(jokesService.retrieveRandomJoke());
    }

    /**
     * Retrieves {times} random Chuck Norris jokes.<br/>
     * GET /random/{times}/chuck-norris-data
     *
     * @param times Indicates the quantity of jokes to retrieve.
     * @return A JSON representing Chuck Norris joke in a '{@link ChuckNorrisData}' object.
     */
    @GetMapping("/random/{times}/chuck-norris-data")
    public Flux<ChuckNorrisData> retrieveTimesRandomJokesWithChuckNorrisData(@PathVariable int times) {
        List<Mono<ChuckNorrisData>> publishers = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            publishers.add(jokesService.retrieveRandomJoke());
        }
        return Flux.merge(publishers);
    }

    /**
     * Retrieves a Chuck Norris joke.<br/>
     * GET /random/chuck-norris-data/wrapped
     *
     * @return A JSON representing Chuck Norris joke in a '{@link ChuckNorrisDataWrapper}' object.
     */
    @GetMapping("/random/chuck-norris-data/wrapped")
    public Mono<ChuckNorrisDataWrapper> retrieveChuckNorrisDataWrap() {
        // https://www.baeldung.com/java-uuid
        return jokesService.retrieveRandomJoke()
            .map(s -> ChuckNorrisDataWrapper.builder()
                .wrapId(UUID.randomUUID().toString())
                .chuckNorrisData(s)
                .build());
    }

    /**
     * Retrieves a Chuck Norris joke.<br/>
     * GET /random/{times}/chuck-norris-data/wrapped
     *
     * @return A JSON representing Chuck Norris joke in a '{@link ChuckNorrisDataWrapper}' object.
     */
    @GetMapping("/random/{times}/chuck-norris-data/wrapped")
    public Flux<ChuckNorrisDataWrapper> retrieveTimesRandomJokesWithChuckNorrisDataWrapper(@PathVariable int times) {
        List<Mono<ChuckNorrisData>> publishers = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            publishers.add(jokesService.retrieveRandomJoke());
        }
        return Flux.merge(publishers)
            .map(s -> ChuckNorrisDataWrapper.builder()
                .wrapId(UUID.randomUUID().toString())
                .chuckNorrisData(s)
                .build());
    }
}
