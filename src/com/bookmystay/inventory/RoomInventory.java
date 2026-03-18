package com.bookmystay.inventory;

import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Add rooms
    public void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    // Check availability
    public boolean isAvailable(String type) {
        return inventory.getOrDefault(type, 0) > 0;
    }

    // Decrement after booking
    public void decrement(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }

    // ✅ FIX 1: Used in UseCase3
    public Map<String, Integer> getRoomAvailability() {
        return inventory;
    }

    // ✅ FIX 2: Used in older services
    public void updateAvailability(String type, int count) {
        inventory.put(type, count);
    }

    // Display
    public void displayInventory() {
        System.out.println("Current Inventory: " + inventory);
    }
}