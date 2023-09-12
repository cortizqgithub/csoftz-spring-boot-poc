package com.reactivespring.client;

import com.reactivespring.domain.Movie;
import com.reactivespring.domain.MovieInfo;
import com.reactivespring.exception.MoviesInfoClientException;
import com.reactivespring.exception.MoviesInfoServerException;
import com.reactivespring.util.RetryUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Component
@Slf4j
public class MoviesInfoRestClient {

    private WebClient webClient;

    @Value("${restClient.moviesInfoUrl}")
    private String moviesInfoUrl;

    public MoviesInfoRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<MovieInfo> retrieveMovieInfo(String movieId) {
        var url = moviesInfoUrl.concat("/{id}");

        return webClient.get()
            .uri(url, movieId)
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
                log.info("Status code is {} ", clientResponse.statusCode().value());
                if(clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)) {
                    return Mono.error(new MoviesInfoClientException("There is no movie info available for the passed in Id: " + movieId,
                        clientResponse.statusCode().value()));
                }
                return clientResponse.bodyToMono(String.class)
                    .flatMap(responseMessage -> Mono.error(new MoviesInfoClientException(responseMessage, clientResponse.statusCode().value())));

            })
            .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
                log.info("Status code is {} ", clientResponse.statusCode().value());
                return clientResponse.bodyToMono(String.class)
                    .flatMap(responseMessage -> Mono.error(new MoviesInfoServerException("Server Exception in Movies info Service: "+ responseMessage)));
            })
            .bodyToMono(MovieInfo.class)
            //.retry(3)
            .retryWhen(RetryUtil.retrySpec())
            .log();
    }

    public Flux<MovieInfo> retrieveMovieInfoStream() {
        var url = moviesInfoUrl.concat("/stream");

        return webClient.get()
            .uri(url)
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
                log.info("Status code is {} ", clientResponse.statusCode().value());

                return clientResponse.bodyToMono(String.class)
                    .flatMap(responseMessage -> Mono.error(new MoviesInfoClientException(responseMessage, clientResponse.statusCode().value())));

            })
            .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
                log.info("Status code is {} ", clientResponse.statusCode().value());
                return clientResponse.bodyToMono(String.class)
                    .flatMap(responseMessage -> Mono.error(new MoviesInfoServerException("Server Exception in Movies info Service: "+ responseMessage)));
            })
            .bodyToFlux(MovieInfo.class)
            .log();
    }
}
