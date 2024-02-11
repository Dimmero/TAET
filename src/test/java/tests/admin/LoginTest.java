package tests.admin;

import BaseTest.BaseAbstractTest;
import org.junit.Assert;
import org.junit.Test;
import pages.admin.LoginPage;

public class LoginTest extends BaseAbstractTest {
    public LoginPage loginPage;

    public LoginTest() {
        super("chrome", false);
        loginPage = new LoginPage(getDriver());
    }

    @Test
    public void loginHappy() {
        System.out.println("Happy");
    }
}
