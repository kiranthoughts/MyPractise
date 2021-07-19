package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class ProductsCategorySteps extends CommonFunctions {

    HomePage homePage = new HomePage(driver);

    @Given("I am on home page {string}")
    public void i_am_on_home_page(String url) {
        driver.get(url);

    }

    @When("I click the product link {string}")
    public void i_click_the_product_link(String category) {
        homePage.clickProductCategory(category);
    }

    @Then("I will be redirected appropritely related page {string}")
    public void i_will_be_redirected_appropritely_related_page(String expectedUrl) {
        homePage.productCategoryPageVal(expectedUrl);

    }

}
