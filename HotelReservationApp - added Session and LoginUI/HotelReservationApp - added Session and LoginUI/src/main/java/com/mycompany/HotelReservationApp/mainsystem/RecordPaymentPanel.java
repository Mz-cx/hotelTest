package com.mycompany.HotelReservationApp.mainsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RecordPaymentPanel extends JFrame implements ActionListener {

    private JButton btnHomePage, btnSideDash, btnSideRegister,
            btnSideCheckIn, btnSideCheckOut, btnSidePay, btnSideReserve, btnSearch, btnProcess;
    private JLabel lblReception, lblHotel, lblManagement, lblBalance, lblSearch, lblResID, lblGuest, lblRoom, lblPayMethod, lblCash, lblCard, lblExpiry, lblCVV, lblPhone, lblOTP;
    private JTextField txtResID, txtGuest, txtRoom, txtCash, txtCard, txtExpiry, txtCVV, txtPhone, txtOTP, txtSearch;
    private JComboBox<String> cmbMethod;
    private JPanel sidePan, topPan, RPanel;

    RecordPaymentPanel(){ 
        sidePanel(); 
        functionMenu(); 
        topPanel(); 
        paymentForm();

        setSize(1200,700); 
        setLayout(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setResizable(false); 
    } 

    private void functionMenu(){ 
        lblReception = new JLabel ("PAYMENT RECORD"); 
        lblReception.setBounds(350, 60, 800, 60); 
        lblReception.setFont(new Font ("Arial Black", Font.BOLD, 60)); 
        add(lblReception); 
    } 

    private void sidePanel() { 
        sidePan = new JPanel (); 
        sidePan.setBounds (0, 0, 300, 800); 
        sidePan.setLayout(null); 
        sidePan.setBackground(Color.decode("#222222")); 
        add(sidePan); 

        lblHotel = new JLabel ("HOTEL"); 
        lblHotel.setBounds(10, 10, 800, 50); 
        lblHotel.setFont(new Font ("Arial Black", Font.BOLD, 40)); 
        lblHotel.setForeground(Color.WHITE); 
        sidePan.add(lblHotel); 

        lblManagement = new JLabel ("MANAGEMENT"); 
        lblManagement.setBounds(10, 50, 800, 50); 
        lblManagement.setFont(new Font ("Arial Black", Font.BOLD, 30)); 
        lblManagement.setForeground(Color.WHITE); 
        sidePan.add(lblManagement); 

        btnHomePage = new JButton ("Home Page"); 
        btnHomePage.setBounds(0, 160, 300, 50); 
        btnHomePage.setBackground(Color.decode("#222222")); 
        btnHomePage.setForeground(Color.WHITE); 
        btnHomePage.setFont(new Font ("Arial Black", Font.BOLD, 18)); 
        btnHomePage.setBorderPainted(false); 
        btnHomePage.setFocusPainted(false); 
        btnHomePage.setBorder(null); 
        btnHomePage.addActionListener(this); 
        sidePan.add(btnHomePage); 

        btnSideDash = new JButton ("Dashboard"); 
        btnSideDash.setBounds(0, 230, 300, 50); 
        btnSideDash.setBackground(Color.decode("#222222")); 
        btnSideDash.setForeground(Color.WHITE); 
        btnSideDash.setFont(new Font ("Arial Black", Font.BOLD, 18)); 
        btnSideDash.setBorderPainted(false); 
        btnSideDash.setFocusPainted(false); 
        btnSideDash.setBorder(null); 
        btnSideDash.addActionListener(this); 
        sidePan.add(btnSideDash); 

        btnSideRegister = new JButton ("Guest Register"); 
        btnSideRegister.setBounds(0, 300, 300, 50); 
        btnSideRegister.setBackground(Color.decode("#222222")); 
        btnSideRegister.setForeground(Color.WHITE); 
        btnSideRegister.setFont(new Font ("Arial Black", Font.BOLD, 18)); 
        btnSideRegister.setBorderPainted(false); 
        btnSideRegister.setFocusPainted(false); 
        btnSideRegister.setBorder(null); 
        btnSideRegister.addActionListener(this); 
        sidePan.add(btnSideRegister); 

        btnSideCheckIn = new JButton ("Check In"); 
        btnSideCheckIn.setBounds(0, 370, 300, 50); 
        btnSideCheckIn.setBackground(Color.decode("#222222")); 
        btnSideCheckIn.setForeground(Color.WHITE); 
        btnSideCheckIn.setFont(new Font ("Arial Black", Font.BOLD, 18)); 
        btnSideCheckIn.setBorderPainted(false); 
        btnSideCheckIn.setFocusPainted(false); 
        btnSideCheckIn.setBorder(null); 
        btnSideCheckIn.addActionListener(this); 
        sidePan.add(btnSideCheckIn); 

        btnSideCheckOut = new JButton ("Check Out"); 
        btnSideCheckOut.setBounds(0, 440, 300, 50); 
        btnSideCheckOut.setBackground(Color.decode("#222222")); 
        btnSideCheckOut.setForeground(Color.WHITE); 
        btnSideCheckOut.setFont(new Font ("Arial Black", Font.BOLD, 18)); 
        btnSideCheckOut.setBorderPainted(false); 
        btnSideCheckOut.setFocusPainted(false); 
        btnSideCheckOut.setBorder(null); 
        btnSideCheckOut.addActionListener(this); 
        sidePan.add(btnSideCheckOut); 

        btnSidePay = new JButton ("Payment Record"); 
        btnSidePay.setBounds(0, 510, 300, 50); 
        btnSidePay.setBackground(Color.decode("#FFFFFFF")); 
        btnSidePay.setForeground(Color.BLACK); 
        btnSidePay.setFont(new Font ("Arial Black", Font.BOLD, 18)); 
        btnSidePay.setBorderPainted(false); 
        btnSidePay.setFocusPainted(false); 
        btnSidePay.setBorder(null); 
        btnSidePay.addActionListener(this); 
        sidePan.add(btnSidePay); 

        btnSideReserve = new JButton ("Reservation"); 
        btnSideReserve.setBounds(0, 580, 300, 50); 
        btnSideReserve.setBackground(Color.decode("#222222")); 
        btnSideReserve.setForeground(Color.WHITE); 
        btnSideReserve.setFont(new Font ("Arial Black", Font.BOLD, 18)); 
        btnSideReserve.setBorderPainted(false); 
        btnSideReserve.setFocusPainted(false); 
        btnSideReserve.setBorder(null); 
        btnSideReserve.addActionListener(this); 
        sidePan.add(btnSideReserve); 
    } 

    private void topPanel() { 
        topPan = new JPanel (); 
        topPan.setBounds (0, 0, 1500, 150); 
        topPan.setLayout(null); 
        topPan.setBackground(Color.decode("#FFFFFF")); 
        add(topPan); 
    } 
    private void paymentForm() {

        RPanel = new JPanel();
        RPanel.setBounds(320, 170, 850, 470);
        RPanel.setLayout(null);
        RPanel.setBackground(Color.WHITE);
        add(RPanel);

        lblSearch = new JLabel("Search Reservation ID:");
        lblSearch.setBounds(30, 20, 200, 20);
        RPanel.add(lblSearch);

        txtSearch = new JTextField();
        txtSearch.setBounds(30, 45, 400, 35);
        RPanel.add(txtSearch);

        btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(450, 45, 150, 35);
        btnSearch.setBackground(Color.decode("#222222"));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);
        btnSearch.addActionListener(this);
        RPanel.add(btnSearch);

        lblResID = new JLabel("Reservation ID");
        lblResID.setBounds(30, 95, 150, 20);
        RPanel.add(lblResID);

        txtResID = new JTextField();
        txtResID.setBounds(30, 120, 150, 35);
        RPanel.add(txtResID);

        lblGuest = new JLabel("Guest Name");
        lblGuest.setBounds(200, 95, 150, 20);
        RPanel.add(lblGuest);

        txtGuest = new JTextField();
        txtGuest.setBounds(200, 120, 200, 35);
        RPanel.add(txtGuest);

        lblRoom = new JLabel("Room No.");
        lblRoom.setBounds(420, 95, 150, 20);
        RPanel.add(lblRoom);

        txtRoom = new JTextField();
        txtRoom.setBounds(420, 120, 150, 35);
        RPanel.add(txtRoom);

        lblBalance = new JLabel("Outstanding Balance: ");
        lblBalance.setBounds(30, 170, 300, 20);
        RPanel.add(lblBalance);

        lblPayMethod = new JLabel("Payment Method");
        lblPayMethod.setBounds(30, 200, 200, 20);
        RPanel.add(lblPayMethod);

        cmbMethod = new JComboBox<>(new String[]{"Cash", "Credit Card", "E-Wallet"});
        cmbMethod.setBounds(30, 225, 200, 35);
        cmbMethod.addActionListener(this);
        RPanel.add(cmbMethod);

        lblCash = new JLabel("Cash Amount");
        lblCash.setBounds(30, 275, 150, 20);
        RPanel.add(lblCash);

        txtCash = new JTextField();
        txtCash.setBounds(30, 300, 200, 35);
        RPanel.add(txtCash);

        lblCard = new JLabel("Card Number");
        lblCard.setBounds(30, 275, 150, 20);
        RPanel.add(lblCard);

        txtCard = new JTextField();
        txtCard.setBounds(30, 300, 200, 35);
        RPanel.add(txtCard);

        lblExpiry = new JLabel("Expiry (MM/YY)");
        lblExpiry.setBounds(255, 275, 150, 20);
        RPanel.add(lblExpiry);

        txtExpiry = new JTextField();
        txtExpiry.setBounds(255, 300, 150, 35);
        RPanel.add(txtExpiry);

        lblCVV = new JLabel("CVV");
        lblCVV.setBounds(435, 275, 100, 20);
        RPanel.add(lblCVV);

        txtCVV = new JTextField();
        txtCVV.setBounds(435, 300, 100, 35);
        RPanel.add(txtCVV);

        lblPhone = new JLabel("Phone Number");
        lblPhone.setBounds(30, 275, 150, 20);
        RPanel.add(lblPhone);

        txtPhone = new JTextField();
        txtPhone.setBounds(30, 300, 200, 35);
        RPanel.add(txtPhone);

        lblOTP = new JLabel("OTP");
        lblOTP.setBounds(255, 275, 150, 20);
        RPanel.add(lblOTP);

        txtOTP = new JTextField();
        txtOTP.setBounds(255, 300, 150, 35);
        RPanel.add(txtOTP);

        btnProcess = new JButton("PROCESS PAYMENT");
        btnProcess.setBounds(300, 380, 200, 40);
        btnProcess.setBackground(Color.decode("#222222"));
        btnProcess.setForeground(Color.WHITE);
        btnProcess.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnProcess.setBorderPainted(false);
        btnProcess.setFocusPainted(false);
        btnProcess.addActionListener(this);
        RPanel.add(btnProcess);

        updateFields();
    }

    private void updateFields() {

        String method = (String) cmbMethod.getSelectedItem();

        lblCash.setVisible(false);
        txtCash.setVisible(false);

        lblCard.setVisible(false);
        txtCard.setVisible(false);
        lblExpiry.setVisible(false);
        txtExpiry.setVisible(false);
        lblCVV.setVisible(false);
        txtCVV.setVisible(false);

        lblPhone.setVisible(false);
        txtPhone.setVisible(false);
        lblOTP.setVisible(false);
        txtOTP.setVisible(false);

        if (method.equals("Cash")) {
            lblCash.setVisible(true);
            txtCash.setVisible(true);
        } else if (method.equals("Credit Card")) {
            lblCard.setVisible(true);
            txtCard.setVisible(true);
            lblExpiry.setVisible(true);
            txtExpiry.setVisible(true);
            lblCVV.setVisible(true);
            txtCVV.setVisible(true);
        } else {
            lblPhone.setVisible(true);
            txtPhone.setVisible(true);
            lblOTP.setVisible(true);
            txtOTP.setVisible(true);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cmbMethod) {
            updateFields();
        }

        if (e.getSource() == btnHomePage) {
            dispose(); new HomePage().setVisible(true);
        } else if (e.getSource() == btnSideDash) {
            dispose(); new ReceptionistDashboard().setVisible(true);
        } else if (e.getSource() == btnSideRegister) {
            dispose(); new RegisterGuestPanel().setVisible(true);
        } else if (e.getSource() == btnSideCheckIn) {
            dispose(); new CheckInPanel().setVisible(true);
        } else if (e.getSource() == btnSideCheckOut) {
            dispose(); new CheckOutPanel().setVisible(true);
        } else if (e.getSource() == btnSideReserve) {
            dispose(); new ViewReservationPanel().setVisible(true);
        }
    }
}