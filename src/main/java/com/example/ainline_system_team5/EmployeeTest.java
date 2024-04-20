package com.example.ainline_system_team5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeTest {
	Employee employee=new Employee();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(1)
	void testgetDetails() {
		ArrayList<Person>Expectedlist = new ArrayList<Person>();
		Person person1=new Person("Seif","Yasser1","1", "seiffyasser1@gmail.com", 1090555883, "Cairo1");
		Expectedlist.add(person1);
		Person person2=new Person("Seif","Yasser2","2", "seiffyasser2@gmail.com", 1090555883, "Cairo2");
		Expectedlist.add(person2);
		Person person3=new Person("Seif","Yasser3","3", "seiffyasser3@gmail.com", 1090555883, "Cairo3");
		Expectedlist.add(person3);
		Person person4=new Person("Seif","Yasser4","4", "seiffyasser4@gmail.com", 1090555883, "Cairo4");
		Expectedlist.add(person4);
		Person person5=new Person("Seif","Yasser5","5", "seiffyasser5@gmail.com", 1090555883, "Cairo5");
		Expectedlist.add(person5);
		Person person6=new Person("Seif","Yasser6","6", "seiffyasser6@gmail.com", 1090555883, "Cairo6");
		Expectedlist.add(person6);
		Person person7=new Person("Seif","Yasser7","7", "seiffyasser7@gmail.com", 1090555883, "Cairo7");
		Expectedlist.add(person7);
		Person person8=new Person("Seif","Yasser8","8", "seiffyasser8@gmail.com", 1090555883, "Cairo8");
		Expectedlist.add(person8);
		//Starts from 1 as junit creates object on its own
		//person's id=0 is null because it is been created while calling personlist ArrayList.
		System.out.println(employee.getPersonDetailsbyID(1));
//		fail("Not yet implemented");
		for(int i=1;i<9;i++) {
			assertEquals(Expectedlist.get(i-1).getPersonDetails(),employee.getPersonDetailsbyID(i));
		}
	}
	@Test
	@Order(2)
	void test() {
		
	}
	

}
