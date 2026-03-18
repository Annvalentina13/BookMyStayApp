package com.bookmystay.service;

import com.bookmystay.model.BookingHistory;
import com.bookmystay.model.Reservation;

/**
 * CLASS - BookingReportService
 *
 * Generates reports from booking history
 */
public class BookingReportService {

    public void generateReport(BookingHistory history) {

        System.out.println("===== BOOKING REPORT =====");

        for (Reservation r : history.getConfirmedReservations()) {
            System.out.println("Guest: " + r.getGuestName()
                    + " | Room Type: " + r.getRoomType());
        }

        System.out.println("==========================");
    }
}