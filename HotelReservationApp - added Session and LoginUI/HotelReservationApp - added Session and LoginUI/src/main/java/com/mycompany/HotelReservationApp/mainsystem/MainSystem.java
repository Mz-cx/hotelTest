package com.mycompany.HotelReservationApp.mainsystem;

import com.mycompany.HotelReservationApp.mainsystem.hotelreservation.session.SessionManager;
import com.mycompany.HotelReservationApp.mainsystem.login.UpdatedLoginFrame;

public class MainSystem {
    
    public static void main(String[] args) {
        
        SessionManager.init();
        new UpdatedLoginFrame().setVisible(true);
    }
}
