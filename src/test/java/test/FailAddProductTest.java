package test;

import model.User;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import service.UserCreator;

public class FailAddProductTest extends BaseTest{

    @Test (priority = 1)
    public void failAddAProduct(){
        User user = UserCreator.createErrorUserWithUserData();
        UserActionsUtil.login(driver, user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartSauceLabsBolt();
        inventoryPage.clickAddToCartSauceLabsBackpack();
        inventoryPage.clickAddToCartTestAllthingsTShirt();
        inventoryPage.goToTheCartPage();

        CartPage cartPage = new CartPage(driver);
        String[] expectedProductsInCar = {"Sauce Labs Backpack"};
        String[] actualProductsInCar = cartPage.getProductInCart();

        Assert.assertArrayEquals(expectedProductsInCar, actualProductsInCar);
    }

    @Test (priority = 2)
    public void failAddThreeProducts(){
        User user = UserCreator.createErrorUserWithUserData();
        UserActionsUtil.login(driver, user);
        UserActionsUtil.saveThreeProducts(driver);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.goToTheCartPage();

        CartPage cartPage = new CartPage(driver);
        String[] expectedProductsInCar = {};
        String[] actualProductsInCar = cartPage.getProductInCart();

        Assert.assertArrayEquals(expectedProductsInCar, actualProductsInCar);
    }

}
