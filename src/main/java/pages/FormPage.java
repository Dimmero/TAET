package pages;

import BaseAbstractElements.BaseAbstractPage;
import Core.TAEDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends BaseAbstractPage {
    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameInput;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;
    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneInput;
    @FindBy(xpath = "//input[@id='subject']")
    public WebElement subjectInput;
    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement messageTextarea;
    @FindBy(xpath = "//button[@id='submitContact']")
    public WebElement submitButton;
    @FindBy(xpath = "//div[contains(@class, 'contact')]//h2")
    public WebElement confirmationText;

    public FormPage(TAEDriver driver) {
        super(driver);
        PageFactory.initElements(driver.getDriver(), this);
    }

    public void setNameContent(String value) {
        nameInput.sendKeys(value);
    }

    public void setEmailContent(String value) {
        emailInput.sendKeys(value);
    }

    public void setPhoneContent(String value) {
        phoneInput.sendKeys(value);
    }

    public void setSubjectContent(String value) {
        subjectInput.sendKeys(value);
    }

    public void setMessageContent(String value) {
        messageTextarea.sendKeys(value);
    }

    public void clickButton() {
        submitButton.click();
    }

    public String getConfirmationText() {
        return confirmationText.getText();
    }

}
