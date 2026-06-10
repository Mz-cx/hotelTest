package com.mycompany.HotelReservationApp.mainsystem.guest.ui;

import javax.swing.*;
import java.awt.*;

public class GuestProfilePanel extends JPanel {
    // Private variables for Encapsulation
    private JLabel lblTitle;
    private JLabel lblName;
    private JLabel lblEmail;
    private JLabel lblPassword;
    private JTextField txtName;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnUpdate;
    private JButton btnChangePassword;

    public GuestProfilePanel() {
        
        setLayout(null);
        setBackground(Color.WHITE);

        
        lblTitle = new JLabel("GUEST PROFILE");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(50, 30, 300, 40);
        add(lblTitle);

        
        lblName = new JLabel("Full Name");
        lblName.setBounds(50, 100, 150, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(50, 130, 300, 35);
        add(txtName);

        
        lblEmail = new JLabel("Email Address");
        lblEmail.setBounds(50, 180, 150, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(50, 210, 300, 35);
        add(txtEmail);

        
        lblPassword = new JLabel("New Password");
        lblPassword.setBounds(50, 260, 150, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(50, 290, 300, 35);
        add(txtPassword);

        
        btnUpdate = new JButton("Update Profile Information");
        btnUpdate.setBounds(50, 360, 250, 40);
        add(btnUpdate);

        
        btnChangePassword = new JButton("Change Password");
        btnChangePassword.setBounds(310, 360, 200, 40);
        add(btnChangePassword);
        
        
        loadGuestData();
    }

    private void loadGuestData() {
        
        txtName.setText("Guest");
        txtEmail.setText("guest@email.com");
    }
}
