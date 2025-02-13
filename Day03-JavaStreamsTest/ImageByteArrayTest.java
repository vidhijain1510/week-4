package com.capgeminitraining.week4.day3javastreams;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;


class ImageByteArrayConversionTest {

    private static final String ORIGINAL_IMAGE_PATH = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\test\\resources\\OriginalImage.jpg"; // Provide the original image path
    private static final String NEW_IMAGE_PATH = "C:\\Users\\Lenovo\\OneDrive\\Desktop\\CapgemTrain\\week4\\src\\test\\resources\\NewImage.jpg";     // Provide the new image path

    @Test
    void testImageConversionAndVerification() throws IOException {
        //Converting the original image to a byte array
        byte[] imageBytes = ImageByteArray.imageToByteArray(ORIGINAL_IMAGE_PATH);

        //Writing the byte array back to a new image file
        ImageByteArray.byteArrayToImage(imageBytes, NEW_IMAGE_PATH);

        //Verifying that the new image file is created and identical to the original image
        File newImageFile = new File(NEW_IMAGE_PATH);

        //Checking if the new image file exists
        assertTrue(newImageFile.exists(), "New image file should be created.");

        //Verifying that the new image file is identical to the original
        boolean areIdentical = ImageByteArray.verifyImages(ORIGINAL_IMAGE_PATH, NEW_IMAGE_PATH);

        assertTrue(areIdentical, "The new image should be identical to the original.");
    }
}