package com.example.ainline_system_team5;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketsTest {

    private Tickets tickets;

    @BeforeEach
    void setUp() {
        tickets = new Tickets();
    }

    @AfterEach
    void tearDown() {
        tickets = null;
    }

    @Test
    void testSetPassenger() {
        Customer passenger = new Customer("John", 25);
        tickets.setPassenger(passenger);
        assertEquals(passenger, tickets.getPassenger());
    }

    @Test
    void testSetFlight() {
        Flight flight = new Flight();
        tickets.setFlight(flight);
        assertEquals(flight, tickets.getFlight());
    }

    @Test
    void testSetTicketId() {
        tickets.setTicketId("001", "ABC");
        assertNotNull(tickets.getTicketId());
    }

    @Test
    void testSetSeatNum() {
        tickets.setSeatNum("001");
        assertNotNull(tickets.getSeatNum());
    }


    @Test
    void testSetClassType() {
        tickets.setClassType(true, false);
        assertTrue(tickets.isBusiness());
        assertFalse(tickets.isEconomy());
    }

    @Test
    void testSetStatus() {
        tickets.setStatus("Purchased");
        assertEquals("Purchased", tickets.getStatus());
    }

    @Test
    void testSetPrice() {
        Customer passenger = new Customer("John", 10);
        tickets.setPassenger(passenger);
        tickets.setPrice(100);
        assertEquals(50, tickets.getPrice());
    }

    @Test
    void testSetBaggageAllowance() {
        tickets.setBaggageAllowance(20);
        assertEquals(20, tickets.getBaggageAllowance());
    }

    @Test
    void testFormatSeatOrFlightId() {
        assertEquals("001", tickets.formatSeatOrFlightId("1"));
        assertEquals("010", tickets.formatSeatOrFlightId("10"));
        assertEquals("100", tickets.formatSeatOrFlightId("100"));
        assertEquals("000", tickets.formatSeatOrFlightId("1000"));
    }

    @Test
    void testGetIssuedTicketIds() {
        tickets.getIssuedTicketIds().add("ABC123");
        tickets.getIssuedTicketIds().add("DEF456");

        List<String> issuedTicketIds = tickets.getIssuedTicketIds();
        assertNotNull(issuedTicketIds);
        assertFalse(issuedTicketIds.isEmpty());
        assertEquals(2, issuedTicketIds.size()); 
    }

    @Test
    void testInvalidStatus() {
        tickets.setStatus("InvalidStatus");
        assertNotEquals("InvalidStatus", tickets.getStatus());
    }

    @Test
    void testInvalidBaggageAllowance() {
        tickets.setBaggageAllowance(10);
        assertNotEquals(10, tickets.getBaggageAllowance());
    }

    @Test
    void testInvalidClassType() {
        tickets.setClassType(true, true);
        assertFalse(tickets.isBusiness());
        assertFalse(tickets.isEconomy());
    }

    @Test
    void testInvalidPriceWithoutPassenger() {
        tickets.setPrice(100);
        assertNotEquals(100, tickets.getPrice());
    }

    @Test
    void testInvalidTicketId() {
        tickets.setTicketId("001", "ABC");
        tickets.setTicketId("002", "DEF");
        
        try {
            tickets.setTicketId("001", "XYZ");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void testInvalidSeatNum() {
        tickets.setSeatNum("001");
        tickets.setSeatNum("002");
        
        try {
            tickets.setSeatNum("000");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
        }
    }


    @Test
    void testInvalidSetPassenger() {
        tickets.setPassenger(null);
        assertNull(tickets.getPassenger());
    }

    @Test
    void testInvalidSetFlight() {
        tickets.setFlight(null);
        assertNull(tickets.getFlight());
    }

    @Test
    void testInvalidSetPrice() {
        tickets.setPassenger(new Customer("John", 20));
        tickets.setPrice(-100);
        assertEquals(0, tickets.getPrice());
    }

    @Test
    void testInvalidSetBaggageAllowance() {
        tickets.setBaggageAllowance(5);
        assertNotEquals(5, tickets.getBaggageAllowance());
    }
    
    @Nested
    class TicketSuite {
        @Test
        void testTicketCreation() {
            tickets.setTicketId("001", "ABC");
            tickets.setSeatNum("001");
            Airport airportFrom=new Airport();
            Airport airportTo=new Airport();
            tickets.setFlight(new Flight(123, airportFrom,airportTo));
            tickets.setPrice(100);
            tickets.setBaggageAllowance(20);
            assertEquals("001", tickets.getSeatNum());
            assertEquals(123, tickets.getFlight().getFlightID());
            assertEquals(100, tickets.getPrice());
            assertEquals(20, tickets.getBaggageAllowance());
        }
        	
        @Test
        void testInvalidTicketCreation() {
            tickets.setTicketId("001", "ABC");
            tickets.setSeatNum("001");
            Airport airportFrom=new Airport();
            Airport airportTo=new Airport();
            tickets.setFlight(new Flight(123,airportFrom,airportTo));
            tickets.setPrice(-100);
            tickets.setBaggageAllowance(5);
            assertNull(tickets.getPassenger());
            assertEquals("001", tickets.getSeatNum());
            assertEquals(123, tickets.getFlight().getFlightID());
            assertEquals(0, tickets.getPrice());
            assertNotEquals(5, tickets.getBaggageAllowance());
        }
    }
}
