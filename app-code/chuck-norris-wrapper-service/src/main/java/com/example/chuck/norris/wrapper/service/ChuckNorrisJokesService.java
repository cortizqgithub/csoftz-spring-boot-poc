/*----------------------------------------------------------------------------*/
/* Source File:   CHUCKNORRISJOKESSERVICE.JAVA                                */
/* Description:   Connects to https://api.chucknorris.io for jokes about      */
/*                Chuck Norris. (Service implementations).                    */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.21/2019                                                 */
/* Last Modified: Oct.21/2019                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.21/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.chuck.norris.wrapper.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.chuck.norris.wrapper.domain.ChuckNorrisData;
import com.example.chuck.norris.wrapper.service.intr.JokesService;

import reactor.core.publisher.Mono;

/**
 * <p> Service abstraction implementation to <a href="https://api.chucknorris.io">chucknorris.io is a free JSON API for hand curated Chuck Norris facts.</a>
 * and as such it is considered as a wrapper to that service for educational purposes.
 * </p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.15/2019
 * @since 11 (JDK), Oct.11/2019
 */
@Service
public class ChuckNorrisJokesService implements JokesService {
    private String chuckNorrisServiceURL;

    /**
     * Build the service component.
     *
     * @param chuckNorrisServiceURL The URL to get external information from.
     */
    public ChuckNorrisJokesService(@Value("${chuck.norris.service}") String chuckNorrisServiceURL) {
        this.chuckNorrisServiceURL = chuckNorrisServiceURL;
    }

    /**
     * Retrieves a random Joke about Chuck Norris.
     *
     * @return The JSON output from external service.
     */
    @Override
    public Mono<String> retrievePlainRandomJoke() {
        return WebClient.create(chuckNorrisServiceURL)
                .get()
                .uri("/jokes/random")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
    }

    /**
     * Retrieves a random Joke about Chuck Norris.
     *
     * @return The external service response serialized.
     * @link ChuckNorrisData
     */
    @Override
    public Mono<ChuckNorrisData> retrieveRandomJoke() {
        return WebClient.create(chuckNorrisServiceURL)
                .get()
                .uri("/jokes/random")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ChuckNorrisData.class);
    }
}
