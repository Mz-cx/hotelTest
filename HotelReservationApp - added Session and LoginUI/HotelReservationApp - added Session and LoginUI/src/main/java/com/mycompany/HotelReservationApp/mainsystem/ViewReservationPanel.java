package com.mycompany.HotelReservationApp.mainsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ViewReservationPanel extends JFrame implements ActionListener{

private JButton btnCheckIn, btnCheckOut, btnRegistration, btnDashBoard, btnPayment, btnReservation,
            btnSideDash, btnSideRegister, btnSideCheckIn, btnSideCheckOut, btnSidePay, btnSideReserve, btnHomePage,
            btnSearch, btnCancel, btnViewDetails;
    private JLabel lblReception, lblHotel, lblManagement;
    private JPanel sidePan, topPan, filterPanel, tablePanel, actionPanel;
    private JTable tblReservations;
    private JTextField txtSearch, txtGuestFilter, txtDateFilter;
    private JComboBox<String> cbStatus, cbRoomFilter;
    
    
    ViewReservationPanel(){
        sidePanel();
        functionMenu();
        topPanel();
        filterSection();
        tableSection();
        actionSection();
        
        setSize(1200,700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    private void functionMenu(){
        
        lblReception = new JLabel ("RESERVATION");
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
        btnSideReserve.setBackground(Color.decode("#FFFFFF"));
        btnSideReserve.setForeground(Color.BLACK);
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
    }private void filterSection() {

        filterPanel = new JPanel();
        filterPanel.setBounds(320, 140, 850, 50);
        filterPanel.setLayout(null);
        add(filterPanel);

        txtSearch = new JTextField();
        txtSearch.setBounds(10, 20, 140, 30);
        filterPanel.add(txtSearch);

        cbStatus = new JComboBox<>(new String[]{
                "All", "Confirmed", "Checked-In", "Checked-Out", "Cancelled"
        });
        cbStatus.setBounds(160, 20, 130, 30);
        filterPanel.add(cbStatus);

        cbRoomFilter = new JComboBox<>(new String[]{"All Rooms"});
        cbRoomFilter.setBounds(300, 20, 120, 30);
        filterPanel.add(cbRoomFilter);

        txtGuestFilter = new JTextField();
        txtGuestFilter.setBounds(430, 20, 150, 30);
        filterPanel.add(txtGuestFilter);

        txtDateFilter = new JTextField();
        txtDateFilter.setBounds(590, 20, 120, 30);
        filterPanel.add(txtDateFilter);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(720, 20, 100, 30);
        btnSearch.setBackground(Color.decode("#222222"));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);
        btnSearch.addActionListener(this);
        filterPanel.add(btnSearch);
    }
    private void tableSection() {

        tablePanel = new JPanel();
        tablePanel.setBounds(320, 200, 850, 350);
        tablePanel.setLayout(null);
        add(tablePanel);

        String[] columns = {"ID", "Guest Name", "Room", "Date", "Status"};

        Object[][] data = new Object[0][5];

        tblReservations = new JTable(data, columns);

        JScrollPane sp = new JScrollPane(tblReservations);
        sp.setBounds(0, 0, 850, 350);

        tablePanel.add(sp);
    }

    private void actionSection() {

        actionPanel = new JPanel();
        actionPanel.setBounds(320, 570, 850, 60);
        actionPanel.setLayout(null);
        add(actionPanel);

        btnCheckIn = new JButton("Check-In");
        btnCheckIn.setBounds(160, 10, 120, 35);
        btnCheckIn.setBackground(Color.decode("#222222"));
        btnCheckIn.setForeground(Color.WHITE);
        btnCheckIn.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnCheckIn.setBorderPainted(false);
        btnCheckIn.setFocusPainted(false);
        btnCheckIn.addActionListener(this);
        actionPanel.add(btnCheckIn);

        btnCheckOut = new JButton("Check-Out");
        btnCheckOut.setBounds(290, 10, 120, 35);
        btnCheckOut.setBackground(Color.decode("#222222"));
        btnCheckOut.setForeground(Color.WHITE);
        btnCheckOut.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnCheckOut.setBorderPainted(false);
        btnCheckOut.setFocusPainted(false);
        btnCheckOut.addActionListener(this);
        actionPanel.add(btnCheckOut);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(420, 10, 120, 35);
        btnCancel.setBackground(Color.decode("#222222"));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(this);
        actionPanel.add(btnCancel);

        btnViewDetails = new JButton("View Details");
        btnViewDetails.setBounds(550, 10, 140, 35);
        btnViewDetails.setBackground(Color.decode("#222222"));
        btnViewDetails.setForeground(Color.WHITE);
        btnViewDetails.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnViewDetails.setBorderPainted(false);
        btnViewDetails.setFocusPainted(false);
        btnViewDetails.addActionListener(this);
        actionPanel.add(btnViewDetails);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSearch) {
            System.out.println("Search using DAO");
        }

        if (e.getSource() == btnCheckIn) {
            System.out.println("Check-in");
        }

        if (e.getSource() == btnCheckOut) {
            System.out.println("Check-out");
        }

        if (e.getSource() == btnCancel) {
            System.out.println("Cancel reservation");
        }

        if (e.getSource() == btnViewDetails) {
            System.out.println("View details");
        }
        
        if(e.getSource() == btnHomePage){
            dispose();
            new HomePage().setVisible(true);
        }else if(e.getSource() == btnSideDash){
            dispose();
            new ReceptionistDashboard().setVisible(true);
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
        }
        
    }
    
}
