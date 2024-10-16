package com.ttejeda.saucedemo.test;

import com.ttejeda.saucedemo.model.User;
import com.ttejeda.saucedemo.pages.CartPage;
import com.ttejeda.saucedemo.pages.InventoryPage;
import com.ttejeda.saucedemo.service.UserCreator;
import org.junit.Assert;
import org.testng.annotations.Test;

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
