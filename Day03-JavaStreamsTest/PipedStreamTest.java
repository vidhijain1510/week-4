package com.capgeminitraining.week4.day3javastreams;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class PipedStreamExampleTest {
    private static final String EXPECTED_OUTPUT = "Hello from WriterThread!";
    @Test
    void testPipedStreamCommunication() {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();

        try {
            pipedOutputStream.connect(pipedInputStream);

            WriterThread writerThread = new WriterThread(pipedOutputStream);
            ReaderThread readerThread = new ReaderThread(pipedInputStream);

            writerThread.start();
            readerThread.start();

            writerThread.join();
            readerThread.join();

            assertEquals(EXPECTED_OUTPUT, EXPECTED_OUTPUT, "The data read by ReaderThread should match the written data.");
        } catch (IOException | InterruptedException e) {
            fail("An error occurred during the test: " + e.getMessage());
        }
    }
}