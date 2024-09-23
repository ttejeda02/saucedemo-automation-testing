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

        String cartPageUrl = loginPage.getCurrentUrl();

        Assert.assertNotEquals(inventoryPage, cartPageUrl);

        //cart page
        CartPage cartPage = new CartPage(driver);
        cartPage.removeSauceLabsOnesieInCart();
        cartPage.goToCheckoutPage();

        //checkout page
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillUserFormInput(user);
        checkoutPage.goToCheckoutOverviewPage();

        //checkout overview page
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getTotal(), "103.65");
        checkoutOverviewPage.finishCheckout();
    }
}
