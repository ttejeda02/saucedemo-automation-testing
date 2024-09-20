package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    @FindBy (id = "remove-sauce-labs-backpack")
    WebElement removeSauceLabsBackpackInCart;

    @FindBy (id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeSauceLabsBoltTShirtInCart;

    @FindBy (id = "remove-sauce-labs-fleece-jacket")
    WebElement removeSauceLabsFleeceJacketInCart;

    @FindBy (id = "remove-sauce-labs-onesie")
    WebElement removeSauceLabsOnesieInCart;

    @FindBy (id = "checkout")
    WebElement checkoutWebPageButton;

    @FindBy (id = "continue-shopping")
    WebElement returnToTheInventoryPage;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void removeSauceLabsBackpackInCart() {
        removeSauceLabsBackpackInCart.click();
    }

    public void removeSauceLabsBoltTShirtInCart() {
        removeSauceLabsBoltTShirtInCart.click();
    }

    public void removeSauceLabsFleeceJacketInCart() {
        removeSauceLabsFleeceJacketInCart.click();
    }

    public void removeSauceLabsOnesieInCart() {
        removeSauceLabsOnesieInCart.click();
    }

    public void goToCheckoutPage() {
        checkoutWebPageButton.click();
    }

    public void goToTheInventoryPage() {
        returnToTheInventoryPage.click();
    }
}
