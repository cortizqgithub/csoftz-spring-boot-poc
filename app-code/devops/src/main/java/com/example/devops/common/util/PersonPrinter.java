/*----------------------------------------------------------------------------*/
/* Source File:   PERSONPRINTERTEST.JAVA                                      */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.04/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.common.util;

import com.example.devops.domain.Person;

import lombok.extern.slf4j.Slf4j;

/**
 * Util for Person tasks.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, Dec.12/2020
 * @since 11 (JDK), Mar.01/2019
 */
@Slf4j
public class PersonPrinter {
    private final Person person;

    /**
     * Default Constructor
     *
     * @param person instance.
     */
    PersonPrinter(Person person) {
        this.person = person;
    }

    /**
     * Prints the Person instance values.
     *
     * @return String containing Person values.
     */
    public String toString() {
        if ("".equals(person.getLastName())) {
            String noLastnameLog = "That person has no name";
            log.info(noLastnameLog);
            return "";
        }

        return person.getFirstName() + " " + person.getLastName();
    }
}
