package tests.admin;

import BaseTest.BaseAbstractTest;
import com.beust.jcommander.IValueValidator;
import features.admin.LoginFeature;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.admin.ForgotPasswordPage;
import pages.admin.LoginPage;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest extends BaseAbstractTest {
    public LoginFeature loginFeature;
    public LoginPage loginPage;

    public ForgotPasswordPage forgotPasswordPage;

    public LoginTest() {
        super("chrome", false);
        loginFeature = new LoginFeature(getTAEDriver());
        loginPage = new LoginPage(getTAEDriver());
    }

    @Test
    public void verifyLoginWithValidCredentials() {
        String expectedUrl = "/dashboard";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(loginFeature.LOGIN, "test");
        parameters.put(loginFeature.PASSWORD, "Garaz123!");
        parameters.put(loginFeature.SUBMIT, true);
        loginFeature.loginAdminWithDifferentCredentials(parameters);
        Assert.assertTrue(driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }

    @Test(dataProvider = "loginData")
    public void verifyLoginWithInvalidCredentials(String login, String password) {
        String expectedUrl = "/dashboard";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(loginFeature.LOGIN, login);
        parameters.put(loginFeature.PASSWORD, password);
        parameters.put(loginFeature.SUBMIT, true);
        loginFeature.loginAdminWithDifferentCredentials(parameters);
        Assert.assertFalse(driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }

    @Test
    public void verifyFlashMessageInvalidCredentials() {
        String expectedFlashMsg = "Nieprawidłowy login lub hasło.";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(loginFeature.LOGIN, "Test");
        parameters.put(loginFeature.PASSWORD, "test");
        parameters.put(loginFeature.SUBMIT, true);
        loginFeature.loginAdminWithDifferentCredentials(parameters);
        Assert.assertEquals(loginPage.flashMassage.getAttribute("outerText"), expectedFlashMsg);
    }

    @Test
    public void verifyUrlAfterSwitchToEN() {
        String expectedUrl = "/admin/auth/login?language=en_US";
        loginPage.goToLoginPage();
        loginPage.switchToLanguage("en_US");
        Assert.assertTrue(driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }

    @Test
    public void verifyTranslationAfterSwitchLanguageEnglish() {
        loginPage.goToLoginPage();
        String inscriptionLoginTextBefore = loginPage.inscriptionLogin.getText();
        String inscriptionUnderLoginTextBefore = loginPage.inscriptionUnderLogin.getText();
        String buttonForgotPasswordTextBefore = loginPage.buttonForgotPassword.getText();
        loginPage.switchToLanguage("en_US");
        String inscriptionLoginTextAfter = loginPage.inscriptionLogin.getText();// remove inscription
        String inscriptionUnderLoginTextAfter = loginPage.inscriptionUnderLogin.getText();
        String buttonForgotPasswordTextAfter = loginPage.buttonForgotPassword.getText();
        Assert.assertNotEquals(inscriptionLoginTextBefore,inscriptionLoginTextAfter, "text login doesn't exchange");
        Assert.assertNotEquals(inscriptionUnderLoginTextBefore,inscriptionUnderLoginTextAfter,"text under login doesn't exchange" );
        Assert.assertNotEquals(buttonForgotPasswordTextBefore,buttonForgotPasswordTextAfter, "text button forgot password doesn't exchange");
    }

    @Test
    public void  appearanceOfDotsInPasswordField(){
        String expectedPassword = "1234567891";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(loginFeature.LOGIN, "Test");
        parameters.put(loginFeature.PASSWORD,"1234567891");
        loginFeature.loginAdminWithDifferentCredentials(parameters);
        Assert.assertNotEquals(loginPage.passwordInput.getText(),expectedPassword);
    }

    @Test
    public void verifyGoToForgotPasswordPage(){
        String expectedUrl = forgotPasswordPage.REMINDER_URL;
        loginPage.goToLoginPage();
        loginPage.clickForgotPassword();
        Assert.assertTrue(driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }

    @DataProvider(name = "loginData")
    public Object[][] createTestData() {
        return new Object[][]{
                {"Test", "test"},
                {"Test", ""},
                {"", "test"},
                {"", ""}
        };
    }
}
