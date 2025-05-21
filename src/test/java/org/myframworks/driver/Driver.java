package org.myframworks.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    public static WebDriver driver;

    public static void setDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in/");
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
