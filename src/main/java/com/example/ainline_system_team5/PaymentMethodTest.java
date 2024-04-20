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

    @Test
    @Order(11)
    public void testInvalidCardNumber() {
        // Test with an invalid card number (too short)
        assertThrows(IllegalArgumentException.class, () -> {
            paymentMethod.setCardNumber("12345"); // Invalid length
        });
    }

    @Test
    @Order(12)
    public void testInvalidExpirationDate() {
        // Test with an invalid expiration date format
        assertThrows(IllegalArgumentException.class, () -> {
            paymentMethod.setExpirationDate("13/25"); // Invalid month
        });
    }

    @Test
    @Order(13)
    public void testInvalidSecurityCode() {
        // Test with an invalid security code (too long)
        assertThrows(IllegalArgumentException.class, () -> {
            paymentMethod.setSecurityCode("12345"); // Invalid length
        });
    }
}
