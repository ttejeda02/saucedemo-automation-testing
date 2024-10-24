package com.ttejeda.saucedemo.test;

import com.ttejeda.saucedemo.model.User;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.ttejeda.saucedemo.pages.LoginPage;
import com.ttejeda.saucedemo.service.UserCreator;


/**
 * Test class for Swag Labs e-shop (saucedemo) login with a locked out user.
 * Uses Selenium Webdriver for browser automation.
 */
public class FailLoginTest extends BaseTest {

    /**
     * Test method that verifies the locked out user can't login into the e-shop.
     * The test check that the page doesn't change after click on the login button.
     */
    @Test (priority = 1)
    public void failLogin() {
        LoginPage loginPage = new LoginPage(driver);
        User user = UserCreator.createLockedUserWithoutUserData();
        String loginPageUrl = loginPage.getCurrentUrl();
        loginPage.accountLogin(user);
        String currentPageUrl = loginPage.getCurrentUrl();

        Assert.assertEquals(loginPageUrl, currentPageUrl);
    }

}
