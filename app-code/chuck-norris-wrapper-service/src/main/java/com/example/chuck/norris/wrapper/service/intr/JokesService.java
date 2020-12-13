/*----------------------------------------------------------------------------*/
/* Source File:   JOKESSERVICE.JAVA                                           */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.11/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.chuck.norris.wrapper.service.intr;

import com.example.chuck.norris.wrapper.domain.ChuckNorrisData;

import reactor.core.publisher.Mono;

/**
 * <p> Service abstraction to <a href="https://api.chucknorris.io">chucknorris.io is a free JSON API for hand curated Chuck Norris facts.</a>
 * and as such it is considered as a wrapper to that service for educational purposes.
 * </p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.12/2020
 * @since 11 (JDK), Oct.11/2019
 */
public interface JokesService {
    /**
     * Retrieves a random Joke about Chuck Norris.
     *
     * @return The JSON output from external service.
     */
    Mono<String> retrievePlainRandomJoke();

    /**
     * Retrieves a random Joke about Chuck Norris.
     *
     * @return The external service response serialized.
     * @link ChuckNorrisData
     */
    Mono<ChuckNorrisData> retrieveRandomJoke();
}
