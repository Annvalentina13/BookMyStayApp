package com.bookmystay.app;

import com.bookmystay.model.BookingHistory;
import com.bookmystay.model.Reservation;
import com.bookmystay.service.BookingReportService;

/**
 * MAIN CLASS - Use Case 8
 */
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        // Simulate confirmed reservations
        history.addReservation(new Reservation("Annie", "Deluxe"));
        history.addReservation(new Reservation("Akshaya", "Standard"));
        history.addReservation(new Reservation("Samuel", "Suite"));

        // Generate report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}