package com.acme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestContainerApplication {

    public static void main(String[] args) {
        SpringApplication.from(Application::main).with(TestContainerApplication.class).run(args);
    }

}
