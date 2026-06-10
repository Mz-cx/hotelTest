package com.mycompany.HotelReservationApp.mainsystem;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.session.SessionManager;
import com.mycompany.HotelReservationApp.mainsystem.login.LoginFrame;
public class MainSystem {
    
    public static void main(String[] args) {
        
        SessionManager.init();
        new LoginFrame().setVisible(true);
    }
}
