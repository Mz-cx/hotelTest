package com.mycompany.HotelReservationApp.mainsystem.guest.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuestDashboard extends JFrame {
    
    private JLabel lblWelcome;
    private JPanel sidebar, header, contentArea;
    private JButton btnRooms, btnMake, btnView, btnCancel, btnGProfile, btnLogout;

    public GuestDashboard() {
        setTitle("Hotel Guest System");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        sidebar = new JPanel();
        sidebar.setBounds(0, 0, 250, 768);
        sidebar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sidebar.setLayout(null);

        btnRooms = new JButton("SEARCH ROOMS");
        btnRooms.setBounds(25, 150, 200, 50);
        btnRooms.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        btnMake = new JButton("MAKE RESERVATION");
        btnMake.setBounds(25, 230, 200, 50);
        btnMake.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        btnView = new JButton("VIEW RESERVATION");
        btnView.setBounds(25, 310, 200, 50);
        btnView.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        btnCancel = new JButton("CANCEL RESERVATION");
        btnCancel.setBounds(25, 390, 200, 50);
        btnCancel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        btnGProfile = new JButton("GUEST PROFILE");
        btnGProfile.setBounds(25, 470, 200, 50);
        btnGProfile.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        btnLogout = new JButton("LOGOUT");
        btnLogout.setBounds(25, 650, 200, 50);
        btnLogout.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        sidebar.add(btnRooms);
        sidebar.add(btnMake);
        sidebar.add(btnView);
        sidebar.add(btnCancel);
        sidebar.add(btnGProfile);
        sidebar.add(btnLogout);

        header = new JPanel();
        header.setBounds(250, 0, 1116, 80);
        header.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        header.setLayout(null);
        
        lblWelcome = new JLabel("GUEST DASHBOARD");
        lblWelcome.setBounds(30, 25, 400, 30);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 32));
        header.add(lblWelcome);

        contentArea = new JPanel();
        contentArea.setBounds(250, 80, 1116, 688);
        contentArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentArea.setLayout(new BorderLayout());

        btnRooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(new SearchRoomsPanel());
            }
        });

        btnMake.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(new MakeReservationPanel());
            }
        });
        
        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(new ViewReservationsPanel());
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(new CancelReservationPanel());
            }
        });
        
        btnGProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(new GuestProfilePanel());
            }
        });

        add(sidebar);
        add(header);
        add(contentArea);
    }

    public void switchPanel(JPanel panel) {
        contentArea.removeAll();
        contentArea.add(panel);
        contentArea.revalidate();
        contentArea.repaint();
    }
}