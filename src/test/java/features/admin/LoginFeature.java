package features.admin;

import Core.TAEDriver;
import pages.admin.LoginPage;

import java.awt.dnd.DragSourceEvent;
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

    public void loginAdminWithDifferentCredentials(Map<String, Object> parameters) {
        loginPage.goToLoginPage();
            loginPage.fillLoginInput((String) parameters.get(LOGIN));
            loginPage.fillPasswordInput((String) parameters.get(PASSWORD));
            if (parameters.get(SUBMIT) == null || (Boolean) parameters.get(SUBMIT)) {
                loginPage.submitForm();
            }
    }

    public void loginAdminWithGoodCredentials() {
        loginPage.goToLoginPage();
        loginPage.fillLoginInput(GOOD_LOGIN);
        loginPage.fillPasswordInput(GOOD_PASSWORD);
        loginPage.submitForm();
    }


}
