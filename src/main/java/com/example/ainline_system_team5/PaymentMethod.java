package com.example.ainline_system_team5;

public class PaymentMethod {
    private String type; // Credit card, Debit card, PayPal, etc.
    private String cardNumber;
    private String expirationDate;
    private String securityCode;

    // Constructor with validation
    public PaymentMethod(String type, String cardNumber, String expirationDate, String securityCode) {
        this.type = type;
        
        if (isValidCardNumber(cardNumber)) {
            this.cardNumber = cardNumber;
        } else {
            throw new IllegalArgumentException("Invalid card number: must be 16 digits.");
        }

        if (isValidExpirationDate(expirationDate)) {
            this.expirationDate = expirationDate;
        } else {
            throw new IllegalArgumentException("Invalid expiration date: must be MM/YY and a valid month.");
        }

        if (isValidSecurityCode(securityCode)) {
            this.securityCode = securityCode;
        } else {
            throw new IllegalArgumentException("Invalid security code: must be 3 digits.");
        }
    }

    // Getters and setters with validation
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
        if (isValidCardNumber(cardNumber)) {
            this.cardNumber = cardNumber;
        } else {
            throw new IllegalArgumentException("Invalid card number: must be 16 digits.");
        }
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        if (isValidExpirationDate(expirationDate)) {
            this.expirationDate = expirationDate;
        } else {
            throw new IllegalArgumentException("Invalid expiration date: must be MM/YY and a valid month.");
        }
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        if (isValidSecurityCode(securityCode)) {
            this.securityCode = securityCode;
        } else {
            throw new IllegalArgumentException("Invalid security code: must be 3 digits.");
        }
    }

    // Validation methods
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
}

