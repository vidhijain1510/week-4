/*7️⃣ Extract Links from a Web Page
🔹 Example Text:
"Visit https://www.google.com and http://example.org for more info."
🔹 Expected Output:
https://www.google.com, http://example.org*/
package com.capgeminitraining.week4.day5regexjunit.regex.extractionproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractingLinks {
    //Method to extract links from text
    public static List<String> extractLinks(String text){
        String regex = "https?://[a-zA-Z0-9./_-]+" ;//Regex to extract links from text

        List<String> links = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            links.add(matcher.group());
        }
        return links;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info";

        List<String> links = extractLinks(text);
        for(String link : links){
            System.out.print(link + ", ");
        }
    }
}
