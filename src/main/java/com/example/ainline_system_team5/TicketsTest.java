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
    @Order(1)
    void testSetPassenger() {
    	System.out.println(1);
        Customer passenger = new Customer("John", 25);
        tickets.setPassenger(passenger);
        assertEquals(passenger, tickets.getPassenger());
    }

    @Test
    @Order(2)
    void testSetFlight() {
    	System.out.println(2);
        Flight flight = new Flight();
        tickets.setFlight(flight);
        assertEquals(flight, tickets.getFlight());
    }

    @Test
    @Order(3)
    void testSetTicketId() {
    	System.out.println(3);
        tickets.setTicketId("001", "ABC");
        assertNotNull(tickets.getTicketId());
    }

    @Test
    @Order(4)
    void testSetSeatNum() {
    	System.out.println(4);
        tickets.setSeatNum("001");
        assertNotNull(tickets.getSeatNum());
    }


    @Test
    @Order(5)
    void testSetClassType() {
    	System.out.println(5);
        tickets.setClassType(true, false);
        assertTrue(tickets.isBusiness());
        assertFalse(tickets.isEconomy());
    }

    @Test
    @Order(6)
    void testSetStatus() {
    	System.out.println(6);
        tickets.setStatus("Purchased");
        assertEquals("Purchased", tickets.getStatus());
    }

    @Test
    @Order(7)
    void testSetPrice() {
    	System.out.println(7);
        Customer passenger = new Customer("John", 10);
        tickets.setPassenger(passenger);
        tickets.setPrice(100);
        assertEquals(50, tickets.getPrice());
    }

    @Test
    @Order(8)
    void testSetBaggageAllowance() {
    	System.out.println(8);
        tickets.setBaggageAllowance(20);
        assertEquals(20, tickets.getBaggageAllowance());
    }

    @Test
    @Order(9)
    void testFormatSeatOrFlightId() {
    	System.out.println(9);
        assertEquals("001", tickets.formatSeatOrFlightId("1"));
        assertEquals("010", tickets.formatSeatOrFlightId("10"));
        assertEquals("100", tickets.formatSeatOrFlightId("100"));
        assertEquals("000", tickets.formatSeatOrFlightId("1000"));
    }

    @Test
    @Order(10)
    void testGetIssuedTicketIds() {
    	System.out.println(10);
        tickets.getIssuedTicketIds().add("ABC123");
        tickets.getIssuedTicketIds().add("DEF456");

        List<String> issuedTicketIds = tickets.getIssuedTicketIds();
        assertNotNull(issuedTicketIds);
        assertFalse(issuedTicketIds.isEmpty());
        assertEquals(2, issuedTicketIds.size()); 
    }

    @Test
    @Order(11)
    void testInvalidStatus() {
    	System.out.println(11);
        tickets.setStatus("InvalidStatus");
        assertNotEquals("InvalidStatus", tickets.getStatus());
    }

    @Test
    @Order(12)
    void testInvalidBaggageAllowance() {
    	System.out.println(12);
        tickets.setBaggageAllowance(10);
        assertNotEquals(10, tickets.getBaggageAllowance());
    }

    @Test
    @Order(13)
    void testInvalidClassType() {
    	System.out.println(13);
        tickets.setClassType(true, true);
        assertFalse(tickets.isBusiness());
        assertFalse(tickets.isEconomy());
    }

    @Test
    @Order(14)
    void testInvalidPriceWithoutPassenger() {
    	System.out.println(14);
        tickets.setPrice(100);
        assertNotEquals(100, tickets.getPrice());
    }

    @Test
    @Order(15)
    void testInvalidTicketId() {
    	System.out.println(15);
        tickets.setTicketId("001", "ABC");
        tickets.setTicketId("002", "DEF");
        
        try {
            tickets.setTicketId("001", "XYZ");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    @Order(16)
    void testInvalidSeatNum() {
    	System.out.println(16);
        tickets.setSeatNum("001");
        tickets.setSeatNum("002");
        
        try {
            tickets.setSeatNum("000");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
        }
    }


    @Test
    @Order(17)
    void testInvalidSetPassenger() {
    	System.out.println(17);
        tickets.setPassenger(null);
        assertNull(tickets.getPassenger());
    }

    @Test
    @Order(18)
    void testInvalidSetFlight() {
    	System.out.println(18);
        tickets.setFlight(null);
        assertNull(tickets.getFlight());
    }

    @Test
    @Order(19)
    void testInvalidSetPrice() {
    	System.out.println(19);
        tickets.setPassenger(new Customer("John", 20));
        tickets.setPrice(-100);
        assertEquals(0, tickets.getPrice());
    }

    @Test
    @Order(20)
    void testInvalidSetBaggageAllowance() {
    	System.out.println(20);
        tickets.setBaggageAllowance(5);
        assertNotEquals(5, tickets.getBaggageAllowance());
    }
    
    @Nested
    class TicketSuite {
        @Test
        @Order(21)
        void testTicketCreation() {
        	System.out.println(21);
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
        @Order(21)
        void testInvalidTicketCreation() {
        	System.out.println(22);
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
