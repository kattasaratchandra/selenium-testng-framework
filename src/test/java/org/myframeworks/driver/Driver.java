package org.myframeworks.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class Driver {

    public static WebDriver driver;

    public static void setDriver() {
        if(Objects.isNull(driver)) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.co.in/");
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }
}
