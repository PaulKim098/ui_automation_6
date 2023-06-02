package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TGIFramesPages extends TGBasePage{
    public  TGIFramesPages(){
        super();
    }

    @FindBy(css = "#name_form > p")
    public WebElement inputHeader;

    @FindBy(css = "#form_frame")
    public WebElement iFrameId;



}
