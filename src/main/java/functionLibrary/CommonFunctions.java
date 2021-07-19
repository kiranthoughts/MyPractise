package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    public static WebDriver driver;
    public String errShotsPath= new File("src/main/resources/errShots").getAbsolutePath();

    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

   public void closeBrowser() {

        driver.quit();
    }

    public void waitFor(int wait) {

        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    }


    public void takeScreenShot(String fileName) throws Exception
    {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(errShotsPath + "/"+ fileName);

        FileUtils.copyFile(srcFile, destFile);

    }
   /* public void switchToFrame(String frame)
    {
        try
        {
            driver.switchTo().frame(frame);
            System.out.println("Navigated to frame with name " + frame);
        }
        catch (NoSuchFrameException e)
        {
            System.out.println("Unable to locate frame with id " + frame);
        }
    }*/


}


