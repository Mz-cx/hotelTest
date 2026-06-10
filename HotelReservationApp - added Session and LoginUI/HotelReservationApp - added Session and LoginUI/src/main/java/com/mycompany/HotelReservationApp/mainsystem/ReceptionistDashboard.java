package com.mycompany.HotelReservationApp.mainsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ReceptionistDashboard extends JFrame implements ActionListener{

    private JButton btnSideDash, btnSideRegister, btnSideCheckIn, btnSideCheckOut, btnSidePay, btnSideReserve, btnHomePage, btnQuickCheckIn, btnQuickCheckOut, btnQuickReserve;;
    private JLabel lblReception, lblHotel, lblManagement, lblCheckIn, lblCheckOut, lblRooms, lblOccupancy, lblRecent;
    private JPanel sidePan, topPan, dashboardPanel, card1, card2, card3, card4, recentPanel, quickPanel;
    private JTextArea txtRecent;
    
    
    ReceptionistDashboard(){
        sidePanel();
        functionMenu();
        topPanel();
        dashboardPan();
        
        setSize(1200,700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void functionMenu(){
        
        lblReception = new JLabel ("DASHBOARD");
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
        btnSideDash.setBackground(Color.decode("#FFFFFF"));
        btnSideDash.setForeground(Color.BLACK);
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
        btnSidePay.setBackground(Color.decode("#222222"));
        btnSidePay.setForeground(Color.WHITE);
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
    private void dashboardPan(){

    dashboardPanel = new JPanel();
    dashboardPanel.setBounds(300, 150, 900, 500);
    dashboardPanel.setLayout(null);
    dashboardPanel.setBackground(Color.decode("#F5F5F5"));
    add(dashboardPanel);

    card1 = new JPanel();
    card1.setBounds(30, 20, 200, 80);
    card1.setBackground(Color.decode("#222222"));
    card1.setLayout(null);
    dashboardPanel.add(card1);

    JLabel lbl1 = new JLabel("Check-ins Today: ");
    lbl1.setBounds(10, 25, 150, 30);
    lbl1.setFont(new Font("Arial Black", Font.BOLD, 12));
    lbl1.setForeground(Color.WHITE);
    card1.add(lbl1);

    card2 = new JPanel();
    card2.setBounds(250, 20, 200, 80);
    card2.setBackground(Color.decode("#222222"));
    card2.setLayout(null);
    dashboardPanel.add(card2);

    JLabel lbl2 = new JLabel("Check-outs Today: ");
    lbl2.setBounds(10, 25, 160, 30);
    lbl2.setFont(new Font("Arial Black", Font.BOLD, 12));
    lbl2.setForeground(Color.WHITE);
    card2.add(lbl2);

    card3 = new JPanel();
    card3.setBounds(470, 20, 200, 80);
    card3.setBackground(Color.decode("#222222"));
    card3.setLayout(null);
    dashboardPanel.add(card3);

    JLabel lbl3 = new JLabel("Available Rooms: ");
    lbl3.setBounds(10, 25, 150, 30);
    lbl3.setFont(new Font("Arial Black", Font.BOLD, 12));
    lbl3.setForeground(Color.WHITE);
    card3.add(lbl3);

    card4 = new JPanel();
    card4.setBounds(690, 20, 180, 80);
    card4.setBackground(Color.decode("#222222"));
    card4.setLayout(null);
    dashboardPanel.add(card4);

    JLabel lbl4 = new JLabel("Occupancy %: ");
    lbl4.setBounds(10, 25, 150, 30);
    lbl4.setFont(new Font("Arial Black", Font.BOLD, 12));
    lbl4.setForeground(Color.WHITE);
    card4.add(lbl4);

    recentPanel = new JPanel();
    recentPanel.setBounds(30, 130, 400, 320);
    recentPanel.setBackground(Color.decode("#222222"));
    recentPanel.setLayout(null);
    dashboardPanel.add(recentPanel);

    JLabel lblRecent = new JLabel("Recent Reservations");
    lblRecent.setBounds(10, 10, 300, 30);
    lblRecent.setFont(new Font("Arial Black", Font.BOLD, 25));
    lblRecent.setForeground(Color.WHITE);
    recentPanel.add(lblRecent);

    txtRecent = new JTextArea();
    txtRecent.setBounds(10, 50, 380, 250);
    txtRecent.setBackground(Color.decode("#222222"));
    txtRecent.setForeground(Color.WHITE);
    txtRecent.setFont(new Font("Arial Black", Font.PLAIN, 14));
    recentPanel.add(txtRecent);

    JPanel quickPanel = new JPanel();
    quickPanel.setBounds(470, 130, 400, 320);
    quickPanel.setBackground(Color.decode("#222222"));
    quickPanel.setLayout(null);
    dashboardPanel.add(quickPanel);

    JLabel lblQuick = new JLabel("Quick Actions");
    lblQuick.setBounds(10, 10, 300, 30);
    lblQuick.setFont(new Font("Arial Black", Font.BOLD, 25));
    lblQuick.setForeground(Color.WHITE);
    quickPanel.add(lblQuick);

    btnQuickCheckIn = new JButton("Check In");
    btnQuickCheckIn.setBounds(0, 80, 400, 50);
    btnQuickCheckIn.setFont(new Font("Arial Black", Font.BOLD, 20));
    btnQuickCheckIn.setBackground(Color.decode("#222222"));
    btnQuickCheckIn.setForeground(Color.WHITE);
    quickPanel.add(btnQuickCheckIn);
    btnQuickCheckIn.addActionListener(this);
    
    btnQuickCheckIn.setBorderPainted(false);
    btnQuickCheckIn.setFocusPainted(false);
    btnQuickCheckIn.setBorder(null);
    btnQuickCheckIn.addActionListener(this);
    quickPanel.add(btnQuickCheckIn);

    btnQuickCheckOut = new JButton("Check Out");
    btnQuickCheckOut.setBounds(0, 150, 400, 50);
    btnQuickCheckOut.setFont(new Font("Arial Black", Font.BOLD, 20));
    btnQuickCheckOut.setBackground(Color.decode("#222222"));
    btnQuickCheckOut.setForeground(Color.WHITE);
    quickPanel.add(btnQuickCheckOut);
    btnQuickCheckOut.addActionListener(this);
    
    btnQuickCheckOut.setBorderPainted(false);
    btnQuickCheckOut.setFocusPainted(false);
    btnQuickCheckOut.setBorder(null);
    btnQuickCheckOut.addActionListener(this);
    quickPanel.add(btnQuickCheckOut);

    btnQuickReserve = new JButton("Reservation");
    btnQuickReserve.setBounds(0, 220, 400, 50);
    btnQuickReserve.setFont(new Font("Arial Black", Font.BOLD, 20));
    btnQuickReserve.setBackground(Color.decode("#222222"));
    btnQuickReserve.setForeground(Color.WHITE);
    quickPanel.add(btnQuickReserve);
    btnQuickReserve.addActionListener(this);
    
    btnQuickReserve.setBorderPainted(false);
    btnQuickReserve.setFocusPainted(false);
    btnQuickReserve.setBorder(null);
    btnQuickReserve.addActionListener(this);
    quickPanel.add(btnQuickReserve);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnHomePage){
            dispose();
            new HomePage().setVisible(true);
        }else if(e.getSource() == btnSideRegister){
            dispose();
            new RegisterGuestPanel().setVisible(true);
        }else if(e.getSource() == btnSideCheckIn){
            dispose();
            new CheckInPanel().setVisible(true);
        }else if(e.getSource() == btnSideCheckOut){
            dispose();
            new CheckOutPanel().setVisible(true);
        }else if(e.getSource() == btnSidePay){
            dispose();
            new RecordPaymentPanel().setVisible(true);
        }else if(e.getSource() == btnSideReserve){
            dispose();
            new ViewReservationPanel().setVisible(true);
        }else if(e.getSource() == btnQuickCheckIn){
            dispose();
            new CheckInPanel().setVisible(true);
        }else if(e.getSource() == btnQuickCheckOut){
            dispose();
            new CheckOutPanel().setVisible(true);
        }else if(e.getSource() == btnQuickReserve){
            dispose();
            new ViewReservationPanel().setVisible(true);
        }
        
    }
    
}

