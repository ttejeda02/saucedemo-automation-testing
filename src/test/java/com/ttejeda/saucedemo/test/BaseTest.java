package com.ttejeda.saucedemo.test;

import com.ttejeda.saucedemo.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * BaseTest class provides the foundation for all test classes.
 * It contains the common setup and teardown methods that are executed
 * before and after each test method.
 * <p>
 * This class is responsible for initializing the WebDriver before each test
 * and cleaning up after each test by quitting the WebDriver instance.
 * </p>
 */

public class BaseTest {
    protected WebDriver driver;

    /**
     * Initializes the WebDriver before each test method.
     * <p>
     * This method calls {@link DriverSingleton#getDriver()} to obtain a new
     * instance of the WebDriver. It runs before the execution of each test
     * method to ensure that a fresh WebDriver instance is available.
     * </p>
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }

    /**
     * Quits the WebDriver and removes the instance after each test method.
     * <p>
     * This method calls {@link DriverSingleton#quitDriver()} to close the browser
     * and properly clean up the WebDriver instance, ensuring there are no lingering
     * processes after each test. It runs after the execution of each test method.
     * </p>
     */
    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        DriverSingleton.quitDriver();
    }
}
