package com.capgeminitraining.week4.day5regexjunit.junit.advancejunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), 0.01, "0°C should be 32°F");
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), 0.01, "100°C should be 212°F");
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40), 0.01, "-40°C should be -40°F");
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), 0.01, "32°F should be 0°C");
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212), 0.01, "212°F should be 100°C");
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40), 0.01, "-40°F should be -40°C");
    }
}
