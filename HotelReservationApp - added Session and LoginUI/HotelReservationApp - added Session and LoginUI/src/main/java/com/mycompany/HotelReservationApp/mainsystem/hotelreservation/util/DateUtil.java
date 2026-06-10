/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    //Standard checkout time is 11:00 AM
    private static final LocalTime STANDARD_CHECKOUT = LocalTime.of(11, 0);

    public static long calculateNights(LocalDate checkIn, LocalDate checkOut) {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public static boolean isValidDateRange(LocalDate checkIn, LocalDate checkOut) {
        if (checkIn == null || checkOut == null) return false;
        if (checkIn.isBefore(LocalDate.now())) return false;
        if (!checkOut.isAfter(checkIn)) return false;
        return true;
    }

    public static double getRefundPercentage(LocalDate checkInDate, LocalDate cancelDate) {
        long daysBeforeCheckIn = ChronoUnit.DAYS.between(cancelDate, checkInDate);

        if (daysBeforeCheckIn > 7) {
            return 1.00; //100% refund
        } else if (daysBeforeCheckIn == 7) {
            return 0.90; //90% refund
        } else {
            return 0.00; //No refund
        }
    }

    public static double calculateRefundAmount(double totalPaid, LocalDate checkInDate, LocalDate cancelDate) {
        double percentage = getRefundPercentage(checkInDate, cancelDate);
        return totalPaid * percentage;
    }

    public static double calculateCheckoutFee(LocalTime checkoutTime) {
        if (checkoutTime == null) return 0;
        if (!checkoutTime.isAfter(STANDARD_CHECKOUT)) return 0;

        long minutesLate = ChronoUnit.MINUTES.between(STANDARD_CHECKOUT, checkoutTime);
        long hoursLate = minutesLate / 60;

        if (hoursLate <= 2) {
            return 500.00;
        } else if (hoursLate <= 4) {
            return 1000.00;
        } else {
            return 2000.00;
        }
    }

    public static boolean isWithinRefundWindow(LocalDate checkInDate, LocalDate cancelDate) {
        long daysBeforeCheckIn = ChronoUnit.DAYS.between(cancelDate, checkInDate);
        return daysBeforeCheckIn >= 7;
    }

    public static long dateDifference(LocalDate from, LocalDate to) {
        return ChronoUnit.DAYS.between(from, to);
    }
}