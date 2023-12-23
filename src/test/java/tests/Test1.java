package tests;

import BaseTest.BaseAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Test1 extends BaseAbstractTest {
    public Test1() {
        super("chrome", false);
    }

    @Test
    public void submitFormWithAllParameters() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.goToPage();

        String name = "Dima";
        String email = "a@a.com";
        String phone = "12345678333390";
        String subject = "TestSubject";
        String message = "Test message Test message";
        loginPage.setNameContent(name);
        loginPage.setEmailContent(email);
        loginPage.setPhoneContent(phone);
        loginPage.setSubjectContent(subject);

        Thread.sleep(1000);
        loginPage.setMessageContent(message);
        loginPage.clickButton();
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.getConfirmationText(), String.format("Thanks for getting in touch %s!", name));
    }

}
