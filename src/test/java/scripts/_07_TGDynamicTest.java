package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _07_TGDynamicTest extends Base {
    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Dynamic Elements" card
    Validate both boxes are displayed with the below texts
    Box 1
     */

    @BeforeMethod
    public void setURL(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-3")).click();
    }

    @Test
    public void validateDynamicElements(){

        WebElement box1 = driver.findElement(By.cssSelector("p[id^='box_1_']"));


        Assert.assertTrue(box1.isDisplayed());
        Assert.assertEquals(box1.getText(), "Box 1");
    }
}
