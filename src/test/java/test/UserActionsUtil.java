package test;

import model.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class UserActionsUtil {
    public static void login(WebDriver driver, User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.accountLogin(user);
    }
}
