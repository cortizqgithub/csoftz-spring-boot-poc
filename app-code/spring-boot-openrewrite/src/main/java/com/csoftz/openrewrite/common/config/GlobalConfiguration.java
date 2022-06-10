/*----------------------------------------------------------------------------*/
/* Source File:   GLOBALCONFIGURATION.JAVA                                    */
/* Copyright (c), 2022 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jun.10/2022  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.openrewrite.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfiguration {

    @Bean
    String appName() {
        return "AppName";
    }
}
