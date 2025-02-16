package com.capgeminitraining.week4.day6annotationsreflection.annotations.advancedlevel;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class RoleBasedAccessControlTest {
    @Test
    void testAdminAccessAllowed() {
        SecureService service = new SecureService();
        User adminUser = new User("ADMIN");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SecureService.executeMethod(adminUser, service, "performAdminTask");

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Admin task executed!"), "Admin should be able to execute admin tasks");
    }

    @Test
    void testUserAccessDenied() {
        SecureService service = new SecureService();
        User normalUser = new User("USER");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SecureService.executeMethod(normalUser, service, "performAdminTask");

        String output = outputStream.toString().trim();
        assertTrue(output.contains("❌ Access Denied"), "User should be denied access to admin tasks");
    }

    @Test
    void testGeneralTaskAllowedForAll() {
        SecureService service = new SecureService();
        User normalUser = new User("USER");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SecureService.executeMethod(normalUser, service, "performGeneralTask");

        String output = outputStream.toString().trim();
        assertTrue(output.contains("General task executed!"), "General tasks should be accessible to all");
    }

}