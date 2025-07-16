package org.myframeworks.extentreports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.myframeworks.enums.ConfigProperties;
import org.myframeworks.utils.ReadPropertyFileUtils;
import org.myframeworks.utils.ScreenShotUtils;

public class ExtentLogger {

    public static void pass(String message){
        ExtentReportManager.getExtent().pass(message);
    }

    public static void description(String message){
        ExtentReportManager.getExtent().info(message);
    }

    public static void fail(String message){
        ExtentReportManager.getExtent().fail(message);
    }

    public static void skip(String message){
        ExtentReportManager.getExtent().skip(message);
    }

    public static void pass(String message, Boolean isScreenshotNeeded) {
        if(ReadPropertyFileUtils.getProperty(ConfigProperties.PASSED_EACH_STEPS_SCREENSHOTS.name()).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentReportManager.getExtent().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
        } else {
            pass(message);
        }
    }

    public static void fail(String message, Boolean isScreenshotNeeded) {
        if(ReadPropertyFileUtils.getProperty(ConfigProperties.FAILED_EACH_STEPS_SCREENSHOTS.name()).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentReportManager.getExtent().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
        } else {
            fail(message);
        }
    }

    public static void skip(String message, Boolean isScreenshotNeeded) {
        if(ReadPropertyFileUtils.getProperty(ConfigProperties.SKIPPED_EACH_STEPS_SCREENSHOTS.name()).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentReportManager.getExtent().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
        } else {
            skip(message);
        }
    }


}
