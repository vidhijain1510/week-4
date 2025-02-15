package com.capgeminitraining.week4.day5regexjunit.junit.advancejunit;

import java.util.regex.Pattern;

public class UserRegistration {

    //Regex for validating email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static String registerUser(String username, String email, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !Pattern.matches(EMAIL_REGEX, email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (password == null || password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must be at least 8 characters, contain one uppercase letter and one digit");
        }
        return "User registered successfully";
    }
}
