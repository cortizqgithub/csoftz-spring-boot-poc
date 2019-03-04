package com.example.demo.util;

import com.example.demo.domain.Person;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonPrinter {
    private Person person;

    PersonPrinter(Person person) {
        this.person = person;
    }

    public String toString() {
        if ("".equals(person.getLastName())) {
            String noLastnameLog = "That person has no name";
            log.info(noLastnameLog);
            return "";
        }

        return person.getFirstName() + " " + person.getLastName();
    }
}
