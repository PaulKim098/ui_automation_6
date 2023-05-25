package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _09_TGCheckboxTest extends Base{

    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Checkboxes" card
    Validate "Apple" and "Microsoft" checkboxes are displayed, enabled, and not selected
    Select both and validate they are both selected
    Deselect both and validate they are deselected
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-7")).click();
    }

    @Test
    public void validateAllCheckboxes(){
        List<WebElement> allCheckboxesLabel = driver.findElements(By.cssSelector("#checkbox-button-group_1 label"));
        List<WebElement> allCheckboxesInput = driver.findElements(By.cssSelector("#checkbox-button-group_1 input"));

        allCheckboxesInput.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertFalse(cb.isSelected());
            Assert.assertTrue(cb.isEnabled());
        });

//        for (int i = 0; i < allCheckboxesLabel.size() ; i++) {
//            Assert.assertTrue(allCheckboxesInput.get(i).isDisplayed());
//            Assert.assertTrue(allCheckboxesInput.get(i).isEnabled());
//            Assert.assertFalse(allCheckboxesInput.get(i).isSelected());
//        }

        for (int i = 0; i < allCheckboxesLabel.size(); i++) {
            allCheckboxesLabel.get(i).click();
            Assert.assertTrue(allCheckboxesInput.get(i).isSelected());
        }

        for (int i = 0; i < allCheckboxesLabel.size(); i++) {
            allCheckboxesLabel.get(i).click();
            Assert.assertFalse(allCheckboxesInput.get(i).isSelected());
        }
    }

    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Checkboxes" card
    Validate "Tesla" and "SpaceX" checkboxes are displayed, enabled, and not selected
    Select both and validate they are both selected
    Deselect both and validate they are deselected
     */

    @Test
    public void validateOtherBoxes(){
        List<WebElement> allCheckboxesLabel = driver.findElements(By.cssSelector("#checkbox-button-group_2 label"));
        List<WebElement> allCheckboxesInput = driver.findElements(By.cssSelector("#checkbox-button-group_2 input"));

        allCheckboxesInput.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertFalse(cb.isSelected());
            Assert.assertTrue(cb.isEnabled());
        });

//        for (int i = 0; i < allCheckboxesLabel.size() ; i++) {
//            Assert.assertTrue(allCheckboxesInput.get(i).isDisplayed());
//            Assert.assertTrue(allCheckboxesInput.get(i).isEnabled());
//            Assert.assertFalse(allCheckboxesInput.get(i).isSelected());
//        }

        for (int i = 0; i < allCheckboxesLabel.size(); i++) {
            allCheckboxesLabel.get(i).click();
            Assert.assertTrue(allCheckboxesInput.get(i).isSelected());
        }

        for (int i = 0; i < allCheckboxesLabel.size(); i++) {
            allCheckboxesLabel.get(i).click();
            Assert.assertFalse(allCheckboxesInput.get(i).isSelected());
        }
    }
}
