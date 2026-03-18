package com.bookmystay.service;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.model.Reservation;

/**
 * CLASS - ConcurrentBookingProcessor
 *
 * Handles booking in multi-threaded environment
 */
public class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService
    ) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            // 🔒 Synchronize queue access
            synchronized (bookingQueue) {

                if (!bookingQueue.hasPendingRequests()) {
                    break; // stop thread if no more requests
                }

                reservation = bookingQueue.getNextRequest();
            }

            // 🔒 Synchronize inventory (critical section)
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}