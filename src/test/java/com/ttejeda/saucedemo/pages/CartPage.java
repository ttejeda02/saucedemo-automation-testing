package com.ttejeda.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


/**
 * This class represents the Cart page of the Saucedemo application.
 * It contains WebElements for removing products from the cart, as well as lists of products
 * and their prices.
 * It also includes buttons for navigating to the Checkout page or returning to the Inventory page.
 * The class provides methods for interacting with the cart, such as removing items,
 * proceeding to checkout, and navigating back to the inventory page.
 */

public class CartPage {
    // Webdriver instance
    WebDriver driver;

    // Web elements for removing products from the cart
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeSauceLabsBackpackInCart;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeSauceLabsBoltTShirtInCart;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    WebElement removeSauceLabsFleeceJacketInCart;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeSauceLabsBikeLightInCart;

    @FindBy(id = "remove-sauce-labs-onesie")
    WebElement removeSauceLabsOnesieInCart;

    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    WebElement removeTestAllThingsTShirtInCart;

    // Web element for the checkout button
    @FindBy(id = "checkout")
    WebElement checkoutWebPageButton;

    // Web element to return to the Inventory page
    @FindBy(id = "continue-shopping")
    WebElement returnToTheInventoryPage;

    // List of WebElements representing the products currently in the cart
    @FindBy(xpath = "//div[@class='cart_item_label']/a[@href='#']")
    List<WebElement> productsInCart;

    // List of WebElements representing the prices of the products in the cart
    @FindBy(className = "inventory_item_price")
    List<WebElement> priceList;

    /**
     * Constructor to initialize the CartPage with the provided WebDriver.
     * Initializes the page elements using PageFactory.
     *
     * @param driver WebDriver instance used to interact with the web browser.
     */
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this); // Initialize the WebElements
    }

    /**
     * Removes the Sauce Labs Backpack from the shopping cart.
     */
    public void removeSauceLabsBackpackInCart() {
        removeSauceLabsBackpackInCart.click();
    }

    /**
     * Removes the Sauce Labs Bolt T-Shirt from the shopping cart.
     */
    public void removeSauceLabsBoltTShirtInCart() {
        removeSauceLabsBoltTShirtInCart.click();
    }

    /**
     * Removes the Sauce Labs Fleece Jacket from the shopping cart.
     */
    public void removeSauceLabsFleeceJacketInCart() {
        removeSauceLabsFleeceJacketInCart.click();
    }

    /**
     * Removes the Sauce Labs Onesie from the shopping cart.
     */
    public void removeSauceLabsOnesieInCart() {
        removeSauceLabsOnesieInCart.click();
    }

    /**
     * Removes the Test Allthings T-Shirt (Red) from the shopping cart.
     */
    public void removeTestAllTheThingsTShirtInCart() {
        removeTestAllThingsTShirtInCart.click();
    }

    /**
     * Removes the Sauce Labs Bike Light from the shopping cart.
     */
    public void removeSauceLabsBikeLightInCart() {
        removeSauceLabsBikeLightInCart.click();
    }

    /**
     * Navigates to the checkout page by clicking the checkout button.
     */
    public void goToCheckoutPage() {
        checkoutWebPageButton.click();
    }

    /**
     * Navigates to the Inventory page by clicking the "Continue Shopping" button.
     */
    public void goToTheInventoryPage() {
        returnToTheInventoryPage.click();
    }

    /**
     * Retrieves a list of product names currently in the shopping cart.
     *
     * @return An array of product names as strings.
     */
    public String[] getProductInCart() {
        String[] productInCart = new String[productsInCart.size()];
        for (int i = 0; i < productsInCart.size(); i++) {
            productInCart[i] = productsInCart.get(i).getText();
        }
        return productInCart;
    }

    /**
     * Retrieves the prices of the products currently in the shopping cart.
     * The price values are parsed from string format (e.g., "$29.99") into a Double.
     *
     * @return An array of product prices as Double values.
     */
    public Double[] getProductsPrices() {
        String[] productPricesStrings = new String[priceList.size()];
        for (int i = 0; i < productPricesStrings.length; i++) {
            productPricesStrings[i] = priceList.get(i).getText();
        }

        Double[] productPrices = new Double[productPricesStrings.length];
        for (int i = 0; i < productPricesStrings.length; i++) {
            String price = productPricesStrings[i];
            price = price.replace("$", "");
            productPrices[i] = Double.parseDouble(price);
        }

        return productPrices;
    }
}
