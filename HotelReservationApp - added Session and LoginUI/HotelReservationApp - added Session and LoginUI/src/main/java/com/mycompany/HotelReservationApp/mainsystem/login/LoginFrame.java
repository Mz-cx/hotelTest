package com.mycompany.HotelReservationApp.mainsystem.login;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.session.SessionManager;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.session.AuthManager;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.ui.StyledButton;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.MessageBox;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;
import com.mycompany.HotelReservationApp.mainsystem.guest.ui.GuestInterface;
import com.mycompany.HotelReservationApp.mainsystem.receptionist.ReceptionMainWindow;
import com.mycompany.HotelReservationApp.mainsystem.admin.ui.AdminDashboardMain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginFrame extends JFrame implements ActionListener, KeyListener {
    
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JComboBox<String> cmbRole;
    private JButton btnLogin, btnExit, btnForgotPassword;
    private JLabel lblTitle, lblUsername, lblPassword, lblRole;
    private JCheckBox chkRememberMe;
    
    public LoginFrame() {
        initWindow();
        createComponents();
        Logger.getInstance().info("LoginFrame initialized");
    }
    
    private void initWindow() {
        setTitle("Hotel Reservation System - Login");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
    }
    
    private void createComponents() {
        lblTitle = new JLabel("HOTEL RESERVATION SYSTEM");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(new Color(70, 70, 70));
        lblTitle.setBounds(50, 30, 400, 35);
        add(lblTitle);
        
        JLabel lblSubtitle = new JLabel("Login to your account");
        lblSubtitle.setFont(new Font("Arial", Font.PLAIN, 12));
        lblSubtitle.setForeground(new Color(120, 120, 120));
        lblSubtitle.setBounds(50, 65, 400, 15);
        add(lblSubtitle);
        
        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 12));
        lblUsername.setBounds(50, 100, 150, 20);
        add(lblUsername);
        
        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
        txtUsername.setBounds(50, 125, 400, 35);
        txtUsername.addKeyListener(this);
        add(txtUsername);
        
        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
        lblPassword.setBounds(50, 165, 150, 20);
        add(lblPassword);
        
        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        txtPassword.setBounds(50, 190, 400, 35);
        txtPassword.addKeyListener(this);
        add(txtPassword);
        
        lblRole = new JLabel("Select Role:");
        lblRole.setFont(new Font("Arial", Font.BOLD, 12));
        lblRole.setBounds(50, 230, 150, 20);
        add(lblRole);
        
        cmbRole = new JComboBox<>(new String[]{"Guest", "Receptionist", "Admin"});
        cmbRole.setFont(new Font("Arial", Font.PLAIN, 12));
        cmbRole.setBounds(50, 255, 400, 35);
        add(cmbRole);
        
        chkRememberMe = new JCheckBox("Remember me");
        chkRememberMe.setFont(new Font("Arial", Font.PLAIN, 11));
        chkRememberMe.setBounds(50, 300, 150, 20);
        add(chkRememberMe);
        
        btnLogin = new StyledButton("LOGIN", "success");
        btnLogin.setBounds(50, 330, 190, 45);
        btnLogin.addActionListener(this);
        add(btnLogin);
        
        btnForgotPassword = new JButton("Forgot Password?");
        btnForgotPassword.setFont(new Font("Arial", Font.PLAIN, 11));
        btnForgotPassword.setBounds(260, 330, 190, 45);
        btnForgotPassword.setBackground(new Color(200, 200, 200));
        btnForgotPassword.setBorderPainted(false);
        btnForgotPassword.setFocusPainted(false);
        btnForgotPassword.addActionListener(this);
        add(btnForgotPassword);
        
        btnExit = new JButton("EXIT");
        btnExit.setFont(new Font("Arial", Font.PLAIN, 11));
        btnExit.setBounds(50, 385, 400, 35);
        btnExit.setBackground(new Color(244, 67, 54));
        btnExit.setForeground(Color.WHITE);
        btnExit.setBorderPainted(false);
        btnExit.setFocusPainted(false);
        btnExit.addActionListener(this);
        add(btnExit);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            handleLogin();
        } else if (e.getSource() == btnForgotPassword) {
            handleForgotPassword();
        } else if (e.getSource() == btnExit) {
            handleExit();
        }
    }
    
    private void handleLogin() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        String role = (String) cmbRole.getSelectedItem();
        
        if (username.isEmpty() || password.isEmpty()) {
            MessageBox.showWarning("Login", "Please enter username and password");
            Logger.getInstance().warn("Login attempt with empty credentials");
            return;
        }
        
        AuthManager auth = AuthManager.getInstance();
        if (auth.authenticate(username, password)) {
            SessionManager.login(username, role);
            openModule(role);
            dispose();
        } else {
            MessageBox.showError("Login Failed", "Invalid username or password");
        }
    }
    
    private void openModule(String role) {
        try {
            switch (role) {
                case "Guest":
                    new GuestInterface().setVisible(true);
                    break;
                case "Receptionist":
                    new ReceptionMainWindow().setVisible(true);
                    break;
                case "Admin":
                    new AdminDashboardMain().setVisible(true);
                    break;
                default:
                    MessageBox.showError("Error", "Unknown role: " + role);
            }
        } catch (Exception ex) {
            Logger.getInstance().error("Error opening module", ex);
            MessageBox.showError("Error", "Failed to open module: " + ex.getMessage());
        }
    }
    
    private void handleForgotPassword() {
        String email = JOptionPane.showInputDialog(this,
            "Enter your registered email address:",
            "Forgot Password",
            JOptionPane.QUESTION_MESSAGE);
        
        if (email != null && !email.isEmpty()) {
            Logger.getInstance().info("Password reset requested for: " + email);
            MessageBox.showInfo("Password Reset",
                "Instructions have been sent to " + email);
        }
    }
    
    private void handleExit() {
        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to exit?", "Exit",
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            Logger.getInstance().info("Application closed by user");
            System.exit(0);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            handleLogin();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
}