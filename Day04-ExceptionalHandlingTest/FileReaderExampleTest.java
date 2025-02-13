package com.capgeminitraining.week4.day4exceptionalhandling;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderExampleTest {

    @Test
    void testReadFile_FileExists() throws IOException {
        // Creating a temporary file with some content
        String testFileName = "testData.txt";
        File file = new File(testFileName);
        FileWriter writer = new FileWriter(file);
        writer.write("Hello, World!");
        writer.close();

        // Testing the method
        String result = FileReader.readFile(testFileName);
        assertEquals("Hello, World!", result);

        // Cleaning up
        file.delete();
    }

    @Test
    void testReadFile_FileNotFound() {
        String result = FileReader.readFile("nonexistent.txt");
        assertEquals("File not found", result);
    }
}
