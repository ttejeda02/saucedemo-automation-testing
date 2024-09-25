package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import service.UserCreator;


public class HappyPathTest extends BaseTest {

    @Test (priority = 1)
    public void happyPathTest() {
        //login page
        LoginPage loginPage = new LoginPage(driver);
        String homePageUrl = loginPage.getCurrentUrl();

        User user = UserCreator.createStandardUserWithUserData();
        loginPage.accountLogin(user);
        String inventoryPageUrl = loginPage.getCurrentUrl();

        Assert.assertNotEquals(homePageUrl, inventoryPageUrl);

        //inventory page
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartSauceLabsBackpack();
        inventoryPage.clickAddToCartSauceLabsBolt();
        inventoryPage.clickAddToCartSauceLabsOnesie();
        inventoryPage.clickAddToCartSauceLabsFleeceJacket();

        inventoryPage.goToTheCartPage();

        //cart page
        CartPage cartPage = new CartPage(driver);
        cartPage.removeSauceLabsOnesieInCart();
        cartPage.goToCheckoutPage();

        String[] actualProducts = cartPage.getProductInCart();
        String[] expectedProducts = {"Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket"};
        Assert.assertNotEquals(expectedProducts, actualProducts);

        //checkout page
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillUserFormInput(user);
        checkoutPage.goToCheckoutOverviewPage();

        //checkout overview page
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getTotalPriceWithTaxes(), Double.parseDouble("103.65"));
        checkoutOverviewPage.finishCheckout();
    }
}
