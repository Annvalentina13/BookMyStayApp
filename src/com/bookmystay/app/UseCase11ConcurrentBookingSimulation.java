package com.bookmystay.app;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.model.Reservation;
import com.bookmystay.service.*;

/**
 * MAIN CLASS - Use Case 11
 */
public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("=== Concurrent Booking Simulation ===");

        // Shared resources
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Deluxe", 2);

        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Add booking requests
        bookingQueue.addRequest(new Reservation("Annie", "Deluxe"));
        bookingQueue.addRequest(new Reservation("Akshaya", "Deluxe"));
        bookingQueue.addRequest(new Reservation("Samuel", "Deluxe"));
        bookingQueue.addRequest(new Reservation("Akash", "Deluxe"));

        // Create threads
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        // Start threads
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        // Final inventory
        inventory.displayInventory();
    }
}