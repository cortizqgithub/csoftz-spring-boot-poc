/*----------------------------------------------------------------------------*/
/* Source File:   PERSONPRINTER.JAVA                                          */
/* Description:   Util for Person tasks.                                      */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Mar.01/2019                                                 */
/* Last Modified: Oct.15/2019                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.01/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.devops.util;

import com.example.devops.domain.Person;

import lombok.extern.log4j.Log4j2;

/**
 * Util for Person tasks.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.15/2019
 * @since 11 (JDK), Mar.01/2019
 */
@Log4j2
public class PersonPrinter {
    private Person person;

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
     * @return
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
