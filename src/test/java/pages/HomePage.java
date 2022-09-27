package pages;

import org.example.framework.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='Popover-module_popover-container__3qpkj Popover-module_bottom-caret-notlogin__19OPO']")
    private WebElement btnLogIn;

    @FindBy(xpath = "//button[text()=\"Computadoras \"]")
    private WebElement lblLogIn;

    @FindBy(xpath = "//input[@id='testId-SearchBar-Input']")
    private WebElement txtSearch;

    @FindBy(xpath = "//button[@id='testId-accept-cookies-btn']")
    private WebElement btnAcceptCookies;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageLoad() throws Exception {
        return this.isDisplayed(btnLogIn);
    }

    public void acceptCookies() {
        btnAcceptCookies.click();
    }

    public void setSearchCriteria(String sCriteria) {
        txtSearch.sendKeys(sCriteria);
        txtSearch.sendKeys(Keys.ENTER);
    }
}
