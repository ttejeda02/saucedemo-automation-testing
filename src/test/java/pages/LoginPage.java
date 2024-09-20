package pages;


import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static final String URL = "https://www.saucedemo.com/";
    WebDriver driver;

    @FindBy (id = "user-name")
    WebElement usernameInput;

    @FindBy (id = "password")
    WebElement passwordInput;

    @FindBy (id = "login-button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
        this.driver.get(URL);
        PageFactory.initElements(this.driver, this);
    }

    public void accountLogin(User user) {
        usernameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
