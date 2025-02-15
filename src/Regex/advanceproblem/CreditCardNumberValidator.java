/*1️⃣1️⃣ Validate a Credit Card Number (Visa, MasterCard, etc.)
A Visa card number starts with 4 and has 16 digits.
A MasterCard starts with 5 and has 16 digits.*/
package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardNumberValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        //Regex for Visa (starts with 4, 16 digits) and MasterCard (starts with 5, 16 digits)
        String regex = "^(4\\d{15}|5\\d{15})$"; 

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);

        //Returning whether card number matches the pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] cards = {"4457487982548844", "5574879825488445", "6574879825488441", "4574879825488445"};

        for (String card : cards) {
            System.out.println(card + " is " + (isValidCreditCard(card) ? "Valid" : "Invalid"));
        }
    }
}
