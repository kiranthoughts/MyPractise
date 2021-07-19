package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

public class MediaLinkSteps extends CommonFunctions {

    HomePage homePage = new HomePage(driver);
    @Given("user is on home page {string}")
    public void user_is_on_home_page(String url) {
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);

    }
    @When("user clicks on media link {string}")
    public void user_clicks_on_media_link(String mediaName) {
        homePage.clickMediaLink(mediaName);
        
    }
    @Then("user should redirected to appropriate media page title {string}")
    public void user_should_redirected_to_appropriate_media_page_title(String mediaTitleName) {

        homePage.mediaLinkValidation(mediaTitleName);
        
    }




}
