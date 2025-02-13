package com.capgeminitraining.week4.day3javastreams;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

class ReadLargeFileTest {

    private static Path tempFile;

    @BeforeAll
    static void setUp() throws IOException {
        //Generating large file
        tempFile = Files.createTempFile("testLargeFile", ".txt");
        BufferedWriter writer = Files.newBufferedWriter(tempFile);

        //Writing sample data
        writer.write("This is a normal log line.\n");
        writer.write("Warning: Disk space low.\n");
        writer.write("ERROR: Out of memory occurred.\n");
        writer.write("Another line without issues.\n");
        writer.write("Critical ERROR detected in the system.\n");

        writer.close();
    }

    @Test
    void testReadLargeFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile.toFile()))) {
            String line;
            int errorCount = 0;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.toLowerCase().contains("error")) {
                    errorCount++;
                }
            }
            assertEquals(2, errorCount);
        } catch (IOException e) {
            fail("Exception should not occur: " + e.getMessage());
        }
    }
    @AfterAll
    static void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }
}
