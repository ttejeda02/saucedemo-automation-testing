package test;

import model.User;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import service.UserCreator;

public class SaveProductsInCartTest extends BaseTest {

    @Test
    public void saveAProductsInTheCart() {
        User user = UserCreator.createStandardUserWithoutUserData();
        UserActionsUtil.login(driver, user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartSauceLabsOnesie();
        inventoryPage.goToTheCartPage();

        CartPage cartPage = new CartPage(driver);
        String[] products = cartPage.getProductInCart();
        String[] expectedProducts = {"Sauce Labs Onesie"};

        Assert.assertEquals(expectedProducts, products);
    }

    @Test
    public void saveThreeProductsInTheCart() {
        User user = UserCreator.createStandardUserWithoutUserData();
        UserActionsUtil.login(driver, user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartSauceLabsBikeLight();
        inventoryPage.clickAddToCartSauceLabsOnesie();
        inventoryPage.clickAddToCartTestAllthingsTShirt();
        inventoryPage.goToTheCartPage();

        CartPage cartPage = new CartPage(driver);
        String[] products = cartPage.getProductInCart();
        String[] expectedProducts = {"Sauce Labs Bike Light", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};
        Assert.assertEquals(expectedProducts, products);
    }
}
