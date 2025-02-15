package com.capgeminitraining.week4.day5regexjunit.junit;

import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {
    private static final String TEST_FILE = "testfile.txt";
    private FileProcessor fileProcessor;

    @BeforeEach
    void setUp() {
        fileProcessor = new FileProcessor();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE)); // Cleanup test file
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, File Testing!";

        fileProcessor.writeToFile(TEST_FILE, content);
        String readContent = fileProcessor.readFromFile(TEST_FILE);

        assertEquals(content, readContent, "The written and read content should match.");
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        fileProcessor.writeToFile(TEST_FILE, "Sample content");

        assertTrue(Files.exists(Path.of(TEST_FILE)), "File should exist after writing.");
    }

    @Test
    void testReadNonExistentFileThrowsException() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"),
                "Reading a non-existent file should throw IOException.");
    }
}
