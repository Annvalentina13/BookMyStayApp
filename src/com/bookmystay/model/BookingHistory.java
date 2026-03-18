package com.bookmystay.model;

import java.util.ArrayList;
import java.util.List;

/**
 * CLASS - BookingHistory
 *
 * Stores confirmed reservations
 */
public class BookingHistory {

    private List<Reservation> confirmedReservations;

    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    // Add reservation
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    // Get all reservations
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}