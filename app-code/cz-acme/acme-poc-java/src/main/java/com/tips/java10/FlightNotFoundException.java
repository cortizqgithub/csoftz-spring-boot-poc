package com.tips.java10;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(String errorMessage) {
        super((errorMessage));
    }
}
