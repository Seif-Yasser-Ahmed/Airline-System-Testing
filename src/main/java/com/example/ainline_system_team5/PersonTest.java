package com.example.ainline_system_team5;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.example.ainline_system_team5.Flight.flightstatus;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonTest {
	static Person person=new Person();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
//		person
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
//		person=new Person();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@Order (1)
	void testSetFirstName() {
    	String Expected="Seif";
		person.setFirstName(Expected);
		assertEquals(Expected,person.getFirstname());
//		fail("Not yet implemented");
	}

	@Test
	@Order (2)
	void testSetFullName() {
    	String Expectedfname="Seif";
    	String Expectedlname="Yasser";
    	person.setFirstName(Expectedfname);
		person.setLastName(Expectedlname);
		assertEquals(Expectedfname+" "+Expectedlname,person.getFullName());
	}
	
	@Test
	@Order(3)
	void testPassword() {
		String Expected="Pass@123";
		person.setPassword(Expected);
		assertEquals(Expected,person.password);
	}
	
	@Test
	@Order(4)
	void testID() {
		int Expected=1234;
		person.setId(Expected);
		assertEquals(Expected,person.getId());
	}
	@Test
	@Order(5)
	void testAddress() {
		String Expected="Cairo";
		person.setAddress(Expected);
		assertEquals(Expected,person.getAddress());
	}
	@Test
	@Order(6)
	void testPhoneNo() {
		int Expected=1090555883;
		person.setPhone_num(Expected);
		assertEquals(Expected,person.getPhone_num());
	}
	
	@Test
	@Order(7)
	void testEmail() {
	String Expected="seiffyasserr@gmail.com";
	person.setEmail(Expected);
		assertEquals(Expected,person.getEmail());
	}
	@Test
	@Order(8)
	void testIdmap() {

		Person person1=new Person();
		Person person2=new Person();
		Person person3=new Person();
		Person person4=new Person();
		assertEquals(1,person1.getId());
		assertEquals(2,person2.getId());
		assertEquals(3,person3.getId());
		assertEquals(4,person4.getId());
	}
	
	@Test
	@Order(9)
	void testGetPersonDetails() {
		Booking booking1 = new Booking(null, null, null, null, null);
//		person.addBooking(booking1);
//		Person person1=new Person("Seif1","Yasser");
//		System.out.println(person.id);
		person.setAddress("Cairo");
		person.setEmail("seiffyasserr@gmail.com");
		person.setFirstName("Seif");
		person.setLastName("Yasser");
		person.setPassword("1234");
		person.setPhone_num(1090555883);
		String Expected="Person ID: 1234\n"
				+ "First Name: Seif\n"
				+ "Second Name: Yasser\n"
				+ "Phone Number: 1090555883\n"
				+ "Email: seiffyasserr@gmail.com\n"
//				+ "Bookings: "+booking1.+
				+ "Address: Cairo\n";
		assertEquals(Expected,person.getPersonDetails());
	}
	@Test
	@Order(10)
	void testSearch() { 
	        
		Airport airportFrom1=new Airport();
		Airport airportTo1=new Airport();
		Airport airportFrom2=new Airport();
		Airport airportTo2=new Airport();
		Airport airportFrom3=new Airport();
		Airport airportTo3=new Airport();
		Airport airportFrom4=new Airport();
		Airport airportTo4=new Airport();
		Airport airportFrom5=new Airport();
		Airport airportTo5=new Airport();
		
		Flight flight1=new Flight(1,airportFrom1,airportTo1);
		Flight flight2=new Flight(2,airportFrom2,airportTo2);
		Flight flight3=new Flight(3,airportFrom3,airportTo3);
		Flight flight4=new Flight(4,airportFrom4,airportTo4);
		Flight flight5=new Flight(5,airportFrom5,airportTo5);
		airportFrom1.flights.add(flight1);
		airportFrom2.flights.add(flight2);
		airportFrom1.flights.add(flight3);
		airportFrom1.flights.add(flight4);
		airportFrom1.flights.add(flight5);
		int Expected=person.searchFlights(airportFrom5, airportTo5).get(0).getFlightID();
		assertEquals(5,Expected);
	}
	@Test
	@Order(12)
	void testSearchBooking() {
		Booking booking1=new Booking();
		String ID="00"+"-"+LocalDateTime.now().getDayOfMonth()+""+LocalDateTime.now().getMonthValue()+""+LocalDateTime.now().getYear();
		person.addBooking(booking1);
		assertEquals(booking1,person.getBookingDetails(ID));
	}
	
//	@Test
//	@Order(13)
//	void testBookings() {
//		Booking booking1=new Booking();
//		Booking booking2=new Booking();
//		Booking booking3=new Booking();
//		List<Booking>Expected;
//		Expected.add(booking1);
//		Expected.add(booking2);
//		Expected.add(booking3);
//		person.addBooking(booking1);
//		person.addBooking(booking2);
//		person.addBooking(booking3);
//		assertEquals(Expected,person.getBookings());
//	}
//	

}
