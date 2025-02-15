/*2️⃣ Testing String Utility Methods
Problem:
Create a StringUtils class with the following methods:
reverse(String str): Returns the reverse of a given string.
isPalindrome(String str): Returns true if the string is a palindrome.
toUpperCase(String str): Converts a string to uppercase.
Write JUnit test cases to verify that these methods work correctly.
*/
package com.capgeminitraining.week4.day5regexjunit.junit;

public class StringUtils {

    //Method to reverse a string
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    //Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed); // Case-insensitive palindrome check
    }

    //Method to convert a string to uppercase
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}

