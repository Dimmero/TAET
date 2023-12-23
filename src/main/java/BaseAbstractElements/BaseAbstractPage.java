package BaseAbstractElements;

import Core.TAEBaseObject;
import Core.TAEDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseAbstractPage extends TAEBaseObject {
    protected TAEDriver driver;
    protected WebDriverWait wait;

    public BaseAbstractPage(TAEDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT), Duration.ofSeconds(DEFAULT_SLEEP));
    }

    public void clickElement(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.getDriver().findElement(By.xpath(xpath)).click();
    }
}
