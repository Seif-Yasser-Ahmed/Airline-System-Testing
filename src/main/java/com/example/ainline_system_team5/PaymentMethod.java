package com.example.ainline_system_team5;
public class PaymentMethod {
	 private String type; // Credit card, Debit card, PayPal, etc.
	    private String cardNumber;
	    private String expirationDate;
	    private String securityCode;

	    public PaymentMethod(String type, String cardNumber, String expirationDate, String securityCode) {
	        this.type = type;
	        this.cardNumber = cardNumber;
	        this.expirationDate = expirationDate;
	        this.securityCode = securityCode;
	    }

	    // Getters and setters
	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public String getCardNumber() {
	        return cardNumber;
	    }

	    public void setCardNumber(String cardNumber) {
	        this.cardNumber = cardNumber;
	    }

	    public String getExpirationDate() {
	        return expirationDate;
	    }

	    public void setExpirationDate(String expirationDate) {
	        this.expirationDate = expirationDate;
	    }

	    public String getSecurityCode() {
	        return securityCode;
	    }

	    public void setSecurityCode(String securityCode) {
	        this.securityCode = securityCode;
	    }
	}
