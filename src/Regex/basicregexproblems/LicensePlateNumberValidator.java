/*Validate a License Plate Number
License plate format: Starts with two uppercase letters, followed by four digits.
Example: "AB1234" is valid, but "A12345" is invalid.*/
package com.capgeminitraining.week4.day5regexjunit.regex.basicregexproblems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicensePlateNumberValidator {
    //Method which validates the License plate number
    public static boolean isValidLicense(String LicensePlateNumber){

        String regex = "^[A-Z]{2}[0-9]{4}$";//Regex for license plate number

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(LicensePlateNumber);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Taking user input for Lincense plate number
        System.out.println("Enter the License plate number: ");
        String LicensePlateNumber = input.nextLine();

         if(isValidLicense(LicensePlateNumber)){
             System.out.println("Valid License Plate number!");
         }
         if(!isValidLicense(LicensePlateNumber)){
             System.out.println("Invalid License Plate number!");
         }
    }
}
