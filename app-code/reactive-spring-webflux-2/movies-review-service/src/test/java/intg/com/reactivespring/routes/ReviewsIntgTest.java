package com.reactivespring.routes;

import com.reactivespring.domain.Review;
import com.reactivespring.repository.ReviewReactiveRepository;
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

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
public class ReviewsIntgTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    ReviewReactiveRepository reviewReactiveRepository;

    private static String REVIEW_INFO_ENDPOINT = "/v1/reviews";

    @BeforeEach
    void setUp() {
        var reviewsList = List.of(
            new Review(null, 1L, "Awesome Movie", 9.0),
            new Review(null, 1L, "Awesome Movie1", 9.0),
            new Review("abc", 2L, "Excellent Movie", 8.0));
        reviewReactiveRepository.saveAll(reviewsList)
            .blockLast();
    }

    @AfterEach
    void tearDown() {
        reviewReactiveRepository.deleteAll().block();
    }

    @Test
    void addReview() {
        //given
        var review = new Review(null, 1L, "Awesome Movie", 9.0);

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
    void getAllReviews() {

        //when
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
        //given
        var review = new Review("abc", 2L, "The Worst Movie", 4.0);
        var reviewId = "abc";

        //when
        webTestClient.put()
            .uri(REVIEW_INFO_ENDPOINT + "/{id}", reviewId)
            .bodyValue(review)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody(Review.class)
            .consumeWith(reviewEntityExchangeResult -> {
                var updatedReview = reviewEntityExchangeResult.getResponseBody();
                assert updatedReview != null;
                assert updatedReview.getReviewId() != null;
                Assertions.assertEquals("The Worst Movie", updatedReview.getComment());

            });
    }

    @Test
    void deleteReview() {
        //given
        var reviewId = "abc";

        //when
        webTestClient.delete()
            .uri(REVIEW_INFO_ENDPOINT + "/{id}", reviewId)
            .exchange()
            .expectStatus()
            .isNoContent();
    }

    @Test
    void getReviewByMovieInfoId() {
        //given



        //when
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
