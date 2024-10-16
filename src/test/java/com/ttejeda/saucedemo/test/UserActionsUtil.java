package com.ttejeda.saucedemo.test;

import com.ttejeda.saucedemo.model.User;
import com.ttejeda.saucedemo.pages.InventoryPage;
import org.openqa.selenium.WebDriver;
import com.ttejeda.saucedemo.pages.LoginPage;

public class UserActionsUtil {
    public static void login(WebDriver driver, User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.accountLogin(user);
    }

    public static void saveThreeProducts(WebDriver driver) {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartSauceLabsBolt();
        inventoryPage.clickAddToCartSauceLabsFleeceJacket();
        inventoryPage.clickAddToCartTestAllthingsTShirt();
    }
}
