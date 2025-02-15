package com.capgeminitraining.week4.day5regexjunit.junit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {
    private DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(db.isConnected(), "Database should be connected.");
    }

    @Test
    void testConnectionClosed() {
        db.disconnect();
        assertFalse(db.isConnected(), "Database should be disconnected.");
    }
}
