package com.mycompany.HotelReservationApp.mainsystem.admin.ui;
import javax.swing.*;
import java.awt.*;

public class RoomManagementPanel extends JPanel {

    public RoomManagementPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, 0, 1116, 668);

        JLabel lblTitle = new JLabel("Room Management");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setBounds(30, 30, 400, 28);
        add(lblTitle);
        

        JLabel lblCount = new JLabel("Total rooms on record: 0");
        lblCount.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblCount.setForeground(Color.DARK_GRAY);
        lblCount.setBounds(30, 95, 400, 22);
        add(lblCount);

        
        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblRoomNumber.setBounds(30, 140, 150, 22);
        add(lblRoomNumber);

        JTextField txtRoomNumber = new JTextField();
        txtRoomNumber.setBounds(30, 165, 300, 35);
        add(txtRoomNumber);

        JLabel lblRoomType = new JLabel("Room Type:");
        lblRoomType.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblRoomType.setBounds(30, 215, 150, 22);
        add(lblRoomType);

        JTextField txtRoomType = new JTextField();
        txtRoomType.setBounds(30, 240, 300, 35);
        add(txtRoomType);

        JLabel lblRate = new JLabel("Nightly Rate:");
        lblRate.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblRate.setBounds(30, 290, 150, 22);
        add(lblRate);

        JTextField txtRate = new JTextField();
        txtRate.setBounds(30, 315, 300, 35);
        add(txtRate);

        JLabel lblCapacity = new JLabel("Capacity:");
        lblCapacity.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblCapacity.setBounds(30, 365, 150, 22);
        add(lblCapacity);

        JTextField txtCapacity = new JTextField();
        txtCapacity.setBounds(30, 390, 300, 35);
        add(txtCapacity);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblStatus.setBounds(30, 440, 150, 22);
        add(lblStatus);

        JComboBox<String> cmbStatus = new JComboBox<>(new String[]{"AVAILABLE", "OCCUPIED", "MAINTENANCE"});
        cmbStatus.setBounds(30, 465, 300, 35);
        add(cmbStatus);

        
        JButton btnAdd = new JButton("Add Room");
        btnAdd.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnAdd.setBackground(new Color(220, 220, 220));
        btnAdd.setForeground(Color.DARK_GRAY);
        btnAdd.setFocusPainted(false);
        btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAdd.setBounds(30, 520, 140, 38);
        add(btnAdd);

        JButton btnEdit = new JButton("Edit Room");
        btnEdit.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnEdit.setBackground(new Color(220, 220, 220));
        btnEdit.setForeground(Color.DARK_GRAY);
        btnEdit.setFocusPainted(false);
        btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEdit.setBounds(185, 520, 145, 38);
        add(btnEdit);
    }
}
