package com.reactivespring.router;

import com.reactivespring.handler.ReviewHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ReviewRouter {

    @Bean
    public RouterFunction<ServerResponse> reviewsRoute(ReviewHandler reviewHandler) {
        return route()
            .nest(path("/v1/reviews"), builder -> {
                builder.POST("",request -> reviewHandler.addReview(request))
                    .GET("",request -> reviewHandler.getReviews(request))
                .PUT("/{id}", request -> reviewHandler.updateReview(request))
                    .DELETE("/{id}", request -> reviewHandler.deleteReview(request))
                    .GET("/stream", request -> reviewHandler.reviewsStream(request));
            })
            .GET("/v1/helloworld", (request -> ServerResponse.ok().bodyValue("helloworld")) )
            .build();
    }
}
