package com.ttejeda.saucedemo.test;

import com.ttejeda.saucedemo.model.User;
import com.ttejeda.saucedemo.pages.InventoryPage;
import org.openqa.selenium.WebDriver;
import com.ttejeda.saucedemo.pages.LoginPage;


/**
 * UserActionsUtil class provides basic actions that can be performed
 * on the Saucedemo page
 */
public class UserActionsUtil {

    /**
     * Logs in to the Saucedemo page using the provided user credentials.
     *
     * @param driver the WebDriver instance for interacting with the browser
     * @param user the User object containing the user's credentials
     */
    public static void login(WebDriver driver, User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.accountLogin(user);
    }

    /**
     * Adds three products to the cart from the inventory page.
     *
     * @param driver the WebDriver instance for interacting with the browser
     */
    public static void saveThreeProducts(WebDriver driver) {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartSauceLabsBolt();
        inventoryPage.clickAddToCartSauceLabsFleeceJacket();
        inventoryPage.clickAddToCartTestAllthingsTShirt();
    }
}
