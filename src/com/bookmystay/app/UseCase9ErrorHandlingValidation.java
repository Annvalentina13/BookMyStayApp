package com.bookmystay.app;

import java.util.Scanner;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.service.BookingRequestQueue;
import com.bookmystay.service.ReservationValidator;
import com.bookmystay.model.Reservation;
import com.bookmystay.exception.InvalidBookingException;

/**
 * MAIN CLASS - Use Case 9
 */
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("=== Booking Validation ===");

        Scanner scanner = new Scanner(System.in);

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Deluxe", 2);
        inventory.addRoom("Standard", 1);

        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            // Take input
            System.out.print("Enter Guest Name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter Room Type: ");
            String roomType = scanner.nextLine();

            // Validate input
            validator.validate(guestName, roomType, inventory);

            // If valid → create reservation
            Reservation reservation = new Reservation(guestName, roomType);
            bookingQueue.addRequest(reservation);

            System.out.println("Booking request added successfully!");

        } catch (InvalidBookingException e) {

            System.out.println("Booking failed: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}