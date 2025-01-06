package com.ttejeda.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


/**
 * This class represents the Checkout Overview page in the purchasing flow of the Saucedemo application.
 * It contains WebElements for displaying the subtotal, total price, product prices,
 * and buttons to finish or cancel the checkout process.
 * The class provides methods to retrieve price information and interact with the buttons to complete
 * or cancel the checkout.
 */
public class CheckoutOverviewPage {
    // Webdriver instance
    WebDriver driver;

    // WebElement for the subtotal of the order
    @FindBy(className = "summary_subtotal_label")
    private WebElement subtotal;

    // WebElement for the total price, including taxes
    @FindBy(xpath = "//div[starts-with(text(), 'Total')]")
    private WebElement total;

    // WebElement for the finish checkout button
    @FindBy(id = "finish")
    private WebElement finishCheckoutButton;

    // WebElement for the cancel checkout button
    @FindBy(id = "cancel")
    private WebElement cancelCheckoutButton;

    // List of WebElements representing the prices of the products in the order
    @FindBy(className = "inventory_item_price")
    private List<WebElement> priceList;

    /**
     * Constructor that initializes the CheckoutOverviewPage with the provided WebDriver.
     * It initializes the page elements using PageFactory.
     *
     * @param driver The WebDriver instance used to interact with the web browser.
     */
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this); // Initialize the WebElements
    }

    /**
     * Retrieves the total price of the order without taxes.
     *
     * @return The subtotal as a Double value.
     */
    public Double getTotalPriceWithoutTaxes() {
        String subtotalText = subtotal.getText();
        subtotalText = subtotalText.replace("Item total: $", "");

        return Double.parseDouble(subtotalText);
    }

    /**
     * Retrieves the total price of the order including taxes.
     *
     * @return The total price with taxes as a Double value.
     */
    public Double getTotalPriceWithTaxes() {
        String totalText = total.getText();
        totalText = totalText.replace("Total: $", "");

        return Double.parseDouble(totalText);
    }

    /**
     * Completes the checkout process by clicking the "Finish" button.
     */
    public void finishCheckout() {
        finishCheckoutButton.click();
    }

    /**
     * Cancels the checkout process and returns to the Inventory page by clicking the "Cancel" button.
     */
    public void cancelCheckoutAndReturnToInventoryPage() {
        cancelCheckoutButton.click();
    }

    /**
     * Retrieves the prices of the products in the order.
     * The price values are parsed from string format (e.g., "$29.99") into Double.
     *
     * @return An array of Doubles representing the prices of the products in the order.
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
