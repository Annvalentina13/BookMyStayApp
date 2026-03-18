package com.bookmystay.model;

/**
 * CLASS - AddOnService
 *
 * Represents optional services like Breakfast, Spa, etc.
 */
public class AddOnService {

    private String serviceName;
    private double cost;

    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }
}