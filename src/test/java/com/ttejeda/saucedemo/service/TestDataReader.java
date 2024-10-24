package com.ttejeda.saucedemo.service;

import java.util.ResourceBundle;


/**
 *  Utility class to read test data from a ResourceBundle based on environment.
 */
public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    /**
     * Retrieves test data value associate with the specified key.
     * @param key The key to look up in the test data ResourceBundle.
     * @return The test data value associate with the key.
     */
    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }

}
