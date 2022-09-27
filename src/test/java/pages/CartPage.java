package pages;

import org.example.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(xpath = "//span[text()='Resumen de la orden']")
    private WebElement lblResume;

    @FindBy(xpath = "//span[@data-testid = 'total-amount']")
    private WebElement lblTotalPrice;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPageLoad() throws Exception {
        return this.isDisplayed(lblResume);
    }

    public String getTotalPrice() {
        return lblTotalPrice.getText();
    }
}
