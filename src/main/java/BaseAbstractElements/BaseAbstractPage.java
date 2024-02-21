package BaseAbstractElements;

import Core.TAEBaseObject;
import Core.TAEDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseAbstractPage extends TAEBaseObject {
    public TAEDriver driver;
    public final String BASE_URL = "https://sklep165422.shoparena.pl/admin";


    public BaseAbstractPage(TAEDriver driver) {
        this.driver = driver;
        this.driver.wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT), Duration.ofSeconds(DEFAULT_SLEEP));
    }

    public void clickElementByXpath(String xpath) {
        driver.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    public void clickElement(WebElement element) {
        driver.getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void goToPage(String url) {
        driver.getDriver().get(url);
    }

}
