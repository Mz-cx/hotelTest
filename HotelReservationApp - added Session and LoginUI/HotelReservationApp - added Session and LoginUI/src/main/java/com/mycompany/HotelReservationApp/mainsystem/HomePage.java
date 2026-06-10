package com.mycompany.HotelReservationApp.mainsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener{
        
    private JButton btnCheckIn, btnCheckOut, btnRegistration, btnDashBoard, btnPayment, btnReservation,
            btnSideDash, btnSideRegister, btnSideCheckIn, btnSideCheckOut, btnSidePay, btnSideReserve, btnHomePage;
    private JLabel lblReception;
    
    
    HomePage(){
        functionMenu();
        
        setSize(1200,700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    private void functionMenu(){
        
        lblReception = new JLabel ("RECEPTION");
        lblReception.setBounds(400, 60, 800, 60);
        lblReception.setFont(new Font ("Arial Black", Font.BOLD, 70));
        add(lblReception);
        
        btnDashBoard = new JButton ("DASHBOARD");
        btnDashBoard.setBounds(200, 180, 245, 200);
        btnDashBoard.setBackground(Color.BLACK);
        btnDashBoard.setForeground(Color.WHITE);
        btnDashBoard.setFont(new Font ("Arial Black", Font.BOLD, 20));
        
        btnDashBoard.setBorderPainted(false);
        btnDashBoard.setFocusPainted(false);
        btnDashBoard.setBorder(null);
        btnDashBoard.addActionListener(this);
        add(btnDashBoard);
        
        btnRegistration = new JButton ("GUEST REGISTRATION");
        btnRegistration.setBounds(510, 180, 245, 200);
        btnRegistration.setBackground(Color.BLACK);
        btnRegistration.setForeground(Color.WHITE);
        btnRegistration.setFont(new Font ("Arial Black", Font.BOLD, 15));
        
        btnRegistration.setBorderPainted(false);
        btnRegistration.setFocusPainted(false);
        btnRegistration.setBorder(null);
        btnRegistration.addActionListener(this);
        add(btnRegistration);
        
        btnCheckIn = new JButton ("CHECK IN");
        btnCheckIn.setBounds(820, 180, 245, 200);
        btnCheckIn.setBackground(Color.BLACK);
        btnCheckIn.setForeground(Color.WHITE);
        btnCheckIn.setFont(new Font ("Arial Black", Font.BOLD, 20));
        
        btnCheckIn.setBorderPainted(false);
        btnCheckIn.setFocusPainted(false);
        btnRegistration.setBorder(null);
        btnCheckIn.addActionListener(this);
        add(btnCheckIn);
        
        btnCheckOut = new JButton ("CHECK OUT");
        btnCheckOut.setBounds(200, 400, 245, 200);
        btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
        btnCheckOut.setFont(new Font ("Arial Black", Font.BOLD, 20));
        
        btnCheckOut.setBorderPainted(false);
        btnCheckOut.setFocusPainted(false);
        btnCheckOut.setBorder(null);
        btnCheckOut.addActionListener(this);
        add(btnCheckOut);
        
        btnPayment = new JButton ("PAYMENT RECORD");
        btnPayment.setBounds(510, 400, 245, 200);
        btnPayment.setBackground(Color.BLACK);
        btnPayment.setForeground(Color.WHITE);
        btnPayment.setFont(new Font ("Arial Black", Font.BOLD, 17));
        
        btnPayment.setBorderPainted(false);
        btnPayment.setFocusPainted(false);
        btnPayment.setBorder(null);
        btnPayment.addActionListener(this);
        add(btnPayment);
        
        btnReservation = new JButton ("RESERVATION");
        btnReservation.setBounds(820, 400, 245, 200);
        btnReservation.setBackground(Color.BLACK);
        btnReservation.setForeground(Color.WHITE);
        btnReservation.setFont(new Font ("Arial Black", Font.BOLD, 20));
        
        btnReservation.setBorderPainted(false);
        btnReservation.setFocusPainted(false);
        btnReservation.setBorder(null);
        btnReservation.addActionListener(this);
        add(btnReservation);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnDashBoard){
            dispose();
            new ReceptionistDashboard().setVisible(true);
        }else if(e.getSource() == btnRegistration){
            dispose();
            new RegisterGuestPanel().setVisible(true);
        }else if(e.getSource() == btnCheckIn){
            dispose();
            new CheckInPanel().setVisible(true);
        }else if(e.getSource() == btnCheckOut){
            dispose();
            new CheckOutPanel().setVisible(true);
        }else if(e.getSource() == btnPayment){
            dispose();
            new RecordPaymentPanel().setVisible(true);
        }else if(e.getSource() == btnReservation){
            dispose();
            new ViewReservationPanel().setVisible(true);
        }
        
    }
    
}