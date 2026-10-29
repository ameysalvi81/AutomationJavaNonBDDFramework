package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

    public static WebElement waitForVisibilitiy(WebDriver driver, By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(WebDriver driver, By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(locator));
    }
}
