package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _15_TGFileUpload extends GlobalBase {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-13")).click();
    }

    /**
     * NOTE: Create .txt file called "hello.txt" in the root of your project and use it as a file path
     * TEST CASE
     * Go to https://techglobal-training.com/frontend
     * Click on the "File Upload" card
     * Send the path of the file as keys to the "Choose File" input box
     * Click on the "UPLOAD" button
     * Validate the result message equals "You Uploaded "hello.txt"
     */

    @Test
    public void basicFileUpload(){
        WebElement fileUploadInput = driver.findElement(By.id("file_upload"));
        WebElement submitButton = driver.findElement(By.id("file_submit"));

        String filePath = "C:\\Users\\STP\\IdeaProjects\\ui_automation_6\\hello.txt";

        fileUploadInput.sendKeys(filePath);
        submitButton.click();

        WebElement resultMessage = driver.findElement(By.id("result"));
        Assert.assertEquals(resultMessage.getText(), "You Uploaded '" +
                filePath.substring(filePath.lastIndexOf('\\') + 1) + "'");

    }

}
