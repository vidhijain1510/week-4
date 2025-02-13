/* Multiple Catch Blocks
💡 Problem Statement:
Create a Java program that performs array operations.
Accept an integer array and an index number.
Retrieve and print the value at that index.
Handle the following exceptions:
ArrayIndexOutOfBoundsException if the index is out of range.
NullPointerException if the array is null.
Expected Behavior:
If valid, print "Value at index X: Y".
If the index is out of bounds, display "Invalid index!".
If the array is null, display "Array is not initialized!".*/
package com.capgeminitraining.week4.day4exceptionalhandling;

import java.util.Scanner;

public class ArrayOperations {
    public static String getValueAtIndex(int[] array, int index) {
        try {
            return "Value at index " + index + ": " + array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Invalid index!";
        } catch (NullPointerException e) {
            return "Array is not initialized!";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter index to retrieve value: ");
        int index = scanner.nextInt();

        System.out.println(getValueAtIndex(array, index));
        scanner.close();
    }
}
