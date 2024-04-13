package com.example.ainline_system_team5;

import java.util.List;
import java.util.Stack;

public class Airport {
    public static List<Flight> flights=new Stack<Flight>();
    private List<Booking> bookings;
    
    private String code;
    private String name;
    private String country;
   

    public Airport(String code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }
    
    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }
    
    public void removeBooking(Booking booking) {
        this.bookings.remove(booking);
    }
    
    public String getAirportInfo() {
        return "Airport Code: " + code + ", Name: " + name + ", Country: " + country;
    }

}
