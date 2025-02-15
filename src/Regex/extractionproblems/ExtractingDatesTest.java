package com.capgeminitraining.week4.day5regexjunit.regex.extractionproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ExtractingDatesTest {

    @Test
    void testValidDates() {
        String text = "Events on 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> result = ExtractingDates.extractdates(text);
        assertEquals(List.of("12/05/2023", "15/08/2024", "29/02/2020"), result);
    }
}
