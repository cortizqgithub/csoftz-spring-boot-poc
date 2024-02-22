package com.tips.java9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// A Comprehensive Journey from Java 8 to Java 21 with Code Examples of Essential API Enhancements”
// https://rathod-ajay.medium.com/a-comprehensive-journey-from-java-8-to-java-21-with-code-examples-of-essential-api-enhancements-6817d2ab3ba8
// There are few more examples in this article.
public class StreamAPIImprovementsExample {
    public static void main(String[] args) {
        // Example 1: takeWhile
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> lessThanFive = numbers.stream()
            .takeWhile(n -> n < 5)
            .collect(Collectors.toList());

        System.out.println("Numbers less than 5: " + lessThanFive);

        // Example 2: dropWhile
        List<Integer> greaterThanThree = numbers.stream()
            .dropWhile(n -> n <= 3)
            .collect(Collectors.toList());

        System.out.println("Numbers greater than 3: " + greaterThanThree);

        // Example 3: ofNullable

        // Example 3: ofNullable
        String value1 = "Hello";
        String value2 = null;

        // Example with a non-null value
        // Does not exist in Java 21 --> Stream.ofNullable(value1).ifPresentOrElse(v -> System.out.println("ofNullable Example - Non-null value: " + v), () -> System.out.println("ofNullable Example - Null value"));

        // Example with a null value
        //Stream.ofNullable(value2).ifPresentOrElse(v -> System.out.println("ofNullable Example - Non-null value: " + v), () -> System.out.println("ofNullable Example - Null value"));

        //Example of null safe stream
        List<String> names = Arrays.asList("Alice", "Bob", null, "Charlie", null, "David");
        List<String> nonNullNames = names.stream()
            .flatMap(name -> StreamAPIImprovementsExample.nullSafeStream(name))
            .collect(Collectors.toList());

        System.out.println("Non-null names: " + nonNullNames);
    }

    // Helper method to create a stream from a potentially null value
    private static <T> Stream<T> nullSafeStream(T value) {
        return value == null ? Stream.empty() : Stream.of(value);
    }
}