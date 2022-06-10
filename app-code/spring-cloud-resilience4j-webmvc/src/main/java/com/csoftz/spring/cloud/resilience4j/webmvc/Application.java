package com.csoftz.spring.cloud.resilience4j.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Based on the article
 * <a href="https://www.baeldung.com/spring-cloud-circuit-breaker">
 * Quick Guide to Spring Cloud Circuit Breaker</a>
 * <p>Other useful guides:
 * <a href="https://www.baeldung.com/rest-template">The Guide to RestTemplate</a></p>
 * <a href="https://reflectoring.io/spring-resttemplate/">Complete Guide to RestTemplate</a></p>
 * <p><a href="https://www.baeldung.com/spring-rest-template-list">Get and Post Lists of Objects with RestTemplate</a></p>
 * <a href="https://www.baeldung.com/spring-cloud-openfeign">Introduction to Spring Cloud OpenFeign</a>
 */
@SpringBootApplication
@EnableFeignClients
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
