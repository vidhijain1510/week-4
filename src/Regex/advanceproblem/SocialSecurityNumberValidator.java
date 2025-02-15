/*1️⃣5️⃣ Validate a Social Security Number (SSN)
🔹 Example Input:
"My SSN is 123-45-6789."
🔹 Expected Output:
✅ "123-45-6789" is valid
❌ "123456789" is invalid*/
package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SocialSecurityNumberValidator {
    public static boolean isValidSSN(String ssn) {
        //Regex pattern for SSN format: XXX-XX-XXXX
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String SocialSecurityNumber1 = "123-45-6789";
        String SocialSecurityNumber2 = "123456789";

        System.out.println("\"" + SocialSecurityNumber1 + "\" is " + (isValidSSN(SocialSecurityNumber1) ? "valid" : "invalid"));
        System.out.println("\"" + SocialSecurityNumber2 + "\" is " + (isValidSSN(SocialSecurityNumber2) ? "valid" : "invalid"));
    }
}
