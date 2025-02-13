package com.capgeminitraining.week4.day4exceptionalhandling;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileReader2Test {

    @Test
    void testFileExists() throws IOException {
        // Creating a temporary file with content
        String testFileName = "testInfo.txt";
        File file = new File(testFileName);
        FileWriter writer = new FileWriter(file);
        writer.write("Hello, World!\nSecond Line");
        writer.close();

        // Testing method
        String result = FileReader2.readFirstLine(testFileName);
        assertEquals("Hello, World!", result);

        // Cleaning up
        file.delete();
    }

    @Test
    void testFileNotFound() {
        String result = FileReader2.readFirstLine("nonexistent.txt");
        assertEquals("Error reading file", result);
    }
}
