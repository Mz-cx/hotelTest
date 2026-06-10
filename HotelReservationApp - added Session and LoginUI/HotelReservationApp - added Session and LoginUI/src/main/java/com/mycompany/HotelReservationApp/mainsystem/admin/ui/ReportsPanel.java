package com.mycompany.HotelReservationApp.mainsystem.admin.ui;
import javax.swing.*;
import java.awt.*;

public class ReportsPanel extends JPanel {

    public ReportsPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, 0, 1116, 668);

        JLabel Title = new JLabel("Reports and Analytics");
        Title.setFont(new Font("SansSerif", Font.BOLD, 18));
        Title.setForeground(Color.DARK_GRAY);
        Title.setBounds(30, 30, 400, 28);
        add(Title);

        

        String[] stats = {
            "Total rooms: 0",
            "Available rooms: 0",
            "Total reservations: 0",
            "Active reservations: 0",
            "Total staff accounts: 0",
            "Total revenue collected: PHP 0.0"
        };

        for (int i = 0; i < stats.length; i++) {
            JLabel stat = new JLabel(stats[i]);
            stat.setFont(new Font("SansSerif", Font.PLAIN, 14));
            stat.setForeground(Color.DARK_GRAY);
            stat.setBounds(30, 100 + i * 30, 500, 22);
            add(stat);
        }

        JButton Update = new JButton("Update Reports");
        Update.setFont(new Font("SansSerif", Font.PLAIN, 13));
        Update.setBackground(new Color(220, 220, 220));
        Update.setForeground(Color.DARK_GRAY);
        Update.setFocusPainted(false);
        Update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Update.setBounds(30, 300, 160, 38);
        add(Update);
    }
}
