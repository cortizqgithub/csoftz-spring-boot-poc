package com.tips.java10;

import static java.util.Comparator.comparing;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// Guide to Java 8 Comparator.comparing()
// https://www.baeldung.com/java-8-comparator-comparing
public class OptionalApi {
    /**
     * new .orElseThrow()
     */
    public static void main(String[] args) {

        Optional<Flight> earliestFlight = List.of(new Flight("Boston", "San Fransisco", LocalDate.now()))
            .stream()
            .filter(f -> "Boston".equals(f.from()))
            .filter(f -> "San Francisco".equals(f.to()))
            .min(comparing(Flight::date));

        earliestFlight.orElseThrow(() -> new FlightNotFoundException("Error"));
    }
}

record Flight(String from, String to, LocalDate date) {}


