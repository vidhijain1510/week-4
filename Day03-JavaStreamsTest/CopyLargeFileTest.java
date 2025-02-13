package com.capgeminitraining.week4.day3javastreams;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class CopyLargeFileTest {
    private static final String SOURCE_FILE = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\test\\resources\\30MB_text_file.txt";
    private static final String DEST_FILE_BUFFERED = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\test\\resources\\test_dest_buffered.txt";
    private static final String DEST_FILE_UNBUFFERED = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\test\\resources\\test_dest_unbuffered.txt";
    private static final int BUFFER_SIZE = 4096;

    @BeforeAll
    static void setUp() throws IOException {
        generateTestFile(SOURCE_FILE, 5 * 1024 * 1024);
    }

    @AfterAll
    static void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(SOURCE_FILE));
        Files.deleteIfExists(Paths.get(DEST_FILE_BUFFERED));
        Files.deleteIfExists(Paths.get(DEST_FILE_UNBUFFERED));
    }

    @Test
    void testCopyFileBuffered() throws IOException {
        CopyLargeFile.copyFileBuffered(SOURCE_FILE, DEST_FILE_BUFFERED);
        assertTrue(Files.exists(Paths.get(DEST_FILE_BUFFERED)));
        assertEquals(Files.size(Paths.get(SOURCE_FILE)), Files.size(Paths.get(DEST_FILE_BUFFERED)));
    }

    @Test
    void testCopyFileUnbuffered() throws IOException {
        CopyLargeFile.copyFileUnbuffered(SOURCE_FILE, DEST_FILE_UNBUFFERED);
        assertTrue(Files.exists(Paths.get(DEST_FILE_UNBUFFERED)));
        assertEquals(Files.size(Paths.get(SOURCE_FILE)), Files.size(Paths.get(DEST_FILE_UNBUFFERED)));
    }

    private static void generateTestFile(String filePath, int size) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] data = new byte[BUFFER_SIZE];
            for (int i = 0; i < size / BUFFER_SIZE; i++) {
                bos.write(data);
            }
        }
    }
}