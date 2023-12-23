package pages;

import BaseAbstractElements.BaseAbstractPage;
import Core.TAEDriver;
import Entities.WebDriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseAbstractPage {
    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameInput;
    public String nameInputX = "//input[@id='name']";
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;
    public String emailInputX = "//input[@id='email']";
    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneInput;
    public String phoneInputX = "//input[@id='phone']";
    @FindBy(xpath = "//input[@id='subject']")
    public WebElement subjectInput;
    public String subjectInputX = "//input[@id='subject']";
    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement messageTextarea;
    public String messageTextareaX = "//textarea[@id='description']";
    @FindBy(xpath = "//button[@id='submitContact']")
    public WebElement submitButton;
    public String submitButtonX = "//button[@id='submitContact']";
    @FindBy(xpath = "//div[contains(@class, 'contact')]//h2")
    public WebElement confirmationText;
    public String confirmationTextX = "//div[contains(@class, 'contact')]//h2";

    public LoginPage(TAEDriver driver) {
        super(driver);
        PageFactory.initElements(driver.getDriver(), this);
    }

    public void goToPage() {
        driver.getDriver().get("https://automationintesting.online");
    }

    public void setNameContent(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nameInputX)));
        nameInput.sendKeys(value);
    }

    public void setEmailContent(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailInputX)));
        emailInput.sendKeys(value);
    }

    public void setPhoneContent(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(phoneInputX)));
        phoneInput.sendKeys(value);
    }

    public void setSubjectContent(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(subjectInputX)));
        subjectInput.sendKeys(value);
    }

    public void setMessageContent(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(messageTextareaX)));
        messageTextarea.sendKeys(value);
    }

    public void clickButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(submitButtonX)));
        submitButton.click();
    }

    public String getConfirmationText() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(confirmationTextX)));
        return confirmationText.getText();
    }

}
