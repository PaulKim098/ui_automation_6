package scripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _10_TGRadioButtonsTest extends Base{

    /*
    TEST CASE 1
    Go to https://techglobal-training.com/frontend/
    Click on the "Radio Buttons" card
    Validate that "Java", "JavaScript" and "C#" radio buttons are displayed, enabled, and not selected
    Select "Java" and validate it is selected but the other 2 are deselected
    Select "JavaScript" to validate it is selected but the other 2 are deselected
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-6")).click();
    }

    @Test
    public void validateRadioButtons(){
        List<WebElement> buttonLabel = driver.findElements(By.cssSelector("#radio-button-group_1 label"));
        List<WebElement> buttonInput = driver.findElements(By.cssSelector("#radio-button-group_1 input"));

        for (WebElement element : buttonInput) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.isEnabled());
            Assert.assertFalse(element.isSelected());
        }

        buttonLabel.get(0).click();
        Assert.assertTrue(buttonInput.get(0).isSelected());

        for (int i = 1; i < buttonLabel.size(); i++) {
            Assert.assertFalse(buttonLabel.get(i).isSelected());
        }

        buttonLabel.get(1).click();
        Assert.assertTrue(buttonInput.get(1).isSelected());
        Assert.assertFalse(buttonInput.get(0).isSelected());
        Assert.assertFalse(buttonInput.get(2).isSelected());

    }
}
