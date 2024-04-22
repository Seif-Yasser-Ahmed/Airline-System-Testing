package com.example.ainline_system_team5;
import com.example.ainline_system_team5.Flight.flightstatus;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




class FlightTest {
	private List<Flight> seats;
    private static final int FlightID = 2190007;
	private Airport fromAirport;
    private Airport toAirport;
    private flightstatus status;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int availableSeats;

    @BeforeEach
    public void setUp() {
        fromAirport = new Airport("FromCode","FromName","FromCountry");
        toAirport = new Airport("ToCode","ToName","ToCountry");
        arrivalTime = LocalDateTime.of(2024, 4, 22, 10, 30);
        departureTime = LocalDateTime.of(2024, 4, 22, 14, 45);
        status = flightstatus.Static;
    }

    @Test
    public void testGetFlightID() {
        Flight flight = new Flight(FlightID, fromAirport, toAirport,status,departureTime,arrivalTime);
        assertEquals(2190007, flight.getFlightID());
    }

    @Test
    public void testGetFrom() {
        Flight flight = new Flight(FlightID, fromAirport, toAirport, status,departureTime,arrivalTime);
        assertEquals(fromAirport, flight.getFrom());
    }

    @Test
    public void testGetTo() {
        Flight flight = new Flight(FlightID, fromAirport, toAirport, status,departureTime,arrivalTime);
        assertEquals(toAirport, flight.getTo());
    }

    @Test
    public void testGetArrivalTime() {
        Flight flight = new Flight(FlightID, fromAirport, toAirport, status,departureTime,arrivalTime);
        assertEquals(arrivalTime, flight.getArrivalTime());
    }
    @Test
    public void testGetDepartureTime() {
        Flight flight = new Flight(FlightID, fromAirport, toAirport, status,departureTime,arrivalTime);
        assertEquals(departureTime, flight.getDepartureTime());
    }

    @Test
    public void testGetStatus() {
        Flight flight = new Flight(FlightID, fromAirport, toAirport, status,departureTime,arrivalTime);
        assertEquals(status, flight.getFlightStatus());
    }
    @Test
    public void testSetFlightID() {
        Flight flight = new Flight(FlightID, fromAirport, toAirport, status,departureTime,arrivalTime);
        flight.setFlightID(123456);
        assertEquals(123456, flight.getFlightID());
    }
    @Test
    public void testSetFlightStatus() {
        Flight flight = new Flight(FlightID, fromAirport, toAirport, status,departureTime,arrivalTime);
        flight.setFlightStatus(flightstatus.Tookoff);
        assertEquals(fromAirport, flight.getFrom());
    }
    @Test
    public void testSetDepartureTime() {
        Flight flight = new Flight(2190007, fromAirport, toAirport, status,departureTime,arrivalTime);
        LocalDateTime departureTime = LocalDateTime.of(2024, 4, 22, 10, 30);
        flight.setDepartureTime(departureTime);
        assertEquals(departureTime, flight.getDepartureTime());
    }
    @Test
    public void testSetArrivalTime() {
        Flight flight = new Flight(2190007, fromAirport, toAirport, status,departureTime,arrivalTime);
        LocalDateTime arrivalTime = LocalDateTime.of(2024, 4, 22, 14, 45);
        flight.setArrivalTime(arrivalTime);
        assertEquals(arrivalTime, flight.getArrivalTime());
    }
}