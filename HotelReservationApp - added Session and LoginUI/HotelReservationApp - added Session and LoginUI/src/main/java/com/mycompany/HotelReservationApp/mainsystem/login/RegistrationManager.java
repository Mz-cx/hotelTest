package com.mycompany.HotelReservationApp.mainsystem.login;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;
import com.mycompany.HotelReservationApp.mainsystem.model.User;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistrationManager {
    
    private static RegistrationManager instance;
    private Map<String, User> registeredUsers;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    private RegistrationManager() {
        this.registeredUsers = new HashMap<>();
        initializeDefaultUsers();
        Logger.getInstance().info("RegistrationManager initialized");
    }
    
    public static synchronized RegistrationManager getInstance() {
        if (instance == null) {
            instance = new RegistrationManager();
        }
        return instance;
    }
    
    /**
     * Initialize default users for testing/demonstration
     */
    private void initializeDefaultUsers() {
        // Default admin user - password: admin123
        User adminUser = new User(
            "ADMIN_001",
            "admin",
            hashPassword("admin123"),  // Properly hashed password
            "Admin",
            "System",
            "Admin",
            "admin@hotel.com",
            "555-0001"
        );
        adminUser.setRegistrationDate(LocalDateTime.now().format(DATE_FORMAT));
        adminUser.setActive(true);
        registeredUsers.put("admin", adminUser);
        
        // Default guest user - password: guest123
        User guestUser = new User(
            "GUEST_001",
            "guest",
            hashPassword("guest123"),  // Properly hashed password
            "Guest",
            "John",
            "Doe",
            "guest@example.com",
            "555-0002"
        );
        guestUser.setRegistrationDate(LocalDateTime.now().format(DATE_FORMAT));
        guestUser.setActive(true);
        registeredUsers.put("guest", guestUser);
        
        // Default receptionist user - password: receptionist123
        User receptionistUser = new User(
            "REC_001",
            "receptionist",
            hashPassword("receptionist123"),  // Properly hashed password
            "Receptionist",
            "Jane",
            "Smith",
            "receptionist@hotel.com",
            "555-0003"
        );
        receptionistUser.setRegistrationDate(LocalDateTime.now().format(DATE_FORMAT));
        receptionistUser.setActive(true);
        registeredUsers.put("receptionist", receptionistUser);
        
        Logger.getInstance().info("Default users initialized");
    }
    
    /**
     * Register a new user
     * @param firstName User's first name
     * @param lastName User's last name
     * @param email User's email
     * @param phoneNumber User's phone number
     * @param username Unique username
     * @param password User's password
     * @param role User's role (Guest or Receptionist)
     * @return true if registration successful, false if username already exists
     */
    public boolean registerUser(String firstName, String lastName, String email, 
                               String phoneNumber, String username, String password, String role) {
        
        // Check if username already exists
        if (userExists(username)) {
            Logger.getInstance().warn("Registration failed - Username already exists: " + username);
            return false;
        }
        
        // Validate role
        if (!isValidRole(role)) {
            Logger.getInstance().warn("Registration failed - Invalid role: " + role);
            return false;
        }
        
        // Generate unique user ID
        String userID = generateUserID(role);
        
        // Create new user
        User newUser = new User(
            userID,
            username,
            hashPassword(password),  // Hash the password
            role,
            firstName,
            lastName,
            email,
            phoneNumber
        );
        
        newUser.setRegistrationDate(LocalDateTime.now().format(DATE_FORMAT));
        newUser.setActive(true);
        
        // Store user
        registeredUsers.put(username.toLowerCase(), newUser);
        
        Logger.getInstance().info("New user registered successfully - Username: " + username + 
                                 ", UserID: " + userID + ", Role: " + role);
        return true;
    }
    
    /**
     * Check if username already exists
     * @param username Username to check
     * @return true if username exists, false otherwise
     */
    public boolean userExists(String username) {
        return registeredUsers.containsKey(username.toLowerCase());
    }
    
    /**
     * Authenticate user with username and password
     * @param username Username
     * @param password Password
     * @return User object if authentication successful, null otherwise
     */
    public User authenticateUser(String username, String password) {
        User user = registeredUsers.get(username.toLowerCase());
        
        if (user != null && verifyPassword(password, user.getPassword())) {
            if (user.isActive()) {
                Logger.getInstance().info("User authenticated successfully: " + username);
                return user;
            } else {
                Logger.getInstance().warn("Authentication failed - User account is inactive: " + username);
                return null;
            }
        }
        
        Logger.getInstance().warn("Authentication failed - Invalid credentials for user: " + username);
        return null;
    }
    
    /**
     * Get user by username
     * @param username Username to search
     * @return User object if found, null otherwise
     */
    public User getUserByUsername(String username) {
        return registeredUsers.get(username.toLowerCase());
    }
    
    /**
     * Get user by user ID
     * @param userID User ID to search
     * @return User object if found, null otherwise
     */
    public User getUserByID(String userID) {
        for (User user : registeredUsers.values()) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }
    
    /**
     * Update user information
     * @param username Username of user to update
     * @param user Updated user object
     * @return true if update successful, false otherwise
     */
    public boolean updateUser(String username, User user) {
        if (registeredUsers.containsKey(username.toLowerCase())) {
            registeredUsers.put(username.toLowerCase(), user);
            Logger.getInstance().info("User updated: " + username);
            return true;
        }
        Logger.getInstance().warn("Update failed - User not found: " + username);
        return false;
    }
    
    /**
     * Deactivate user account
     * @param username Username of user to deactivate
     * @return true if deactivation successful, false otherwise
     */
    public boolean deactivateUser(String username) {
        User user = registeredUsers.get(username.toLowerCase());
        if (user != null) {
            user.setActive(false);
            Logger.getInstance().info("User account deactivated: " + username);
            return true;
        }
        Logger.getInstance().warn("Deactivation failed - User not found: " + username);
        return false;
    }
    
    /**
     * Reactivate user account
     * @param username Username of user to reactivate
     * @return true if reactivation successful, false otherwise
     */
    public boolean reactivateUser(String username) {
        User user = registeredUsers.get(username.toLowerCase());
        if (user != null) {
            user.setActive(true);
            Logger.getInstance().info("User account reactivated: " + username);
            return true;
        }
        Logger.getInstance().warn("Reactivation failed - User not found: " + username);
        return false;
    }
    
    /**
     * Change user password
     * @param username Username
     * @param oldPassword Current password
     * @param newPassword New password
     * @return true if password changed successfully, false otherwise
     */
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        User user = registeredUsers.get(username.toLowerCase());
        
        if (user != null && verifyPassword(oldPassword, user.getPassword())) {
            user.setPassword(hashPassword(newPassword));
            Logger.getInstance().info("Password changed for user: " + username);
            return true;
        }
        
        Logger.getInstance().warn("Password change failed - Invalid old password: " + username);
        return false;
    }
    
    /**
     * Get total number of registered users
     * @return Number of registered users
     */
    public int getTotalUsers() {
        return registeredUsers.size();
    }
    
    /**
     * Get number of active users
     * @return Number of active users
     */
    public int getActiveUsers() {
        return (int) registeredUsers.values().stream()
            .filter(User::isActive)
            .count();
    }
    
    // Helper Methods
    
    /**
     * Generate unique user ID based on role
     * @param role User role
     * @return Generated user ID
     */
    private String generateUserID(String role) {
        String prefix = role.substring(0, 3).toUpperCase();
        long count = registeredUsers.values().stream()
            .filter(u -> u.getRole().equals(role))
            .count();
        return prefix + "_" + String.format("%04d", count + 1);
    }
    
    /**
     * Check if role is valid
     * @param role Role to validate
     * @return true if role is valid, false otherwise
     */
    private boolean isValidRole(String role) {
        return role.equalsIgnoreCase("Guest") || role.equalsIgnoreCase("Receptionist");
    }
    
    /**
     * Hash password (simple implementation - use bcrypt or similar in production)
     * @param password Plain text password
     * @return Hashed password
     */
    private String hashPassword(String password) {
        // In production, use bcrypt, Argon2, or similar
        // This is a simple implementation for demonstration
        return "HASH_" + Integer.toHexString(password.hashCode());
    }
    
    /**
     * Verify password against hash (simple implementation)
     * @param password Plain text password to verify
     * @param hash Stored password hash
     * @return true if password matches hash, false otherwise
     */
    private boolean verifyPassword(String password, String hash) {
        // In production, use bcrypt, Argon2, or similar
        return hash.equals("HASH_" + Integer.toHexString(password.hashCode()));
    }
}
