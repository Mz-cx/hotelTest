/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.HotelReservationApp.mainsystem.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Payment {
    
    //Fields
    private int paymentId;
    private int reservationId;
    private double paymentAmount;
    private String paymentMethod;// Cash, Credit Card, E-Wallet
    private String paymentTypeDetails;
    private String paymentStatus;// Pending, Completed, Failed, Refunded
    private LocalDate paymentDate;
    private LocalTime paymentTime;
    private double refundAmount;
    private LocalDate refundDate;
    private String refundReason;
    private String transactionId;
    private String createdAt;
    private String updatedAt;
    
    //Constructors
    public Payment() {}
    
    //Getters
    public int getPaymentId(){
        return paymentId;}
    public int getReservationId(){ 
        return reservationId;}
    public double getPaymentAmount() { 
        return paymentAmount;}
    public String getPaymentMethod(){ 
        return paymentMethod;}
    public String getPaymentTypeDetails(){ 
        return paymentTypeDetails;}
    public String getPaymentStatus(){ 
        return paymentStatus;}
    public LocalDate getPaymentDate(){ 
        return paymentDate;}
    public LocalTime getPaymentTime(){ 
        return paymentTime;}
    public double getRefundAmount(){ 
        return refundAmount;}
    public LocalDate getRefundDate(){ 
        return refundDate;}
    public String getRefundReason(){
        return refundReason;}
    public String getTransactionId(){ 
        return transactionId;}
    public String getCreatedAt(){ 
        return createdAt;}
    public String getUpdatedAt(){ 
        return updatedAt;}
    
    //Setters
    public void setPaymentId(int id){ 
        this.paymentId = id;}
    public void setReservationId(int id){ 
        this.reservationId = id;}
    public void setPaymentAmount(double amount){ 
        this.paymentAmount = amount;}
    public void setPaymentMethod(String method){ 
        this.paymentMethod = method;}
    public void setPaymentTypeDetails(String d){ 
        this.paymentTypeDetails = d;}
    public void setPaymentStatus(String status){ 
        this.paymentStatus = status;}
    public void setPaymentDate(LocalDate date){ 
        this.paymentDate = date;}
    public void setPaymentTime(LocalTime time){ 
        this.paymentTime = time;}
    public void setRefundAmount(double amount){ 
        this.refundAmount = amount;}
    public void setRefundDate(LocalDate date){ 
        this.refundDate = date;}
    public void setRefundReason(String reason){ 
        this.refundReason = reason;}
    public void setTransactionId(String id){ 
        this.transactionId = id;}
    public void setCreatedAt(String createdAt){ 
        this.createdAt = createdAt;}
    public void setUpdatedAt(String updatedAt){ 
        this.updatedAt = updatedAt;}
    
    @Override
    public String toString()
    { return "[ PaymentID:" +paymentId+
            " | Reservation:" +reservationId+
            " | PHP " +paymentAmount+
            " | " +paymentMethod+
            " | " +paymentStatus+ " ]";
    }
}
