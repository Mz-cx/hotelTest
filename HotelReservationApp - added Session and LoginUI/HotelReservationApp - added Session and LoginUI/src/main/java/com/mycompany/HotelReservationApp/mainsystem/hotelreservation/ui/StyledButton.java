package com.mycompany.HotelReservationApp.mainsystem.hotelreservation.ui;

import javax.swing.*;
import java.awt.*;

public class StyledButton extends JButton {
    
    public StyledButton(String text, String style) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 12));
        setBorderPainted(false);
        setFocusPainted(false);
        setPreferredSize(new Dimension(120, 40));
        
        applyStyle(style);
    }
    
    private void applyStyle(String style) {
        switch (style.toLowerCase()) {
            case "success":
                setBackground(new Color(76, 175, 80));
                setForeground(Color.WHITE);
                break;
            case "danger":
                setBackground(new Color(244, 67, 54));
                setForeground(Color.WHITE);
                break;
            case "info":
                setBackground(new Color(33, 150, 243));
                setForeground(Color.WHITE);
                break;
            case "warning":
                setBackground(new Color(255, 193, 7));
                setForeground(Color.BLACK);
                break;
            default:
                setBackground(new Color(200, 200, 200));
                setForeground(Color.BLACK);
        }
    }
}