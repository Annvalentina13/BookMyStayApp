package com.bookmystay.app;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.model.SingleRoom;
import com.bookmystay.model.DoubleRoom;
import com.bookmystay.model.SuiteRoom;
import com.bookmystay.service.RoomSearchService;

/**
 * MAIN CLASS - UseCase4RoomSearch
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class demonstrates how guests
 * can view available rooms without
 * modifying inventory data.
 *
 * The system enforces read-only access
 * by design and usage discipline.
 *
 * @version 4.0
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Initialize room definitions
        SingleRoom singleRoom = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        SuiteRoom suiteRoom = new SuiteRoom();

        // Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Create search service instance
        RoomSearchService searchService = new RoomSearchService();

        // Perform search and display available rooms
        searchService.searchAvailableRooms(inventory, singleRoom, doubleRoom, suiteRoom);
    }
}