package com.bookmystay.exception;

/**
 * Custom Exception for invalid bookings
 */
public class InvalidBookingException extends Exception {

    public InvalidBookingException(String message) {
        super(message);
    }
}