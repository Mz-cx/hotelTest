package com.mycompany.HotelReservationApp.mainsystem.admin.ui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame {

    private JPanel sidebar;
    private JPanel header;
    private JPanel contentPanel;

    private JButton btnUserManagement;
    private JButton btnRoomManagement;
    private JButton btnReports;
    private JButton btnReservations;
    private JButton btnLogout;

    public AdminDashboard() {
        setTitle("Hotel Reservation System");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);


        sidebar = new JPanel();
        sidebar.setBounds(0, 0, 250, 768);
        sidebar.setLayout(null);
        sidebar.setBackground(Color.DARK_GRAY);

        JLabel sidebarTitle = new JLabel("ADMIN PANEL");
        sidebarTitle.setFont(new Font("Arial", Font.BOLD, 16));
        sidebarTitle.setForeground(Color.WHITE);
        sidebarTitle.setBounds(25, 60, 200, 30);
        sidebar.add(sidebarTitle);

        btnUserManagement = createSidebarButton("USER MANAGEMENT");
        btnUserManagement.setBounds(25, 150, 200, 50);
        sidebar.add(btnUserManagement);

        btnRoomManagement = createSidebarButton("ROOM MANAGEMENT");
        btnRoomManagement.setBounds(25, 220, 200, 50);
        sidebar.add(btnRoomManagement);

        btnReports = createSidebarButton("REPORTS");
        btnReports.setBounds(25, 290, 200, 50);
        sidebar.add(btnReports);

        btnReservations = createSidebarButton("RESERVATIONS");
        btnReservations.setBounds(25, 360, 200, 50);
        sidebar.add(btnReservations);

        btnLogout = createSidebarButton("LOGOUT");
        btnLogout.setBounds(25, 650, 200, 50);
        sidebar.add(btnLogout);


        header = new JPanel();
        header.setBounds(250, 0, 1116, 100);
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel lblTitle = new JLabel("ADMIN DASHBOARD");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 28));
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setBounds(30, 15, 500, 38);
        header.add(lblTitle);

        JLabel lblWelcome = new JLabel("Welcome, ADMIN");
        lblWelcome.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblWelcome.setForeground(Color.DARK_GRAY);
        lblWelcome.setBounds(30, 55, 500, 20);
        header.add(lblWelcome);

       
        contentPanel = new JPanel();
        contentPanel.setBounds(250, 100, 1116, 668);
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));


        btnUserManagement.addActionListener(e -> switchTo("USER MANAGEMENT", new UserManagementPanel()));
        btnRoomManagement.addActionListener(e -> switchTo("ROOM MANAGEMENT", new RoomManagementPanel()));
        btnReports.addActionListener(e -> switchTo("REPORTS", new ReportsPanel()));
        btnReservations.addActionListener(e -> switchTo("RESERVATIONS", new ReservationsPanel()));
        btnLogout.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,"Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) System.exit(0);
        });

        add(sidebar);
        add(header);
        add(contentPanel);


        switchTo("REPORTS", new ReportsPanel());
    }

    void switchTo(String sectionName, JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    JButton createSidebarButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setBackground(new Color(70, 70, 70));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminDashboard dashboard = new AdminDashboard();
            dashboard.setVisible(true);
        });
    }
}
