package tests;

import BaseTest.BaseAbstractTest;
import Core.TAEDriver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PracticeAutomationTests extends BaseAbstractTest {
    public final String BASE_URL = "https://automationintesting.online";
    public final String BASE_URL_APILO = "https://laptok.apilo.com/";
    public boolean cantDownload = true;


    public PracticeAutomationTests() {
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




    private String extractText(String text) {
        Pattern pattern = Pattern.compile("(https.*22)");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(0).replace("\\", "");
        }
        return null;
    }


}
