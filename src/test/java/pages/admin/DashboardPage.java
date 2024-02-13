package pages.admin;

import BaseAbstractElements.BaseAbstractPage;
import Core.TAEDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseAbstractPage {
    // here you can put WebElements
    //    @FindBy(xpath = "your xpath")
    //    public WebElement nameOfWebElement;

    public DashboardPage(TAEDriver driver) {
        super(driver);
        PageFactory.initElements(driver.getDriver(), this);
    }

    // here you can put methods which will help you to interact with WebElements of the page.
    // feel free to put here any method you want to facilitate the test implementation
}
