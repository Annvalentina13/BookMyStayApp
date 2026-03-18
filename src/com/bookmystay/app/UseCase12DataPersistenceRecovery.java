package com.bookmystay.app;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.service.FilePersistenceService;

/**
 * MAIN CLASS - Use Case 12
 */
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("=== Data Persistence & Recovery ===");

        String filePath = "inventory.txt";

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        // 🔄 Load previous state
        persistenceService.loadInventory(inventory, filePath);

        // If first run, initialize
        if (inventory.getRoomAvailability().isEmpty()) {
            inventory.addRoom("Deluxe", 3);
            inventory.addRoom("Standard", 2);
        }

        System.out.println("Current Inventory:");
        inventory.displayInventory();

        // Simulate change
        inventory.decrement("Deluxe");

        System.out.println("After Booking:");
        inventory.displayInventory();

        // 💾 Save updated state
        persistenceService.saveInventory(inventory, filePath);
    }
}