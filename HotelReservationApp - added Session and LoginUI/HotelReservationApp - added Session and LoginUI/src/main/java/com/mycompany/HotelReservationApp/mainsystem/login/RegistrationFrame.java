package com.mycompany.HotelReservationApp.mainsystem.login;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.ui.StyledButton;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.MessageBox;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RegistrationFrame extends JFrame implements ActionListener, KeyListener {
    
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtEmail;
    private JTextField txtPhoneNumber;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JComboBox<String> cmbRole;
    private JButton btnRegister, btnCancel;
    private JLabel lblTitle, lblFirstName, lblLastName, lblEmail, lblPhoneNumber, lblUsername, lblPassword, lblConfirmPassword, lblRole;
    private UpdatedLoginFrame parentLoginFrame;
    
    public RegistrationFrame(UpdatedLoginFrame parentFrame) {
        this.parentLoginFrame = parentFrame;
        initWindow();
        createComponents();
        Logger.getInstance().info("RegistrationFrame initialized");
    }
    
    private void initWindow() {
        setTitle("Hotel Reservation System - Create Account");
        setSize(550, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
    }
    
    private void createComponents() {
        lblTitle = new JLabel("CREATE ACCOUNT");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(new Color(70, 70, 70));
        lblTitle.setBounds(50, 20, 400, 35);
        add(lblTitle);
        
        JLabel lblSubtitle = new JLabel("Register to start booking your hotel stay");
        lblSubtitle.setFont(new Font("Arial", Font.PLAIN, 12));
        lblSubtitle.setForeground(new Color(120, 120, 120));
        lblSubtitle.setBounds(50, 55, 400, 15);
        add(lblSubtitle);
        
        int yPos = 90;
        int fieldHeight = 35;
        int labelHeight = 20;
        int spacing = 10;
        
        // First Name
        lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Arial", Font.BOLD, 12));
        lblFirstName.setBounds(50, yPos, 150, labelHeight);
        add(lblFirstName);
        yPos += labelHeight + 5;
        
        txtFirstName = new JTextField();
        txtFirstName.setFont(new Font("Arial", Font.PLAIN, 12));
        txtFirstName.setBounds(50, yPos, 200, fieldHeight);
        txtFirstName.addKeyListener(this);
        add(txtFirstName);
        yPos += fieldHeight + spacing;
        
        // Last Name
        lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Arial", Font.BOLD, 12));
        lblLastName.setBounds(50, yPos, 150, labelHeight);
        add(lblLastName);
        yPos += labelHeight + 5;
        
        txtLastName = new JTextField();
        txtLastName.setFont(new Font("Arial", Font.PLAIN, 12));
        txtLastName.setBounds(50, yPos, 200, fieldHeight);
        txtLastName.addKeyListener(this);
        add(txtLastName);
        yPos += fieldHeight + spacing;
        
        // Email
        lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
        lblEmail.setBounds(50, yPos, 150, labelHeight);
        add(lblEmail);
        yPos += labelHeight + 5;
        
        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
        txtEmail.setBounds(50, yPos, 450, fieldHeight);
        txtEmail.addKeyListener(this);
        add(txtEmail);
        yPos += fieldHeight + spacing;
        
        // Phone Number
        lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 12));
        lblPhoneNumber.setBounds(50, yPos, 150, labelHeight);
        add(lblPhoneNumber);
        yPos += labelHeight + 5;
        
        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPhoneNumber.setBounds(50, yPos, 200, fieldHeight);
        txtPhoneNumber.addKeyListener(this);
        add(txtPhoneNumber);
        yPos += fieldHeight + spacing;
        
        // Username
        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 12));
        lblUsername.setBounds(50, yPos, 150, labelHeight);
        add(lblUsername);
        yPos += labelHeight + 5;
        
        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
        txtUsername.setBounds(50, yPos, 450, fieldHeight);
        txtUsername.addKeyListener(this);
        add(txtUsername);
        yPos += fieldHeight + spacing;
        
        // Password
        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
        lblPassword.setBounds(50, yPos, 150, labelHeight);
        add(lblPassword);
        yPos += labelHeight + 5;
        
        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPassword.setBounds(50, yPos, 450, fieldHeight);
        txtPassword.addKeyListener(this);
        add(txtPassword);
        yPos += fieldHeight + spacing;
        
        // Confirm Password
        lblConfirmPassword = new JLabel("Confirm Password:");
        lblConfirmPassword.setFont(new Font("Arial", Font.BOLD, 12));
        lblConfirmPassword.setBounds(50, yPos, 150, labelHeight);
        add(lblConfirmPassword);
        yPos += labelHeight + 5;
        
        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        txtConfirmPassword.setBounds(50, yPos, 450, fieldHeight);
        txtConfirmPassword.addKeyListener(this);
        add(txtConfirmPassword);
        yPos += fieldHeight + spacing;
        
        // Role Selection
        lblRole = new JLabel("Select Role:");
        lblRole.setFont(new Font("Arial", Font.BOLD, 12));
        lblRole.setBounds(50, yPos, 150, labelHeight);
        add(lblRole);
        yPos += labelHeight + 5;
        
        cmbRole = new JComboBox<>(new String[]{"Guest", "Receptionist"});
        cmbRole.setFont(new Font("Arial", Font.PLAIN, 12));
        cmbRole.setBounds(50, yPos, 200, fieldHeight);
        add(cmbRole);
        yPos += fieldHeight + spacing + 10;
        
        // Register Button
        btnRegister = new StyledButton("REGISTER", "success");
        btnRegister.setBounds(50, yPos, 210, 45);
        btnRegister.addActionListener(this);
        add(btnRegister);
        
        // Cancel Button
        btnCancel = new JButton("CANCEL");
        btnCancel.setFont(new Font("Arial", Font.PLAIN, 12));
        btnCancel.setBounds(290, yPos, 210, 45);
        btnCancel.setBackground(new Color(244, 67, 54));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(this);
        add(btnCancel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            handleRegister();
        } else if (e.getSource() == btnCancel) {
            handleCancel();
        }
    }
    
    private void handleRegister() {
        String firstName = txtFirstName.getText().trim();
        String lastName = txtLastName.getText().trim();
        String email = txtEmail.getText().trim();
        String phoneNumber = txtPhoneNumber.getText().trim();
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());
        String role = (String) cmbRole.getSelectedItem();
        
        // Validate all fields
        if (!validateInput(firstName, lastName, email, phoneNumber, username, password, confirmPassword)) {
            return;
        }
        
        // Create user account
        RegistrationManager registrationManager = RegistrationManager.getInstance();
        if (registrationManager.registerUser(firstName, lastName, email, phoneNumber, username, password, role)) {
            MessageBox.showInfo("Registration Successful", 
                "Account created successfully!\nUsername: " + username + "\n\nYou can now login with your credentials.");
            Logger.getInstance().info("New user registered: " + username);
            dispose();
        } else {
            MessageBox.showError("Registration Failed", 
                "Username already exists. Please choose a different username.");
            Logger.getInstance().warn("Registration failed - Username already exists: " + username);
        }
    }
    
    private boolean validateInput(String firstName, String lastName, String email, 
                                   String phoneNumber, String username, String password, 
                                   String confirmPassword) {
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || 
            phoneNumber.isEmpty() || username.isEmpty() || password.isEmpty()) {
            MessageBox.showWarning("Validation Error", "All fields are required");
            Logger.getInstance().warn("Registration validation failed - Empty fields");
            return false;
        }
        
        if (!email.contains("@") || !email.contains(".")) {
            MessageBox.showWarning("Validation Error", "Please enter a valid email address");
            Logger.getInstance().warn("Registration validation failed - Invalid email: " + email);
            return false;
        }
        
        if (phoneNumber.length() < 7 || !phoneNumber.matches("[0-9\\-\\+ ]+")) {
            MessageBox.showWarning("Validation Error", "Please enter a valid phone number");
            Logger.getInstance().warn("Registration validation failed - Invalid phone: " + phoneNumber);
            return false;
        }
        
        if (username.length() < 3) {
            MessageBox.showWarning("Validation Error", "Username must be at least 3 characters long");
            Logger.getInstance().warn("Registration validation failed - Username too short: " + username);
            return false;
        }
        
        if (password.length() < 6) {
            MessageBox.showWarning("Validation Error", "Password must be at least 6 characters long");
            Logger.getInstance().warn("Registration validation failed - Password too short");
            return false;
        }
        
        if (!password.equals(confirmPassword)) {
            MessageBox.showWarning("Validation Error", "Passwords do not match");
            Logger.getInstance().warn("Registration validation failed - Passwords do not match");
            return false;
        }
        
        return true;
    }
    
    private void handleCancel() {
        dispose();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            handleRegister();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
}