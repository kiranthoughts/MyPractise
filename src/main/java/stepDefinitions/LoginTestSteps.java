package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;

public class LoginTestSteps extends CommonFunctions {

    HomePage homePage = new HomePage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    @Given("User enters url {string}")
    public void user_enters_url(String string) {
        driver.get(string);

    }

    @When("user enters My Account link in the header")
    public void user_enters_my_account_link_in_the_header() {
        homePage.clickMyAccountLink();
    }

    @When("user enters invalid Email-Id {string}")
    public void user_enters_invalid_email_id(String username) {
        myAccountPage.enterUserName(username);

    }

    @When("user enters invalid Password {string}")
    public void user_enters_invalid_password(String password) {
        myAccountPage.userEntersPassword(password);
    }

    @When("user clicks SignIn button")
    public void user_clicks_sign_in_button() {
        myAccountPage.userClicksSignInButton();

    }

    @Then("user sees a login unsuccessful message {string}")
    public void user_sees_a_login_unsuccessful_message(String expectedLoginFailureMessage)
    {
       myAccountPage.validateLoginFailure(expectedLoginFailureMessage);

    }

}

