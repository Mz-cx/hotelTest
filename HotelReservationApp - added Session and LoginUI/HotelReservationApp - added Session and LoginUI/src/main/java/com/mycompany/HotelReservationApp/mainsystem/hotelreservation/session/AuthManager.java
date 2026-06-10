package com.mycompany.HotelReservationApp.mainsystem.hotelreservation.session;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;
import com.mycompany.HotelReservationApp.mainsystem.login.RegistrationManager;
import com.mycompany.HotelReservationApp.mainsystem.model.User;

/**
 * Updated AuthManager that integrates with RegistrationManager
 * Handles user authentication against registered users
 */
public class AuthManager {
    
    private static AuthManager instance;
    private boolean authenticated;
    private String authenticatedUser;
    private User authenticatedUserObject;
    
    private AuthManager() {
        authenticated = false;
        authenticatedUser = null;
        authenticatedUserObject = null;
    }
    
    public static synchronized AuthManager getInstance() {
        if (instance == null) {
            instance = new AuthManager();
        }
        return instance;
    }
    
    /**
     * Authenticate user against registered users in RegistrationManager
     * @param username Username to authenticate
     * @param password Password to verify
     * @return true if authentication successful, false otherwise
     */
    public boolean authenticate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            Logger.getInstance().warn("Authentication failed - Empty credentials");
            return false;
        }
        
        // Use RegistrationManager to authenticate
        RegistrationManager regManager = RegistrationManager.getInstance();
        User user = regManager.authenticateUser(username, password);
        
        if (user != null) {
            authenticated = true;
            authenticatedUser = username;
            authenticatedUserObject = user;
            Logger.getInstance().info("Authentication successful for user: " + username);
            return true;
        }
        
        Logger.getInstance().warn("Authentication failed for user: " + username);
        return false;
    }
    
    public void deauthenticate() {
        if (authenticated) {
            Logger.getInstance().info("User deauthenticated: " + authenticatedUser);
        }
        authenticated = false;
        authenticatedUser = null;
        authenticatedUserObject = null;
    }
    
    public boolean isAuthenticated() {
        return authenticated && authenticatedUser != null;
    }
    
    public String getAuthenticatedUser() {
        return authenticatedUser;
    }
    
    /**
     * Get the authenticated User object with full details
     * @return User object of authenticated user, or null if not authenticated
     */
    public User getAuthenticatedUserObject() {
        return authenticatedUserObject;
    }
    
    /**
     * Get role of authenticated user
     * @return Role of authenticated user, or null if not authenticated
     */
    public String getAuthenticatedUserRole() {
        if (authenticatedUserObject != null) {
            return authenticatedUserObject.getRole();
        }
        return null;
    }
    
    /**
     * Get user ID of authenticated user
     * @return User ID of authenticated user, or null if not authenticated
     */
    public String getAuthenticatedUserID() {
        if (authenticatedUserObject != null) {
            return authenticatedUserObject.getUserID();
        }
        return null;
    }
}
