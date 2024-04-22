package com.example.ainline_system_team5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Airport {
    public static ArrayList<Flight> flights=new ArrayList<Flight>();
    private List<Booking> bookings;
    
    private String code;
    private String name;
    private String country;
    public Airport() {
    	
    }
    public Airport(String code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }
    
    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
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
    public List<Flight> searchFlights(Airport from ,Airport to) {
    	ArrayList<Flight>Found=new ArrayList<Flight>();
    	for(int i=0;i<flights.size();i++) {
    		if(flights.get(i).getFrom()==from&&flights.get(i).getTo()==to) {
    			Found.add(flights.get(i));
    		}
    	}
    	return Found;
    }

}
