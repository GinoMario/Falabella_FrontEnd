package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class TestBase {
    protected WebDriver driver = Hooks.getDriver();
    protected HomePage homePage = PageFactory.initElements(driver,HomePage.class);
    protected SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
    protected ProductDetailsPage productDetailsPage = PageFactory.initElements(driver, ProductDetailsPage.class);
    protected CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
}
