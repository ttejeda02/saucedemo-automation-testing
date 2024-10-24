package com.ttejeda.saucedemo.service;

import com.ttejeda.saucedemo.model.User;


/**
 * Utility class to create User objects using test data.
 */
public class UserCreator {
    private static final String TEST_USERNAME = "testdata.username";
    private static final String TEST_PASSWORD = "testdata.password";
    private static final String TEST_FIRST_NAME = "testdata.first.name";
    private static final String TEST_LAST_NAME = "testdata.last.name";
    private static final String TEST_POSTAL_CODE = "testdata.postal.code";

    //special options for negative tests
    private static final String TEST_USERNAME_LOCKED = "testdata.username.locked";
    private static final String TEST_USERNAME_ERROR = "testdata.username.error";

    /**
     * Creates a Standard User object based on test data read from "environment" system property (-Denvironment flag).
     * @return User without data user instance.
     */
    public static User createUserWithoutUserData(){
        return new User(
                TestDataReader.getTestData(TEST_USERNAME),
                TestDataReader.getTestData(TEST_PASSWORD),
                "",
                "",
                ""
        );
    }

    /**
     * Creates a Standard User object based on test data read from "environment" system property (-Denvironment flag).
     * @return User with data user instance.
     */
    public static User createUserWithUserData(){
        return new User(
                TestDataReader.getTestData(TEST_USERNAME),
                TestDataReader.getTestData(TEST_PASSWORD),
                TestDataReader.getTestData(TEST_FIRST_NAME),
                TestDataReader.getTestData(TEST_LAST_NAME),
                TestDataReader.getTestData(TEST_POSTAL_CODE)
        );
    }

    /**
     * Creates a Locked User object based on test data read from "environment" system property (-Denvironment flag).
     * @return Locked User without data user instance.
     */
    public static User createLockedUserWithoutUserData(){
        return new User(
                TestDataReader.getTestData(TEST_USERNAME_LOCKED),
                TestDataReader.getTestData(TEST_PASSWORD),
                "",
                "",
                ""
        );
    }

    /**
     * Creates an Error User object based on test data read from "environment" system property (-Denvironment flag).
     * @return Error User without data user instance.
     */
    public static User createErrorUserWithoutUserData(){
        return new User(
                TestDataReader.getTestData(TEST_USERNAME_ERROR),
                TestDataReader.getTestData(TEST_PASSWORD),
                "",
                "",
                ""
        );
    }
}
