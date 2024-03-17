package pages.admin;

import BaseAbstractElements.BaseAbstractPage;
import Core.TAEDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BaseAbstractPage {

    public final String REMINDER_URL = "/admin/auth/reminder";

    @FindBy(xpath = "//span[@class= 'size_xxxl color_dark weight_semibold']")
    public WebElement RemindPasswordSpan;

    @FindBy(xpath = "//form[@class='form_block']//p[@class='size_xl']")
    public WebElement EnterEmailParagraph;

    @FindBy(xpath = "//a[@class='link']")
    public WebElement linkBackToLogin;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='flash-messenger']")
    public WebElement flashMassage;

    public ForgotPasswordPage(TAEDriver driver) {
        super(driver);
        PageFactory.initElements(driver.getDriver(), this);
    }

    public void goToForgotPasswordPage() {
        goToPage(BASE_URL + REMINDER_URL);
    }

    public void backToLoginPage() {
        clickElement(linkBackToLogin);
    }

    public void clickSubmit(){
        clickElement(submitButton);
    }

    public void fillEmailInput(String EMAIL) {emailInput.sendKeys(EMAIL);}

}


