/*----------------------------------------------------------------------------*/
/* Source File:   LEAPYEARCONTROLLERTEST.JAVA                                 */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jul.24/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.api.controller.integration;

import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1600;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1600_STATUS;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1700;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1700_STATUS;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1800;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1800_STATUS;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1900;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_1900_STATUS;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_2000;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_2000_STATUS;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_2019;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_2019_STATUS;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_2020;
import static com.example.devops.common.util.consts.CommonTestConstants.LEAP_YEAR_TEST_2020_STATUS;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.devops.api.controller.LeapYearController;
import com.example.devops.service.intr.LeapYearService;

/**
 * REST Api for LeapYear end-points. (Tests)
 * <p><b>NOTE:</b>This controller uses Spring WebFlux, this means it is reactive.</p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Dec.12/2020
 * @since 11 (JDK), Jul.24/2020
 */
@ExtendWith(SpringExtension.class)
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "api.example.com")
@WebFluxTest(LeapYearController.class)
class LeapYearControllerIntegrationTest {
    private static final String LEAP_YEAR_BASE_URL = "/api/v1/leap/year";
    private static final String LEAP_YEAR_CHECK_URL = LEAP_YEAR_BASE_URL + "/check?leapYear=2020";
    private static final String LEAP_YEARS_CHECK_URL = LEAP_YEAR_BASE_URL + "/check/years?leapYears=1600,1700,1800,1900,2000,2019,2020";
    private static final String ASCIIDOC_SNIPPET_LEAP_YEAR_CHECK = "leap-year-check";
    private static final String ASCIIDOC_SNIPPET_LEAP_YEARS_CHECK = "leap-years-check";

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private LeapYearService leapYearService;

    /**
     * As MessageController is a WebFlux (it has Mono and Flux return types) it means that this test must use
     * Spring WebFlux testing capabilities.
     */
    @Test
    void shouldReturnCheckedLeapYear() {
        when(leapYearService.check(LEAP_YEAR_TEST_2020)).thenReturn(LEAP_YEAR_TEST_2020_STATUS);

        this.webTestClient.get()
            .uri(LEAP_YEAR_CHECK_URL)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .consumeWith(document(ASCIIDOC_SNIPPET_LEAP_YEAR_CHECK, preprocessResponse(prettyPrint())));

        verify(leapYearService, times(1)).check(anyInt());
    }

    @Test
    void shouldReturnCheckedLeapYears() {
        when(leapYearService.check(LEAP_YEAR_TEST_1600)).thenReturn(LEAP_YEAR_TEST_1600_STATUS);
        when(leapYearService.check(LEAP_YEAR_TEST_1700)).thenReturn(LEAP_YEAR_TEST_1700_STATUS);
        when(leapYearService.check(LEAP_YEAR_TEST_1800)).thenReturn(LEAP_YEAR_TEST_1800_STATUS);
        when(leapYearService.check(LEAP_YEAR_TEST_1900)).thenReturn(LEAP_YEAR_TEST_1900_STATUS);
        when(leapYearService.check(LEAP_YEAR_TEST_2000)).thenReturn(LEAP_YEAR_TEST_2000_STATUS);
        when(leapYearService.check(LEAP_YEAR_TEST_2019)).thenReturn(LEAP_YEAR_TEST_2019_STATUS);
        when(leapYearService.check(LEAP_YEAR_TEST_2020)).thenReturn(LEAP_YEAR_TEST_2020_STATUS);

        this.webTestClient.get()
            .uri(LEAP_YEARS_CHECK_URL)
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .consumeWith(document(ASCIIDOC_SNIPPET_LEAP_YEARS_CHECK, preprocessResponse(prettyPrint())));

        verify(leapYearService, times(7)).check(anyInt());
    }
}