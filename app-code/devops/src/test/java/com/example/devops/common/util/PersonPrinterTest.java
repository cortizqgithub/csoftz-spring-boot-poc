/*----------------------------------------------------------------------------*/
/* Source File:   PERSONPRINTERTEST.JAVA                                      */
/* Description:   Person Printer tests.                                       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.04/2019                                                 */
/* Last Modified: Jan.27/2020                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.common.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.example.devops.domain.Person;

/**
 * <p>This is part of a demo in supressing lombok annotated classes from coverage, in JaCoCo and in SonarQube.</p>
 * <p><a href="https://www.rainerhahnekamp.com/en/ignoring-lombok-code-in-jacoco">
 * Ignoring Lombok Code in Jacoco</a></p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Jan.27/2020
 * @since 11 (JDK), Mar.04/2019
 */
public class PersonPrinterTest {
    /**
     * Validates the Person creation holds a complete record.
     */
    @Test
    public void shouldPersonBeComplete() {
        Person harrison = Person.builder()
            .firstName("John").lastName("Harrison").build();

        assertThat(new PersonPrinter(harrison).toString())
            .isEqualTo("John Harrison");
    }

    /**
     * Validates Person Last Name is empty.
     */
    @Test
    public void shouldPersonLastNameBeEmpty() {
        Person anonymous = Person.builder()
            .firstName("anonymous").lastName("").build();

        assertThat(new PersonPrinter(anonymous).toString())
            .isEmpty();
    }
}