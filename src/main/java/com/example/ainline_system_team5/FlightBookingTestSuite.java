package com.example.ainline_system_team5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.Result;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	FlightTest.class,
	BookingTest.class
	})
@Nested
public class FlightBookingTestSuite {
	@Test
	public void FlightTest() {
		
	}
	@Test
	public void BookingTest() {
		
	}
	
}



