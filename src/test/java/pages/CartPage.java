package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    WebDriver driver;

    @FindBy (id = "remove-sauce-labs-backpack")
    WebElement removeSauceLabsBackpackInCart;

    @FindBy (id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeSauceLabsBoltTShirtInCart;

    @FindBy (id = "remove-sauce-labs-fleece-jacket")
    WebElement removeSauceLabsFleeceJacketInCart;

    @FindBy (id = "remove-sauce-labs-bike-light")
    WebElement removeSauceLabsBikeLightInCart;

    @FindBy (id = "remove-sauce-labs-onesie")
    WebElement removeSauceLabsOnesieInCart;

    @FindBy (id = "remove-test.allthethings()-t-shirt-(red)")
    WebElement removeTestAllThingsTShirtInCart;

    @FindBy (id = "checkout")
    WebElement checkoutWebPageButton;

    @FindBy (id = "continue-shopping")
    WebElement returnToTheInventoryPage;

    @FindBy (xpath = "//div[@class='cart_item_label']/a[@href='#']")
    List<WebElement> productsInCart;

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

    public void removeTestAllTheThingsTShirtInCart() {
        removeTestAllThingsTShirtInCart.click();
    }

    public void removeSauceLabsBikeLightInCart() {
        removeSauceLabsBikeLightInCart.click();
    }

    public void goToCheckoutPage() {
        checkoutWebPageButton.click();
    }

    public void goToTheInventoryPage() {
        returnToTheInventoryPage.click();
    }

    public String[] getProductInCart() {
        String[] productInCart = new String[productsInCart.size()];
        for (int i = 0; i < productsInCart.size(); i++) {
            productInCart[i] = productsInCart.get(i).getText();
        }
        return productInCart;
    }
}
