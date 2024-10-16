package com.ttejeda.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage {
    WebDriver driver;

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartSauceLabsBackpack;

    @FindBy (id = "add-to-cart-sauce-labs-bike-light")
    WebElement addToCartSauceLabsBikeLight;

    @FindBy (id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addToCartSauceLabsBolt;

    @FindBy (id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addToCartSauceLabsFleeceJacket;

    @FindBy (id = "add-to-cart-sauce-labs-onesie")
    WebElement addToCartSauceLabsOnesie;

    @FindBy (id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement addToCartTestAllthingsTShirt;

    @FindBy (xpath = "//a[@data-test=\"shopping-cart-link\"]")
    WebElement cartPageButton;

    @FindBy (className = "inventory_item_name")
    List<WebElement> productsListInTheCart;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartSauceLabsBackpack() {
        waitForElementToBeVisible(addToCartSauceLabsBackpack);
        addToCartSauceLabsBackpack.click();
    }

    public void clickAddToCartSauceLabsBikeLight() {
        waitForElementToBeVisible(addToCartSauceLabsBikeLight);
        addToCartSauceLabsBikeLight.click();
    }

    public void clickAddToCartSauceLabsBolt() {
        addToCartSauceLabsBolt.click();
    }

    public void clickAddToCartSauceLabsFleeceJacket() {
        waitForElementToBeVisible(addToCartSauceLabsFleeceJacket);
        addToCartSauceLabsFleeceJacket.click();
    }

    public void clickAddToCartSauceLabsOnesie() {
        waitForElementToBeVisible(addToCartSauceLabsOnesie);
        addToCartSauceLabsOnesie.click();
    }

    public void clickAddToCartTestAllthingsTShirt() {
        waitForElementToBeVisible(addToCartTestAllthingsTShirt);
        addToCartTestAllthingsTShirt.click();
    }

    public void goToTheCartPage(){
        waitForElementToBeVisible(cartPageButton);
        cartPageButton.click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    private void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public String[] getProductsListInTheCart() {
        String[] productsInCart = new String[productsListInTheCart.size()];
        for (int i = 0; i < productsListInTheCart.size(); i++) {
            productsInCart[i] = productsListInTheCart.get(i).getText();
        }

        return productsInCart;
    }
}
