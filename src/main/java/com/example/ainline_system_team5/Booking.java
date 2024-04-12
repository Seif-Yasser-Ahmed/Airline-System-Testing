package com.example.ainline_system_team5;
import java.time.LocalDateTime;

public class Booking extends Flight{
    LocalDateTime datetime; // in format yyyy-MM-dd-HH-mm-ss-ns

    String bookingID;
    String seat_class;
    Airport from;
    Airport to;

    public Booking(String FlightID, Airport from, Airport to, LocalDateTime datetime, String seat_class) {
        this.bookingID = FlightID+LocalDateTime.now();
        this.from = from;
        this.to = to;
        this.datetime = datetime;
        this.seat_class = seat_class;
    }
}
