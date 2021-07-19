import functionLibrary.CommonFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hooks {

CommonFunctions commonFunctions = new CommonFunctions();
@BeforeTest
public void beforeTest()
{
    commonFunctions.openBrowser();
}

@AfterTest
public void afterTest()
{
    commonFunctions.closeBrowser();
}


}
