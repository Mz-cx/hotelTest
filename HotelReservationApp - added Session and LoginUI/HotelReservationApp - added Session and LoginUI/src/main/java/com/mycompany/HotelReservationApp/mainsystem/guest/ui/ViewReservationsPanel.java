package com.mycompany.HotelReservationApp.mainsystem.guest.ui;
import javax.swing.*;
import java.awt.*;

public class ViewReservationsPanel extends JPanel {
    private JLabel lblTitle;
    private JTable resTable;
    private JScrollPane scrollPane;

    public ViewReservationsPanel() {
        setLayout(null);

        lblTitle = new JLabel("VIEW RESERVATIONS");
        lblTitle.setBounds(50, 20, 300, 30);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle);

        
        String[] columns = {"ID", "Room", "Check In", "Check Out", "Status"};

        
        Object[][] data = {
            {"1", "101", "2024-05-01", "2024-05-10", "Active"},
            {"2", "202", "2024-06-15", "2024-06-20", "Pending"},
            {"3", "305", "2024-07-01", "2024-07-05", "Cancelled"}
        };

        
        resTable = new JTable(data, columns);
        
        scrollPane = new JScrollPane(resTable);
        scrollPane.setBounds(50, 70, 1000, 400);
        add(scrollPane);
    }
}
