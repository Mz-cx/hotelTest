package com.mycompany.HotelReservationApp.mainsystem.model;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * Guest class extends User with guest-specific properties
 * Eliminates duplication from the base User class
 */
public class Guest extends User {
    private String identityType;
    private String identityNumber;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String guestType; // Regular or VIP
    private List<String> reservationHistory;
    private double totalSpent;
    
    public Guest() {
        super();
        this.reservationHistory = new ArrayList<>();
        this.totalSpent = 0;
        this.guestType = "Regular";
    }
    
    public Guest(String guestID, String firstName, String lastName, String email, String phoneNumber) {
        this();
        this.setUserID(guestID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setRole("Guest");
    }
    
    // Guest-Specific Getters and Setters (NOT inherited from User)
    public String getIdentityType() { return identityType; }
    public void setIdentityType(String identityType) { this.identityType = identityType; }
    
    public String getIdentityNumber() { return identityNumber; }
    public void setIdentityNumber(String identityNumber) { this.identityNumber = identityNumber; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    
    public String getGuestType() { return guestType; }
    public void setGuestType(String guestType) { this.guestType = guestType; }
    
    public List<String> getReservationHistory() { return reservationHistory; }
    public void addReservation(String reservationID) {
        reservationHistory.add(reservationID);
        Logger.getInstance().info("Reservation added to guest: " + getUserID());
    }
    
    public double getTotalSpent() { return totalSpent; }
    public void setTotalSpent(double totalSpent) { this.totalSpent = totalSpent; }
    
    // Guest-Specific Methods
    public boolean isVIP() {
        return "VIP".equalsIgnoreCase(guestType);
    }
    
    public void upgradeToVIP() {
        if (!isVIP()) {
            this.guestType = "VIP";
            Logger.getInstance().info("Guest upgraded to VIP: " + getUserID());
        }
    }
    
    public void downgradeToRegular() {
        if (isVIP()) {
            this.guestType = "Regular";
            Logger.getInstance().info("Guest downgraded to Regular: " + getUserID());
        }
    }
    
    @Override
    public String toString() {
        return "Guest [ID=" + getUserID() + ", Name=" + getFullName() + 
               ", Email=" + getEmail() + ", Type=" + guestType + "]";
    }
}
