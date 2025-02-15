package com.capgeminitraining.week4.day5regexjunit.regex.extractionproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CensorBadWordsTest {

    @Test
    void testCensorWords() {
        assertEquals(
                "This is a **** bad example with some **** words!",
                CensorBadWords.censorWords("This is a damn bad example with some stupid words!",
                        new String[]{"damn", "stupid"})
        );

        assertEquals(
                "No bad words here!",
                CensorBadWords.censorWords("No bad words here!",
                        new String[]{"damn", "stupid"})
        );

        assertEquals(
                "****! That was a **** move.",
                CensorBadWords.censorWords("Damn! That was a stupid move.",
                        new String[]{"damn", "stupid"})
        );

        assertEquals(
                "Damnation is not the same as ****.",
                CensorBadWords.censorWords("Damnation is not the same as damn.",
                        new String[]{"damn"})
        );

        assertEquals(
                "stupidly done is not the same as ****.",
                CensorBadWords.censorWords("stupidly done is not the same as stupid.",
                        new String[]{"stupid"})
        );
    }
}
