/*1️⃣2️⃣ Extract Programming Language Names from a Text
🔹 Example Text:
"I love Java, Python, and JavaScript, but I haven't tried Go yet."
🔹 Expected Output:
Java, Python, JavaScript, Go*/
package com.capgeminitraining.week4.day5regexjunit.regex.advanceproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractingProgrammingLanguage {
    public static List<String> extractLanguages(String text) {
        //List of programming languages to match
        String regex = "\\b(JavaScript|Java|Python|Go|C\\+\\+|C#|Ruby|Swift|PHP|Kotlin|Rust|TypeScript)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        //List to store extracted languages
        List<String> languages = new ArrayList<>();

        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> languages = extractLanguages(text);

        if (languages.isEmpty()) {
            System.out.println("No programming languages found.");
        }
        if(!languages.isEmpty()){
            System.out.println("Extracted Languages: " + String.join(", ", languages));
        }
    }
}
