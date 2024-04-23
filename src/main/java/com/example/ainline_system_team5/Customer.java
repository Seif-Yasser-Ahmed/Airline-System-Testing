package com.example.ainline_system_team5;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Stack;

public class Customer extends Person{
    List<Booking> BookingHistory=new Stack<Booking>();

    public Customer(String fname, String lname) {
        super(fname, lname);
    }
    public Customer(String fname,int Age) {
    	this.Age=Age;
    	this.firstname=fname;
    }

    public Customer(String fname, String lname, int id, String pass, String mail, int phone, String add) {
        super(fname, lname,pass, mail, phone, add);
    }

    public void BookFlight(String bookingID, Airport from, Airport to, String seat_class){
        Booking booking=new Booking(bookingID,from,to,seat_class);
        BookingHistory.add(booking);
    }
    public void searchflights(){
        return;
    }
}
