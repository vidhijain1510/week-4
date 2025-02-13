/*finally Block Execution
💡 Problem Statement:
Write a program that performs integer division and demonstrates the finally block execution.
The program should:
Take two integers from the user.
Perform division.
Handle ArithmeticException (if dividing by zero).
Ensure "Operation completed" is always printed using finally.
Expected Behavior:
If valid, print the result.
If an exception occurs, handle it and still print "Operation completed".
*/
package com.capgeminitraining.week4.day4exceptionalhandling;

public class DivisionWithFinally {
    //Method to perform division and handle exceptions
    public static String divide(int num1, int num2) {
        try {
            //Performing division
            int result = num1 / num2;
            return "Result of division: " + result;
        } catch (ArithmeticException e) {
            //Handling division by zero
            return "Error: Division by zero is not allowed.";
        } finally {
            //Checking "Operation completed" is always printed
            System.out.println("Operation completed.");
        }
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 2));
        System.out.println(divide(10, 0));
    }
}
