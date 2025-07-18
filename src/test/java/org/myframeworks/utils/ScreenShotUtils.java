package org.myframeworks.utils;

import org.myframeworks.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


/**
 * Utility class for taking screenshots in the framework.
 * Provided method to capture screenshots and return them in Base64 format.
 */
public class ScreenShotUtils {

    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
