package org.myframeworks.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.myframeworks.constants.FrameworkConstants;

import java.util.Objects;

public class ExtentReport {
    private static ExtentReports extentReports;

    public static void initReports(){
        if(Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportPath());
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setDocumentTitle("Extent Reports Demo");
            extentSparkReporter.config().setReportName("Sample Extent Report");
            extentSparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
        }
    }

    public static void flushReports() {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
            ExtentReportManager.unload(); // Ensure the report is written to the file
        }
    }

    public  static void createTest(String testName) {
        if (extentReports != null) {
            ExtentReportManager.setExtentTest(extentReports.createTest(testName));
        }
    }
}
