package com.mycompany.HotelReservationApp.mainsystem.guest.manager;

import com.mycompany.HotelReservationApp.mainsystem.model.Guest;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class GuestManager {
    private static GuestManager instance;
    private Map<String, Guest> guests;
    
    private GuestManager() {
        this.guests = new HashMap<>();
        Logger.getInstance().info("GuestManager initialized");
    }
    
    public static synchronized GuestManager getInstance() {
        if (instance == null) {
            instance = new GuestManager();
        }
        return instance;
    }
    
    public boolean addGuest(Guest guest) {
        if (guest == null || guest.getUserID() == null || guest.getUserID().isEmpty()) {
            Logger.getInstance().warn("Cannot add null or invalid guest");
            return false;
        }
        
        if (guests.containsKey(guest.getUserID())) {
            Logger.getInstance().warn("Guest already exists: " + guest.getUserID());
            return false;
        }
        
        guests.put(guest.getUserID(), guest);
        Logger.getInstance().info("Guest added: " + guest.getUserID());
        return true;
    }
    
    public Guest getGuest(String guestID) {
        return guests.get(guestID);
    }
    
    public boolean updateGuest(Guest guest) {
        if (guest == null || !guests.containsKey(guest.getUserID())) {
            Logger.getInstance().warn("Cannot update non-existent guest");
            return false;
        }
        
        guests.put(guest.getUserID(), guest);
        Logger.getInstance().info("Guest updated: " + guest.getUserID());
        return true;
    }
    
    public boolean deleteGuest(String guestID) {
        if (guests.remove(guestID) != null) {
            Logger.getInstance().info("Guest deleted: " + guestID);
            return true;
        }
        return false;
    }
    
    public List<Guest> getAllGuests() {
        return new ArrayList<>(guests.values());
    }
    
    public List<Guest> getVIPGuests() {
        List<Guest> vipGuests = new ArrayList<>();
        for (Guest guest : guests.values()) {
            if (guest.isVIP()) {
                vipGuests.add(guest);
            }
        }
        return vipGuests;
    }
    
    public Guest findGuestByEmail(String email) {
        for (Guest guest : guests.values()) {
            if (guest.getEmail().equalsIgnoreCase(email)) {
                return guest;
            }
        }
        return null;
    }
    
    public Guest findGuestByPhone(String phone) {
        for (Guest guest : guests.values()) {
            if (guest.getPhoneNumber().equals(phone)) {
                return guest;
            }
        }
        return null;
    }
    
    public int getTotalGuestCount() {
        return guests.size();
    }
    
    public int getVIPCount() {
        return (int) guests.values().stream()
            .filter(Guest::isVIP)
            .count();
    }
}
