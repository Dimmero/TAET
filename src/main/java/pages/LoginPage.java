package pages;

import BaseAbstractElements.BaseAbstractPage;
import Core.TAEDriver;
import Entities.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseAbstractPage {

    public String TITLE = "GLO Login";
    public String INFO_TEXT = "Use your GlobalLogic / Windows credential to login";

    @FindBy()
    public WebElement infoLabel;
    public WebElement loginInput;
    public WebElement passwordInput;
    public WebElement loginButton;

    public LoginPage(TAEDriver driver, String title) {
        super(driver, title);
    }

}
