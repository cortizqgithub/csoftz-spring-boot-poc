package com.reactivespring.routes;

import com.reactivespring.domain.Review;
import com.reactivespring.exceptionhandler.GlobalErrorHandler;
import com.reactivespring.handler.ReviewHandler;
import com.reactivespring.repository.ReviewReactiveRepository;
import com.reactivespring.router.ReviewRouter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

@WebFluxTest
@ContextConfiguration(classes = {ReviewRouter.class, ReviewHandler.class, GlobalErrorHandler.class})
@AutoConfigureWebTestClient
public class ReviewsUnitTest {

    @MockBean
    private ReviewReactiveRepository reviewReactiveRepository;

    @Autowired
    WebTestClient webTestClient;
    private static String REVIEW_INFO_ENDPOINT = "/v1/reviews";

    @Test
    void addReview() {
        //given
        var review = new Review(null, 1L, "Awesome Movie", 9.0);

        when(reviewReactiveRepository.save(isA(Review.class)))
            .thenReturn(Mono.just(new Review("abc", 1L, "Awesome Movie", 9.0)));

        //when
        webTestClient
            .post()
            .uri(REVIEW_INFO_ENDPOINT)
            .bodyValue(review)
            .exchange()
            .expectStatus().isCreated()
            .expectBody(Review.class)
            .consumeWith(reviewResponse -> {
                var savedReview = reviewResponse.getResponseBody();
                assert savedReview != null;
                Assertions.assertNotNull(savedReview.getReviewId());
            });

        //then
    }

    @Test
    void addReviewValidation() {
        //given
        var review = new Review(null, null, "Awesome Movie", -9.0);

        when(reviewReactiveRepository.save(isA(Review.class)))
            .thenReturn(Mono.just(new Review("abc", 1L, "Awesome Movie", 9.0)));

        //when
        webTestClient
            .post()
            .uri(REVIEW_INFO_ENDPOINT)
            .bodyValue(review)
            .exchange()
            .expectStatus().isBadRequest()
            .expectBody(String.class)
            .isEqualTo("rating.movieInfoId : must not be null, rating.negative : rating is negative and please pass a non-negative value");


        //then
    }


    @Test
    void getReviews() {
        var reviewsList = List.of(
            new Review("ghi", 1L, "Awesome Movie", 9.0),
            new Review("def", 1L, "Awesome Movie1", 9.0),
            new Review("abc", 2L, "Excellent Movie", 8.0));

        when(reviewReactiveRepository.findAll()).thenReturn(Flux.fromIterable(reviewsList));

        webTestClient.get()
            .uri(REVIEW_INFO_ENDPOINT)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBodyList(Review.class)
            .hasSize(3);
    }

    @Test
    void updateReview() {
        var newReview = new Review("abc", 2L, "Excellent Movie", 8.0);
        var oldReview = new Review("abc", 1L, "A bad movie", 5.0);

        when(reviewReactiveRepository.save(isA(Review.class))).thenReturn(Mono.just(newReview));
        when(reviewReactiveRepository.findById(anyString())).thenReturn(Mono.just(oldReview));

        webTestClient.put()
            .uri(REVIEW_INFO_ENDPOINT + "/{id}", "abc")
            .bodyValue(newReview)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody(Review.class)
            .consumeWith(reviewEntityExchangeResult -> {
                var updatedReview = reviewEntityExchangeResult.getResponseBody();
                assert updatedReview != null;
                assert updatedReview.getReviewId() != null;
                Assertions.assertEquals("Excellent Movie", updatedReview.getComment());

            });

    }

    @Test
    void deleteReview() {
        var reviewId = "abc";
        var review = new Review("abc", 1L, "A bad movie", 5.0);
        when(reviewReactiveRepository.findById(anyString())).thenReturn(Mono.just(review));
        when(reviewReactiveRepository.deleteById(anyString())).thenReturn(Mono.empty());

        webTestClient.delete()
            .uri(REVIEW_INFO_ENDPOINT + "/{id}", reviewId)
            .exchange()
            .expectStatus()
            .isNoContent();
    }

    @Test
    void getReviewByMovieInfoId() {

        var reviewsList = List.of(
            new Review("ghi", 1L, "Awesome Movie", 9.0),
            new Review("def", 1L, "Awesome Movie1", 9.0));

        when(reviewReactiveRepository.findReviewsByMovieInfoId(anyLong())).thenReturn(Flux.fromIterable(reviewsList));

        webTestClient.get()
            .uri(uriBuilder -> {
                return uriBuilder.path(REVIEW_INFO_ENDPOINT)
                    .queryParam("movieInfoId", "1")
                    .build();
            })
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBodyList(Review.class)
            .hasSize(2);
    }
}
