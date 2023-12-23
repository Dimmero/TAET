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
import org.openqa.selenium.remote.DesiredCapabilities;

public class TAEDriver extends TAEBaseObject {
    private WebDriver driver;
    private WebDriverType driverType;
    private final String HEADLESS_CHROME = "headless";

    public TAEDriver(WebDriverType driverType) {
        this.driverType = driverType;
        if(driverType == WebDriverType.CHROME) {
            configureChromeDriver();
            runChromeDriver(false);
        } else if (driverType == WebDriverType.FIREFOX) {
            runFirefoxDriver(false);
        } else if (driverType == WebDriverType.EDGE) {
            runEdgeDriver();
        }
        else {
            throw new WebDriverException(String.format("Not configured driver type %s. ", driverType.getDriverName()));
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }


    private void configureChromeDriver() {
        System.setProperty("headless", "false");
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    private void runChromeDriver(boolean headless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) {
            chromeOptions.addArguments("--" + HEADLESS_CHROME);
        }
        driver = new ChromeDriver(chromeOptions);
    }

    private void runFirefoxDriver(boolean headless) {
        FirefoxOptions ffOptions = new FirefoxOptions();
        if(headless) {
            ffOptions.addArguments("--" + HEADLESS_CHROME);
        }
        driver = new FirefoxDriver(ffOptions);
    }

    private void runEdgeDriver() {
        DesiredCapabilities capability = DesiredCapabilities.edge();
        EdgeOptions edgeOptions = new EdgeOptions();
        capability.setCapability("edge option", edgeOptions);
        driver = new EdgeDriver();
    }
}
