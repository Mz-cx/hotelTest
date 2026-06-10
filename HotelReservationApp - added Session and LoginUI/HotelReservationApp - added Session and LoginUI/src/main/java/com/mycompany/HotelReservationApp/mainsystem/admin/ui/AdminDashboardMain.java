package com.mycompany.HotelReservationApp.mainsystem.admin.ui;

import com.mycompany.HotelReservationApp.mainsystem.guest.manager.GuestManager;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.room.manager.RoomManager;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.reservation.manager.ReservationManager;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.payment.manager.PaymentManager;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.ui.StyledButton;
import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboardMain extends JFrame implements ActionListener {
    
    private JTabbedPane tabbedPane;
    private GuestManager guestManager;
    private RoomManager roomManager;
    private ReservationManager reservationManager;
    private PaymentManager paymentManager;
    
    public AdminDashboardMain() {
        this.guestManager = GuestManager.getInstance();
        this.roomManager = RoomManager.getInstance();
        this.reservationManager = ReservationManager.getInstance();
        this.paymentManager = PaymentManager.getInstance();
        
        initWindow();
        createComponents();
        Logger.getInstance().info("AdminDashboardMain opened");
    }
    
    private void initWindow() {
        setTitle("Admin Dashboard");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }
    
    private void createComponents() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(45, 85, 130));
        
        JLabel lblTitle = new JLabel("ADMIN DASHBOARD");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        topPanel.add(lblTitle, BorderLayout.WEST);
        
        add(topPanel, BorderLayout.NORTH);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Dashboard", createDashboardPanel());
        tabbedPane.addTab("System Statistics", createStatisticsPanel());
        tabbedPane.addTab("Financial Reports", createFinancialPanel());
        tabbedPane.addTab("System Settings", createSettingsPanel());
        
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panel.add(createStatCard("Total Guests", String.valueOf(guestManager.getTotalGuestCount())));
        panel.add(createStatCard("Total Rooms", String.valueOf(roomManager.getTotalRoomCount())));
        panel.add(createStatCard("Active Reservations", String.valueOf(reservationManager.getConfirmedReservationCount())));
        panel.add(createStatCard("Total Revenue", "$" + String.format("%.2f", paymentManager.getTotalRevenue())));
        
        return panel;
    }
    
    private JPanel createStatCard(String title, String value) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(new Color(240, 240, 240));
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        
        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        
        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Arial", Font.BOLD, 24));
        lblValue.setForeground(new Color(70, 130, 180));
        lblValue.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        lblValue.setHorizontalAlignment(SwingConstants.CENTER);
        
        card.add(lblTitle, BorderLayout.NORTH);
        card.add(lblValue, BorderLayout.CENTER);
        
        return card;
    }
    
    private JPanel createStatisticsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Courier", Font.PLAIN, 12));
        
        JButton btnRefresh = new StyledButton("Refresh Stats", "info");
        btnRefresh.addActionListener(e -> {
            StringBuilder stats = new StringBuilder();
            stats.append("===== SYSTEM STATISTICS =====\n\n");
            stats.append("GUESTS:\n");
            stats.append("  Total Guests: ").append(guestManager.getTotalGuestCount()).append("\n");
            stats.append("  VIP Guests: ").append(guestManager.getVIPCount()).append("\n\n");
            
            stats.append("ROOMS:\n");
            stats.append("  Total Rooms: ").append(roomManager.getTotalRoomCount()).append("\n");
            stats.append("  Available: ").append(roomManager.getAvailableRoomCount()).append("\n");
            stats.append("  Occupied: ").append(roomManager.getOccupiedRoomCount()).append("\n");
            stats.append("  Occupancy Rate: ").append(String.format("%.2f", roomManager.calculateOccupancyRate())).append("%\n\n");
            
            stats.append("RESERVATIONS:\n");
            stats.append("  Total Reservations: ").append(reservationManager.getTotalReservationCount()).append("\n");
            stats.append("  Confirmed: ").append(reservationManager.getConfirmedReservationCount()).append("\n\n");
            
            stats.append("PAYMENTS:\n");
            stats.append("  Total Payments: ").append(paymentManager.getTotalPaymentCount()).append("\n");
            stats.append("  Total Revenue: $").append(String.format("%.2f", paymentManager.getTotalRevenue())).append("\n");
            stats.append("  Pending Amount: $").append(String.format("%.2f", paymentManager.getPendingAmount())).append("\n");
            
            textArea.setText(stats.toString());
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnRefresh);
        
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createFinancialPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Courier", Font.PLAIN, 12));
        
        JButton btnRefresh = new StyledButton("Generate Report", "success");
        btnRefresh.addActionListener(e -> {
            StringBuilder report = new StringBuilder();
            report.append("===== FINANCIAL REPORT =====\n\n");
            report.append("Total Revenue (Completed): $").append(String.format("%.2f", paymentManager.getTotalRevenue())).append("\n");
            report.append("Pending Payments: $").append(String.format("%.2f", paymentManager.getPendingAmount())).append("\n");
            report.append("Total Transactions: ").append(paymentManager.getTotalPaymentCount()).append("\n\n");
            report.append("Payment Methods:\n");
            report.append("  Completed: ").append(paymentManager.getCompletedPayments().size()).append("\n");
            report.append("  Pending: ").append(paymentManager.getPendingPayments().size()).append("\n");
            report.append("  Failed: ").append(paymentManager.getFailedPayments().size()).append("\n");
            
            textArea.setText(report.toString());
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnRefresh);
        
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createSettingsPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        
        JLabel lblSettings = new JLabel("System Settings & Configuration");
        lblSettings.setFont(new Font("Arial", Font.BOLD, 14));
        lblSettings.setBounds(30, 30, 300, 25);
        panel.add(lblSettings);
        
        JLabel lblBackup = new JLabel("Database Backup:");
        lblBackup.setBounds(30, 80, 120, 25);
        JButton btnBackup = new StyledButton("Backup Now", "info");
        btnBackup.setBounds(160, 80, 150, 30);
        btnBackup.addActionListener(e -> Logger.getInstance().info("Database backup initiated"));
        panel.add(lblBackup);
        panel.add(btnBackup);
        
        JLabel lblLogs = new JLabel("View System Logs:");
        lblLogs.setBounds(30, 130, 120, 25);
        JButton btnLogs = new StyledButton("View Logs", "info");
        btnLogs.setBounds(160, 130, 150, 30);
        btnLogs.addActionListener(e -> Logger.getInstance().info("System logs requested"));
        panel.add(lblLogs);
        panel.add(btnLogs);
        
        return panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Action handlers
    }
}