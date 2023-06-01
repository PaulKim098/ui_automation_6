package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DropdownHandler;

import java.util.List;


public class _11_TGDropdownTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-5")).click();
    }

    @Test
    public void productDropdownTest() {


//        Select select = new Select(driver.findElement(By.id("product_dropdown")));
//        select.selectByVisibleText("iPhone 14 Pro Max");

        WebElement dropdown = driver.findElement(By.id("product_dropdown"));
        DropdownHandler.selectByVisibleText(dropdown, "iPhone 14 Pro Max");
    }

    @Test
    public void colorDropdownTest(){

//        Select select = new Select(driver.findElement(By.id("color_dropdown")));
//
//        select.selectByIndex(0);
//        select.selectByIndex(1);
//        select.selectByIndex(2);
//        select.selectByIndex(3);
//
//        Waiter.pause(2);

        WebElement dropdown = driver.findElement(By.id("color_dropdown"));
        DropdownHandler.selectByIndex(dropdown, 2);

    }

    @Test
    public void shipmentTypeTest() {

//        WebElement option = driver.findElement(By.id("shipment_dropdown"));
//        option.click();
//        Waiter.pause(2);
//
//        List<WebElement> select = driver.findElements(By.cssSelector("#shipment_dropdown span:last-child"));
//
//        String[] expectedShipment = {"Delivery", "Pick Up"};
//
//        for (int i = 0; i < expectedShipment.length; i++) {
//            Assert.assertTrue(select.get(i).isDisplayed());
//            Assert.assertEquals(select.get(i).getText(), expectedShipment[i]);
//        }


        WebElement dropdown = driver.findElement(By.id("shipment_dropdown"));
        List<WebElement> dropdownOption = driver.findElements(By.cssSelector("#shipment_dropdown span"));

        DropdownHandler.clickDropdownOption(dropdown, dropdownOption, "Delivery");

    }

    /**
     * Test Case: Validate Dropdowns Functionality on TechGlobal Training Page
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Dropdowns" card
     * Select the "MacBook Pro 13" option from the "Product" dropdown.
     * Select the "Green" option from the "Color" dropdown.
     * Open the "Shipping" dropdown and click on the "Delivery" option.
     * Click on the "Submit" button.
     * Validate result message displays "Your Green MacBook Pro 13 will be delivered to you."
     */

    @Test
    public void validateDropdownFunctionalityTest(){

        WebElement productOption = driver.findElement(By.id("product_dropdown"));
        DropdownHandler.selectByVisibleText(productOption, "MacBook Pro 13");

        WebElement colorOption = driver.findElement(By.id("color_dropdown"));
        DropdownHandler.selectByIndex(colorOption, 2);

        WebElement shipmentOption = driver.findElement(By.id("shipment_dropdown"));
        shipmentOption.click();

        List<WebElement> selectDelivery = driver.findElements(By.cssSelector("#shipment_dropdown span"));
        selectDelivery.get(0).click();

        driver.findElement(By.cssSelector("#submit")).click();
        String resultText = driver.findElement(By.cssSelector("#result")).getText();

        Assert.assertEquals(resultText, "Your Green MacBook Pro 13 will be delivered to you.");

    }
}