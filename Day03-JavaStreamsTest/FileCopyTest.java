package com.capgeminitraining.week4.day3javastreams;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class FileCopyTest {
    private static final String SOURCE_FILE = "test_source.txt";
    private static final String DESTINATION_FILE = "test_destination.txt";

    @BeforeEach
    void setUp() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(SOURCE_FILE)) {
            fos.write("Hello, this is a test file!".getBytes());
        }
    }

    @AfterEach
    void tearDown() {
        new File(SOURCE_FILE).delete();
        new File(DESTINATION_FILE).delete();
    }

    @Test
    void testFileCopySuccess() {
        FileCopy.main(new String[]{});
        File destFile = new File(DESTINATION_FILE);
        assertTrue(destFile.exists(), "Destination file should exist after copying");
        assertEquals(readFile(SOURCE_FILE), readFile(DESTINATION_FILE), "File contents should match");
    }

    @Test
    void testMissingSourceFile() {
        new File(SOURCE_FILE).delete();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outputStream));
        FileCopy.main(new String[]{});

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Error: Source file does not exist"), "Expected error message for missing source file");
    }

    private String readFile(String filePath) {
        try {
            return new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filePath)));
        } catch (IOException e) {
            return null;
        }
    }
}
