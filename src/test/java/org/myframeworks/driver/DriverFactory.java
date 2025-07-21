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
        String runMode = ReadPropertyFileUtils.getProperty(ConfigProperties.RUN_MODE.name());

        if ("remote".equalsIgnoreCase(runMode)) {
            return createRemoteDriver(browser, version);
        } else {
            return createLocalDriver(browser);
        }
    }

    private static WebDriver createRemoteDriver(String browser, String version) {
        try {
            URL url = URI.create(ReadPropertyFileUtils.getProperty(ConfigProperties.SELENIUM_GRID_URL.name())).toURL();

            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (!Objects.equals(version, "latest")) {
                        chromeOptions.setBrowserVersion(version);
                    }
                    return new RemoteWebDriver(url, chromeOptions);

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (!Objects.equals(version, "latest")) {
                        firefoxOptions.setBrowserVersion(version);
                    }
                    return new RemoteWebDriver(url, firefoxOptions);

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (!Objects.equals(version, "latest")) {
                        edgeOptions.setBrowserVersion(version);
                    }
                    return new RemoteWebDriver(url, edgeOptions);

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static WebDriver createLocalDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}