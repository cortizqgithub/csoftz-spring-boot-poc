/*----------------------------------------------------------------------------*/
/* Source File:   CUSTOMPROPERTIES.JAVA                                       */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.28/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.common.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>A sample class to create the configuration properties for an application
 * using the Spring Boot mechanism.
 * <ul><li>
 * <a href="https://www.baeldung.com/intellij-resolve-spring-boot-configuration-properties">
 * IntelliJ – Cannot Resolve Spring Boot Configuration Properties Error</a></li>
 * <li><a href="https://www.baeldung.com/spring-boot-configuration-metadata#generating-metadata">
 * A Guide to Spring Boot Configuration Metadata</a></li>
 * </ul>
 * </p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Dec.12/2020
 * @since 11 (JDK), Mar.28/2020
 */

@Configuration
@ConfigurationProperties(prefix = "com.csoftz")
@Getter
@Setter
public class CustomProperties {
    /**
     * The url to connect to.
     */
    String url;

    /**
     * The time to wait for the connection.
     */
    private int timeoutInMilliSeconds = 1000;
}
