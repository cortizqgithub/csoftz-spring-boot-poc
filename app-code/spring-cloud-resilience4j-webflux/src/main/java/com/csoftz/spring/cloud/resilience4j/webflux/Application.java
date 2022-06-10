package com.csoftz.spring.cloud.resilience4j.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Based on the article
 * <a href="https://betterprogramming.pub/implementing-reactive-circuit-breaker-using-resilience4j-4fe81d28e100">
 * Implementing Reactive Circuit Breaker Using Resilience4j</a>
 * <p>Other Useful Guides
 * <a href="https://vikasverma.tech/post/spring-boot-resilience4j-circuitbreaker-example/">Spring boot reactive and resilience4j circuit breaker example</a>
 * <b>NOTE:</b>This is Kotlin coded</p>
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
