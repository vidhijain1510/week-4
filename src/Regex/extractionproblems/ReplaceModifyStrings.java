/* Replace and Modify Strings
8️⃣ Replace Multiple Spaces with a Single Space
🔹 Example Input:
"This   is an   example with    multiple   spaces."
🔹 Expected Output:
"This is an example with multiple spaces."*/
package com.capgeminitraining.week4.day5regexjunit.regex.extractionproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceModifyStrings {
    //Method to Replace and Modify Strings
    public static String replaceModifyStrings(String text){
        String regex = "\\s+";//Regex to replace and modify strings

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return matcher.replaceAll(" ");
    }

    public static void main(String[] args) {
        String text = "This   is an   example with    multiple   spaces.";
        System.out.println("Original text: " + text);
        System.out.println("Modified text: "+ replaceModifyStrings(text));
    }
}
