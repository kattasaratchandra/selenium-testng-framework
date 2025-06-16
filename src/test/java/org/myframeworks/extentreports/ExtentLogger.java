package org.myframeworks.extentreports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.myframeworks.driver.DriverManager;
import org.myframeworks.utils.ReadPropertyFileUtils;
import org.openqa.selenium.TakesScreenshot;

public class ExtentLogger {

    public static void pass(String message){
        ExtentReportManager.getExtent().pass(message);
    }

    public static void fail(String message){
        ExtentReportManager.getExtent().fail(message);
    }

    public static void skip(String message){
        ExtentReportManager.getExtent().skip(message);
    }

    public static void pass(String message, Boolean isScreenshotNeeded) {
        if(ReadPropertyFileUtils.getProperty("passedEachStepsScreenshots").equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentReportManager.getExtent().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot()).build());
        } else {
            pass(message);
        }
    }

    public static void fail(String message, Boolean isScreenshotNeeded) {
        if(ReadPropertyFileUtils.getProperty("failedEachStepsScreenshots").equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentReportManager.getExtent().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot()).build());
        } else {
            fail(message);
        }
    }

    public static void skip(String message, Boolean isScreenshotNeeded) {
        if(ReadPropertyFileUtils.getProperty("skippedEachStepsScreenshots").equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentReportManager.getExtent().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot()).build());
        } else {
            skip(message);
        }
    }

    private static String base64Screenshot() {
     return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(org.openqa.selenium.OutputType.BASE64);
    }

}
