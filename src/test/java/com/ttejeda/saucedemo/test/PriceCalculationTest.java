package com.ttejeda.saucedemo.test;

import com.ttejeda.saucedemo.model.User;
import com.ttejeda.saucedemo.pages.CartPage;
import com.ttejeda.saucedemo.pages.CheckoutOverviewPage;
import com.ttejeda.saucedemo.pages.CheckoutPage;
import com.ttejeda.saucedemo.pages.InventoryPage;
import com.ttejeda.saucedemo.service.UserCreator;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * Test class for Swag Labs e-shop (saucedemo). Check products prices.
 * Uses Selenium Webdriver for browser automation.
 */
public class PriceCalculationTest extends BaseTest {

    /**
     * Test method that verifies the prices of the products in the cart.
     * The test add products to the cart and assert the prices.
     */
    @Test (priority = 1)
    public void pricesInCartTest() {
        User user = UserCreator.createUserWithoutUserData();
        UserActionsUtil.login(driver, user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        UserActionsUtil.saveThreeProducts(driver);
        inventoryPage.goToTheCartPage();

        CartPage cartPage = new CartPage(driver);

        Double[] expected = {15.99, 49.99, 15.99};
        Double[] actualProductPrices = cartPage.getProductsPrices();

        Assert.assertArrayEquals(expected, actualProductPrices);
    }

    /**
     * Test method that verifies the total price in the checkout page.
     * The test add three products and check the subtotal and total of the purchase.
     */
    @Test (priority = 2)
    public void checkTotalPricesInCheckout() {
        User user = UserCreator.createUserWithUserData();
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

    /**
     * Private method that calculates the total price (subtotal plus taxes)
     * @param subTotal Purchase subtotal
     * @return The total (subtotal plus 8% sales taxes)
     */
    private Double calculatePriceWithTaxes(Double subTotal) {
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(subTotal + (subTotal * 0.08));
        expectedTotalPrice = expectedTotalPrice.setScale(2, RoundingMode.UP);
        return expectedTotalPrice.doubleValue();
    }
}
