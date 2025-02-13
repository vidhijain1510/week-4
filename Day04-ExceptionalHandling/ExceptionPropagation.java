/*Exception Propagation in Methods
💡 Problem Statement:
Create a Java program with three methods:
method1(): Throws an ArithmeticException (10 / 0).
method2(): Calls method1().
main(): Calls method2() and handles the exception.
Expected Behavior:
The exception propagates from method1() → method2() → main().
Catch and handle it in main(), printing "Handled exception in main".*/
package com.capgeminitraining.week4.day4exceptionalhandling;

public class ExceptionPropagation {

    //method1 Throws an ArithmeticException (10 / 0)
    public static void method1() {
        int result = 10 / 0;  //This will throw ArithmeticException
    }

    //method2 Calls method1()
    public static void method2() {
        method1();  //This will propagate the exception from method1()
    }

    public static void main(String[] args) {
        try {
            //Calling method2 which will call method1 and propagate the exception
            method2();
        } catch (ArithmeticException e) {
            //Handling the exception in main() and printing the message
            System.out.println("Handled exception in main");
        }
    }
}
