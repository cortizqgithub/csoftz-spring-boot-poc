/*----------------------------------------------------------------------------*/
/* Source File:   PROPERTYENVIRONMENTEXTRACTORSERVICEIMPLTEST.JAVA            */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Dec.25/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.cz.examples.service.extractor;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.cz.examples.utils.TestTools;

/**
 * Unit tests for PropertyEnvironmentExtractorServiceImpl.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.25/2020
 * @see PropertyEnvironmentExtractorServiceImpl
 * @since 15 (JDK), Dec.25/2020
 */
class PropertyEnvironmentExtractorServiceImplTest {
    private static final String EXTRACTOR_PROPS_JSON = "/extractor/props.json";
    private PropertyEnvironmentExtractorService propertyEnvironmentExtractorService;

    @BeforeEach
    void setUp() {
        propertyEnvironmentExtractorService = new PropertyEnvironmentExtractorServiceImpl();
    }

    @Test
    void when() throws IOException {
        assertThat(
            propertyEnvironmentExtractorService
                .extractPropertiesFrom(TestTools.retrieveSrcTestResourcesDirectoryWith(EXTRACTOR_PROPS_JSON)))
            .hasSize(2)
            .contains("carlos=ortiz", "next=one");
    }
}
