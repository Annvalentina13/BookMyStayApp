package com.bookmystay.service;

import java.util.*;

import com.bookmystay.inventory.RoomInventory;

/**
 * CLASS - CancellationService
 *
 * Handles booking cancellation and rollback
 */
public class CancellationService {

    // Stack for rollback (LIFO)
    private Stack<String> releasedRoomIds;

    // Map reservationId → roomType
    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    // Register confirmed booking
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    // Cancel booking
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        // Validate booking exists
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Invalid cancellation: Reservation not found!");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        // Push to stack (rollback tracking)
        releasedRoomIds.push(reservationId);

        // Restore inventory
        inventory.updateAvailability(
                roomType,
                inventory.getRoomAvailability().get(roomType) + 1
        );

        // Remove booking
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled: " + reservationId);
    }

    // Show rollback history (LIFO)
    public void showRollbackHistory() {

        System.out.println("=== Rollback History ===");

        while (!releasedRoomIds.isEmpty()) {
            System.out.println("Cancelled: " + releasedRoomIds.pop());
        }
    }
}