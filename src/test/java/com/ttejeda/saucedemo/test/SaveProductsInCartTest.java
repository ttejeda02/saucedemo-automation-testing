package com.ttejeda.saucedemo.test;

import com.ttejeda.saucedemo.pages.InventoryPage;
import com.ttejeda.saucedemo.model.User;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.ttejeda.saucedemo.pages.CartPage;
import com.ttejeda.saucedemo.service.UserCreator;

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

        Assert.assertArrayEquals("The products don't match", expectedProducts, products);
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
        Assert.assertArrayEquals("The products doesn't match", expectedProducts, products);
    }

    @Test
    public void saveSixProductsAndRemoveFourInCart () {
        User user = UserCreator.createStandardUserWithoutUserData();
        UserActionsUtil.login(driver, user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAddToCartSauceLabsBackpack();
        inventoryPage.clickAddToCartSauceLabsFleeceJacket();
        inventoryPage.clickAddToCartSauceLabsOnesie();
        inventoryPage.clickAddToCartTestAllthingsTShirt();
        inventoryPage.clickAddToCartSauceLabsBolt();
        inventoryPage.clickAddToCartSauceLabsBikeLight();
        inventoryPage.goToTheCartPage();

        CartPage cartPage = new CartPage(driver);
        cartPage.removeSauceLabsOnesieInCart();
        cartPage.removeTestAllTheThingsTShirtInCart();
        String[] products = cartPage.getProductInCart();
        String[] expectedProducts = {"Sauce Labs Backpack", "Sauce Labs Fleece Jacket", "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light"};

        Assert.assertArrayEquals("The products doesn't match", expectedProducts, products);
    }
}
