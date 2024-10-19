package com.ttejeda.saucedemo.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


/**
 * Singleton class to manage WebDriver instance for browser automation.
 */
public class DriverSingleton {
    private static WebDriver driver;

    /**
     * Retrieves the WebDriver instance. If the instance is not already initialized (null),
     * it initializes it based on the "browser" system property (-Dbrowser flag).
     * If the "browser" property is not provided, Chrome will be used as the default browser.
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver == null){
            String browser = System.getProperty("browser", "chrome");
            switch (browser.toLowerCase()) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--remote-debugging-port=9222");

                    driver = new ChromeDriver(options);
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");
                    options.addPreference("security.sandbox.content.enabled", false);
                    options.addPreference("dom.webnotifications.enabled", false);
                    options.addPreference("network.proxy.allow_hijacking_localhost", true);

                    driver = new FirefoxDriver(options);
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--headless");
                    options.addArguments("disable-dev-shm-usage");
                    options.addArguments("no-sandbox");
                    options.addArguments("disable-notifications");

                    driver = new EdgeDriver(options);
                    break;
                }
                default: {
                    throw new RuntimeException("Unsupported browser: " + System.getProperty("browser"));
                }
            }
        }

        return driver;
    }

    /**
     * Quits the WebDriver instance and sets it to null
     */
    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
