/*----------------------------------------------------------------------------*/
/* Source File:   PERSONPRINTERTEST.JAVA                                      */
/* Description:   Util for Person tasks.                                      */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.01/2019                                                 */
/* Last Modified: Jan.17/2020                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019, 2020 CSoftZ                                           */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.04/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.common.util;

import com.example.devops.domain.Person;

import lombok.extern.log4j.Log4j2;

/**
 * Util for Person tasks.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Jan.17/2020
 * @since 11 (JDK), Mar.01/2019
 */
@Log4j2
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
