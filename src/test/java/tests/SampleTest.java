package tests;

import base.BaseTest;
import base.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void frameworkValidation() {
        String title = driver.getTitle();
        Assert.assertFalse(title.isEmpty());
        System.out.println("Title: " + title);
    }
}
