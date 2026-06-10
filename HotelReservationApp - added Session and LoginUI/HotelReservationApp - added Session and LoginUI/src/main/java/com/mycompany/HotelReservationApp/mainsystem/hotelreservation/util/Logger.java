package com.mycompany.HotelReservationApp.mainsystem.hotelreservation.util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
    private FileWriter fileWriter;
    private DateTimeFormatter formatter;
    
    private Logger() {
        try {
            new File("logs").mkdirs();
            this.fileWriter = new FileWriter("logs/hotel_system.log", true);
            this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void info(String message) {
        log("INFO", message);
    }
    
    public void warn(String message) {
        log("WARN", message);
    }
    
    public void error(String message, Exception e) {
        log("ERROR", message + " - " + e.getMessage());
    }
    
    public void debug(String message) {
        log("DEBUG", message);
    }
    
    private void log(String level, String message) {
        try {
            String timestamp = LocalDateTime.now().format(formatter);
            String logMessage = "[" + timestamp + "] " + level + ": " + message + "\n";
            fileWriter.write(logMessage);
            fileWriter.flush();
            System.out.println(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void close() {
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}