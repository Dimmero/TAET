package pages.admin;

import BaseAbstractElements.BaseAbstractPage;
import BaseTest.BaseAbstractTest;
import Core.TAEDriver;
import Entities.WebDriverType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class LoginPage extends BaseAbstractPage {
    public final String LOGIN_URL = "/auth/login";

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class = 'box box_spacing-s']//h1")
    public WebElement inscriptionLogin;

    @FindBy(xpath = "//div[@class='mb-6']//p[@class='size_xl']")
    public WebElement inscriptionUnderLogin;

    @FindBy(xpath = "//a[contains(@href,'/admin/auth/reminder')]")
    public WebElement buttonForgotPassword;

    @FindBy(xpath = "//div[@class ='flash-messenger']")
    public WebElement flashMassage;


    public LoginPage(TAEDriver driver) {
        super(driver);
        PageFactory.initElements(driver.getDriver(), this);
    }

    public void fillLoginInput(String login) {
        loginInput.sendKeys(login);
    }

    public void fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void submitForm() {
        clickElement(submitButton);
    }

    public void clickForgotPassword() {
        clickElement(buttonForgotPassword);
    }

    public void goToLoginPage() {
        goToPage(BASE_URL + LOGIN_URL);
    }

}
