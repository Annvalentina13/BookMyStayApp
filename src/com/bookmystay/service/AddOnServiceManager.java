package com.bookmystay.service;

import java.util.*;

import com.bookmystay.model.AddOnService;

/**
 * CLASS - AddOnServiceManager
 *
 * Manages services for each reservation
 */
public class AddOnServiceManager {

    // reservationId → list of services
    private Map<String, List<AddOnService>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    // Add service to reservation
    public void addService(String reservationId, AddOnService service) {

        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());
        servicesByReservation.get(reservationId).add(service);

        System.out.println(service.getServiceName() + " added to " + reservationId);
    }

    // Calculate total cost
    public double calculateTotalServiceCost(String reservationId) {

        double total = 0;

        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services != null) {
            for (AddOnService s : services) {
                total += s.getCost();
            }
        }

        return total;
    }
}