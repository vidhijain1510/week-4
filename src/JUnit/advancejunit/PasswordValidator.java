package com.capgeminitraining.week4.day5regexjunit.junit.advancejunit;

public class PasswordValidator {

    public static boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (hasUppercase && hasDigit) {
                return true;
            }
        }
        return false;
    }
}

