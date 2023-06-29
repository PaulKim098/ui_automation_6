package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class TGBasePage {

    // Modify default constructor to introduce web elements to driver!
    public TGBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Common elements from the header and footer and some other common elements
    @FindBy(id = "logo")
    public WebElement logo;

    @FindBy(id = "dropdown-button")
    public WebElement headerDropdown;

    @FindBy(id = "dropdown-menu a")
    public List<WebElement> headerDropdownOptions;


}
