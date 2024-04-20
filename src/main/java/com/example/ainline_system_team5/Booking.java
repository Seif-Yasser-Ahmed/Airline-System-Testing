package com.example.ainline_system_team5;
import java.time.LocalDateTime;

public class Booking extends Flight{
    LocalDateTime datetime; // in format yyyy-MM-dd-HH-mm-ss-ns

    String bookingID;
    String seat_class;
    Airport from;
    Airport to;
    private PaymentMethod paymentMethod;

    public Booking(String FlightID, Airport from, Airport to, LocalDateTime datetime, String seatClass) {
        this.bookingID = FlightID+ "-"+LocalDateTime.now();
        this.from = from;
        this.to = to;
        this.datetime = datetime;
        this.seat_class = seatClass;
    }
    
    // Getters and setters
    public String getBookingID() {
        return bookingID;
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getTo() {
        return to;
    }

    public void setTo(Airport to) {
        this.to = to;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getSeatClass() {
        return seat_class;
    }

    public void setSeatClass(String seatClass) {
        this.seat_class = seatClass;
    }
    
    public void EditBooking(String seatClass, PaymentMethod paymentMethod) {
        this.seat_class = seatClass;
        this.paymentMethod = paymentMethod;
    }
    
    public void CancelBooking() {
    	 Airport airport = from;
         airport.removeBooking(this);
    
    }
    
    public String GetBookingDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Booking ID: ").append(bookingID).append("\n");
        details.append("From: ").append(from).append("\n");
        details.append("To: ").append(to).append("\n");
        details.append("Date and Time: ").append(datetime).append("\n");
        details.append("Seat Class: ").append(seat_class).append("\n");
      
        return details.toString();
    }
}
