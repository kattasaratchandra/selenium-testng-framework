package org.myframeworks.driver;

import org.myframeworks.enums.ConfigProperties;
import org.myframeworks.utils.ReadPropertyFileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

public class DriverFactory {

    public static WebDriver getDriver(String browser, String version) {
        WebDriver driver = null;
        String runMode = ReadPropertyFileUtils.getProperty(ConfigProperties.RUN_MODE.name());
        if (browser.equalsIgnoreCase("chrome")) {
            if (runMode.equalsIgnoreCase("remote")) {
                // Initialize remote Chrome driver
                ChromeOptions options = new ChromeOptions();
                if (!Objects.equals(version, "latest")) {
                    options.setBrowserVersion(version);
                }
                try {
                    URL url = URI.create("http://localhost:4444/wd/hub").toURL();
                    driver = new RemoteWebDriver(url, options);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (runMode.equalsIgnoreCase("remote")) {

                // Initialize remote Firefox driver
                FirefoxOptions options = new FirefoxOptions();
                if (!Objects.equals(version, "latest")) {
                    options.setBrowserVersion(version);
                }
                try {
                    URL url = URI.create("http://localhost:4444/wd/hub").toURL();
                    driver = new RemoteWebDriver(url, options);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // Initialize local Firefox driver
                driver = new FirefoxDriver();
            }
        } else if (browser.equalsIgnoreCase("edge")) {
            if (runMode.equalsIgnoreCase("remote")) {
                // Initialize remote Edge driver
                EdgeOptions options = new EdgeOptions();
                if (!Objects.equals(version, "latest")) {
                    options.setBrowserVersion(version);
                }
                try {
                    URL url = URI.create("http://localhost:4444/wd/hub").toURL();
                    driver = new RemoteWebDriver(url, options);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // Initialize local Edge driver
                driver = new EdgeDriver();
            }
        }
        return driver;
    }
}
