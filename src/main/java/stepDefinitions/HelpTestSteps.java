package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HelpPage;
import pageObjects.HomePage;


public class HelpTestSteps extends CommonFunctions {
    HomePage homePage=new HomePage(driver);
    HelpPage helpPage=new HelpPage(driver);

    @Given("User is on home page {string}")
    public void user_is_on_home_page(String url)throws Exception {
        driver.get(url);
        takeScreenShot("homePageLanded.jpg");
    }

    @When("user clicks on the help link in header")
    public void user_clicks_on_the_help_link_in_header() throws Exception{

        homePage.clickHelpLink();
        takeScreenShot("helpLinkClicked.jpg");
        
    }
    @When("user clicks on Contact Us link")
    public void user_clicks_on_contact_us_link()throws Exception {
        waitFor(6);
        //switchToFrame("helpSiteFrame");
        helpPage.clickHelpFaqBot();
        takeScreenShot("contactUs.jpg");
    }

    @Then("user gets the contact list numbers")
    public void user_gets_the_contact_list_numbers() throws Exception{
        helpPage.validateHelpFaqBotClickRedirection();
        takeScreenShot("faqBotLinkRedirected.jpg");
    }

}
