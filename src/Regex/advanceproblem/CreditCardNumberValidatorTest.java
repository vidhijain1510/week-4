package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreditCardNumberValidatorTest {

    @Test
    void testValidVisaCards() {
        assertTrue(CreditCardNumberValidator.isValidCreditCard("4556737586899855"), "Visa card should be valid");
        assertTrue(CreditCardNumberValidator.isValidCreditCard("4111111111111111"), "Visa card should be valid");
    }

    @Test
    void testValidMasterCards() {
        assertTrue(CreditCardNumberValidator.isValidCreditCard("5555555555554444"), "MasterCard should be valid");
        assertTrue(CreditCardNumberValidator.isValidCreditCard("5105105105105100"), "MasterCard should be valid");
    }

    @Test
    void testInvalidCreditCardNumbers() {
        assertFalse(CreditCardNumberValidator.isValidCreditCard("6574879825488441"), "Card not starting with 4 or 5 should be invalid");
        assertFalse(CreditCardNumberValidator.isValidCreditCard("345678901234567"), "15-digit number should be invalid");
        assertFalse(CreditCardNumberValidator.isValidCreditCard("5123-4567-8901-2345"), "Card with dashes should be invalid");
        assertFalse(CreditCardNumberValidator.isValidCreditCard("abcdefabcdefabcd"), "Card with letters should be invalid");
        assertFalse(CreditCardNumberValidator.isValidCreditCard("1234567890123456"), "Random 16-digit number should be invalid");
    }
}