package com.mycompany.HotelReservationApp.mainsystem.hotelreservation.session;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;

public class SessionManager {
    
    private static String currentUser;
    private static String currentRole;
    private static String currentUserID;
    private static long loginTime;
    private static boolean isActive;
    
    // Benedict
    public static void init() {
        currentUser = null;
        currentRole = null;
        currentUserID = null;
        loginTime = 0;
        isActive = false;
        
        Logger.getInstance().info("SessionManager initialized");
    }
    
    public static void login(String user, String role) {
        currentUser = user;
        currentRole = role;
        loginTime = System.currentTimeMillis();
        isActive = true;
        
        Logger.getInstance().info("User logged in - Username: " + user + ", Role: " + role);
    }
    
    public static void login(String userID, String user, String role) {
        currentUserID = userID;
        currentUser = user;
        currentRole = role;
        loginTime = System.currentTimeMillis();
        isActive = true;
        
        Logger.getInstance().info("User logged in - ID: " + userID + ", Username: " + user + ", Role: " + role);
    }
    
    public static void logout() {
        Logger.getInstance().info("User logged out - Username: " + currentUser + ", Session duration: " + 
                                (System.currentTimeMillis() - loginTime) + "ms");
        currentUser = null;
        currentRole = null;
        currentUserID = null;
        loginTime = 0;
        isActive = false;
    }
    
    // Lance
    public static boolean isLoggedIn() {
        return currentUser != null && isActive;
    }
    
    public static String getCurrentUser() {
        return currentUser;
    }
    
    public static String getUserID() {
        return currentUserID;
    }
    
    public static String getRole() {
        return currentRole;
    }
    
    public static boolean hasRole(String role) {
        return currentRole != null && currentRole.equalsIgnoreCase(role);
    }
    
    public static long getLoginTime() {
        return loginTime;
    }
    
    public static long getSessionDuration() {
        if (loginTime == 0) {
            return 0;
        }
        return System.currentTimeMillis() - loginTime;
    }
    
    // Marla
    public static boolean canAccessAdmin() {
        return isLoggedIn() && hasRole("Admin");
    }
    
    public static boolean canAccessGuest() {
        return isLoggedIn() && hasRole("Guest");
    }
    
    public static boolean canAccessReceptionist() {
        return isLoggedIn() && hasRole("Receptionist");
    }
    
    public static boolean canAccessReception() {
        return isLoggedIn() && (hasRole("Receptionist") || hasRole("Admin"));
    }
    
    public static String getSessionInfo() {
        if (!isLoggedIn()) {
            return "No active session";
        }
        
        long duration = getSessionDuration();
        long minutes = duration / 60000;
        long seconds = (duration % 60000) / 1000;
        
        return "User: " + currentUser + ", Role: " + currentRole + 
               ", Duration: " + minutes + "m " + seconds + "s";
    }
}