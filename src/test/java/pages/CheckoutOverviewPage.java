package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutOverviewPage {

    WebDriver driver;

    @FindBy (className = "summary_subtotal_label")
    WebElement subtotal;

    @FindBy (xpath = "//div[starts-with(text(), 'Total')]")
    WebElement total;

    @FindBy (id = "finish")
    WebElement finishCheckoutButton;

    @FindBy (id = "cancel")
    WebElement cancelCheckoutButton;

    @FindBy (className = "inventory_item_price")
    List<WebElement> priceList;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public Double getTotalPriceWithoutTaxes() {
        String subtotalText = subtotal.getText();
        subtotalText = subtotalText.replace("Item total: $", "");

        return Double.parseDouble(subtotalText);
    }

    public Double getTotalPriceWithTaxes() {
        String totalText = total.getText();
        totalText = totalText.replace("Total: $", "");

        return Double.parseDouble(totalText);
    }

    public void finishCheckout() {
        finishCheckoutButton.click();
    }

    public void cancelCheckoutAndReturnToInventoryPage() {
        cancelCheckoutButton.click();
    }

    public Double[] getProductsPrices() {
        String[] productPricesStrings = new String[priceList.size()];
        for (int i = 0; i < productPricesStrings.length; i++) {
            productPricesStrings[i] = priceList.get(i).getText();
        }

        Double[] productPrices = new Double[productPricesStrings.length];
        for (int i = 0; i < productPricesStrings.length; i++) {
            String price = productPricesStrings[i];
            price = price.replace("$", "");
            productPrices[i] = Double.parseDouble(price);
        }

        return productPrices;
    }
}
