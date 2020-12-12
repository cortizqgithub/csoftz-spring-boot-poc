/*----------------------------------------------------------------------------*/
/* Source File:   PERSONPRINTERTEST.JAVA                                      */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.common.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.devops.domain.Person;

/**
 * <p>This is part of a demo in supressing lombok annotated classes from coverage, in JaCoCo and in SonarQube.</p>
 * <p><a href="https://www.rainerhahnekamp.com/en/ignoring-lombok-code-in-jacoco">
 * Ignoring Lombok Code in Jacoco</a></p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.12/2020
 * @since 11 (JDK), Mar.04/2019
 */
class PersonPrinterTest {
    /**
     * Validates the Person creation holds a complete record.
     */
    @Test
    void shouldPersonBeComplete() {
        Person harrison =
            Person
                .builder()
                .firstName("John")
                .lastName("Harrison")
                .build();

        assertThat(new PersonPrinter(harrison).toString())
            .hasToString("John Harrison");
    }

    /**
     * Validates Person Last Name is empty.
     */
    @Test
    void shouldPersonLastNameBeEmpty() {
        Person anonymous =
            Person
                .builder()
                .firstName("anonymous")
                .lastName("")
                .build();

        assertThat(new PersonPrinter(anonymous).toString())
            .isEmpty();
    }
}