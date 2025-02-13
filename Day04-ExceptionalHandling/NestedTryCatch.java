/*Nested try-catch Block
💡 Problem Statement:
Write a Java program that:
Takes an array and a divisor as input.
Tries to access an element at an index.
Tries to divide that element by the divisor.
Uses nested try-catch to handle:
ArrayIndexOutOfBoundsException if the index is invalid.
ArithmeticException if the divisor is zero.
Expected Behavior:
If valid, print the division result.
If the index is invalid, catch and display "Invalid array index!".
If division by zero, catch and display "Cannot divide by zero!".*/
package com.capgeminitraining.week4.day4exceptionalhandling;

import java.util.Scanner;

public class NestedTryCatch{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Taking input for the array and the divisor
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        //filling the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the index to access: ");
        int index = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        try {
            //Try accessing the array element
            try {
                int element = array[index];  //throw ArrayIndexOutOfBoundsException
                //Try dividing the element by the divisor
                try {
                    int result = element / divisor;  //throw ArithmeticException
                    System.out.println("Division result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } finally {
            scanner.close();
        }
    }
}
