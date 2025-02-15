/*Basic Regex Problems
1️⃣ Validate a Username
A valid username:
Can only contain letters (a-z, A-Z), numbers (0-9), and underscores (_)
Must start with a letter
Must be between 5 to 15 characters long
🔹 Example Inputs & Outputs
✅ "user_123" → Valid
❌ "123user" → Invalid (starts with a number)
❌ "us" → Invalid (too short)*/
package com.capgeminitraining.week4.day5regexjunit.regex.basicregexproblems;

import java.util.regex.*;
import java.util.Scanner;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {

        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$"; //Regex which validates the username

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);

        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Taking user input for username
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        if (isValidUsername(username)) {
            System.out.println("Valid username!");
        }
        if(!isValidUsername(username)){
            System.out.println("Invalid username!");
        }
        scanner.close();
    }
}


