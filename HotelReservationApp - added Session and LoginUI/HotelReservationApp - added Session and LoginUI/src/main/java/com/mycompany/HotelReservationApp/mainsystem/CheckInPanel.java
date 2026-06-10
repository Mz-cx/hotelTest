package com.mycompany.HotelReservationApp.mainsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CheckInPanel extends JFrame implements ActionListener{

private JButton btnCheckIn, btnCheckOut, btnRegistration, btnDashBoard, btnPayment, btnReservation,
            btnSideDash, btnSideRegister, btnSideCheckIn, btnSideCheckOut, btnSidePay, btnSideReserve, btnHomePage;
    private JLabel lblReception, lblHotel, lblManagement, lblSearch, lblDetails;;
    private JButton btnSearch, btnConfirmIdentity, btnCheckInGuest, btnGenerateReceipt;
     private JTextField txtSearch, txtGuestName, txtReservationID, txtRoom, txtStatus;
    private JPanel sidePan, topPan, mainPan;
    
    
    CheckInPanel(){
        sidePanel();
        functionMenu();
        topPanel();
        checkInForm();
        
        setSize(1200,700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    private void functionMenu(){
        
        lblReception = new JLabel ("CHECK IN");
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
        btnSideCheckIn.setBackground(Color.decode("#FFFFFF"));
        btnSideCheckIn.setForeground(Color.BLACK);
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
    private void checkInForm() {

        mainPan = new JPanel();
        mainPan.setBounds(320, 170, 850, 470);
        mainPan.setLayout(null);
        mainPan.setBackground(Color.decode("#FFFFFF")); 
        add(mainPan);

        JLabel title = new JLabel("CHECK-IN MANAGEMENT");
        title.setBounds(30, 10, 400, 30);
        title.setFont(new Font("Arial Black", Font.BOLD, 18));
        mainPan.add(title);


        JLabel lblSearch = new JLabel("Search Reservation (ID / Name):");
        lblSearch.setBounds(30, 50, 300, 25);
        lblSearch.setFont(new Font("Arial", Font.BOLD, 14));
        mainPan.add(lblSearch);

        JTextField txtSearch = new JTextField();
        txtSearch.setBounds(30, 80, 450, 40);
        txtSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPan.add(txtSearch);

        JButton btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(500, 80, 150, 40);
        btnSearch.setBackground(Color.decode("#222222"));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnSearch.setBorderPainted(false);
        btnSearch.setFocusPainted(false);
        mainPan.add(btnSearch);


        JLabel lblResID = new JLabel("Reservation ID");
        lblResID.setBounds(30, 140, 150, 25);
        mainPan.add(lblResID);

        JTextField txtResID = new JTextField();
        txtResID.setBounds(30, 165, 180, 40);
        mainPan.add(txtResID);


        JLabel lblGuest = new JLabel("Guest Name");
        lblGuest.setBounds(230, 140, 150, 25);
        mainPan.add(lblGuest);

        JTextField txtGuest = new JTextField();
        txtGuest.setBounds(230, 165, 200, 40);
        mainPan.add(txtGuest);


        JLabel lblRoom = new JLabel("Room No.");
        lblRoom.setBounds(450, 140, 150, 25);
        mainPan.add(lblRoom);

        JTextField txtRoom = new JTextField();
        txtRoom.setBounds(450, 165, 120, 40);
        mainPan.add(txtRoom);


        JLabel lblStatus = new JLabel("Status");
        lblStatus.setBounds(590, 140, 150, 25);
        mainPan.add(lblStatus);

        JTextField txtStatus = new JTextField();
        txtStatus.setBounds(590, 165, 120, 40);
        mainPan.add(txtStatus);

        btnConfirmIdentity = new JButton("VERIFY GUEST");
        btnConfirmIdentity.setBounds(100, 260, 180, 40);
        btnConfirmIdentity.setBackground(Color.decode("#222222"));
        btnConfirmIdentity.setForeground(Color.WHITE);
        btnConfirmIdentity.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnConfirmIdentity.setBorderPainted(false);
        btnConfirmIdentity.setFocusPainted(false);
        mainPan.add(btnConfirmIdentity);
        

        btnCheckInGuest = new JButton("CHECK-IN");
        btnCheckInGuest.setBounds(300, 260, 180, 40);
        btnCheckInGuest.setBackground(Color.decode("#222222"));
        btnCheckInGuest.setForeground(Color.WHITE);
        btnCheckInGuest.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnCheckInGuest.setBorderPainted(false);
        btnCheckInGuest.setFocusPainted(false);
        mainPan.add(btnCheckInGuest);

        btnGenerateReceipt = new JButton("RECEIPT");
        btnGenerateReceipt.setBounds(500, 260, 180, 40);
        btnGenerateReceipt.setBackground(Color.decode("#222222"));
        btnGenerateReceipt.setForeground(Color.WHITE);
        btnGenerateReceipt.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnGenerateReceipt.setBorderPainted(false);
        btnGenerateReceipt.setFocusPainted(false);
        mainPan.add(btnGenerateReceipt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnHomePage){
            dispose();
            new HomePage().setVisible(true);
        }else if(e.getSource() == btnSideDash){
            dispose();
            new ReceptionistDashboard().setVisible(true);
        }else if(e.getSource() == btnSideRegister){
            dispose();
            new RegisterGuestPanel().setVisible(true);
        }else if(e.getSource() == btnSideCheckOut){
            dispose();
            new CheckOutPanel().setVisible(true);
        }else if(e.getSource() == btnSidePay){
            dispose();
            new RecordPaymentPanel().setVisible(true);
        }else if(e.getSource() == btnSideReserve){
            dispose();
            new ViewReservationPanel().setVisible(true);
        }
        
    }

}
