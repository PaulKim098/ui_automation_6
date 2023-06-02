package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TGBasePage;
import pages.TGFrontendTestingHomePage;
import utils.ConfigReader;
import utils.Driver;

public class GlobalBase {

    TGBasePage techGlobalBasePage;
    TGFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    public static WebDriver driver; // declaration

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        techGlobalBasePage = new TGBasePage();
    }

    @AfterMethod
    public void tearDown(){
        // We will quit driver and do other proper clean-ups.
        Driver.quitDriver();
    }
}
