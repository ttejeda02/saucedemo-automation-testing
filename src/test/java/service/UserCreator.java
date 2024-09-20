package service;

import model.User;

public class UserCreator {
    private static final String TEST_USERNAME = "standard_user";
    private static final String TEST_PASSWORD = "secret_sauce";
    private static final String TEST_FIRST_NAME = "John";
    private static final String TEST_LAST_NAME = "Doe";
    private static final Integer TEST_POSTAL_CODE = 35000;

    public static User createUserWithoutUserData(){
        return new User(
                TEST_USERNAME,
                TEST_PASSWORD,
                "",
                "",
                0
        );
    }

    public static User createUserWithUserData(){
        return new User(
                TEST_USERNAME,
                TEST_PASSWORD,
                TEST_FIRST_NAME,
                TEST_LAST_NAME,
                TEST_POSTAL_CODE
        );
    }
}
