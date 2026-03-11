package com.bookmystay.service;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.model.Room;

import java.util.Map;

/**
 * CLASS - RoomSearchService
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class provides search functionality
 * for guests to view available rooms.
 *
 * It reads room availability from inventory
 * and room details from Room objects.
 *
 * No inventory mutation or booking logic
 * is performed in this class.
 *
 * @version 4.0
 */
public class RoomSearchService {

    /**
     * Displays available rooms along with
     * their details and pricing.
     *
     * This method performs read-only access
     * to inventory and room data.
     *
     * @param inventory centralized room inventory
     * @param singleRoom single room definition
     * @param doubleRoom double room definition
     * @param suiteRoom suite room definition
     */
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("===== AVAILABLE ROOMS =====\n");

        // Check and display Single Room availability
        Integer singleAvail = availability.get("Single Room");
        if (singleAvail != null && singleAvail > 0) {
            System.out.println("Single Room - Available: " + singleAvail);
            singleRoom.displayRoomDetails();
            System.out.println();
        }

        // Check and display Double Room availability
        Integer doubleAvail = availability.get("Double Room");
        if (doubleAvail != null && doubleAvail > 0) {
            System.out.println("Double Room - Available: " + doubleAvail);
            doubleRoom.displayRoomDetails();
            System.out.println();
        }

        // Check and display Suite Room availability
        Integer suiteAvail = availability.get("Suite Room");
        if (suiteAvail != null && suiteAvail > 0) {
            System.out.println("Suite Room - Available: " + suiteAvail);
            suiteRoom.displayRoomDetails();
            System.out.println();
        }
    }
}