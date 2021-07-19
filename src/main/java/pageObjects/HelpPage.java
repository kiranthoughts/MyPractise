package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class HelpPage {

    public WebDriver localDriver;
    public HelpPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.localDriver=driver;
    }


    @FindBy(xpath="//section[@class='sectionThing phone']")
    public WebElement contactUsLink;


    @FindBy(id="searchQuestion")
    public WebElement searchOurFaqTextField;

    @FindBy(id="subCategoryTitle")
    public WebElement contactDetailMessage;


    @FindBy(xpath="//span[@class='liTitle' and text()='Help - FAQ Bot']")
    public WebElement helpFaqBot;


    @FindBy(id="WAC__header-name")
    public WebElement helpFaqBotclickedElement;


    public void SearchOurFaq(String question)
    {
       searchOurFaqTextField.sendKeys(question);
    }

    public void validateLandingHelpPage()
    {
        Assert.assertTrue(searchOurFaqTextField.isDisplayed());
        System.out.println("landed on Help Page OR Frequently asked question Page");

    }
   @Test
    public void clickContactUsLink()
    {
        contactUsLink.click();
        System.out.println("contact us link clicked");
    }

    public void validateContactUsLink()
    {
        Assert.assertTrue(contactUsLink.isDisplayed());
        System.out.println("Contact Us link displayed");
    }

    public void validateContactDetailsMessage()
    {
        Assert.assertTrue(contactDetailMessage.isDisplayed());
        System.out.println("Contact details are displaying");
    }
    public void clickHelpFaqBot() {


        localDriver.switchTo().frame(localDriver.findElement(By.id("helpSiteFrame")));
        helpFaqBot.click();
        System.out.println("HelpFaqBot clicked");
        localDriver.switchTo().defaultContent();
    }

        public void validateHelpFaqBotClickRedirection()
        {
            Set<String> windows=localDriver.getWindowHandles();
            Iterator<String> it=windows.iterator();
            String parentId=it.next();
            String childId= it.next();
            localDriver.switchTo().window(childId);
             Assert.assertTrue(helpFaqBotclickedElement.isDisplayed());
            System.out.println("HelpFaqBot clicked Redirected");
            localDriver.switchTo().defaultContent();
        }

    }







