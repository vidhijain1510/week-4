/*Extraction Problems
4️⃣ Extract All Email Addresses from a Text
🔹 Example Text:
"Contact us at support@example.com and info@company.org"
🔹 Expected Output:
support@example.com
info@company.org*/
package com.capgeminitraining.week4.day5regexjunit.regex.extractionproblems;

import java.util.regex.*;
import java.util.*;

public class AllEmailExtractor {
    //Method to extract emails from text
    public static List<String> extractEmails(String text) {
        //List to save all elements
        List<String> emails = new ArrayList<>();
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"; //Regex for email

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";

        List<String> emails = extractEmails(text);
        for (String email : emails) {
            System.out.println(email);
        }
    }
}

