package com.mycompany.HotelReservationApp.mainsystem.model;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;

/**
 * Base User class for authentication and core user information
 * All user types (Guest, Receptionist, Admin) should extend this class
 */
public class User {
    private String userID;
    private String username;
    private String password;
    private String role;  // Admin, Guest, Receptionist
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean isActive;
    private String registrationDate;
    private String lastLoginDate;
    private int loginAttempts;
    private static final int MAX_LOGIN_ATTEMPTS = 5;
    
    public User() {
        this.isActive = true;
        this.loginAttempts = 0;
    }
    
    public User(String userID, String username, String password, String role, 
                String firstName, String lastName, String email, String phoneNumber) {
        this();
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    // Core Getters and Setters
    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    
    public String getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(String registrationDate) { this.registrationDate = registrationDate; }
    
    public String getLastLoginDate() { return lastLoginDate; }
    public void setLastLoginDate(String lastLoginDate) { this.lastLoginDate = lastLoginDate; }
    
    public int getLoginAttempts() { return loginAttempts; }
    public void setLoginAttempts(int attempts) { this.loginAttempts = attempts; }
    
    public void incrementLoginAttempts() {
        this.loginAttempts++;
        if (this.loginAttempts >= MAX_LOGIN_ATTEMPTS) {
            this.isActive = false;
            Logger.getInstance().warn("User account locked: " + username);
        }
    }
    
    public void resetLoginAttempts() { this.loginAttempts = 0; }
    
    public String getFullName() { return firstName + " " + lastName; }
    
    public boolean hasRole(String roleName) {
        return role != null && role.equalsIgnoreCase(roleName);
    }
    
    public boolean isAdmin() { return hasRole("Admin"); }
    public boolean isGuest() { return hasRole("Guest"); }
    public boolean isReceptionist() { return hasRole("Receptionist"); }
    
    @Override
    public String toString() {
        return "User [ID=" + userID + ", Username=" + username + 
               ", Name=" + getFullName() + ", Role=" + role + "]";
    }
}
