package Core;

import Entities.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class TAEDriver extends TAEBaseObject {
    private WebDriver driver;
    private WebDriverType driverType;

    public TAEDriver(WebDriverType driverType, boolean headless) {
        this.driverType = driverType;
        if(driverType == WebDriverType.CHROME) {
            configureChromeDriver();
            runChromeDriver(headless);
        } else if (driverType == WebDriverType.FIREFOX) {
            runFirefoxDriver(headless);
        } else if (driverType == WebDriverType.SAFARI) {
            runSafariDriver(headless);
        }
        else {
            throw new WebDriverException(String.format("Not configured driver type %s. ", driverType.getDriverName()));
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void configureChromeDriver() {
        System.setProperty("headless", "false");
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    private void runChromeDriver(boolean headless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) {
            chromeOptions.addArguments("--headless");
        }
        driver = new ChromeDriver(chromeOptions);
    }

    private void runSafariDriver(boolean headless) {
//        SafariOptions safariOptions = new SafariOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");
//        if(headless) {
//            safariOptions.setCapability("--headless", headless);
//        }
        driver = new SafariDriver(SafariOptions.fromCapabilities(capabilities));
    }

    private void runFirefoxDriver(boolean headless) {
        FirefoxOptions ffOptions = new FirefoxOptions();
        if(headless) {
            ffOptions.addArguments("--headless");
        }
        driver = new FirefoxDriver(ffOptions);
    }


}
