package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IPValidatorTest {

    @Test
    void testValidIPAddresses() {
        assertTrue(IPValidator.isValidIPAddress("192.168.1.1"), "192.168.1.1 should be valid");
        assertTrue(IPValidator.isValidIPAddress("0.0.0.0"), "0.0.0.0 should be valid");
        assertTrue(IPValidator.isValidIPAddress("255.255.255.255"), "255.255.255.255 should be valid");
        assertTrue(IPValidator.isValidIPAddress("1.2.3.4"), "1.2.3.4 should be valid");
    }

    @Test
    void testInvalidIPAddresses_OutOfRange() {
        assertFalse(IPValidator.isValidIPAddress("256.100.50.25"), "256.100.50.25 should be invalid");
        assertFalse(IPValidator.isValidIPAddress("192.300.1.1"), "192.300.1.1 should be invalid");
        assertFalse(IPValidator.isValidIPAddress("999.999.999.999"), "999.999.999.999 should be invalid");
    }
}
