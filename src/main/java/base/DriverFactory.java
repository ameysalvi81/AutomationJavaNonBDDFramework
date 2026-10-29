package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import utilities.ConfigReader;

import java.util.Locale;

import static java.sql.DriverManager.getDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver>
            driver = new ThreadLocal<>();

    public static void initializeDriver(){

        String browser = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        int width = Integer.parseInt(ConfigReader.getProperty("windowWidth"));
        int height = Integer.parseInt(ConfigReader.getProperty("windowHeight"));

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--window-size=" + width + "," + height);
                }
                driver.set(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (headless) {
                    firefoxOptions.addArguments("-headless");
                    firefoxOptions.addArguments("--window-size=" + width + "," + height);
                }
                driver.set(new FirefoxDriver(firefoxOptions));
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--window-size=" + width + "," + height);
                }
                driver.set(new EdgeDriver(edgeOptions));
                break;
            case "safari":
                if (headless) {
                    throw new RuntimeException("Safari does not support headless mode");
                }
                driver.set(new SafariDriver());
                break;
            default:
                throw new RuntimeException("Invalid Browser " + browser);
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if (driver.get() != null) {
            driver.get().quit();
        }
    }

}