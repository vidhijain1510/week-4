/*🔟Validate an IP Address
A valid IPv4 address consists of four groups of numbers (0-255) separated by dots.*/

package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidator {
    public static boolean isValidIPAddress(String ip) {
        //Regex for IPv4 validation
        String regex = "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\."
                + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\."
                + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\."
                + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        //Returning whether IP matches the pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testIPs = {"192.168.1.1", "255.255.255.255", "256.100.50.25", "123.045.067.089"};

        for (String ip : testIPs) {
            System.out.println(ip + " is " + (isValidIPAddress(ip) ? "Valid" : "Invalid"));
        }
    }
}
