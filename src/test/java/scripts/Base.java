package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TGBasePage;
import utils.Driver;

public class Base {

    TGBasePage techGlobalBasePage;
    public static WebDriver driver; // declaration

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        techGlobalBasePage = new TGBasePage();
    }

    @AfterMethod
    public void tearDown(){
        // We will quit driver and do other proper clean-ups.
        Driver.quitDriver();
    }
}
