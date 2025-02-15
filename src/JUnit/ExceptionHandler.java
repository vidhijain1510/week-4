/*4️⃣ Testing Exception Handling
Problem:
Create a method divide(int a, int b) that throws an ArithmeticException if b is zero. Write a JUnit test to verify that the exception is thrown properly.
*/
package com.capgeminitraining.week4.day5regexjunit.junit;


public class ExceptionHandler {

    //Method to perform division and throw ArithmeticException if b is zero
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
