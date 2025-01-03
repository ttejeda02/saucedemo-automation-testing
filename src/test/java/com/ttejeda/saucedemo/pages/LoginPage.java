package com.ttejeda.saucedemo.pages;

import com.ttejeda.saucedemo.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * LoginPage class represents the login page of the Saucedemo application.
 * It contains WebElements for the username, password input fields, and the login button.
 * It also provides methods to interact with the page, such as logging in with user credentials
 * and retrieving the current URL of the page.
 */
public class LoginPage {

    // URL of the login page
    private static final String URL = "https://www.saucedemo.com/";

    // WebDriver instance
    WebDriver driver;

    // WebElements for the username input, password input, and login button
    @FindBy (id = "user-name")
    WebElement usernameInput;

    @FindBy (id = "password")
    WebElement passwordInput;

    @FindBy (id = "login-button")
    WebElement loginButton;

    /**
     * Constructor initializes the LoginPage object by setting up the WebDriver
     * and navigating to the login page URL.
     *
     * @param driver the WebDriver instance for interacting with the browser
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        this.driver.get(URL);
        PageFactory.initElements(this.driver, this); // Initialize the WebElements
    }

    /**
     * Performs login using the provided user credentials.
     *
     * @param user the User object containing the login credentials
     */
    public void accountLogin(User user) {
        usernameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
    }

    /**
     * Returns the current URL of the page.
     *
     * @return the current URL as a string
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
