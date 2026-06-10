package com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.reservation.manager;

import com.mycompany.HotelReservationApp.mainsystem.model.Reservation;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
    private static ReservationManager instance;
    private Map<Integer, Reservation> reservations;

    private ReservationManager() {
        this.reservations = new HashMap<>();
        Logger.getInstance().info("ReservationManager initialized");
    }

    public static synchronized ReservationManager getInstance() {
        if (instance == null) {
            instance = new ReservationManager();
        }
        return instance;
    }

    public boolean addReservation(Reservation reservation) {
        if (reservation == null || reservation.getReservationId() <= 0) {
            Logger.getInstance().warn("Cannot add null or invalid reservation");
            return false;
        }
        if (reservations.containsKey(reservation.getReservationId())) {
            Logger.getInstance().warn("Reservation already exists: " + reservation.getReservationId());
            return false;
        }
        reservations.put(reservation.getReservationId(), reservation);
        Logger.getInstance().info("Reservation added: " + reservation.getReservationId());
        return true;
    }

    public Reservation getReservation(int reservationId) {
        return reservations.get(reservationId);
    }

    public boolean updateReservation(Reservation reservation) {
        if (reservation == null || !reservations.containsKey(reservation.getReservationId())) {
            Logger.getInstance().warn("Cannot update non-existent reservation");
            return false;
        }
        reservations.put(reservation.getReservationId(), reservation);
        Logger.getInstance().info("Reservation updated: " + reservation.getReservationId());
        return true;
    }

    public boolean cancelReservation(int reservationId) {
        Reservation res = reservations.get(reservationId);
        if (res != null) {
            res.setReservationStatus("Cancelled");
            return true;
        }
        return false;
    }

    public List<Reservation> getReservationsByGuest(int guestId) {
        List<Reservation> guestReservations = new ArrayList<>();
        for (Reservation res : reservations.values()) {
            if (res.getGuestId() == guestId) {
                guestReservations.add(res);
            }
        }
        return guestReservations;
    }

    public List<Reservation> getReservationsByRoom(int roomId) {
        List<Reservation> roomReservations = new ArrayList<>();
        for (Reservation res : reservations.values()) {
            if (res.getRoomId() == roomId) {
                roomReservations.add(res);
            }
        }
        return roomReservations;
    }

    public List<Reservation> getActiveReservations() {
        List<Reservation> active = new ArrayList<>();
        for (Reservation res : reservations.values()) {
            if ("Confirmed".equals(res.getReservationStatus())) {
                active.add(res);
            }
        }
        return active;
    }

    public List<Reservation> getReservationsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation res : reservations.values()) {
            if (!res.getCheckInDate().isBefore(startDate) && !res.getCheckInDate().isAfter(endDate)) {
                result.add(res);
            }
        }
        return result;
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations.values());
    }

    public int getTotalReservationCount() {
        return reservations.size();
    }

    public int getConfirmedReservationCount() {
        return (int) reservations.values().stream()
            .filter(r -> "Confirmed".equals(r.getReservationStatus()))
            .count();
    }
}