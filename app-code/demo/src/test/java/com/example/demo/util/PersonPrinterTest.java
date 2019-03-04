package com.example.demo.util;

import com.example.demo.domain.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is part of a demo in supressing lombok annotated classes from coverage, in JaCoCo and in SonarQube.
 *
 * @see <a href="https://www.rainerhahnekamp.com/en/ignoring-lombok-code-in-jacoco"></a>
 */
public class PersonPrinterTest {
    @Test
    public void testDefault() {
        Person harrison = Person.builder()
                .firstName("John").lastName("Harrison").build();

        assertEquals("John Harrison",
                new PersonPrinter(harrison).toString());
    }

    @Test
    public void testNoLastname() {
        Person anonymous = Person.builder()
                .firstName("anonymous").lastName("").build();

        assertEquals("", new PersonPrinter(anonymous).toString());
    }
}