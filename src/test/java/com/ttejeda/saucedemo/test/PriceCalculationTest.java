package com.ttejeda.saucedemo.test;

import com.ttejeda.saucedemo.model.User;
import com.ttejeda.saucedemo.pages.CartPage;
import com.ttejeda.saucedemo.pages.CheckoutOverviewPage;
import com.ttejeda.saucedemo.pages.CheckoutPage;
import com.ttejeda.saucedemo.pages.InventoryPage;
import com.ttejeda.saucedemo.service.UserCreator;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.ttejeda.saucedemo.pages.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    @Test (priority = 2)
    public void checkTotalPricesInCheckout() {
        User user = UserCreator.createStandardUserWithUserData();
        UserActionsUtil.login(driver, user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        UserActionsUtil.saveThreeProducts(driver);
        inventoryPage.goToTheCartPage();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckoutPage();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillUserFormInput(user);
        checkoutPage.goToCheckoutOverviewPage();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        Double expectedSubTotalPrice = 81.97;
        Double actualSubTotalPrice = checkoutOverviewPage.getTotalPriceWithoutTaxes();
        Assert.assertEquals(expectedSubTotalPrice, actualSubTotalPrice);

        Double expectedTotalPrice = calculatePriceWithTaxes(expectedSubTotalPrice);
        Double actualTotalPrice = checkoutOverviewPage.getTotalPriceWithTaxes();
        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    private Double calculatePriceWithTaxes(Double taxes) {
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(taxes + (taxes * 0.08));
        expectedTotalPrice = expectedTotalPrice.setScale(2, RoundingMode.UP);
        return expectedTotalPrice.doubleValue();
    }
}
