package com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.room.manager;

import com.mycompany.HotelReservationApp.mainsystem.model.Room;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private static RoomManager instance;
    private Map<String, Room> rooms;
    
    private RoomManager() {
        this.rooms = new HashMap<>();
        Logger.getInstance().info("RoomManager initialized");
    }
    
    public static synchronized RoomManager getInstance() {
        if (instance == null) {
            instance = new RoomManager();
        }
        return instance;
    }
    
    public boolean addRoom(Room room) {
        if (room == null || room.getRoomNumber() == null) {
            Logger.getInstance().warn("Cannot add null or invalid room");
            return false;
        }
        
        if (rooms.containsKey(room.getRoomNumber())) {
            Logger.getInstance().warn("Room already exists: " + room.getRoomNumber());
            return false;
        }
        
        rooms.put(room.getRoomNumber(), room);
        Logger.getInstance().info("Room added: " + room.getRoomNumber());
        return true;
    }
    
    public Room getRoom(String roomNumber) {
        return rooms.get(roomNumber);
    }
    
    public boolean updateRoom(Room room) {
        if (room == null || !rooms.containsKey(room.getRoomNumber())) {
            Logger.getInstance().warn("Cannot update non-existent room");
            return false;
        }
        
        rooms.put(room.getRoomNumber(), room);
        Logger.getInstance().info("Room updated: " + room.getRoomNumber());
        return true;
    }
    
    public List<Room> getAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.isAvailable()) {
                available.add(room);
            }
        }
        return available;
    }
    
    public List<Room> getRoomsByType(String type) {
        List<Room> roomsByType = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.getRoomType().equalsIgnoreCase(type)) {
                roomsByType.add(room);
            }
        }
        return roomsByType;
    }
    
    public List<Room> getAvailableRoomsByType(String type) {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.getRoomType().equalsIgnoreCase(type) && room.isAvailable()) {
                available.add(room);
            }
        }
        return available;
    }
    
    public List<Room> getRoomsByCapacity(int capacity) {
        List<Room> roomsByCapacity = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.getCapacity() >= capacity) {
                roomsByCapacity.add(room);
            }
        }
        return roomsByCapacity;
    }
    
    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms.values());
    }
    
    public int getTotalRoomCount() {
        return rooms.size();
    }
    
    public int getAvailableRoomCount() {
        return (int) rooms.values().stream()
            .filter(Room::isAvailable)
            .count();
    }
    
    public int getOccupiedRoomCount() {
        return (int) rooms.values().stream()
            .filter(Room::isOccupied)
            .count();
    }
    
    public double calculateOccupancyRate() {
        if (rooms.isEmpty()) return 0;
        return (double) getOccupiedRoomCount() / getTotalRoomCount() * 100;
    }
}