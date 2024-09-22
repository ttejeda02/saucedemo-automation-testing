package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import service.UserCreator;


public class HappyPathTest {
    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        driver = new ChromeDriver(options);

    }

    @Test (priority = 1)
    public void happyPathTest(){
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

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}
