package com.mycompany.HotelReservationApp.mainsystem.receptionist;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.ui.StyledButton;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.session.SessionManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionMainWindow extends JFrame implements ActionListener {
    private JTabbedPane tabbedPane;
    private JLabel lblWelcome;
    
    public ReceptionMainWindow() {
    if (!SessionManager.canAccessReception()) {
        JOptionPane.showMessageDialog(this, "Access Denied");
        dispose();
        return;
    }

    initWindow();
    createComponents();
    Logger.getInstance().info("ReceptionMainWindow opened");
}
    
    private void initWindow() {
        setTitle("Reception Management");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }
    
    private void createComponents() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(70, 130, 180));
        
        lblWelcome = new JLabel("Welcome to Reception Management");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 16));
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.add(lblWelcome, BorderLayout.WEST);
        
        add(topPanel, BorderLayout.NORTH);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Dashboard", createDashboardPanel());
        tabbedPane.addTab("Check-in", createCheckInPanel());
        tabbedPane.addTab("Check-out", createCheckOutPanel());
        tabbedPane.addTab("Reservations", createReservationsPanel());
        
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));
        textArea.setText("Reception Dashboard\n" +
                        "- View current hotel status\n" +
                        "- Monitor room availability\n" +
                        "- Track check-ins and check-outs");
        
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createCheckInPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        
        JLabel lblReservationID = new JLabel("Reservation ID:");
        lblReservationID.setBounds(30, 30, 120, 25);
        JTextField txtReservationID = new JTextField();
        txtReservationID.setBounds(160, 30, 250, 25);
        
        JButton btnCheckIn = new StyledButton("Check In", "success");
        btnCheckIn.setBounds(160, 80, 120, 35);
        btnCheckIn.addActionListener(e -> {
            Logger.getInstance().info("Check-in processed for reservation: " + txtReservationID.getText());
        });
        
        panel.add(lblReservationID);
        panel.add(txtReservationID);
        panel.add(btnCheckIn);
        
        return panel;
    }
    
    private JPanel createCheckOutPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        
        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setBounds(30, 30, 120, 25);
        JTextField txtRoomNumber = new JTextField();
        txtRoomNumber.setBounds(160, 30, 250, 25);
        
        JButton btnCheckOut = new StyledButton("Check Out", "danger");
        btnCheckOut.setBounds(160, 80, 120, 35);
        btnCheckOut.addActionListener(e -> {
            Logger.getInstance().info("Check-out processed for room: " + txtRoomNumber.getText());
        });
        
        panel.add(lblRoomNumber);
        panel.add(txtRoomNumber);
        panel.add(btnCheckOut);
        
        return panel;
    }
    
    private JPanel createReservationsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        String[] columns = {"Reservation ID", "Guest", "Room", "Check-In", "Check-Out", "Status"};
        JTable table = new JTable(new String[0][0], columns);
        
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        
        return panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Action handlers
    }
}