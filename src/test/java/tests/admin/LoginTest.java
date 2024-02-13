package tests.admin;

import BaseTest.BaseAbstractTest;
import features.admin.BaseAbstractFeature;
import features.admin.LoginFeature;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import pages.admin.LoginPage;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginTest extends BaseAbstractTest {
    public LoginFeature loginFeature;


    public LoginTest() {
        super("chrome", false);
        loginFeature = new LoginFeature(getDriver());
    }

    @Test
    public void loginHappy() {
        String expectedUrl = "dashboard";
        Map<String, Object> parameters = new HashMap<>();
//        parameters.put(loginFeature.LOGIN, "misha");
//        parameters.put(loginFeature.PASSWORD, "test");
       // parameters.put(loginFeature.SUBMIT, false);
        loginFeature.loginAdmin(parameters);
//        assertThat("Actual url doesn't contain " + expectedUrl, driver.getDriver().getCurrentUrl(), containsStringIgnoringCase(expectedUrl));
        Assert.assertFalse( driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }

    @Test
    public void loginUnhappy(){
        String expectedUrl = "https://sklep165422.shoparena.pl/admin/dashboard";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(loginFeature.LOGIN, "test");
        parameters.put(loginFeature.PASSWORD, "GARAZ123!");
        parameters.put(loginFeature.SUBMIT, true);
        loginFeature.loginAdmin(parameters);
        Assert.assertFalse( driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }

    @Test
    public void loginUnhappyEmptyName(){
        String expectedUrl = "https://sklep165422.shoparena.pl/admin/dashboard";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(loginFeature.LOGIN, "");
        parameters.put(loginFeature.PASSWORD, "Garaz123!");
        parameters.put(loginFeature.SUBMIT, true);
        loginFeature.loginAdmin(parameters);
       // loginFeature.loginPage.passwordInput.get
        Assert.assertFalse( driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }
}
