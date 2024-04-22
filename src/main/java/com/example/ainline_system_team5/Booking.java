package com.example.ainline_system_team5;
import java.time.LocalDateTime;

public class Booking{
//    LocalDateTime datetime; // in format yyyy-MM-dd-HH-mm-ss-ns

    String bookingID;
    String seat_class;
    Airport from;
    Airport to;
    Flight flight;
    private PaymentMethod paymentMethod;
    public Booking() {
    	this.bookingID="00"+"-"+LocalDateTime.now().getDayOfMonth()+""+LocalDateTime.now().getMonthValue()+""+LocalDateTime.now().getYear();
    }
    public Booking(String FlightID, Airport from, Airport to,Flight flight, String seatClass) {
        this.bookingID = FlightID+ "-"+LocalDateTime.now();
        this.from = from;
        this.to = to;
        this.flight=flight;
//        this.datetime = datetime;
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
        return this.flight.getDepartureTime();
    }

//    public void setDatetime(LocalDateTime datetime) {
//        this.datetime = datetime;
//    }

    public String getSeatClass() {
        return seat_class;
    }

    public void setSeatClass(String seatClass) {
        this.seat_class = seatClass;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
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
        details.append("From: ").append(from.getName()).append("\n"); // Check `getName()`
        details.append("To: ").append(to.getName()).append("\n");
        details.append("Date and Time: ").append(this.flight.getDepartureTime()).append("\n");
        details.append("Seat Class: ").append(seat_class).append("\n");
      
        return details.toString();
    }
}
