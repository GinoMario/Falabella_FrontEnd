package pages;

import org.example.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Agregar al Carro']")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//a[text()='Ir al Carro']")
    private WebElement btnOpenTheCart;

    @FindBy(xpath = "//span[text()='Lo que llevas en tu Carro']")
    private WebElement lblCartModal;

    @FindBy(xpath = "//span[text()='Tipo de entrega']")
    private WebElement lblTypeDelivery;

    @FindBy(xpath = "//div[contains(@id,\"testId-pod-prices\")]//span")
    private WebElement lblPrice;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDetailLoad() throws Exception {
        return this.isDisplayed(lblTypeDelivery);
    }

    public boolean isCartModalLoad() throws Exception {
        return this.isDisplayed(lblCartModal);
    }

    public void AddToCart() {
        btnAddToCart.click();
    }

    public String getPrice() {
        return lblPrice.getText();
    }

    public void goToCart() {
        btnOpenTheCart.click();
    }
}
