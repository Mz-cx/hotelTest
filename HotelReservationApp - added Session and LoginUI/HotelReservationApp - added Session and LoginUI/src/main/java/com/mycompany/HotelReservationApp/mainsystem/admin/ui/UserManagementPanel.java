package com.mycompany.HotelReservationApp.mainsystem.admin.ui;
import javax.swing.*;
import java.awt.*;

public class UserManagementPanel extends JPanel {

    public UserManagementPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, 0, 1116, 668);

        JLabel lblTitle = new JLabel("User Management");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setBounds(30, 30, 400, 28);
        add(lblTitle);


        JLabel lblCount = new JLabel("Total staff accounts: 0");
        lblCount.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblCount.setForeground(Color.DARK_GRAY);
        lblCount.setBounds(30, 95, 400, 22);
        add(lblCount);


        JLabel lblName = new JLabel("Full Name:");
        lblName.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblName.setBounds(30, 140, 120, 22);
        add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(30, 165, 300, 35);
        add(txtName);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblEmail.setBounds(30, 215, 120, 22);
        add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(30, 240, 300, 35);
        add(txtEmail);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblPassword.setBounds(30, 290, 120, 22);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(30, 315, 300, 35);
        add(txtPassword);

        
        JButton btnAdd = new JButton("Add User");
        btnAdd.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnAdd.setBackground(new Color(220, 220, 220));
        btnAdd.setForeground(Color.DARK_GRAY);
        btnAdd.setFocusPainted(false);
        btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAdd.setBounds(30, 375, 140, 38);
        add(btnAdd);

        JButton btnRemove = new JButton("Remove User");
        btnRemove.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnRemove.setBackground(new Color(220, 220, 220));
        btnRemove.setForeground(Color.DARK_GRAY);
        btnRemove.setFocusPainted(false);
        btnRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRemove.setBounds(185, 375, 145, 38);
        add(btnRemove);
    }
}
