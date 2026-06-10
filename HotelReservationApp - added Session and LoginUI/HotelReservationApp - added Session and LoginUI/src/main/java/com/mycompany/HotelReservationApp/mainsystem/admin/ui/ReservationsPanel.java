package com.mycompany.HotelReservationApp.mainsystem.admin.ui;
import javax.swing.*;
import java.awt.*;

public class ReservationsPanel extends JPanel {

    public ReservationsPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, 0, 1116, 668);

        JLabel lblTitle = new JLabel("Reservations");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setBounds(30, 30, 400, 28);
        add(lblTitle);


        JLabel lblTotal = new JLabel("Total reservations: 0");
        lblTotal.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblTotal.setForeground(Color.DARK_GRAY);
        lblTotal.setBounds(30, 95, 400, 22);
        add(lblTotal);

        JLabel lblActive = new JLabel("Active reservations: 0");
        lblActive.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblActive.setForeground(Color.DARK_GRAY);
        lblActive.setBounds(30, 120, 400, 22);
        add(lblActive);


        JLabel lblGuestName = new JLabel("Guest Name:");
        lblGuestName.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblGuestName.setBounds(30, 165, 150, 22);
        add(lblGuestName);

        JTextField txtGuestName = new JTextField();
        txtGuestName.setBounds(30, 190, 300, 35);
        add(txtGuestName);

        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblRoomNumber.setBounds(30, 240, 150, 22);
        add(lblRoomNumber);

        JTextField txtRoomNumber = new JTextField();
        txtRoomNumber.setBounds(30, 265, 300, 35);
        add(txtRoomNumber);

        JLabel lblCheckIn = new JLabel("Check In (YYYY-MM-DD):");
        lblCheckIn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblCheckIn.setBounds(30, 315, 200, 22);
        add(lblCheckIn);

        JTextField txtCheckIn = new JTextField();
        txtCheckIn.setBounds(30, 340, 300, 35);
        add(txtCheckIn);

        JLabel lblCheckOut = new JLabel("Check Out (YYYY-MM-DD):");
        lblCheckOut.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblCheckOut.setBounds(30, 390, 200, 22);
        add(lblCheckOut);

        JTextField txtCheckOut = new JTextField();
        txtCheckOut.setBounds(30, 415, 300, 35);
        add(txtCheckOut);


        JButton btnAdd = new JButton("Add Reservation");
        btnAdd.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnAdd.setBackground(new Color(220, 220, 220));
        btnAdd.setForeground(Color.DARK_GRAY);
        btnAdd.setFocusPainted(false);
        btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAdd.setBounds(30, 475, 160, 38);
        add(btnAdd);

        JButton btnCancel = new JButton("Cancel Reservation");
        btnCancel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnCancel.setBackground(new Color(220, 220, 220));
        btnCancel.setForeground(Color.DARK_GRAY);
        btnCancel.setFocusPainted(false);
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.setBounds(205, 475, 170, 38);
        add(btnCancel);
    }
}
