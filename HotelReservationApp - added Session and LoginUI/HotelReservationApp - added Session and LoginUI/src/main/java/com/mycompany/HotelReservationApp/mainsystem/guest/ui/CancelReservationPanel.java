package com.mycompany.HotelReservationApp.mainsystem.guest.ui;
import javax.swing.*;
import java.awt.*;

public class CancelReservationPanel extends JPanel {
    private JLabel lblTitle;
    private JComboBox<String> cmbReservations;
    private JTextArea areaPolicy;
    private JButton btnProcess;

    public CancelReservationPanel() {
        setLayout(null);

        lblTitle = new JLabel("CANCEL BOOKING");
        lblTitle.setBounds(50, 30, 300, 30);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle);

        cmbReservations = new JComboBox<>(new String[]{"R-101: Room 101"});
        cmbReservations.setBounds(50, 100, 300, 35);
        add(cmbReservations);

        areaPolicy = new JTextArea("Cancellation Policy Applied.");
        areaPolicy.setBounds(50, 160, 300, 80);
        areaPolicy.setEditable(false);
        add(areaPolicy);

        btnProcess = new JButton("Confirm Cancel");
        btnProcess.setBounds(50, 260, 150, 40);
        btnProcess.setBackground(Color.RED);
        btnProcess.setForeground(Color.WHITE);
        add(btnProcess);
    }
}
