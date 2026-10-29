package listeners;

import base.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ReportManager;
import utilities.ScreenshotUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    private static final ExtentReports extent = ReportManager.getInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ScreenshotUtility.capture(DriverFactory.getDriver(),result.getName());
        System.out.println("Screenshot captured for " + result.getName());

        test.get().fail(result.getThrowable());

        try {
            test.get().fail("Screenshot Attached").addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Extent report flushing...");
        extent.flush();
    }
}
