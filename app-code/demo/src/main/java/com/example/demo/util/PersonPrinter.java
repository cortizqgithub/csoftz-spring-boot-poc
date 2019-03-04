package com.example.demo.util;

import com.example.demo.domain.Person;
import lombok.extern.java.Log;

@Log
public class PersonPrinter {
    private Person person;
    private String separator = " ";
    private String noLastnameLog = "That person has no name";

    public PersonPrinter(Person person) {
        this.person = person;
    }

    public String toString() {
        if ("".equals(person.getLastName())) {
            log.info(noLastnameLog);
            return "";
        }

        return String.format(person.getFirstName() + this.separator +
                person.getLastName());
    }
}
