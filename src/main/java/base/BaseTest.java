package base;

import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.Logger;
import utilities.LoggerManager;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log = LoggerManager.getLogger(this.getClass());

    @BeforeMethod
    public void setup(){
        log.info("Initializing browser");
        DriverFactory.initializeDriver();
        driver = DriverFactory.getDriver();

        String url = ConfigReader.getProperty("url");
        log.info("Opening URL : {}", url);
        driver.get(url);
        log.info("Page Title : {}", driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        log.info("Closing browser");
        DriverFactory.quitDriver();
    }
}
