package org.myframeworks.driver;

import org.myframeworks.enums.ConfigProperties;
import org.myframeworks.utils.ReadPropertyFileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

import static org.myframeworks.driver.DriverManager.*;

public final class Driver {
    private Driver() {}

    public static void initDriver(String browser) {
        if(Objects.isNull(getDriver())) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriver driver = new ChromeDriver();
                setDriver(driver);
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriver driver = new FirefoxDriver();
                setDriver(driver);
            }   else {
                throw new IllegalArgumentException("Browser not supported: " + browser);
            }
            WebDriver localDriver = getDriver();
            localDriver.manage().window().maximize();
            localDriver.get(ReadPropertyFileUtils.getProperty(ConfigProperties.URL.name().toLowerCase()));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }
    }
}
