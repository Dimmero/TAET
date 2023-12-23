package BaseTest;

import Core.TAEBaseObject;
import Core.TAEDriver;
import Core.TestListener;
import Entities.WebDriverType;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)

public abstract class BaseAbstractTest extends TAEBaseObject {
    private static TAEDriver driver;

    public BaseAbstractTest(String browser, boolean headless) {
        switch (browser) {
            case "chrome" -> driver = new TAEDriver(WebDriverType.CHROME, headless);
            case "firefox" -> driver = new TAEDriver(WebDriverType.FIREFOX, headless);
            case "safari" -> driver = new TAEDriver(WebDriverType.SAFARI, headless);
        }
    }

    public TAEDriver getDriver() {
        return driver;
    }

    private String getClassName() {
        String[] nameLines = this.getClass().toString().split("\\.");
        return nameLines[nameLines.length - 1];
    }

    @BeforeClass
    public void beforeClass(ITestContext iTestContext) {
        iTestContext.setAttribute("driver", driver);
        getLogger().info(String.format("     ***** Start executing class '%s' *****     ", getClassName()));
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.getDriver().quit();
        }
    }


}
