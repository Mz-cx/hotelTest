package com.mycompany.HotelReservationApp.mainsystem.hotelreservation.session;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;

public class AuthManager {
    
    private static AuthManager instance;
    private boolean authenticated;
    private String authenticatedUser;
    
    private AuthManager() {
        authenticated = false;
        authenticatedUser = null;
    }
    
    public static synchronized AuthManager getInstance() {
        if (instance == null) {
            instance = new AuthManager();
        }
        return instance;
    }
    
    public boolean authenticate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            Logger.getInstance().warn("Authentication failed - Empty credentials");
            return false;
        }
        
        if (validateCredentials(username, password)) {
            authenticated = true;
            authenticatedUser = username;
            Logger.getInstance().info("Authentication successful for user: " + username);
            return true;
        }
        
        Logger.getInstance().warn("Authentication failed for user: " + username);
        return false;
    }
    
    private boolean validateCredentials(String username, String password) {
        // TODO: Replace with actual database query
        // For now, accept any non-empty credentials
        return !username.isEmpty() && !password.isEmpty() && password.length() >= 6;
    }
    
    public void deauthenticate() {
        if (authenticated) {
            Logger.getInstance().info("User deauthenticated: " + authenticatedUser);
        }
        authenticated = false;
        authenticatedUser = null;
    }
    
    public boolean isAuthenticated() {
        return authenticated && authenticatedUser != null;
    }
    
    public String getAuthenticatedUser() {
        return authenticatedUser;
    }
}