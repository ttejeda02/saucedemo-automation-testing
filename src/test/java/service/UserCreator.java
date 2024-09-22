package service;

import model.User;

public class UserCreator {
    private static final String TEST_USERNAME_STANDARD = "standard_user";
    private static final String TEST_USERNAME_LOCKED_OUT_USER = "locked_out_user";
    private static final String TEST_USERNAME_PROBLEM = "problem_user";
    private static final String TEST_USERNAME_PERFORMANCE_GLITCH_USER = "performance_glitch_user";
    private static final String TEST_USERNAME_ERROR = "error_user";
    private static final String TEST_USERNAME_VISUAL = "visual_user";
    private static final String TEST_PASSWORD = "secret_sauce";
    private static final String TEST_FIRST_NAME = "John";
    private static final String TEST_LAST_NAME = "Doe";
    private static final Integer TEST_POSTAL_CODE = 35000;

    public static User createStandardUserWithoutUserData(){
        return new User(
                TEST_USERNAME_STANDARD,
                TEST_PASSWORD,
                "",
                "",
                0
        );
    }

    public static User createStandardUserWithUserData(){
        return new User(
                TEST_USERNAME_STANDARD,
                TEST_PASSWORD,
                TEST_FIRST_NAME,
                TEST_LAST_NAME,
                TEST_POSTAL_CODE
        );
    }

    public static User createLockedOutUserWithUserData(){
        return new User(
                TEST_USERNAME_LOCKED_OUT_USER,
                TEST_PASSWORD,
                "",
                "",
                0
        );
    }

    public static User createProblemUserWithUserData(){
        return new User(
                TEST_USERNAME_PROBLEM,
                TEST_PASSWORD,
                TEST_FIRST_NAME,
                TEST_LAST_NAME,
                TEST_POSTAL_CODE
        );
    }

    public static User createPerformanceGlitchUserWithUserData(){
        return new User(
                TEST_USERNAME_PERFORMANCE_GLITCH_USER,
                TEST_PASSWORD,
                TEST_FIRST_NAME,
                TEST_LAST_NAME,
                TEST_POSTAL_CODE
        );
    }

    public static User createErrorUserWithUserData(){
        return new User(
                TEST_USERNAME_ERROR,
                TEST_PASSWORD,
                TEST_FIRST_NAME,
                TEST_LAST_NAME,
                TEST_POSTAL_CODE
        );
    }

    public static User createVisualUserWithUserData(){
        return new User(
                TEST_USERNAME_VISUAL,
                TEST_PASSWORD,
                TEST_FIRST_NAME,
                TEST_LAST_NAME,
                TEST_POSTAL_CODE
        );
    }
}
