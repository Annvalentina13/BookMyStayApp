package com.bookmystay.app;

import com.bookmystay.inventory.RoomInventory;
import java.util.Map;

/**
 * MAIN CLASS - UseCase3InventorySetup
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * @version 3.1
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Create inventory object
        RoomInventory inventory = new RoomInventory();

        System.out.println("===== HOTEL ROOM INVENTORY =====");

        // Get availability map
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Print inventory
        for (String roomType : availability.keySet()) {
            System.out.println(roomType + " Available: " + availability.get(roomType));
        }

        System.out.println("\nUpdating inventory...\n");

        // Update example
        inventory.updateAvailability("Single Room", 4);

        for (String roomType : availability.keySet()) {
            System.out.println(roomType + " Available: " + availability.get(roomType));
        }
    }
}