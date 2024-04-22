package com.example.ainline_system_team5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class BookingTest {

    private Airport from;
    private Airport to;
    private Booking booking;

    @BeforeEach
    public void setUp() {
        from = new Airport("EIA", "Egypt International Airport", "Egypt");
        to = new Airport("LHR", "Heathrow Airport", "UK");
        Flight flight=new Flight(1,from,to);
        LocalDateTime datetime = LocalDateTime.of(2024, 4, 13, 12, 0);
        booking = new Booking("ABC123", from, to,flight , "Economy");
    }

    @Test
    public void testGetFromAirport() {
        assertEquals(from, booking.getFrom());
    }

    @Test
    public void testGetToAirport() {
        assertEquals(to, booking.getTo());
    }
    
    @Test
    public void testGetDatetime() {
        LocalDateTime expectedDatetime = LocalDateTime.of(2024,4,25,12,0);
        assertEquals(expectedDatetime, booking.getDatetime());
    }

    @Test
    public void testGetSeatClass() {
        assertEquals("Economy", booking.getSeatClass());
    }
    
    @Test
    public void testSetSeatClass() {
        booking.setSeatClass("Business");
        assertEquals("Business", booking.getSeatClass());
    }

//    @Test
//    public void testSetDatetime() {
//        LocalDateTime newDatetime = LocalDateTime.of(2024, 5, 13, 12, 0);
//        booking.setDatetime(newDatetime);
//        assertEquals(newDatetime, booking.getDatetime());
//    }

    @Test
    public void testGetBookingID() {
        assertTrue(booking.getBookingID().startsWith("ABC123")); // Booking ID should start with "ABC123"
    }

    @Test
    public void testSetFromAirport() {
        Airport newFrom = new Airport("JFK", "John F. Kennedy International Airport", "USA");
        booking.setFrom(newFrom);
        assertEquals(newFrom, booking.getFrom());
    }

    @Test
    public void testSetToAirport() {
        Airport newTo = new Airport("DXB", "Dubai International Airport", "UAE");
        booking.setTo(newTo);
        assertEquals(newTo, booking.getTo());
    }

    @Test
    public void testGetPaymentMethod() {
        PaymentMethod paymentMethod = new PaymentMethod("Credit Card", "1234567890123456", "12/23", "123");
        booking.EditBooking("Business", paymentMethod);
        assertEquals(paymentMethod, booking.getPaymentMethod());
    }

    @Test
    public void testEditBooking() {
        PaymentMethod paymentMethod = new PaymentMethod("Debit Card", "9876543210987654", "12/25", "789");
        booking.EditBooking("Business", paymentMethod);
        assertEquals("Business", booking.getSeatClass());
        assertEquals(paymentMethod, booking.getPaymentMethod());
    }

    @Test
    public void testGetBookingDetails() {
        String details = booking.GetBookingDetails();
        assertTrue(details.contains("Booking ID"));
        assertTrue(details.contains("From: " + booking.getFrom().getName())); 
        assertTrue(details.contains("To: " + booking.getTo().getName())); 
        assertTrue(details.contains("Seat Class: " + booking.getSeatClass())); 
        assertTrue(details.contains("Date and Time"));
    }
}
