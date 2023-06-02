package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TGBasePage;
import utils.Waiter;

public class _03_5_TGLogoTest extends Base {

    @Test
    public void validateTechGlobalLogo(){
        Waiter.waitForVisibilityOfElement(techGlobalBasePage.logo, 30);
        Assert.assertTrue(techGlobalBasePage.logo.isDisplayed());
    }

}
