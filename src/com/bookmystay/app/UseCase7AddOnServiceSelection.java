package com.bookmystay.app;

import com.bookmystay.model.AddOnService;
import com.bookmystay.service.AddOnServiceManager;

/**
 * MAIN CLASS - Use Case 7
 */
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        // Assume reservation already confirmed
        String reservationId = "RES-101";

        AddOnServiceManager manager = new AddOnServiceManager();

        // Create services
        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService spa = new AddOnService("Spa", 1500);
        AddOnService pickup = new AddOnService("Airport Pickup", 800);

        // Add services
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);
        manager.addService(reservationId, pickup);

        // Calculate total cost
        double total = manager.calculateTotalServiceCost(reservationId);

        System.out.println("Total Add-On Cost: " + total);
    }
}