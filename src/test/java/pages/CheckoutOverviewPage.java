package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

    WebDriver driver;

    @FindBy (xpath = "//div[starts-with(text(), 'Total')]")
    WebElement total;

    @FindBy (id = "finish")
    WebElement finishCheckoutButton;

    @FindBy (id = "cancel")
    WebElement cancelCheckoutButton;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getTotal(){
        String totalText = total.getText();
        totalText = totalText.replace("Total: $", "");
        return totalText;
    }

    public void finishCheckout() {
        finishCheckoutButton.click();
    }

    public void cancelCheckoutAndReturnToInventoryPage() {
        cancelCheckoutButton.click();
    }
}
