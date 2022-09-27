package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.ProductDetailsPage;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;


public class ProductsSteps extends TestBase {

    String priceProduct;

    @Given("^The user access to falabella home page$")
    public void theUserAccessToFalabellaHomePage() throws Exception {
        Assert.assertTrue("Error: No cargó correctamente el Home Page", homePage.isHomePageLoad());
        homePage.acceptCookies();
    }

    @When("^enter the search criteria \"([^\"]*)\"$")
    public void enterTheSearchCriteria(String aCriteria) throws Exception {
        homePage.setSearchCriteria(aCriteria);
        Assert.assertTrue(searchPage.isSearchPageLoad());
    }

    @And("^select the category \"([^\"]*)\"$")
    public void selectTheCategory(String aCategory) throws Exception {
        searchPage.clicOnCategory(aCategory);
        sleep(5000);
    }

    @Then("^verify the expected product \"([^\"]*)\" and the result \"([^\"]*)\"$")
    public void verifyTheExpectedProductAndTheResult(String aProductExpect, boolean aResult) throws Exception {
        Assert.assertEquals(aResult,searchPage.findProduct(aProductExpect));
    }

    @When("^enter and select the product \"([^\"]*)\"$")
    public void enterAndSelectTheProduct(String aProduct) throws Exception {
        homePage.setSearchCriteria(aProduct);
//        searchPage.selectTheProduct(aProduct);
        Assert.assertTrue(productDetailsPage.isProductDetailLoad());
    }

    @And("^add to the cart and open$")
    public void addToTheCartAndOpen() throws Exception {
        priceProduct = productDetailsPage.getPrice();
        productDetailsPage.AddToCart();
        productDetailsPage.goToCart();
        Assert.assertTrue(cartPage.isCartPageLoad());
    }

    @Then("^verify the price on the cart$")
    public void verifyThePriceOnTheCart() {
        Assert.assertEquals(priceProduct,cartPage.getTotalPrice());
    }
}
