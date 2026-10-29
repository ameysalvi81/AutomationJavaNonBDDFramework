package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtility;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        WaitUtility.waitForClickable(driver,locator,10).click();
    }

    protected void type(By locator, String text) {
        WaitUtility.waitForVisibilitiy(driver,locator,10).sendKeys(text);
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}
