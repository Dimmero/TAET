package tests;

import BaseTest.BaseAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

public class Test1 extends BaseAbstractTest {
    public final String BASE_URL = "https://automationintesting.online";
    public Test1() {
        super("chrome", false);
    }

    @Test
    public void submitFormWithAllParameters() {
        FormPage loginPage = new FormPage(getDriver());
        getDriver().getDriver().get(BASE_URL);
        String confirmationText = "Thanks for getting in touch %s!";
        String name = "Dima";
        String email = "a@a.com";
        String phone = "12345678333390";
        String subject = "TestSubject";
        String message = "Test message Test message";
        loginPage.setNameContent(name);
        loginPage.setEmailContent(email);
        loginPage.setPhoneContent(phone);
        loginPage.setSubjectContent(subject);
        loginPage.setMessageContent(message);
        loginPage.clickButton();
        Assert.assertEquals(loginPage.getConfirmationText(), String.format(confirmationText, name));
    }

}
