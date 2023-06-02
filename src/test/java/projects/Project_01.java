package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.GlobalBase;

import java.util.List;

public class Project_01 extends GlobalBase {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-21")).click();
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the heading is “Contact Us”
     * Validate the address is “2860 S River Rd Suite 350, Des Plaines IL 60018”
     * Validate the email is “info@techglobalschool.com"
     * Validate the phone number is “(773) 257-3010”
     */

    @Test
    public void ValidateContactInformation(){
        WebElement heading = driver.findElement(By.cssSelector("div [class='is-size-2']"));
        WebElement address = driver.findElement(By.id("address"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement phoneNumber = driver.findElement(By.id("phone-number"));


        Assert.assertEquals(heading.getText(), "Contact Us");
        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");
        Assert.assertEquals(email.getText(), "info@techglobalschool.com");
        Assert.assertEquals(phoneNumber.getText(), "(773) 257-3010");

    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Full name input box is displayed
     * Validate that the Full name input box is required
     * Validate that the label of the Full name input box is “Full name *”
     * Validate that the placeholder of the Full name input box is “Enter your name”
     */

    @Test
    public void validateFullNameInputBox(){
        WebElement fullNameInput = driver.findElement(By.cssSelector("input[placeholder='Enter your full name']"));
        WebElement fullNameLabel = driver.findElement(By.cssSelector("label[for='name']"));

        Assert.assertTrue(fullNameInput.isDisplayed());
        Assert.assertEquals(fullNameInput.getAttribute("required"), "true");
        Assert.assertEquals(fullNameLabel.getText(), "Full name *");
        Assert.assertEquals(fullNameInput.getAttribute("placeholder"), "Enter your full name");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the label is “Gender *”
     * Validate that the Gender is required
     * Validate the options are “Female”, “Male” and “Prefer not to disclose”
     * Validate the options are clickable and not selected
     * Click on the “Male” option and validate it is selected while the others are not selected
     * Click on the “Female” option and validate it is selected while the others are not selected
     */

    @Test
    public void validateGenderRadioButton(){
        WebElement genderHeader = driver.findElement(By.cssSelector("div[class='control'] label[class=label]"));
        Assert.assertEquals(genderHeader.getText(), "Gender *");
        Assert.assertTrue(true, genderHeader.getAttribute("required"));

        List<WebElement> genderTypeLabel = driver.findElements(By.cssSelector("label[class^='radio']"));
        List<WebElement> genderTypeInput = driver.findElements(By.cssSelector("input[type='radio']"));

        String[] expectedTypes = {"Male", "Female", "Prefer not to disclose"};

        for (int i = 0; i < genderTypeLabel.size(); i++) {
            Assert.assertEquals(genderTypeLabel.get(i).getText(), expectedTypes[i]);
            Assert.assertTrue(genderTypeLabel.get(i).isDisplayed());
            Assert.assertTrue(genderTypeInput.get(i).isEnabled());
            Assert.assertFalse(genderTypeInput.get(i).isSelected());
        }

        for (int i = 0; i < genderTypeInput.size(); i++) {
            if(i == 0) continue;
            Assert.assertFalse(genderTypeInput.get(i).isSelected());
        }

        for (int i = 0; i < genderTypeInput.size(); i++) {
            if(i == 1) continue;
            Assert.assertFalse(genderTypeInput.get(i).isSelected());
        }

    }


    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Address input box is displayed
     * Validate that the Address input box is not required
     * Validate that the label of the Address input box is “Address”
     * Validate that the placeholder of the Address input box is “Enter your address*”
     */

    @Test
    public void validateAddressInputBox(){
        WebElement addressInput = driver.findElement(By.cssSelector("input[placeholder='Enter your address']"));
        WebElement addressLabel = driver.findElement(By.cssSelector("form div:nth-child(3) label"));

        Assert.assertEquals(addressLabel.getText(),"Address");
        Assert.assertTrue(addressInput.isDisplayed());
        Assert.assertNull(addressInput.getAttribute("required"));
        Assert.assertEquals(addressInput.getAttribute("placeholder"),"Enter your address");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Email input box is displayed
     * Validate that the Email input box is required
     * Validate that the label of the Email input box is “Email”
     * Validate that the placeholder of the Email input box is “Enter your email”
     */

    @Test
    public void validateEmailInputBox(){
        WebElement emailInput = driver.findElement(By.cssSelector("form div:nth-child(4) div input"));
        WebElement emailLabel = driver.findElement(By.cssSelector("form div:nth-child(4) label"));

        Assert.assertEquals(emailLabel.getText(), "Email *");
        Assert.assertTrue(true, emailLabel.getAttribute("required"));
        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertEquals(emailInput.getAttribute("placeholder"), "Enter your email");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Phone input box is displayed
     * Validate that the Phone input box is not required
     * Validate that the label of the Phone input box is “Phone”
     * Validate that the placeholder of the Address input box is “Enter your phone number”
     */

    @Test
    public void validatePhoneInputBox(){
        WebElement phoneInput = driver.findElement(By.cssSelector("form div:nth-child(5) div input"));
        WebElement phoneLabel = driver.findElement(By.cssSelector("form div:nth-child(5) label"));

        Assert.assertTrue(phoneInput.isDisplayed());
        Assert.assertNull(phoneInput.getAttribute("required"));

        Assert.assertEquals(phoneLabel.getText(),"Phone");
        Assert.assertEquals(phoneInput.getAttribute("placeholder"),"Enter your phone number");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate that the Message text area is displayed
     * Validate that the Message text area is not required
     * Validate that the label of the Message text area is “Message”
     * Validate that the placeholder of the Message text area is “Type your message here…”
     */

    @Test
    public void validateMessageTextArea(){
        WebElement messageInput = driver.findElement(By.cssSelector("form div:nth-child(6) div"));
        WebElement messageLabel = driver.findElement(By.cssSelector("form div:nth-child(6) label"));

        Assert.assertTrue(messageInput.isDisplayed());
        Assert.assertNull(messageInput.getAttribute("required"));

        Assert.assertEquals(messageLabel.getText(),"Message");
        Assert.assertNull(messageInput.getAttribute("placeholder")); // Type your message here…
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the label is “I give my consent to be contacted.”
     * Validate that the Consent checkbox is required
     * Validate that the Consent checkbox is clickable
     * Click on the “I give my consent to be contacted.” checkbox and validate it is selected
     * Click on the “I give my consent to be contacted.” checkbox again and validate it is not selected
     */

    @Test
    public void validateConsentCheckbox(){
        WebElement checkboxInput = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement checkboxLabel = driver.findElement(By.cssSelector(".checkbox"));

        Assert.assertTrue(checkboxLabel.isDisplayed());
        Assert.assertEquals(checkboxLabel.getText()," I give my consent to be contacted.");

        Assert.assertEquals(checkboxInput.getAttribute("required"),"true");
        Assert.assertTrue(checkboxInput.isEnabled());

        checkboxLabel.click();
        Assert.assertTrue(checkboxInput.isSelected());

        checkboxLabel.click();
        Assert.assertFalse(checkboxInput.isSelected());
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Validate the “SUBMIT” button is displayed
     * Validate the “SUBMIT” button is clickable
     * Validate that the button text is “SUBMIT”
     */

    @Test
    public void validateSubmitButton(){
        WebElement buttonLabel = driver.findElement(By.cssSelector("button[type='submit']"));

        Assert.assertTrue(buttonLabel.isDisplayed());
        Assert.assertTrue(buttonLabel.isEnabled());

        Assert.assertEquals(buttonLabel.getText(),"SUBMIT");
    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-1
     * Enter a first name
     * Select a gender
     * Enter an address
     * Enter an email
     * Enter a phone number
     * Enter a message
     * Select the “I give my consent to be contacted.” checkbox
     * Click on the “SUBMIT” button
     * Validate the form message “Thanks for submitting!” is displayed under the “SUBMIT” button
     */

    @Test
    public void validateFormSubmission(){
        List<WebElement> placeholders = driver.findElements(By.cssSelector("div[class='control'] >input[placeholder^=Enter],textarea"));
        String[] keys = {"Paul Kim","5132 Aptakisic","paul.hkim@outloo.com","(847) 877-2608","Thank you for accepting me testing testing 123"};
        for (int i = 0; i < placeholders.size() ; i++) {
            placeholders.get(i).sendKeys(keys[i]);

        }

        List<WebElement> buttonLabel = driver.findElements(By.cssSelector("label[class^='radio']"));
        buttonLabel.get(0).click();

        WebElement checkBoxLabel = driver.findElement(By.cssSelector("label[class='checkbox']"));
        checkBoxLabel.click();

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        WebElement thankYouMessage = driver.findElement(By.cssSelector("strong[class='mt-5'"));
        Assert.assertEquals(thankYouMessage.getText(),"Thanks for submitting!");
    }
}
