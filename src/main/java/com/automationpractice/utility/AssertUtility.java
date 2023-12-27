package com.automationpractice.utility;

import org.testng.Assert;

public class AssertUtility {

    public static void assertEquals(Object actual, Object expected, Object value) {
        try {
            Assert.assertEquals(actual, expected);
            Log.info("Assert value of " + value + " - " + actual + " equals " + expected);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void assertContains(String actual, String expected, String value) {
        try {
            Assert.assertTrue(actual.contains(expected));
        } catch (AssertionError e) {
            Log.info("Assert value of " + value + " - " + actual + " equals " + expected);
            Assert.fail("Assertion Failed: " + e.getMessage());
        }
    }
}
