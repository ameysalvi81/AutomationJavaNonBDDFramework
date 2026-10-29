package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("./reports/ExtentReport.html");
            spark.config().setReportName("Automation Execution Report");
            spark.config().setDocumentTitle("Automation Framework");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester","Amey Salvi");
            extent.setSystemInfo("Framework","Selenium TestNG");
            extent.setSystemInfo("Environment", ConfigReader.getProperty("environment"));
            extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        }
        return extent;
    }
}
