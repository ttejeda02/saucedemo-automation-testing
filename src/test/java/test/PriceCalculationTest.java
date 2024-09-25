package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import model.User;
import pages.*;
import service.UserCreator;

public class PriceCalculationTest extends BaseTest {

    @Test (priority = 1)
    public void pricesInCartTest() {
        User user = UserCreator.createStandardUserWithoutUserData();
        UserActionsUtil.login(driver, user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        UserActionsUtil.saveThreeProducts(driver);
        inventoryPage.goToTheCartPage();

        CartPage cartPage = new CartPage(driver);

        Double[] expected = {15.99, 49.99, 15.99};
        Double[] actualProductPrices = cartPage.getProductsPrices();

        Assert.assertArrayEquals(expected, actualProductPrices);
    }
}
