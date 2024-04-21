package com.example.ainline_system_team5;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonTest {
//seif
	Person person=new Person();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
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
		assertEquals(8,person1.getId());
		assertEquals(9,person2.getId());
		assertEquals(10,person3.getId());
		assertEquals(11,person4.getId());
	}
	
	@Test
	@Order(9)
	void testGetPersonDetails() {
		Booking booking1 = new Booking(null, null, null, null, null);
//		person.addBooking(booking1);
//		Person person1=new Person("Seif1","Yasser");
		person.setAddress("Cairo");
		person.setEmail("seiffyasserr@gmail.com");
		person.setFirstName("Seif");
		person.setLastName("Yasser");
		person.setPassword("1234");
		person.setPhone_num(1090555883);
		String Expected="Person ID: 12\n"
				+ "First Name: Seif\n"
				+ "Second Name: Yasser\n"
				+ "Phone Number: 1090555883\n"
				+ "Email: seiffyasserr@gmail.com\n"
//				+ "Bookings: "+booking1.+
				+ "Address: Cairo\n";
		System.out.println(person.getPersonDetails());
		System.out.println(person.PersonList.get(11).getFirstname());
		assertEquals(Expected,person.getPersonDetails());
	}
	
//	@Test
//	@Order(10)
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
