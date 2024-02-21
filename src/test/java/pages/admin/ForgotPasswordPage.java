package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class ForgotPasswordPage {

    public final String REMINDER_URL = "/auth/login/reminder";

    @FindBy(xpath = "//*[@class= 'size_xxxl color_dark weight_semibold']")
    public WebElement inscriptionRemindPassword;

    @FindBy(xpath = "//*[@class='size_xl']")
    public WebElement inscriptionEnterEmail;

    @FindBy(xpath = "//*[@class='link']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class='control control_with-icon']")
    public WebElement eMailInput;

    @FindBy(xpath = "//*[@class='btn btn_bg']")
    public WebElement buttonPasswordReminder;

    @FindBy(xpath = "//a[contains(@href, 'pl_PL')]")
    public WebElement languagePlLink;
    @FindBy(xpath = "//a[contains(@href, 'en_US')]")
    public WebElement languageUsLink;

}
