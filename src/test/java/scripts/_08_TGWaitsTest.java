package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _08_TGWaitsTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-4")).click();
    }


    /*
    TEST CASE 1
    Go to https://techglobal-training.com/frontend/
    Click on the "Waits" card
    Click on the "Click on me to see a red box" button
    Validate that a red box is displayed
     */

    @Test
    public void validateWaitRedBox(){
        WebElement redBoxButton = driver.findElement(By.cssSelector("button[id='red']"));

        redBoxButton.click();

        WebElement redBoxShown = driver.findElement(By.cssSelector("button[class*='Box']"));
        Assert.assertTrue(redBoxShown.isDisplayed());
    }

    @Test
    public void validateWaitBlueBox(){
        WebElement blueBoxButton = driver.findElement(By.cssSelector("button[id='blue']"));
        blueBoxButton.click();

        WebElement blueBoxShown = driver.findElement(By.cssSelector("button[class$='box']"));

        Waiter.waitForVisibilityOfElement(blueBoxShown, 40);
        Assert.assertTrue(blueBoxShown.isDisplayed());

//        Waiter.waitForElementToBeClickable(blueBoxShown, 40); usually use for prevention of user to submit button until certain condition is met.
//        Assert.assertTrue(blueBoxShown.isEnabled());
    }
}
