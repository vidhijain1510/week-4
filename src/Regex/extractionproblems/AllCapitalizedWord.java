/*Extract All Capitalized Words from a Sentence
🔹 Example Text:
"The Eiffel Tower is in Paris and the Statue of Liberty is in New York."
🔹 Expected Output:
Eiffel, Tower, Paris, Statue, Liberty, New, York
 */
package com.capgeminitraining.week4.day5regexjunit.regex.extractionproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllCapitalizedWord {

    //Method to extract all Capitalized words from text
    public static List<String> extractWords(String text){
        List<String> words = new ArrayList<>();

        String regex = "\\b[A-Z][a-z]*\\b"; //Regex for capitalized text

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        List<String> words = extractWords(text);
        for(String word : words){
            System.out.print(word + ", ");
        }
    }
}
