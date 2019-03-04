package com.example.devops.util;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.devops.domain.Person;
import org.junit.Test;

/**
 * This is part of a demo in supressing lombok annotated classes from coverage, in JaCoCo and in SonarQube.
 *
 * @see <a href="https://www.rainerhahnekamp.com/en/ignoring-lombok-code-in-jacoco"></a>
 */
public class PersonPrinterTest {
    @Test
    public void shouldPersonBeComplete() {
        Person harrison = Person.builder()
                .firstName("John").lastName("Harrison").build();

        assertThat(new PersonPrinter(harrison).toString())
                .isEqualTo("John Harrison");
    }

    @Test
    public void shouldPersonLastNameBeEmpty() {
        Person anonymous = Person.builder()
                .firstName("anonymous").lastName("").build();

        assertThat(new PersonPrinter(anonymous).toString())
                .isEmpty();
    }
}