package com.example.ainline_system_team5;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Stack;

public class Customer extends Person{
    List<Booking> BookingHistory=new Stack<Booking>();

    public void BookFlight(String bookingID, Airport from, Airport to, LocalDateTime datetime, String seat_class){
        Booking booking=new Booking(bookingID,from,to,datetime,seat_class);
        BookingHistory.add(booking);
    }
    public void searchflights(){
        return;
    }
}
