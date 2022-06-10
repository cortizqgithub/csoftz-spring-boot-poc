/*----------------------------------------------------------------------------*/
/* Source File:   OPENFEIGNCLIENTCONFIGURATION.JAVA                           */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.09/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.spring.cloud.resilience4j.webmvc.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.csoftz.spring.cloud.resilience4j.webmvc.common.codec.feign.CustomErrorDecoder;

import feign.Logger;
import feign.codec.ErrorDecoder;

@Configuration
public class OpenFeignClientConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        // If the feign.client.config.default.loggerLevel is defined this bean is not set.
        // If it is not there, this bean would override.
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
