package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {


    public MyAccountPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);


    }


    @FindBy(xpath = "//span[@class='customerText']")
    public WebElement landingMesaage;

    @FindBy(id="EmailOrAccountNumber")
    public WebElement emailTextField;

    @FindBy(id="Password")
    public WebElement passwordTextField;


    @FindBy(id="SignInNow")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class='SignInTo']/div/div/div")
    public WebElement loginFailureMessage;

    public void validateMyAccountPageLanding(){

        Assert.assertTrue(landingMesaage.isDisplayed());

    }

    public void enterUserName(String username)
    {
        emailTextField.sendKeys(username);
    }
    public void userEntersPassword(String password)
    {
        passwordTextField.sendKeys(password);
    }

    public void userClicksSignInButton()
    {
        signInButton.click();
    }


    public void validateLoginFailure(String expectedLoginFailureMessage)
    {

       String actualLoginFailureMessage=loginFailureMessage.getText();
       Assert.assertEquals(expectedLoginFailureMessage,actualLoginFailureMessage);
       System.out.println("login unsuccessful message validated");
    }


}
