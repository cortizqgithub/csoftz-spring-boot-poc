package com.tips.java12;

import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormattingExample {
    public static void main(String[] args) {
        // Creating a number formatter with compact style
        NumberFormat compactFormatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);

        // Formatting large numbers
        System.out.println("Short Format: " + compactFormatter.format(1000));  // Output: 1K
        System.out.println("Short Format: " + compactFormatter.format(1000000));  // Output: 1M

        // Creating a number formatter with compact style (long)
        NumberFormat compactLongFormatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);

        // Formatting large numbers in long style
        System.out.println("Long Format: " + compactLongFormatter.format(10000000));  // Output: 10 million
        System.out.println("Long Format: " + compactLongFormatter.format(1000000000));  // Output: 1 billion
    }
}