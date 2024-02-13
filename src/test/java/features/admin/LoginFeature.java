package features.admin;

import Core.TAEDriver;
import pages.admin.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginFeature extends BaseAbstractFeature {
    public LoginPage loginPage;
    public final String LOGIN = "login";
    public final String PASSWORD = "password";
    public final String SUBMIT = "submit";

    public LoginFeature(TAEDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void loginAdmin(Map<String, Object> parameters) {
        loginPage.goToLoginPage();
        loginPage.fillLoginInput(parameters.get(LOGIN) != null ? (String) parameters.get(LOGIN) : GOOD_LOGIN);
        loginPage.fillPasswordInput(parameters.get(PASSWORD) != null ? (String) parameters.get(PASSWORD) : GOOD_PASSWORD);
        if (parameters.get(SUBMIT) == null || (Boolean) parameters.get(SUBMIT)) {
            loginPage.submitForm();
        }
    }

}
