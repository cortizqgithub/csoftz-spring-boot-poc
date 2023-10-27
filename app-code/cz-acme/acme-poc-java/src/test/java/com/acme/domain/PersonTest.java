
package com.acme.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void testAgeAt() {
        var birthData = LocalDate.of(1980, 1, 1);
        var person = new Person("A", "B", birthData);
        var age = person.ageAt(LocalDate.of(2000, 1, 1));

        assertEquals(20, age);
    }

    @Test
    void testAgeToday() {
        var person = new Person("Random", "Name", LocalDate.now().minusYears(4));
        var ageToday = person.ageToday();

        assertEquals(4, ageToday);
    }

    @Test
    void testOlderThan() {
        var person = new Person("Random", "Name", LocalDate.now().minusYears(4));
        var person2 = new Person("Random", "Name", LocalDate.now().minusYears(5));

        assertTrue(person2.olderThan(person));
    }

    @Test
    void testAssignTask() {
        var person = new Person("Random", "Name", LocalDate.now().minusYears(4));

        person.assign(new Task(1, "Create task Api"));

        assertEquals(1, person.tasks().size());
    }

    @Test
    void testFindTaskById() {
        var person = new Person("Random", "Name", LocalDate.now().minusYears(4));
        var task1 = new Task(1, "Create task Api");
        var task2 = new Task(2, "Create Person Api");

        person.assign(task1);
        person.assign(task2);

        var taskById = person.findTaskById(2);

        assertEquals(2, person.tasks().size());
        assertTrue(taskById.isPresent());
        assertEquals(task2, taskById.get());
    }
}