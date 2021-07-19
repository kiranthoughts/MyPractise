package pageObjects;

import functionLibrary.CommonFunctions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.NotLinkException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePage {
    public WebDriver driver;
    @FindBy(xpath = "//a[@id='header-logo']")
    public WebElement headerLogo;
    @FindBy(xpath = "//input[@id='sli_search_1']")
    public WebElement searchTextField;
    @FindBy(xpath = "//a[@title='Sign in to view account details']")
    public WebElement myAccount;
    @FindBy(linkText = "Help")
    public WebElement help;
    @FindBy(linkText = "Store Locator")
    public WebElement storeLoactor;
    @FindBy(linkText = "Checkout")
    public WebElement checkout;
    @FindBy(linkText = "Store Locator")
    public WebElement nextDayDeliveryLink;
    @FindBy(xpath = "//a[@data-link-name='Shopping Bag']")
    public WebElement shoppingBagIcon;
    @FindBy(xpath = "//a[@data-link-name='Checkout']")
    public WebElement checkoutLink;
    @FindBy(linkText = "Frequently Asked Questions")
    public WebElement frequentlyAskedQuestionFooterLink;
    @FindBy(linkText = "Delivery Information")
    public WebElement deliveryInformationFooterLink;
    @FindBy(linkText = "Arrange A Return")
    public WebElement arrangeADeliveryLink;
    @FindBy(linkText = "Contact Us")
    public WebElement cotactUsFooterLink;
    @FindBy(linkText = "Complaints Process")
    public WebElement complaintProcessLink;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().deleteAllCookies();
    }

    public void clickMyAccountLink() {
        myAccount.click();
    }

    public void clickHelpLink() {
        help.click();
    }

    public void assertLog() {
        Assert.assertTrue(headerLogo.isDisplayed());
    }

    public void clickFrequentlyAskedQuestionFooterLink() {
        frequentlyAskedQuestionFooterLink.click();
    }

    public void clickMediaLink(String mediaName) {
        driver.findElement(By.xpath("//a[@aria-label='" + mediaName + "']")).click();
        driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    public void mediaLinkValidation(String expectedUrl) {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        String actualUrl = driver.getCurrentUrl();
        try {
            Assert.assertTrue(actualUrl.contains(expectedUrl));
        } catch (NoSuchWindowException e) {
            System.out.println("Media Not Found");
        }
    }

    public void clickProductCategory(String category) {
        driver.findElement(By.xpath("//span[text()='" + category + "']")).click();
    }

    public void productCategoryPageVal(String expectedUrl) {

        String actualUrl = driver.getCurrentUrl();
        try {
            Assert.assertTrue(actualUrl.contains(expectedUrl));
            System.out.println("windows  opened");

        } catch (NoSuchWindowException e) {
            System.out.println("windows not opened");
        }
    }

}
