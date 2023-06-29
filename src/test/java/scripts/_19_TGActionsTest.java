package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.time.Duration;

public class _19_TGActionsTest extends GlobalBase {
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-15")).click();
        actions = new Actions(driver);
    }

    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled "Click on me"
     * Verify that a message appears next to the element stating, "You clicked on a button!"
     * Perform a right-click action on the second web element labeled "Right-Click on me"
     * Verify that the message appears next to the element stating, "You right-clicked on a button!"
     * Perform a double-click action on the third web element labeled "Double-Click on me"
     * Verify that the message appears next to the element stating, "You double-clicked on a button!"
     */

    @Test
    public void validateClickAction() {

        Assert.assertEquals(driver.getCurrentUrl(), "https://techglobal-training.com/frontend/actions");

        WebElement clickMe = driver.findElement(By.id("click"));
        WebElement rightClick = driver.findElement(By.id("right-click"));
        WebElement doubleClick = driver.findElement(By.id("double-click"));

        Assert.assertTrue(clickMe.isDisplayed());
        Assert.assertTrue(rightClick.isDisplayed());
        Assert.assertTrue(doubleClick.isDisplayed());

        actions.moveToElement(clickMe).click().perform();

        WebElement result = driver.findElement(By.id("click_result"));
        Assert.assertEquals(result.getText(), "You clicked on a button!");

        actions.moveToElement(rightClick).contextClick().perform();

        WebElement result1 = driver.findElement(By.id("right_click_result"));
        Assert.assertEquals(result1.getText(), "You right-clicked on a button!");

        actions.moveToElement(doubleClick).doubleClick().perform();

        WebElement result3 = driver.findElement(By.id("double_click_result"));
        Assert.assertEquals(result3.getText(), "You double-clicked on a button!");
    }

    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the web element stating, "An element dropped here!"
     */

    @Test
    public void validateDragAndDrop() {

        WebElement dragButton = driver.findElement(By.id("drag_element"));
        WebElement dropButton = driver.findElement(By.id("drop_element"));

        actions.dragAndDrop(dragButton, dropButton).perform();

        WebElement dragDropResult = driver.findElement(By.id("drag_and_drop_result"));

        Waiter.waitForVisibilityOfElement(dragDropResult, 30);

        Assert.assertEquals(dragDropResult.getText(), "An element dropped here!");

        Waiter.pause(3);
    }

    /**
     * TEST CASE 3
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Go to the input box, and remove if there is an existing text inside -- you can ignore here
     * First, enter “h” to the input box in upper case using keyboard actions
     * Then complete the word by sending “ello” as a key
     * Validate value attribute of the input box is “Hello”
     */

    @Test
    public void keyboardActions() {

        WebElement inputBox = driver.findElement(By.id("input_box"));


        actions.keyDown(Keys.SHIFT)
                .sendKeys(inputBox, "h")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .sendKeys(inputBox, "ello")
                .pause(Duration.ofSeconds(2))
                .perform();

        Assert.assertEquals(inputBox.getAttribute("value"), "Hello");
    }

    /**
     * TEST CASE 4
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Go to the input box, and remove if there is an existing text inside
     * Enter “techglobal” to input the box with uppercases
     * Then, copy the text and paste it again
     * Validate the value attribute for the search input box is “TECHGLOBALTECHGLOBAL”
     */

    @Test
    public void moreKeyboardActions() {
        WebElement inputBox = driver.findElement(By.id("input_box"));

        actions.keyDown(Keys.SHIFT)
                .sendKeys(inputBox, "techglobal")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.COMMAND)
                .sendKeys("acvv")
                .pause(Duration.ofSeconds(2))
                .perform();


    }
}
