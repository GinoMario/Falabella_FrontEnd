package pages;

import org.example.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBys({@FindBy(how = How.XPATH, using = "//b[contains(@id,\"testId-pod-displaySubTitle\")]")})
    private List<WebElement> listProducts;

    @FindBy(xpath = "//h2[text()='Categoría']")
    private WebElement lblCategory;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchPageLoad() throws Exception {
        return this.isDisplayed(lblCategory);
    }

    public void clicOnCategory(String sCategory) throws Exception {
        By xpathCategory = By.xpath("//button[text()='" + sCategory + " ']");
        this.click(xpathCategory);
    }

    public boolean findProduct(String sNameProduct) throws Exception {
        boolean productExist = false;
        for (WebElement e : listProducts) {
            System.out.println(e.getText());
            this.performToElement(e);
            if (e.getText().equals(sNameProduct)) {
                productExist = true;
                break;
            }
        }
        return productExist;
    }

    public void selectTheProduct(String sNameProduct) throws Exception {
        for (WebElement e : listProducts) {
            System.out.println(e.getText());
            this.performToElement(e);
            if (e.getText().equals(sNameProduct)) {
                e.click();
                break;
            }
        }
    }
}
