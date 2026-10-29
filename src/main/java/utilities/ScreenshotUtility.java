package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtility {

    public static String capture(WebDriver driver, String testName) {
        try{
            File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Path screenshotsFolder = Paths.get("screenshots");
            Files.createDirectories(screenshotsFolder);
            Path target = screenshotsFolder.resolve(testName + "_" + System.currentTimeMillis() + ".png");
            Files.copy(source.toPath(), target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot Path: " + target.toAbsolutePath());
            return target.toAbsolutePath().toString();
        } catch(Exception e){
            throw new RuntimeException("Screenshot failed!", e);
        }
    }
}
