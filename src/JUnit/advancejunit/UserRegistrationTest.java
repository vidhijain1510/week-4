package com.capgeminitraining.week4.day5regexjunit.junit.advancejunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        assertEquals("User registered successfully",
                UserRegistration.registerUser("JohnDoe", "john@example.com", "Secure123"),
                "Valid user should be registered successfully");
    }

    @Test
    void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("", "user@example.com", "Password1"));
        assertEquals("Username cannot be empty", exception.getMessage(), "Empty username should not be allowed");
    }

    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("User123", "invalid-email", "Password1"));
        assertEquals("Invalid email format", exception.getMessage(), "Should reject invalid email formats");
    }

    @Test
    void testShortPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("User123", "user@example.com", "Short1"));
        assertEquals("Password must be at least 8 characters, contain one uppercase letter and one digit",
                exception.getMessage(), "Should reject passwords shorter than 8 characters");
    }

    @Test
    void testPasswordWithoutUppercase() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("User123", "user@example.com", "password1"));
        assertEquals("Password must be at least 8 characters, contain one uppercase letter and one digit",
                exception.getMessage(), "Should reject passwords without an uppercase letter");
    }

    @Test
    void testPasswordWithoutDigit() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("User123", "user@example.com", "Password"));
        assertEquals("Password must be at least 8 characters, contain one uppercase letter and one digit",
                exception.getMessage(), "Should reject passwords without a digit");
    }
}
