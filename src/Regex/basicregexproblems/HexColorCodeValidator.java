/*Validate a Hex Color Code
A valid hex color:
Starts with a #
Followed by 6 hexadecimal characters (0-9, A-F, a-f).
🔹 Example Inputs & Outputs
✅ "#FFA500" → Valid
✅ "#ff4500" → Valid
❌ "#123" → Invalid (too short)*/
package com.capgeminitraining.week4.day5regexjunit.regex.basicregexproblems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColorCodeValidator {
    //Method to validate Hex Color Code
    public static boolean isValidHexColorCode(String hexColorCode){
        String regex = "^[#][a-fA-F0-9]{6}"; //Regex to Validate Hex Color Code

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(hexColorCode);

        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Taking user input for Hex Color Code
        System.out.println("Enter Hex Color Code: ");
        String hexColorCode = input.nextLine();

        //The HexColorCode should have 6 hexadecimal characters and a # so lenght of string will become 7.
        if(hexColorCode.length()<7){
            System.out.println("Invalid! (too short)");
        }

        if(hexColorCode.length()>7){
            System.out.println("Invalid! (too long)");
        }

        if (hexColorCode.length() == 7) {
            if(isValidHexColorCode(hexColorCode)){
                System.out.println("Valid!");
            }

            if(!isValidHexColorCode(hexColorCode)){
                System.out.println("invalid!");
            }
        }
    }
}
