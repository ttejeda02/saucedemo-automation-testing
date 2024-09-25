package test;

import model.User;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;

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
