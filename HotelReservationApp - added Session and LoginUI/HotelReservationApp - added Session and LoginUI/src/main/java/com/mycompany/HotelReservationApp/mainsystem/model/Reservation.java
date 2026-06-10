package com.mycompany.HotelReservationApp.mainsystem.model;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 * 
 * @author bened
 */
public class Reservation {

    private int reservationId;
    private int guestId;
    private int roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private int numberOfGuests;
    private String reservationStatus;
    private int numberOfNights;
    private double roomRate;
    private double totalPrice;
    private double discountApplied;
    private double finalTotal;
    private LocalDate reservationDate;
    private String notes;
    private String cancelledDate;
    private String cancellationReason;
    private String createdAt;
    private String updatedAt;

    // Empty constructor
    public Reservation() {}

    // Getters
    public int getReservationId()        { return reservationId; }
    public int getGuestId()              { return guestId; }
    public int getRoomId()               { return roomId; }
    public LocalDate getCheckInDate()    { return checkInDate; }
    public LocalDate getCheckOutDate()   { return checkOutDate; }
    public LocalTime getCheckInTime()    { return checkInTime; }
    public LocalTime getCheckOutTime()   { return checkOutTime; }
    public int getNumberOfGuests()       { return numberOfGuests; }
    public String getReservationStatus() { return reservationStatus; }
    public int getNumberOfNights()       { return numberOfNights; }
    public double getRoomRate()          { return roomRate; }
    public double getTotalPrice()        { return totalPrice; }
    public double getDiscountApplied()   { return discountApplied; }
    public double getFinalTotal()        { return finalTotal; }
    public LocalDate getReservationDate(){ return reservationDate; }
    public String getNotes()             { return notes; }
    public String getCancelledDate()     { return cancelledDate; }
    public String getCancellationReason(){ return cancellationReason; }
    public String getCreatedAt()         { return createdAt; }
    public String getUpdatedAt()         { return updatedAt; }

    // Setters
    public void setReservationId(int reservationId) {
        if (reservationId <= 0)
            throw new IllegalArgumentException("Reservation ID must be greater than 0.");
        this.reservationId = reservationId;
    }

    public void setGuestId(int guestId) {
        if (guestId <= 0)
            throw new IllegalArgumentException("Guest ID must be greater than 0.");
        this.guestId = guestId;
    }

    public void setRoomId(int roomId) {
        if (roomId <= 0)
            throw new IllegalArgumentException("Room ID must be greater than 0.");
        this.roomId = roomId;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        if (checkInDate == null)
            throw new IllegalArgumentException("Check-in date cannot be null.");
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        if (checkOutDate == null)
            throw new IllegalArgumentException("Check-out date cannot be null.");
        // only validate against checkInDate if it's already set
        if (this.checkInDate != null && !checkOutDate.isAfter(this.checkInDate))
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        this.checkOutDate = checkOutDate;
    }

    public void setCheckInTime(LocalTime checkInTime) {
        // time is optional so i think  null is allowed
        this.checkInTime = checkInTime;
    }

    public void setCheckOutTime(LocalTime checkOutTime) {
        // time is optional so i think  null is allowed
        this.checkOutTime = checkOutTime;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        if (numberOfGuests < 1)
            throw new IllegalArgumentException("Number of guests must be at least 1.");
        this.numberOfGuests = numberOfGuests;
    }

    public void setReservationStatus(String reservationStatus) {
        if (reservationStatus == null || reservationStatus.trim().isEmpty())
            throw new IllegalArgumentException("Reservation status cannot be empty.");
        this.reservationStatus = reservationStatus;
    }

    public void setNumberOfNights(int numberOfNights) {
        if (numberOfNights < 1)
            throw new IllegalArgumentException("Number of nights must be at least 1.");
        this.numberOfNights = numberOfNights;
    }

    public void setRoomRate(double roomRate) {
        if (roomRate <= 0)
            throw new IllegalArgumentException("Room rate must be greater than 0.");
        this.roomRate = roomRate;
    }

    public void setTotalPrice(double totalPrice) {
        if (totalPrice < 0)
            throw new IllegalArgumentException("Total price cannot be negative.");
        this.totalPrice = totalPrice;
    }

    public void setDiscountApplied(double discountApplied) {
        if (discountApplied < 0)
            throw new IllegalArgumentException("Discount cannot be negative.");
        this.discountApplied = discountApplied;
    }

    public void setFinalTotal(double finalTotal) {
        if (finalTotal < 0)
            throw new IllegalArgumentException("Final total cannot be negative.");
        this.finalTotal = finalTotal;
    }

    public void setReservationDate(LocalDate reservationDate) {
        if (reservationDate == null)
            throw new IllegalArgumentException("Reservation date cannot be null.");
        this.reservationDate = reservationDate;
    }

    public void setNotes(String notes) {
        // OPtional lang ang notes so null maybe
        this.notes = notes;
    }

    public void setCancelledDate(String cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "[Reservation ID: " + reservationId +
                " | Guest: " + guestId +
                " | Room: " + roomId +
                " | Check-in: " + checkInDate +
                " | Check-out: " + checkOutDate +
                " | Nights: " + numberOfNights +
                " | Total: PHP " + finalTotal +
                " | " + reservationStatus + "]";
    }
}