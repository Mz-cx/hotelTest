package com.mycompany.HotelReservationApp.mainsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterGuestPanel extends JFrame implements ActionListener{

    private JButton btnCheckIn, btnCheckOut, btnRegistration, btnDashBoard, btnPayment, btnReservation,
            btnSideDash, btnSideRegister, btnSideCheckIn, btnSideCheckOut, btnSidePay, btnSideReserve, btnHomePage, btnSubmit;
    private JLabel lblReception, lblHotel, lblManagement;
    private JPanel sidePan, topPan, formPanel;
    private JTextField txtFirstName, txtLastName, txtEmail, txtPhone, txtAddress, txtIDNumber;
    private JPasswordField txtPassword;
    private JComboBox<String> cmbIDType;
    
    
    RegisterGuestPanel(){
        sidePanel();
        functionMenu();
        topPanel();
        formPanel();
        
        setSize(1200,700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    private void functionMenu(){
        
        lblReception = new JLabel ("GUEST REGISTRATION");
        lblReception.setBounds(350, 60, 800, 60);
        lblReception.setFont(new Font ("Arial Black", Font.BOLD, 40));
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
        btnSideRegister.setBackground(Color.decode("#FFFFFF"));
        btnSideRegister.setForeground(Color.BLACK);
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
    private void formPanel() {

        formPanel = new JPanel();
        formPanel.setBounds(320, 170, 850, 520);
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        add(formPanel);


        JLabel lbl1 = new JLabel("First Name:");
        lbl1.setBounds(180, 25, 150, 25);
        lbl1.setFont(new Font("Arial Black", Font.BOLD, 18));
        formPanel.add(lbl1);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(350, 20, 300, 40);
        txtFirstName.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(txtFirstName);


        JLabel lbl2 = new JLabel("Last Name:");
        lbl2.setBounds(180, 70, 150, 25);
        lbl2.setFont(new Font("Arial Black", Font.BOLD, 18));
        formPanel.add(lbl2);

        txtLastName = new JTextField();
        txtLastName.setBounds(350, 65, 300, 40);
        txtLastName.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(txtLastName);


        JLabel lbl3 = new JLabel("Email:");
        lbl3.setBounds(180, 115, 150, 25);
        lbl3.setFont(new Font("Arial Black", Font.BOLD, 18));
        formPanel.add(lbl3);

        txtEmail = new JTextField();
        txtEmail.setBounds(350, 110, 300, 40);
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(txtEmail);


        JLabel lbl4 = new JLabel("Phone:");
        lbl4.setBounds(180, 160, 150, 25);
        lbl4.setFont(new Font("Arial Black", Font.BOLD, 18));
        formPanel.add(lbl4);

        txtPhone = new JTextField();
        txtPhone.setBounds(350, 155, 300, 40);
        txtPhone.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(txtPhone);


        JLabel lbl5 = new JLabel("Password:");
        lbl5.setBounds(180, 205, 150, 25);
        lbl5.setFont(new Font("Arial Black", Font.BOLD, 18));
        formPanel.add(lbl5);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(350, 200, 300, 40);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(txtPassword);


        JLabel lbl6 = new JLabel("Address:");
        lbl6.setBounds(180, 250, 150, 25);
        lbl6.setFont(new Font("Arial Black", Font.BOLD, 18));
        formPanel.add(lbl6);

        txtAddress = new JTextField();
        txtAddress.setBounds(350, 245, 300, 40);
        txtAddress.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(txtAddress);


        JLabel lbl7 = new JLabel("ID Type:");
        lbl7.setBounds(180, 295, 150, 25);
        lbl7.setFont(new Font("Arial Black", Font.BOLD, 18));
        formPanel.add(lbl7);

        cmbIDType = new JComboBox<>(new String[]{
                "Select ID", "Passport", "Driver's License", "National ID", "Postal ID"
        });
        cmbIDType.setBounds(350, 290, 300, 40);
        cmbIDType.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(cmbIDType);


        JLabel lbl8 = new JLabel("ID Number:");
        lbl8.setBounds(180, 340, 150, 25);
        lbl8.setFont(new Font("Arial Black", Font.BOLD, 18));
        formPanel.add(lbl8);

        txtIDNumber = new JTextField();
        txtIDNumber.setBounds(350, 335, 300, 40);
        txtIDNumber.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(txtIDNumber);


        btnSubmit = new JButton("Create Guest Account");
        btnSubmit.setBounds(300, 390, 250, 40);
        btnSubmit.setBackground(Color.decode("#222222"));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFont(new Font("Arial Black", Font.BOLD, 13));
        btnSubmit.setBorderPainted(false);
        btnSubmit.setFocusPainted(false);
        btnSubmit.addActionListener(this);
        formPanel.add(btnSubmit);
    }

    private void styleBtn(JButton btn) {
        btn.setBackground(Color.decode("#222222"));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial Black", Font.BOLD, 18));
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSubmit) {

            String first = txtFirstName.getText();
            String last = txtLastName.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();
            String pass = new String(txtPassword.getPassword());
            String address = txtAddress.getText();
            String idType = cmbIDType.getSelectedItem().toString();
            String idNum = txtIDNumber.getText();

            if (first.isEmpty() || last.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter your name.");
                return;
            }

            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(this, "Check your email.");
                return;
            }

            if (!(phone.startsWith("09") || phone.startsWith("+63"))) {
                JOptionPane.showMessageDialog(this, "Phone should start with 09 or +63.");
                return;
            }

            if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter a password.");
                return;
            }

            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter your address.");
                return;
            }

            if (idType.equals("Select ID")) {
                JOptionPane.showMessageDialog(this, "Select an ID type.");
                return;
            }

            if (idNum.length() < 5) {
                JOptionPane.showMessageDialog(this, "Enter a valid ID number.");
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Account created for " + first + " " + last,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        else if (e.getSource() == btnHomePage) {
            dispose();
            new HomePage().setVisible(true);
        } else if (e.getSource() == btnSideDash) {
            dispose();
            new ReceptionistDashboard().setVisible(true);
        } else if (e.getSource() == btnSideCheckIn) {
            dispose();
            new CheckInPanel().setVisible(true);
        } else if (e.getSource() == btnSideCheckOut) {
            dispose();
            new CheckOutPanel().setVisible(true);
        } else if (e.getSource() == btnSidePay) {
            dispose();
            new RecordPaymentPanel().setVisible(true);
        } else if (e.getSource() == btnSideReserve) {
            dispose();
            new ViewReservationPanel().setVisible(true);
        }
    }
}


