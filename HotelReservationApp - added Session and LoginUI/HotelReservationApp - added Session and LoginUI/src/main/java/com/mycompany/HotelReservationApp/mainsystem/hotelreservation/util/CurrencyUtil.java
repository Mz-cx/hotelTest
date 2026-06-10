/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util;

import java.text.DecimalFormat;

public class CurrencyUtil {

    private static final double TAX_RATE = 0.12;
    private static final DecimalFormat formatter = new DecimalFormat("#,##0.00");

    //Calculates the subtotal room price multiplied by number of nights.
     
    public static double calculateSubtotal(double pricePerNight, long nights) {
        return pricePerNight * nights;
    }
    //calculates 12% tax on the subtotal.
     
    public static double calculateTax(double subtotal) {
        return subtotal * TAX_RATE;
    }

    //calculates the final total after adding tax and subtracting discount.
     
    public static double calculateFinalTotal(double subtotal, double tax, double discount) {
        return (subtotal + tax) - discount;
    }


    //formats a double amount as PHP currency string.
      //Example: 28000.0 becomes "PHP 28,000.00"
    
    public static String formatCurrency(double amount) {
        return "PHP " + formatter.format(amount);
    }

      //calculates change for cash payments.
      //returns difference if overpaid, otherwise returns 0.
    
    public static double calculateChange(double amountPaid, double totalDue) {
        if (amountPaid >= totalDue) {
            return amountPaid - totalDue;
        }
        return 0;
    }

     //checks if a payment amount is valid.
     //must be greater than 0 and not exceed 999,999.99
    
    public static boolean isValidAmount(double amount) {
        return amount > 0 && amount <= 999999.99;
    }
    
     //fafely converts a String to Double.
    //returns 0.0 if the string cannot be parsed.
    
    public static double convertToDouble(String value) {
        try {
            return Double.parseDouble(value.replace(",", "").trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}