package com.bookmystay.app;

import java.util.LinkedList;
import java.util.Queue;

import com.bookmystay.model.Reservation;
import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.service.RoomAllocationService;

public class UseCase6RoomAllocation {

    public static void main(String[] args) {

        // Step 1: Setup Inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Deluxe", 2);
        inventory.addRoom("Standard", 1);

        // Step 2: Create FIFO Queue
        Queue<Reservation> requestQueue = new LinkedList<>();

        requestQueue.add(new Reservation("Alice", "Deluxe"));
        requestQueue.add(new Reservation("Bob", "Deluxe"));
        requestQueue.add(new Reservation("Charlie", "Standard"));
        requestQueue.add(new Reservation("Derin", "Standard")); // should fail

        // Step 3: Allocation Service
        RoomAllocationService service = new RoomAllocationService();

        // Step 4: Process Queue (FIFO)
        while (!requestQueue.isEmpty()) {
            Reservation reservation = requestQueue.poll();
            service.allocateRoom(reservation, inventory);
        }

        // Step 5: Final Inventory
        inventory.displayInventory();
    }
}