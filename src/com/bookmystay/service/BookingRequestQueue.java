package com.bookmystay.service;

import java.util.LinkedList;
import java.util.Queue;

import com.bookmystay.model.Reservation;

/**
 * CLASS - BookingRequestQueue
 *
 * Manages booking requests using FIFO queue
 */
public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add request
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    // Get next request (FIFO)
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    // Check if queue has requests
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}