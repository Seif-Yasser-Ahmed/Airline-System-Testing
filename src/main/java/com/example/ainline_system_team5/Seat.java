package com.example.ainline_system_team5;

public class Seat {
    private String seatNumber;
    private boolean isOccupied;
    
    
    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isOccupied = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        this.isOccupied = true;
    }

    public void vacate() {
        this.isOccupied = false;
    }
}
