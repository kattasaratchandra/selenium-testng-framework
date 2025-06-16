package org.myframeworks.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

public class ExtentReportsDemoTest {

    @Test
    public void testExtentReports() {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/ExtentReportsDemoTest.html");
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Extent Reports Demo");
        extentSparkReporter.config().setReportName("Sample Extent Report");
        extentSparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);

        extentReports.createTest("Sample Test")
                .info("This is a sample test to demonstrate ExtentReports")
                .pass("Test passed successfully");

        extentReports.createTest("Another Test")
                .info("This is another test to demonstrate ExtentReports")
                .fail("Test failed due to some reason");

        extentReports.flush(); // Ensure the report is written to the file

    }

}
