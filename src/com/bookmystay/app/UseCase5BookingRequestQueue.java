package com.bookmystay.app;

import com.bookmystay.model.Reservation;
import com.bookmystay.service.BookingRequestQueue;

/**
 * MAIN CLASS - UseCase5BookingRequestQueue
 *
 * Use Case 5: Booking Request (FIFO)
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        // Display header
        System.out.println("=== Booking Request Queue ===\n");

        // Initialize queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process queue (FIFO)
        while (bookingQueue.hasPendingRequests()) {
            Reservation r = bookingQueue.getNextRequest();

            System.out.println(
                "Guest: " + r.getGuestName() +
                " requested a " + r.getRoomType() + " room."
            );
        }
    }
}