/*1️⃣3️⃣ Extract Currency Values from a Text
🔹 Example Text:
"The price is $45.99, and the discount is 10.50."
🔹 Expected Output:
$45.99, 10.50*/
package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCurrencyValues {
    //Method to extract currency value
    public static List<String> extractCurrency(String text){
        String regex = "\\$?\\d+(\\.\\d{2})?"; //Regex for extracting currency values

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        //List to store extracted values
        List<String> values = new ArrayList<>();

        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        List<String> values = extractCurrency(text);

        if (values.isEmpty()) {
            System.out.println("No currency value found.");
        }
        if(!values.isEmpty()){
            System.out.println("Extracted values: " + String.join(", ", values));
        }
    }
}
