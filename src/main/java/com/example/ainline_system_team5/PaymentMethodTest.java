package com.example.ainline_system_team5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class PaymentMethodTest {
	
	 private PaymentMethod paymentMethod;

	    @BeforeEach
	    public void setUp() {
	        // Initialize a PaymentMethod instance with valid details
	        paymentMethod = new PaymentMethod("Credit Card", "1234567890123456", "12/25", "123");
	    }

	    @AfterEach
	    public void tearDown() {
	        // Clean up resources after each test
	        paymentMethod = null;
	    }

	    @Test
	    @Order(1)
	    public void testInitialization() {
	        // Test if the PaymentMethod instance is initialized correctly
	        assertEquals("Credit Card", paymentMethod.getType());
	        assertEquals("1234567890123456", paymentMethod.getCardNumber());
	        assertEquals("12/25", paymentMethod.getExpirationDate());
	        assertEquals("123", paymentMethod.getSecurityCode());
	    }

	    @Test
	    @Order(2)
	    public void testSettersAndGetters() {
	        // Test setting and getting different values
	        paymentMethod.setType("Debit Card");
	        paymentMethod.setCardNumber("9876543210987654");
	        paymentMethod.setExpirationDate("01/28");
	        paymentMethod.setSecurityCode("456");

	        assertEquals("Debit Card", paymentMethod.getType());
	        assertEquals("9876543210987654", paymentMethod.getCardNumber());
	        assertEquals("01/28", paymentMethod.getExpirationDate());
	        assertEquals("456", paymentMethod.getSecurityCode());
	    }

	    // Individual Getter Tests
	    @Test
	    @Order(3)
	    public void testGetType() {
	        assertEquals("Credit Card", paymentMethod.getType());
	    }

	    @Test
	    @Order(4)
	    public void testGetCardNumber() {
	        assertEquals("1234567890123456", paymentMethod.getCardNumber());
	    }

	    @Test
	    @Order(5)
	    public void testGetExpirationDate() {
	        assertEquals("12/25", paymentMethod.getExpirationDate());
	    }

	    @Test
	    @Order(6)
	    public void testGetSecurityCode() {
	        assertEquals("123", paymentMethod.getSecurityCode());
	    }

	    // Individual Setter Tests
	    @Test
	    @Order(7)
	    public void testSetType() {
	        paymentMethod.setType("Debit Card");
	        assertEquals("Debit Card", paymentMethod.getType());
	    }

	    @Test
	    @Order(8)
	    public void testSetCardNumber() {
	        paymentMethod.setCardNumber("9876543210987654");
	        assertEquals("9876543210987654", paymentMethod.getCardNumber());
	    }

	    @Test
	    @Order(9)
	    public void testSetExpirationDate() {
	        paymentMethod.setExpirationDate("11/25");
	        assertEquals("11/25", paymentMethod.getExpirationDate());
	    }

	    @Test
	    @Order(10)
	    public void testSetSecurityCode() {
	        paymentMethod.setSecurityCode("456");
	        assertEquals("456", paymentMethod.getSecurityCode());
	    }

	private boolean isValidCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.matches("\\d{16}");
    }

    private boolean isValidSecurityCode(String securityCode) {
        return securityCode != null && securityCode.matches("\\d{3}");
    }

    private boolean isValidExpirationDate(String expirationDate) {
        if (expirationDate == null || !expirationDate.matches("\\d{2}/\\d{2}")) {
            return false;
        }

        String[] parts = expirationDate.split("/");
        int month = Integer.parseInt(parts[0]);
        return month >= 1 && month <= 12; // Valid months are 01-12
    }

    // Test cases for isValidCardNumber
    @Test
    @Order(11)
    public void testInvalidCardNumber() {
        assertFalse(isValidCardNumber(null)); // Null input
        assertFalse(isValidCardNumber("")); // Empty string
        assertFalse(isValidCardNumber("123456789012345")); // 15 digits
        assertFalse(isValidCardNumber("12345678901234567")); // 17 digits
        assertFalse(isValidCardNumber("1234abcd90123456")); // Non-digit characters
    }

    // Test cases for isValidSecurityCode
    @Test
    @Order(12)
    public void testInvalidSecurityCode() {
        assertFalse(isValidSecurityCode(null)); // Null input
        assertFalse(isValidSecurityCode("")); // Empty string
        assertFalse(isValidSecurityCode("12")); // 2 digits
        assertFalse(isValidSecurityCode("1234")); // 4 digits
        assertFalse(isValidSecurityCode("12a")); // Non-digit characters
    }

    // Test cases for isValidExpirationDate
    @Test
    @Order(13)
    public void testInvalidExpirationDate() {
        assertFalse(isValidExpirationDate(null)); // Null input
        assertFalse(isValidExpirationDate("")); // Empty string
        assertFalse(isValidExpirationDate("13/21")); // Invalid month (13)
        assertFalse(isValidExpirationDate("00/21")); // Invalid month (00)
        assertFalse(isValidExpirationDate("1/21")); // Improper format (not MM/YY)
        assertFalse(isValidExpirationDate("ab/cd")); // Non-digit characters
        assertFalse(isValidExpirationDate("03-21")); // Wrong separator
    }
}
