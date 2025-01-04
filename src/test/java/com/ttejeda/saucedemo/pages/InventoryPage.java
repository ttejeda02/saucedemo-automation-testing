package com.ttejeda.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


/**
 * This class represents the Inventory Page of the application.
 * It contains methods that allow interaction with the elements on the Inventory page.
 * The Inventory Page includes several "Add to Cart" buttons for different products,
 * as well as a button to navigate to the shopping cart page.
 */
public class InventoryPage {
    // WebDriver instance to interact with the browser
    WebDriver driver;

    // Web elements representing various "Add to Cart" buttons for products
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

    // Web element representing the shopping cart page button
    @FindBy (xpath = "//a[@data-test=\"shopping-cart-link\"]")
    WebElement cartPageButton;

    // List of product names visible in the cart
    @FindBy (className = "inventory_item_name")
    List<WebElement> productsListInTheCart;

    /**
     * Constructor to initialize the InventoryPage class with the provided WebDriver.
     * Initializes the page elements using PageFactory.
     *
     * @param driver WebDriver instance used to interact with the web browser.
     */
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize the WebElements

    }

    /**
     * Clicks the "Add to Cart" button for the Sauce Labs Backpack product.
     * Waits for the button to be visible before interacting.
     */
    public void clickAddToCartSauceLabsBackpack() {
        waitForElementToBeVisible(addToCartSauceLabsBackpack);
        addToCartSauceLabsBackpack.click();
    }

    /**
     * Clicks the "Add to Cart" button for the Sauce Labs Bike Light product.
     * Waits for the button to be visible before interacting.
     */
    public void clickAddToCartSauceLabsBikeLight() {
        waitForElementToBeVisible(addToCartSauceLabsBikeLight);
        addToCartSauceLabsBikeLight.click();
    }

    /**
     * Clicks the "Add to Cart" button for the Sauce Labs Bolt T-Shirt product.
     */
    public void clickAddToCartSauceLabsBolt() {
        addToCartSauceLabsBolt.click();
    }

    /**
     * Clicks the "Add to Cart" button for the Sauce Labs Fleece Jacket product.
     * Waits for the button to be visible before interacting.
     */
    public void clickAddToCartSauceLabsFleeceJacket() {
        waitForElementToBeVisible(addToCartSauceLabsFleeceJacket);
        addToCartSauceLabsFleeceJacket.click();
    }

    /**
     * Clicks the "Add to Cart" button for the Sauce Labs Onesie product.
     * Waits for the button to be visible before interacting.
     */
    public void clickAddToCartSauceLabsOnesie() {
        waitForElementToBeVisible(addToCartSauceLabsOnesie);
        addToCartSauceLabsOnesie.click();
    }

    /**
     * Clicks the "Add to Cart" button for the Test.allTheThings() T-Shirt (Red) product.
     * Waits for the button to be visible before interacting.
     */
    public void clickAddToCartTestAllthingsTShirt() {
        waitForElementToBeVisible(addToCartTestAllthingsTShirt);
        addToCartTestAllthingsTShirt.click();
    }

    /**
     * Navigates to the shopping cart page by clicking on the cart button.
     * Waits for the button to be visible before interacting.
     */
    public void goToTheCartPage(){
        waitForElementToBeVisible(cartPageButton);
        cartPageButton.click();
    }

    /**
     * Retrieves the current URL of the Inventory page.
     *
     * @return The current URL as a string.
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Waits for an element to be visible on the page before interacting with it.
     * Uses WebDriverWait to wait for up to 10 seconds for the element to become visible.
     *
     * @param element The WebElement to wait for.
     */
    private void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Retrieves the list of product names currently added to the cart.
     *
     * @return An array of product names as strings.
     */
    public String[] getProductsListInTheCart() {
        String[] productsInCart = new String[productsListInTheCart.size()];
        for (int i = 0; i < productsListInTheCart.size(); i++) {
            productsInCart[i] = productsListInTheCart.get(i).getText();
        }

        return productsInCart;
    }
}
