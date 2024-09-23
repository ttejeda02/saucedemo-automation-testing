package test;

import org.testng.annotations.Test;
import pages.LoginPage;

public class FailedLoginTest extends BaseTest {

    @Test (priority = 1)
    public void failedLogin() {
        LoginPage loginPage = new LoginPage(driver);
        
    }

}
