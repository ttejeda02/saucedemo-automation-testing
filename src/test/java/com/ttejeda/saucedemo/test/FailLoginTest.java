package com.ttejeda.saucedemo.test;

import com.ttejeda.saucedemo.model.User;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.ttejeda.saucedemo.pages.LoginPage;
import com.ttejeda.saucedemo.service.UserCreator;

public class FailLoginTest extends BaseTest {

    @Test (priority = 1)
    public void failLogin() {
        LoginPage loginPage = new LoginPage(driver);
        User user = UserCreator.createLockedOutUserWithUserData();
        String loginPageUrl = loginPage.getCurrentUrl();
        loginPage.accountLogin(user);
        String currentPageUrl = loginPage.getCurrentUrl();

        Assert.assertEquals(loginPageUrl, currentPageUrl);
    }

}
