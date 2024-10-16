package com.ttejeda.saucedemo.pages;

import com.ttejeda.saucedemo.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;

    @FindBy (id = "first-name")
    WebElement firstNameInput;

    @FindBy (id = "last-name")
    WebElement lastNameInput;

    @FindBy (id = "postal-code")
    WebElement postalCodeInput;

    @FindBy (id = "continue")
    WebElement checkoutOverviewPageButton;

    @FindBy (id = "cancel")
    WebElement returnToTheCartButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void fillUserFormInput(User user) {
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        postalCodeInput.sendKeys(user.getPostalCode().toString());
    }

    public void goToCheckoutOverviewPage() {
        checkoutOverviewPageButton.click();
    }

    public void returnToTheCartPage() {
        returnToTheCartButton.click();
    }
}
