package org.myframeworks.driver;

import org.myframeworks.enums.ConfigProperties;
import org.myframeworks.utils.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

import static org.myframeworks.driver.DriverManager.*;

public final class Driver {
    private Driver() {}

    public static void initDriver() {
        if(Objects.isNull(getDriver())) {
            WebDriver driver = new ChromeDriver();
            setDriver(driver);
            WebDriver localDriver = getDriver();
            localDriver.manage().window().maximize();
            localDriver.get(ReadPropertyFile.getProperty(ConfigProperties.URL.name().toLowerCase()));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }
    }
}
