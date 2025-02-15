/*Censor Bad Words in a Sentence
Given a list of bad words, replace them with ****.
🔹 Example Input:
"This is a damn bad example with some stupid words."
🔹 Expected Output:
"This is a **** bad example with some **** words."*/

package com.capgeminitraining.week4.day5regexjunit.regex.extractionproblems;

public class CensorBadWords {
    //Method  to censor bad words
    public static String censorWords(String text, String[] badWords){
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        } //Regex to censor bad words from text.

        return text;
    }

    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};
        System.out.println(censorWords(text, badWords));
    }
}
