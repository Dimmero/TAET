package tests;

import BaseTest.BaseAbstractTest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PracticeAutomationTests extends BaseAbstractTest {
    public final String BASE_URL = "https://automationintesting.online";

    public PracticeAutomationTests() {
        super("chrome", true);
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

    @Test
    public void practiceJsoup() {
        Document document = null;
        try {
            document = Jsoup.connect(BASE_URL).get();
        } catch (IOException e) {
            e.getStackTrace();
        }
        assert document != null;
        Elements elements = document.selectXpath("//div[@class='row']//div[@class='col-sm-3 content']");
        if (elements.size() == 0) {
            getDriver().getDriver().get(BASE_URL);
        }
        List<WebElement> par = getDriver().getDriver().findElements(By.xpath("//div[@class='row']//div[@class='col-sm-3 content']//p"));
        String elText = par.get(0).getText();






    }

}
