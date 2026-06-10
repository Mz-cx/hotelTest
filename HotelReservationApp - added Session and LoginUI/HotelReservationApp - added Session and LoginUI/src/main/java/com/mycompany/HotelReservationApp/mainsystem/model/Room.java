/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.HotelReservationApp.mainsystem.model;
/**
 * 
 * Valid Room Types: Single Standard, Double Standard, Double Deluxe, Suite Deluxe
 * Valid Room Status: Available, Occupied, Maintenance, Cleaning
 * @author bened
 */
public class Room {

    private int roomId;
    private String roomNumber;
    private String roomType;
    private int floor;
    private int capacity;
    private double pricePerNight;
    private String amenities;
    private String roomImage;
    private String status;
    private String createdAt;
    private String updatedAt;

    // Empty constructor
    public Room() {}

    // Full constructor
    public Room(int roomId, String roomNumber, String roomType,
                int floor, int capacity, double pricePerNight,
                String amenities, String roomImage, String status,
                String createdAt, String updatedAt) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floor = floor;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
        this.roomImage = roomImage;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Status checkers
    public boolean isAvailable()    { return "Available".equals(this.status); }
    public boolean isOccupied()     { return "Occupied".equals(this.status); }
    public boolean isMaintenance()  { return "Maintenance".equals(this.status); } // FIXED
    public boolean isCleaning()     { return "Cleaning".equals(this.status); }

    // Getters
    public int getRoomId()           { return roomId; }
    public String getRoomNumber()    { return roomNumber; }
    public String getRoomType()      { return roomType; }
    public int getFloor()            { return floor; }
    public int getCapacity()         { return capacity; }
    public double getPricePerNight() { return pricePerNight; }
    public String getAmenities()     { return amenities; }
    public String getRoomImage()     { return roomImage; }
    public String getStatus()        { return status; }
    public String getCreatedAt()     { return createdAt; }
    public String getUpdatedAt()     { return updatedAt; }

    // Setters
    public void setRoomId(int roomId) {
        if (roomId <= 0) throw new IllegalArgumentException("Room ID must be greater than 0.");
        this.roomId = roomId;
    }

    public void setRoomNumber(String roomNumber) {
        if (roomNumber == null || roomNumber.trim().isEmpty())
            throw new IllegalArgumentException("Room number cannot be empty.");
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        if (roomType == null || roomType.trim().isEmpty())
            throw new IllegalArgumentException("Room type cannot be empty.");
        this.roomType = roomType;
    }

    public void setFloor(int floor) {
        if (floor <= 0) throw new IllegalArgumentException("Floor must be greater than 0.");
        this.floor = floor;
    }

    public void setCapacity(int capacity) {
        if (capacity < 1 || capacity > 10)
            throw new IllegalArgumentException("Capacity must be between 1 and 10.");
        this.capacity = capacity;
    }

    public void setPricePerNight(double pricePerNight) {
        if (pricePerNight <= 0)
            throw new IllegalArgumentException("Price per night must be greater than 0.");
        this.pricePerNight = pricePerNight;
    }

    public void setAmenities(String amenities) {
        // amenities is optional so i think null is allowed
        this.amenities = amenities;
    }

    public void setRoomImage(String roomImage) {
        // image is optional so null i think  is allowed
        this.roomImage = roomImage;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty())
            throw new IllegalArgumentException("Status cannot be empty.");
        this.status = status;
    }

    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "[Room: " + roomNumber + " | " + roomType +
                " | Floor: " + floor + " | Capacity: " + capacity +
                " | Price: " + pricePerNight + " | Status: " + status + "]";
    }
}