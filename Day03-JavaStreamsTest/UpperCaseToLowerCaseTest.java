package com.capgeminitraining.week4.day3javastreams;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class UppercaseToLowercaseConverterTest {

    private static final String INPUT_FILE_PATH = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\test\\resources\\testInput.txt";
    private static final String OUTPUT_FILE_PATH = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\test\\resources\\testOutput.txt";

    @BeforeEach
    void setUp() throws IOException {
        //Creating a test input file with mixed case text
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT_FILE_PATH))) {
            writer.write("HELLO WORLD\n");
            writer.write("JAVA PROGRAMMING\n");
            writer.write("WELCOME!\n");
        }
    }

    @Test
    void testConvertToLowercase() throws IOException {
        UpperCaseToLowerCase.convertToLowerCase(INPUT_FILE_PATH, OUTPUT_FILE_PATH);
        File outputFile = new File(OUTPUT_FILE_PATH);
        assertTrue(outputFile.exists());


        try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE_PATH))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                switch (lineNumber) {
                    case 1:
                        assertEquals("hello world", line);
                        break;
                    case 2:
                        assertEquals("java programming", line);
                        break;
                    case 3:
                        assertEquals("welcome!", line);
                        break;
                    default:
                        fail("Unexpected line found.");
                }
                lineNumber++;
            }
        }
    }
}