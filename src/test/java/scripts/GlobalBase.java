package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.ConfigReader;
import utils.Driver;

public class GlobalBase {


    public static WebDriver driver; // declaration
    public static Actions actions;

    //Declaring pages
    public static TGBasePage techGlobalBasePage;
    public static TGFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    public static Project3Page project3Page;
    public static Project2Page project2Page;
    public static EtsyHomePage etsyHomePage;
    public static GoogleSearchPage googleSearchPage;
    public static GoogleSearchResultsPage googleSearchResultsPage;

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
