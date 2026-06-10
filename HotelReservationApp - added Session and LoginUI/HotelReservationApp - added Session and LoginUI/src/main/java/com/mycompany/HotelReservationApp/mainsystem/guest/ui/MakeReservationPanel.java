/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.HotelReservationApp.mainsystem.guest.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MakeReservationPanel extends JPanel {

    
    private JLabel lblHeader, lblType, lblPax, lblDates, lblTotalDisplay;
    private JComboBox cbRoomType;
    private JTextField txtPax;
    private JTextField txtIn, txtOut;
    private JButton btnCalculate;

    
    private JLabel lblPayMethod, lblAccount;
    private JComboBox cbPayment;
    private JTextField txtAccountNo;
    private JButton btnBook;

    
    private JPanel receiptOverlay;
    private JTextArea txtReceipt;
    private JButton btnCloseReceipt;

    private double selectedRate = 0.0;
    private int maxPax = 0;

    public MakeReservationPanel() {
        setLayout(null);
        setSize(1116, 688);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        lblHeader = new JLabel("MAKE A RESERVATION");
        lblHeader.setBounds(30, 20, 400, 30);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblHeader);

       
        lblType = new JLabel("Select Room Type:");
        lblType.setBounds(30, 70, 200, 25);
        add(lblType);

        String[] roomTypes = {"- Select -", "Single ($100) - 1 Pax", "Double ($200) - 2 Pax", "Suite ($450) - 4 Pax"};
        cbRoomType = new JComboBox(roomTypes);
        cbRoomType.setBounds(30, 95, 290, 35);
        add(cbRoomType);

        
        lblPax = new JLabel("Number of Guests:");
        lblPax.setBounds(340, 70, 150, 25);
        add(lblPax);

        txtPax = new JTextField();
        txtPax.setBounds(340, 95, 100, 35);
        txtPax.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(txtPax);

        
        lblDates = new JLabel("Check-in / Check-out (YYYY-MM-DD):");
        lblDates.setBounds(30, 145, 300, 20);
        add(lblDates);

        txtIn = new JTextField();
        txtIn.setBounds(30, 170, 140, 35);
        txtIn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(txtIn);

        txtOut = new JTextField();
        txtOut.setBounds(180, 170, 140, 35);
        txtOut.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(txtOut);

        btnCalculate = new JButton("Calculate Price");
        btnCalculate.setBounds(30, 220, 150, 30);
        btnCalculate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(btnCalculate);

        lblTotalDisplay = new JLabel("Total Price: $0.00");
        lblTotalDisplay.setBounds(200, 220, 300, 30);
        add(lblTotalDisplay);

        
        lblPayMethod = new JLabel("Payment Method:");
        lblPayMethod.setBounds(30, 280, 200, 20);
        add(lblPayMethod);

        String[] payments = {"- Select -", "Credit Card", "E-Wallet", "Cash"};
        cbPayment = new JComboBox(payments);
        cbPayment.setBounds(30, 305, 290, 35);
        add(cbPayment);

        lblAccount = new JLabel("Account/Card Number:");
        lblAccount.setBounds(30, 355, 200, 20);
        add(lblAccount);

        txtAccountNo = new JTextField();
        txtAccountNo.setBounds(30, 380, 290, 35);
        txtAccountNo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(txtAccountNo);

        btnBook = new JButton("CONFIRM & PAY");
        btnBook.setBounds(30, 440, 290, 50);
        btnBook.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(btnBook);

        
        receiptOverlay = new JPanel();
        receiptOverlay.setLayout(null);
        receiptOverlay.setBounds(450, 70, 450, 500);
        receiptOverlay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        receiptOverlay.setVisible(false);

        txtReceipt = new JTextArea();
        txtReceipt.setBounds(20, 20, 410, 400);
        txtReceipt.setEditable(false);
        receiptOverlay.add(txtReceipt);

        btnCloseReceipt = new JButton("CLOSE");
        btnCloseReceipt.setBounds(175, 440, 100, 30);
        receiptOverlay.add(btnCloseReceipt);

        add(receiptOverlay);

        

        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                int selection = cbRoomType.getSelectedIndex();
                if (selection == 0) {
                    JOptionPane.showMessageDialog(null, "Error: Please select a room type.");
                    return;
                }

                
                if (selection == 1) { selectedRate = 100; maxPax = 1; }
                else if (selection == 2) { selectedRate = 200; maxPax = 2; }
                else if (selection == 3) { selectedRate = 450; maxPax = 4; }

                
                if (txtPax.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Please enter number of guests.");
                    return;
                }

                try {
                    int inputPax = Integer.parseInt(txtPax.getText().trim());
                    if (inputPax <= 0) {
                        JOptionPane.showMessageDialog(null, "Error: Guests must be at least 1.");
                        return;
                    }
                    if (inputPax > maxPax) {
                        JOptionPane.showMessageDialog(null, "Error: This room only allows " + maxPax + " guests.");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please enter a valid number for guests.");
                    return;
                }

                
                lblTotalDisplay.setText("Total Price: $" + selectedRate);
            }
        });

        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if (cbRoomType.getSelectedIndex() == 0 || 
                    txtPax.getText().trim().isEmpty() || 
                    txtIn.getText().trim().isEmpty() || 
                    txtOut.getText().trim().isEmpty() || 
                    cbPayment.getSelectedIndex() == 0) {
                    
                    JOptionPane.showMessageDialog(null, "Error: All fields must be filled out before booking.");
                    return;
                }

                
                String payMethod = cbPayment.getSelectedItem().toString();
                if (!payMethod.equals("Cash") && txtAccountNo.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Account/Card number is required for " + payMethod + ".");
                    return;
                }

                
                if (selectedRate == 0) {
                    JOptionPane.showMessageDialog(null, "Error: Please calculate price first.");
                    return;
                }

                
                receiptOverlay.setVisible(true);
                String receiptText = "--- HOTEL RESERVATION RECEIPT ---\n\n" +
                                     "Room:    " + cbRoomType.getSelectedItem() + "\n" +
                                     "Guests:  " + txtPax.getText() + "\n" +
                                     "Dates:   " + txtIn.getText() + " to " + txtOut.getText() + "\n" +
                                     "---------------------------------\n" +
                                     lblTotalDisplay.getText() + "\n" +
                                     "Method:  " + payMethod + "\n" +
                                     "Account: " + (txtAccountNo.getText().isEmpty() ? "CASH PAYMENT" : txtAccountNo.getText()) + "\n" +
                                     "---------------------------------\n" +
                                     "STATUS: SUCCESSFUL";
                
                txtReceipt.setText(receiptText);
               
            }
        });

        btnCloseReceipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                receiptOverlay.setVisible(false);
            }
        });
    }
}