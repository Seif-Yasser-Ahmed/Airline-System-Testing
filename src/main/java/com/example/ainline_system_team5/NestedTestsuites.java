package com.example.ainline_system_team5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
@Nested
class NestedTestsuites {


	@Test
	public void PersonTestSuite() {
		
	}
	@Test
	public void FlightAirportTestSuite() {
		
	}
	@Nested
	public class innerTest{
		@Test
		public void FlightBookingTestSuite() {
			
		}		
	}
}

