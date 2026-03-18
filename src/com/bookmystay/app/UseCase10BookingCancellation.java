package com.bookmystay.app;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.service.CancellationService;

/**
 * MAIN CLASS - Use Case 10
 */
public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("=== Booking Cancellation ===");

        // Setup inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Deluxe", 2);

        // Cancellation service
        CancellationService service = new CancellationService();

        // Simulate confirmed bookings
        service.registerBooking("RES-101", "Deluxe");
        service.registerBooking("RES-102", "Deluxe");

        // Cancel bookings
        service.cancelBooking("RES-101", inventory);
        service.cancelBooking("RES-102", inventory);

        // Invalid case
        service.cancelBooking("RES-999", inventory);

        // Show rollback history
        service.showRollbackHistory();

        // Final inventory
        inventory.displayInventory();
    }
}