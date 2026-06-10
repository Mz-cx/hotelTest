package com.mycompany.HotelReservationApp.mainsystem.guest.ui;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchRoomsPanel extends JPanel {
    private JLabel lblTitle;
    private JTextField txtDate;
    private JComboBox cbType;
    private JTextField txtPax;
    private JButton btnSearch;
    private JTable roomTable;
    private JScrollPane scrollPane;

    public SearchRoomsPanel() {
        setLayout(null);
        setSize(1116, 688);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        lblTitle = new JLabel("SEARCH ROOMS");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(30, 20, 200, 30);
        add(lblTitle);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(30, 60, 100, 25);
        add(lblDate);

        txtDate = new JTextField();
        txtDate.setBounds(30, 85, 150, 30);
        txtDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(txtDate);

        JLabel lblType = new JLabel("Room Type:");
        lblType.setBounds(200, 60, 100, 25);
        add(lblType);

         
        String[] types = {"- Select -", "Single", "Double", "Suite"};
        cbType = new JComboBox(types);
        cbType.setBounds(200, 85, 150, 30);
        add(cbType);

        JLabel lblPax = new JLabel("Pax/Guests:");
        lblPax.setBounds(370, 60, 100, 25);
        add(lblPax);

        txtPax = new JTextField();
        txtPax.setBounds(370, 85, 100, 30);
        txtPax.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(txtPax);

        btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(500, 85, 120, 30);
        btnSearch.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(btnSearch);

        String[] columns = {"Room ID", "Floor", "Type", "Beds", "Max Pax", "Price"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        roomTable = new JTable(model);
        scrollPane = new JScrollPane(roomTable);
        scrollPane.setBounds(30, 140, 1050, 480);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(scrollPane);

        
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                 
                if (txtDate.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Please enter a search date.");
                    return; 
                }

                 
                if (cbType.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Error: Please select a room type.");
                    return;
                }

                 
                if (txtPax.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Please specify the number of guests.");
                    return;
                }

                 
                try {
                    int guests = Integer.parseInt(txtPax.getText().trim());
                    if (guests <= 0) {
                        JOptionPane.showMessageDialog(null, "Error: Number of guests must be at least 1.");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please enter a valid number for Pax/Guests.");
                    return;
                }

                 
                System.out.println("All fields valid. Proceeding with RoomDAO search...");
                 
            }
        });
    }
}