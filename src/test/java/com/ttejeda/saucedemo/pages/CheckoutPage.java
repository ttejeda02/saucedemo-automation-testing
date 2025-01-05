package com.ttejeda.saucedemo.pages;

import com.ttejeda.saucedemo.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    // WebDriver instance
    private WebDriver driver;

    // Page elements used in the Checkout form.
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement checkoutOverviewPageButton;

    @FindBy(id = "cancel")
    private WebElement returnToTheCartButton;

    /**
     * Constructor that initializes the page elements using the provided WebDriver.
     *
     * @param driver The WebDriver used to interact with the page.
     */
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this); // Initialize the WebElements
    }

    /**
     * Fills out the user form on the Checkout page with the provided user data.
     *
     * @param user The User object containing the user's information to be filled in the form.
     */
    public void fillUserFormInput(User user) {
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        postalCodeInput.sendKeys(user.getPostalCode().toString());
    }

    /**
     * Clicks the button to proceed to the Checkout Overview page.
     */
    public void goToCheckoutOverviewPage() {
        checkoutOverviewPageButton.click();
    }

    /**
     * Clicks the button to return to the Cart page.
     */
    public void returnToTheCartPage() {
        returnToTheCartButton.click();
    }
}
