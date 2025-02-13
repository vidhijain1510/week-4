/*throw vs. throws (Exception Propagation)
💡 Problem Statement:
Create a method calculateInterest(double amount, double rate, int years) that:
Throws IllegalArgumentException if amount or rate is negative.
Propagates the exception using throws and handles it in main().
Expected Behavior:
If valid, return and print the calculated interest.
If invalid, catch and display "Invalid input: Amount and rate must be positive".*/
package com.capgeminitraining.week4.day4exceptionalhandling;

public class InterestCalculator {
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {
        try {
            double interest = calculateInterest(1000, 5, 2);
            System.out.println("Calculated Interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

