package com.example.ainline_system_team5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.List;

@TestMethodOrder(OrderAnnotation.class)
public class AirportTest {

    private static Airport airport;
    private static Airport destinationAirport;
    private Booking booking1;
    private Booking booking2;

    @BeforeAll
    public static void initClass() {
        // Create Airport instances with new airport and destination details
        airport = new Airport("CAI", "Egypt International Airport", "Egypt");
        destinationAirport = new Airport("LHR", "Heathrow Airport", "UK");
    }

    @AfterAll
    public static void cleanupClass() {
        // Clean up any static resources after all tests
        airport = null;
        destinationAirport = null;
    }

    @BeforeEach
    public void setUp() {
        // Create Booking instances before each test with updated airport and destination
        LocalDateTime flightTime = LocalDateTime.now().plusDays(1); // Tomorrow's date for booking
        Flight flight=new Flight();
        booking1 = new Booking("FL001", airport, destinationAirport,flight,"Economy");
        booking2 = new Booking("FL002", airport, destinationAirport,flight,"Business");

        // Initialize the bookings list and add a booking
        airport.setBookings(new ArrayList<>());
        airport.addBooking(booking1);
    }

    @AfterEach
    public void tearDown() {
        // Clean up resources after each test
        airport.getBookings().clear();
    }

    @Test
    @Order(1)
    public void testAirportInitialization() {
        // Test if the airport instance is initialized correctly
        assertEquals("CAI", airport.getCode());
        assertEquals("Egypt International Airport", airport.getName());
        assertEquals("Egypt", airport.getCountry());
    }

    @Test
    @Order(2)
    public void testGettersSetters() {
        // Test getters and setters with updated airport details
        airport.setCode("CAI");
        airport.setName("Egypt International Airport");
        airport.setCountry("Egypt");

        assertEquals("CAI", airport.getCode());
        assertEquals("Egypt International Airport", airport.getName());
        assertEquals("Egypt", airport.getCountry());
    }

    @Test
    @Order(3)
    public void testAddBooking() {
       
        int initialSize = airport.getBookings().size();

        airport.addBooking(booking2);
        assertEquals(initialSize + 1, airport.getBookings().size());
        assertTrue(airport.getBookings().contains(booking2));
    }

    @Test
    @Order(4)
    public void testRemoveBooking() {
        
        int initialSize = airport.getBookings().size();

        airport.removeBooking(booking1);
        assertEquals(initialSize - 1, airport.getBookings().size());
        assertFalse(airport.getBookings().contains(booking1));
    }

    @Test
    @Order(5)
    public void testGetAirportInfo() {
        // Test airport info utility method with updated details
        String expectedInfo = "Airport Code: CAI, Name: Egypt International Airport, Country: Egypt";
        assertEquals(expectedInfo, airport.getAirportInfo());
    }
}
