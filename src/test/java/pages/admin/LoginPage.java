package pages.admin;

import BaseAbstractElements.BaseAbstractPage;
import BaseTest.BaseAbstractTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    public final String LOGIN_URL = "/auth/login";
   @FindBy(xpath = "//input[@name='login']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//a[contains(@href, 'pl_PL')]")
    public WebElement languagePlLink;

    @FindBy(xpath = "//a[contains(@href, 'en_US')]")
    public WebElement languageUsLink;

    public LoginPage() {
        PageFactory.initElements(driver.getDriver(), this);
    }

    public void fillLoginInput(String login) {
        loginInput.sendKeys(login);
    }

    public void fillPasswordInput(String password) {
        loginInput.sendKeys(password);
    }

    public void switchToLanguage(String language) {
        switch (language) {
            case "pl_PL" -> clickElement(languagePlLink);
            case "en_US" -> clickElement(languageUsLink);
        }
    }

    public void submitForm() {
        clickElement(submitButton);
    }

}
