package com.mycompany.HotelReservationApp.mainsystem.model;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;
import java.util.ArrayList;
import java.util.List;

public class Guest {
    private String guestID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String identityType;
    private String identityNumber;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String guestType; // Regular or VIP
    private List<String> reservationHistory;
    private double totalSpent;
    private String registrationDate;
    
    public Guest() {
        this.reservationHistory = new ArrayList<>();
        this.totalSpent = 0;
        this.guestType = "Regular";
    }
    
    public Guest(String guestID, String firstName, String lastName, String email, String phoneNumber) {
        this();
        this.guestID = guestID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    // Getters and Setters
    public String getGuestID() { return guestID; }
    public void setGuestID(String guestID) { this.guestID = guestID; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
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
        Logger.getInstance().info("Reservation added to guest: " + guestID);
    }
    
    public double getTotalSpent() { return totalSpent; }
    public void setTotalSpent(double totalSpent) { this.totalSpent = totalSpent; }
    
    public String getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(String registrationDate) { this.registrationDate = registrationDate; }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public boolean isVIP() {
        return "VIP".equalsIgnoreCase(guestType);
    }
    
    public void upgradeToVIP() {
        if (!isVIP()) {
            this.guestType = "VIP";
            Logger.getInstance().info("Guest upgraded to VIP: " + guestID);
        }
    }
    
    public void downgradeToRegular() {
        if (isVIP()) {
            this.guestType = "Regular";
            Logger.getInstance().info("Guest downgraded to Regular: " + guestID);
        }
    }
    
    @Override
    public String toString() {
        return "Guest [ID=" + guestID + ", Name=" + getFullName() + 
               ", Email=" + email + ", Type=" + guestType + "]";
    }
}