package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
    public void validateDynamicElementBox1(){

        WebElement box1 = driver.findElement(By.cssSelector("p[id^='box_1_']"));


        Assert.assertTrue(box1.isDisplayed());
        Assert.assertEquals(box1.getText(), "Box 1");
    }

    /*
    TEST CASE 2
    Go to https://techglobal-training.com/frontend/
    Click on the "Dynamic Elements" card
    Validate box2 is displayed with the below texts
    Box 2
     */
    @Test
    public void validateDynamicElementBox2(){
        WebElement box2 = driver.findElement(By.cssSelector("p[id^='box_2_']"));


        Assert.assertTrue(box2.isDisplayed());
        Assert.assertEquals(box2.getText(), "Box 2");
    }

    /*
    TEST CASE 3
    Go to https://techglobal-training.com/frontend/
    Click on the "Dynamic Elements" card
    Validate that both boxes are displayed with the below texts
    Box 1, Box 2
     */

    @Test
    public void validateBoxes(){
//        List<WebElement> allBoxes = driver.findElements(By.tagName("p"));
        List<WebElement> allBoxes = driver.findElements(By.cssSelector("p[id*='box_']"));

        String[] expectedBoxes = {"Box 1", "Box 2"};

        for (int i = 0; i < expectedBoxes.length; i++) {
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            Assert.assertEquals(allBoxes.get(i).getText(), expectedBoxes[i]);
        }

//        List<String> expectedBoxes = Arrays.asList("Box 1", "Box 2");
//
//        List<WebElement> allBoxes = driver.findElements(By.cssSelector("p[id*='box_']"));
//
//        IntStream.range(0, expectedBoxes.size())
//                .forEach(i -> {
//                    Assert.assertTrue(allBoxes.get(i).isDisplayed());
//                    Assert.assertEquals(allBoxes.get(i).getText(), expectedBoxes.get(i));
//                });


    }
}
