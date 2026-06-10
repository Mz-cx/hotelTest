package com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.payment.manager;

import com.mycompany.HotelReservationApp.mainsystem.model.Payment;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;   

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class PaymentManager {
    private static PaymentManager instance;
    private Map<Integer, Payment> payments;

    private PaymentManager() {
        this.payments = new HashMap<>();
        Logger.getInstance().info("PaymentManager initialized");
    }

    public static synchronized PaymentManager getInstance() {
        if (instance == null) {
            instance = new PaymentManager();
        }
        return instance;
    }

    public boolean addPayment(Payment payment) {
        if (payment == null || payment.getPaymentId() <= 0) {
            Logger.getInstance().warn("Cannot add null or invalid payment");
            return false;
        }
        if (payments.containsKey(payment.getPaymentId())) {
            Logger.getInstance().warn("Payment already exists: " + payment.getPaymentId());
            return false;
        }
        payments.put(payment.getPaymentId(), payment);
        Logger.getInstance().info("Payment added: " + payment.getPaymentId());
        return true;
    }

    public Payment getPayment(int paymentId) {
        return payments.get(paymentId);
    }

    public boolean updatePayment(Payment payment) {
        if (payment == null || !payments.containsKey(payment.getPaymentId())) {
            Logger.getInstance().warn("Cannot update non-existent payment");
            return false;
        }
        payments.put(payment.getPaymentId(), payment);
        Logger.getInstance().info("Payment updated: " + payment.getPaymentId());
        return true;
    }

    public Payment getPaymentByReservation(int reservationId) {
        for (Payment payment : payments.values()) {
            if (payment.getReservationId() == reservationId) {
                return payment;
            }
        }
        return null;
    }

    public List<Payment> getPaymentsByStatus(String status) {
        List<Payment> result = new ArrayList<>();
        for (Payment payment : payments.values()) {
            if (payment.getPaymentStatus().equalsIgnoreCase(status)) {
                result.add(payment);
            }
        }
        return result;
    }

    public List<Payment> getCompletedPayments() {
        return getPaymentsByStatus("Completed");
    }

    public List<Payment> getPendingPayments() {
        return getPaymentsByStatus("Pending");
    }

    public List<Payment> getFailedPayments() {
        return getPaymentsByStatus("Failed");
    }

    public List<Payment> getAllPayments() {
        return new ArrayList<>(payments.values());
    }

    public double getTotalRevenue() {
        return payments.values().stream()
            .filter(p -> "Completed".equals(p.getPaymentStatus()))
            .mapToDouble(Payment::getPaymentAmount)
            .sum();
    }

    public double getPendingAmount() {
        return payments.values().stream()
            .filter(p -> "Pending".equals(p.getPaymentStatus()))
            .mapToDouble(Payment::getPaymentAmount)
            .sum();
    }

    public int getTotalPaymentCount() {
        return payments.size();
    }
}