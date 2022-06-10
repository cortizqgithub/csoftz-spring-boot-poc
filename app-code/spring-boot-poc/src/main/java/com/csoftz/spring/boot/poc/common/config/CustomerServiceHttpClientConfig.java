/*----------------------------------------------------------------------------*/
/* Source File:   CustomerServiceHttpClientConfig.JAVA                                               */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.09/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.boot.poc.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.csoftz.spring.boot.poc.service.client.CustomerServiceHttpClient;

@Configuration
public class CustomerServiceHttpClientConfig {
    @Bean
    CustomerServiceHttpClient customerServiceHttpClient(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(CustomerServiceHttpClient.class);
    }

    @Bean
    HttpServiceProxyFactory httpServiceProxyFactory(WebClient.Builder clientBuilder, ConversionService service) {

        WebClient webClient = clientBuilder.baseUrl("http://localhost:8500").build();
        HttpServiceProxyFactory proxyFactory = new HttpServiceProxyFactory(new WebClientAdapter(webClient));
        proxyFactory.setConversionService(service);
        return proxyFactory;
    }
}
